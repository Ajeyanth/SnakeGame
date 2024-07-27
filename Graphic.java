
import java.awt.Color;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import javax.swing.Timer;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class Graphic extends JPanel implements KeyListener {
	
	//Global variables used in this class.
	double x=200;
	double y=200;
	static Timer timer;
	Random rnd=new Random();
	Snake square;
	Apple apple;
	Apple apple2;
	int totalLength=2;
	Snake[] Snake=new Snake[500];
	int totalBlocks=0;
	Block[] blocks=new Block[500];
	int moveDirection;
	Grid[][] grid = new Grid[20][20];
	boolean right;
	boolean left;
	boolean up;
	boolean down;
	boolean dead=false;
	Polygon head;
    double x1=0;
    double y1=0;
    boolean useApple=true;
    boolean useBlock=true;
    boolean useEndless=true;
    int score=0;

    
	
	

	
	public Graphic() {
		//Becomes the receiving end for any input.
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		

		//Test head
		int[] polyX= {0,0,0};
		int[] polyY= {0,0,0};
		
		head=new Polygon(polyX, polyY, 3);
		
		
		//Calling the method to create the Snake.
		createSnake();
		
		//Creating a new apple using the class Apple.
		apple=new Apple();
		
		//Calling the method to create the apple.
		if(useApple==true) {
			apple=new Apple();
			apple2= new Apple();

		}
		
		if(useBlock==true) {
			createBlocks();
			apple=new Apple();
			//useApple=false;

		}
	
		
		
		createGrid();
		
	
			 
		timer=new Timer(150, new ActionListener() {

			@Override
			// Method to call the animation method and to repaint and the component.
			public void actionPerformed(ActionEvent e) {
				
	             try {
	             		animation(moveDirection);
	             } catch (IOException e1) {
	             		// TODO Auto-generated catch block
	             		e1.printStackTrace();
	             	}

	             	repaint();
	             	
			};
		       

		});
		
		timer.restart();
	
		 	
		}
		
	
	    
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		
	

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//Calling the method to display the Snake.
        drawSnake(g2);
		//Calling the method to display the grid.

		drawGrid(g2);
		//Calling the method to display the apples.
        drawApples(g2);
		//Calling the method to display the head.
        drawhead(g2);
        //If the blocks mode is being played.
        if(useBlock==true) {
        	//Calling the method to display the blocks.
            drawBlocks(g2);

        }
        
    
        
	}
	
	//Method to create the blocks.
    public void createBlocks() {
    		//This ensures the blocks appear in random positions.
			double x2=rnd.nextInt(500);
			double y2=rnd.nextInt(500);
			//This ensures the block is inside the grid squares.
			int remainder=(int) (x2%25);
			x2-=remainder;
			remainder=(int) (y2%25);
			y2-=remainder;
			//This creates a new block in a random position.
			blocks[totalBlocks]=new Block(x2, y2);
	
	}
	
	//Method to display the blocks on the screen.
	public void drawBlocks(Graphics2D g) {
       for (int i=0;i<totalBlocks;i++) {
			
               blocks[i].draw(g);
			
		}

   }
	

	
	
	//Method to display the head of the snake.
	public void drawhead(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fill(head);
		g.draw(head);
	}
	

				
			
	//Method to display the Snake on the screen. 
	public void drawSnake(Graphics2D g) {
		for (int i=0;i<totalLength;i++) {
			Snake[i].draw(g);
			

			
		}
			
	}
	
	//Method to display the apple on the screen.
		public void drawApples(Graphics2D g) {
				apple.drawApple(g);
				if(useApple==true) {
					apple.drawApple(g);
					apple2.drawApple(g);
		        }
	    }
	            
		
		

	
	public void drawGrid(Graphics2D g) {
		for (int i=0;i<20;i++) {
			for (int j=0;j<grid.length;j++) {
			grid[i][j].sketchGrid(g);
			//System.out.println(i);
			//System.out.println(grid[i].x1);
			//System.out.println(grid.length);
			//System.out.println("Square created");
			
			}
		}
	
	}

	
	
	
	public void createGrid() {
		for (int i=0;i<20;i++) {
			x1=0;
		for (int j=0;j<grid.length;j++) {
			grid[i][j]=new Grid(x1, y1,i+j);
			x1+=25;
			//System.out.println(i);
			//System.out.println(x1);
			//System.out.println(y1);	
					
		}
		y1+=25;
		}
		
	}
	
	
	// Method to create the Snake.	 
	public void createSnake() {
		//Start of for loop.
		//The number of Snake is  to the value within the variable 'totalLength'.
		for (int i=0;i<totalLength;i++) {
			// Create a new square with its X position being 40 less than the X position of square in front of it.
			Snake[i]=new Snake(x, y);
			x-=25;
		}
		//End of for loop.
		//Creates the coordinates for the initial position of the head.
		head.xpoints[0]=(int)Snake[0].x+25;
		head.xpoints[1]=(int)Snake[0].x+50;
		head.xpoints[2]=(int)Snake[0].x+25;
		head.ypoints[0]=(int)Snake[0].y;
		head.ypoints[1]=(int)Snake[0].y+15;
		head.ypoints[2]=(int)Snake[0].y+25;
	}
	
	public void moveHead(Snake tempHead) {
		int shift=25;
		int sign=1;
		//tempHead is the local variable created for the method.
		if ((tempHead.direction==2) || (tempHead.direction==4)) {
			if (tempHead.direction==4) {
				shift=0;
				sign=-1;
			}
			//This is to move the head of the snake.
			head.xpoints[0]=(int)tempHead.x+shift*sign;
			head.xpoints[1]=(int)tempHead.x+shift+(sign*50/2);
			head.xpoints[2]=(int)tempHead.x+shift*sign;
			
			head.ypoints[0]=(int)tempHead.y;
			head.ypoints[1]=(int)tempHead.y+15;
			head.ypoints[2]=(int)tempHead.y+25;
		}
		if ((tempHead.direction==1) || (tempHead.direction==3)) {
			if (tempHead.direction==1) {
				shift=0;
				sign=-1;
			}
			head.ypoints[0]=(int)tempHead.y+shift*sign;
			head.ypoints[1]=(int)tempHead.y+shift+(sign*50/2);
			head.ypoints[2]=(int)tempHead.y+shift*sign;
			
			head.xpoints[0]=(int)tempHead.x;
			head.xpoints[1]=(int)tempHead.x+15;
			head.xpoints[2]=(int)tempHead.x+25;
		}
		
	}
	
	//Method to change the direction in order to make the snake up.
		public void up() {
			Snake[0].direction=1;
			//Sets all the variables except 'up' false.
			up=true;
			down=false;
			left=false;
			right=false;
			//Calls the move method in order to make the snake move.
			try {
				move();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Method to change the direction in order to make the snake down.			
		public void down() {
			Snake[0].direction=3;
			//Sets all the variables except 'down' false.
		    up=false;
			down=true;
			left=false;
			right=false;
			//Calls the move method in order to make the snake move.
			try {
				move();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}
		
		//Method to change the direction in order to make the snake left.
		public void left() {
			
			Snake[0].direction=4;
			//Sets all the variables except 'left' false.
			up=false;
			down=false;
			left=true;
			right=false;
			//Calls the move method in order to make the snake move.
			try {
				move();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
					
		}
		
		//Method to change the direction in order to make the snake right.
		public void right() {
			Snake[0].direction=2;
			//Sets all the variables except 'right' false.
			 up=false;
			 down=false;
			 left=false;
			 right=true;
			//Calls the move method in order to make the snake move.
			 try {
				move();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 	
		}
		
		public void move() throws IOException {
			//Start of for loop.
			// After the first square moves, the squares after will take the position of the square in front of them.
			for (int i=totalLength-1;i>0;i--) {
				Snake[i].x=Snake[i-1].x;
				Snake[i].y=Snake[i-1].y;
			}
			//End of for loop.
			
			if (Snake[0].direction==1)
				Snake[0].y-=25;
				
			if (Snake[0].direction==2)
				Snake[0].x+=25;
			
			if (Snake[0].direction==3)
				Snake[0].y+=25;
			
			if (Snake[0].direction==4)
				Snake[0].x-=25;
			
			//Start of boundary conditions for the snake.
			
			//These are the conditions if the endless mode is chosen.
			if(useEndless) {
				//The snake should go through the right hand side and come out of the left side.
				if(Snake[0].x>500) {
					Snake[0].x=0;
				}
				//The snake should go through the left hand side and come out of the right side.
				if(Snake[0].x<0) {
					Snake[0].x=500;
				}
				//The snake should go through the top side and come out of the bottom side.
				if(Snake[0].y<0) {
					Snake[0].y=500;
				}
				//The snake should go through the bottom  side and come out of the top side.
				if(Snake[0].y>500) {
					Snake[0].y=0;
				}
				
		 	
		}
			else {	
				if ((Snake[0].x>=500) ||  (Snake[0].x<=-25) ||(Snake[0].y>=500)|| (Snake[0].y<=-25) ) {
						dead=true;
						timer.stop();
						//Panel shown when the snake dies.
						JOptionPane.showMessageDialog(null, "You're dead! Your score was:" + Integer.toString(score));
						//Writes the score to a text file.
						if(score>0) {
							File file = new File("Scores.txt");
							FileWriter fr = new FileWriter(file, true);
							BufferedWriter br = new BufferedWriter(fr);
							br.newLine();
							br.write(Integer.toString(score));
		
							br.close();
							fr.close();
						}
				}
			}
				
			
			//End of boundary conditions for the snake.
			
			moveHead(Snake[0]);
			
			
		

		}
		
		//Method to check if there has been a collision between the head and an apple.
		public void checkCollisionWithAppleV1() {
			    // Checks if the head has intersected with an apple.
				if((Snake[0].x==apple.a && Snake[0].y==apple.b)  ) {
					if(Snake[0].collision=true) {
						totalLength+=1;
						
						Snake[totalLength-1]= new Snake(-20,-20);
						
					}
		
	                apple=new Apple();
	                score+=1;
	                totalBlocks+=1;
	                createBlocks();

	                         
				}
				
		}
		
		public void checkCollisionWithAppleV2() {
			//Checks if the snake has intersected with one of the apples.
			if((Snake[0].x==apple.a && Snake[0].y==apple.b)  ) {
				totalLength+=1;
				Snake[totalLength-1]= new Snake(0,0);
				
				//The snake's x and y coordinates become the same as the other apple.
				Snake[0].x=apple2.a;
				Snake[0].y=apple2.b;
	            apple=new Apple();
				apple2=new Apple();
				//The score increments.
				score+=1;
	            
		 }
			//Checks if the snake has intersected with one of the apples.
			   if((Snake[0].x==apple2.a && Snake[0].y==apple2.b)  ) {
				
				totalLength+=1;
				Snake[totalLength-1]= new Snake(0,0);
			
			//The snake's x and y coordinates become the same as the other apple.
				Snake[0].x=apple.a;
				Snake[0].y=apple.b;
	            apple=new Apple();
				apple2=new Apple();
				//The score increments.
				score+=1;
				
				  

			    }

		 }
		
		//Method to check whether the snake has collided with itself.
		public void checkCollisionWithSnake() throws IOException  {
			//Start of for loop.
			for(int i=totalLength-1;i>2;i--) {
				//Checks if the first square collides with any square except the first and second square.
				if(Snake[0].x == Snake[i].x && Snake[0].y== Snake[i].y) {
					System.out.println("Collision with snake");
					timer.stop();
					dead=true;
					JOptionPane.showMessageDialog(null, "You're dead! Your score was:" + Integer.toString(score));

					System.out.println(score);
					
					//This is only if the player scored at least 1 point.
					if(score>0) {
						//Creates a new file instance using the scores text file.
						File file = new File("Scores.txt");
						//Creates a file and buffered writer to add to the text file.
						FileWriter fr = new FileWriter(file, true);
						BufferedWriter br = new BufferedWriter(fr);
						//This will go to the next line in the text file.
						br.newLine();
						//This appends the player's score to the text file.
						br.write(Integer.toString(score));
	
						br.close();
						fr.close();
					}


					
					
				}				
				
			}
			//End of for loop.
			
		}
		
		public void checkCollisionWithBlock() throws IOException {
		    // Checks if the head has intersected with a block.

			//This checks if the head of the snake comes into contact with any of the blocks.
			for(int i =0 ; i<totalBlocks;i++) {
			    if(Snake[0].x==blocks[i].x2 && Snake[0].y ==blocks[i].y2) {
				   timer.stop();
				   dead=true;
				   JOptionPane.showMessageDialog(null, "You're dead! Your score was:" + Integer.toString(score));

			
			     }
			}
			
			if(score>0) {
				File file = new File("Scores.txt");
				FileWriter fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				br.newLine();
				br.write(Integer.toString(score));

				br.close();
				fr.close();
			}

			
	    }
		
		//Creating method for the different key inputs.
		public void animation(int code) throws IOException {
			//If the left arrow clicked, change the snake's direction to make it go to the left unless the snake's current direction is to the right.
			if  (code==37 && right!=true) left();
			if  (code==37 && right==true) right();

			//If the right arrow clicked, change the snake's direction to make it go to the right unless the snake's current direction is to the left.
			if  (code==39 && left!=true) right();
			if  (code==39 && left==true) left();

			//If the up arrow clicked, change the snake's direction to make it go upwards unless the snake's currently moving downwards.
			if  (code==38 && down!=true) up();
			if  (code==38 && down==true) down();

			//If the down arrow clicked, change the snake's direction to make it go downwards unless the snake's currently moving upwards.
			if  (code==40 && up!=true) down();
			if  (code==40 && up==true) up();
			
			if(useApple==true) {
				   checkCollisionWithAppleV2();
			}
			else {
			checkCollisionWithAppleV1();
			}
			
			if(useBlock==true) {
				checkCollisionWithBlock();


			}
			
			//Only call the method to check if the snake has collided with itself when its 'totalLength' is larger than 2.
			if(totalLength>2 )  checkCollisionWithSnake();

	 
			
			
		}


	
		
		public void keyPressed(KeyEvent e) {
			Integer[] codes= {32,37,38,39,40};
			List<Integer> codesList=Arrays.asList(codes);
			if (codesList.stream().anyMatch(a-> a.intValue()==e.getKeyCode())) {
				moveDirection=e.getKeyCode();
			}
				
					
			//Start the timer when the space bar is clicked.		
			if (moveDirection==32) {
	            timer.start();
			}
			
					
		}
			
			
	 public void keyTyped(KeyEvent e) {}
	 public void keyReleased(KeyEvent e) {}
						
			

}




