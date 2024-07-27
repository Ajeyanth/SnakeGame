
import java.awt.Color;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;







public class Side extends JPanel implements KeyListener {
	
	double x=200;
	double y=200;
	static Timer timer,timer1,timer2;
	double width=20;
	double height=20;
	Rectangle.Double rect;
	Random rnd=new Random();
	Snake square;
	Apple apple;
	Apple apple2;
	int totalLength=2;
	Snake[] Snake=new Snake[500];
	int totalBlocks=0;
	//Block[] blocks=new Block[500];
	int moveDirection;
	Snake ghost=new Snake(300,300);
	Grid[][] grid = new Grid[20][20];
	Timer[] timers= new Timer[500];
	int totalTimers=1;
	boolean right;
	boolean left;
	boolean up;
	boolean down;
	boolean dead=false;
	Polygon head;
    double x1=0;
    double y1=0;
    int r;
    boolean useApple=true;
    boolean useBlock=true;
    boolean useClassic=true;
    boolean useSpeed=true;
    boolean useArcade=true;
    boolean useEndless=true;
    int speed=150;

    
	
	

	
	public Side() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		

		//Test head
		int[] polyX= {0,0,0};
		int[] polyY= {0,0,0};
		
		head=new Polygon(polyX, polyY, 3);
		
		
		//Calling the method to create the Snake.
		createSnake();
		if(useBlock==true) {
			//createBlocks();
			apple=new Apple();
			//useApple=false;

		}
		//Calling the method to create the apple.
		if(useApple==true) {
			apple=new Apple();
			apple2= new Apple();
			//useBlock=false;

		}
		
		
		
		
		createGrid();
	
		 	
	}
	
	    
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawGrid(g2);
		//Calling the method to display the Snake.	
        drawSnake(g2);
	   
        drawhead(g2);
        if(useBlock==true) {

        }
        
    
        
	}
	
	public void drawGhost(Graphics2D g) {
		ghost.draw(g);
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

	
		
	public void keyPressed(KeyEvent e) {
	
				
	}
			
			
			
			
	 public void keyTyped(KeyEvent e) {}
	 public void keyReleased(KeyEvent e) {}
						
			

}


       