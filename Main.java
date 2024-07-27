import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;

 
public class Main extends JFrame {
	

   
     // This is the method of the program that calls all the other methods.
    public static void main(String[] args) {
        snakeGame();

     }
    
    //Creates a new method called snakeGame.
    public static void snakeGame() {
    	//This creates a new frame in which the graphics of the game will occur.
    	JFrame window=new JFrame();
    	// This means that this frame can not gain focus even if it requests so.
        window.setFocusable(false);
        //This sets the dimensions of the frame, window.
        window.setSize(800,800); 
        
        //This means that when the game is closed, it will also stop running.
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(false);

    	
        //This creates a new frame in which the navigation of the game will be.
        JFrame menu= new JFrame();
    	// This means that this frame can not gain focus even if it requests so.
        menu.setFocusable(false);
        //This means that when the game is closed, it will also stop running.
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //This sets the dimensions of the frame, menu.
        menu.setPreferredSize(new Dimension(500,500));
        menu.setVisible(true);

    
        //This creates a new frame in which the modes of the game will be.
        JFrame gameModes= new JFrame();
    	// This means that this frame can not gain focus even if it requests so.
        gameModes.setFocusable(false);
        gameModes.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //This sets the dimensions of the frame, game modes.
        gameModes.setPreferredSize(new Dimension(500,500));
        
        //This creates a new frame in which the leaderboard will be.
        JFrame topScores= new JFrame();
    	// This means that this frame can not gain focus even if it requests so.
        topScores.setFocusable(false);
        topScores.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //This sets the dimensions of the frame, topScores.
        topScores.setPreferredSize(new Dimension(500,500));
        
        
        //Creates a new panel.
 		JPanel navPanel=new JPanel();
 		//Sets the dimensions for the panel.
 		navPanel.setPreferredSize(new Dimension(100, 500));
 		//Sets the colour for the panel.
 		navPanel.setBackground(Color.GRAY);
 		
        //Creates a new panel.
 		JPanel backPanel=new JPanel();
 		//Sets the dimensions for the panel.
 		backPanel.setPreferredSize(new Dimension(100, 500));
 		//Sets the colour for the panel.
 		backPanel.setBackground(Color.GRAY);
 		//The panel won't be the focus of any user input.
 		backPanel.setFocusable(false);
 		
 		//Creates a new panel.
 		JPanel gamePanel=new JPanel();
 		gamePanel.setPreferredSize(new Dimension(150, 500));
 		gamePanel.setBackground(Color.GRAY);
 		gamePanel.setFocusable(false);
 		
       
 		
 		JPanel outerPanel=new JPanel();
 		outerPanel.setSize(800,800);
 		outerPanel.setBackground(Color.WHITE);
 		
        //Creates a new panel.
 		JPanel modePanel=new JPanel();
 		modePanel.setSize(800,800);
 		modePanel.setBackground(Color.WHITE);
 		
 		//Creates a new panel.
 		JPanel scorePanel=new JPanel();
 		//Sets dimensions for panel.
 		scorePanel.setSize(800,800);
 		//Sets colour of the panel.
 		scorePanel.setBackground(Color.WHITE);
 		
 		 //Creates a new panel.
 		JPanel scores=new JPanel();
 		//Sets dimensions for panel.
 		scores.setPreferredSize(new Dimension(150, 500));
 		//Sets colour of the panel.
 		scores.setBackground(Color.GRAY);
 		
 
 		//Creates a label to contain text.
 		JLabel topFive= new JLabel();
 		//Dimensions of the label.
 		topFive.setSize(150, 500);
 	
 		
 		
         	
 		Graphic panel ;
 		
 		//Creating a new button and inside, it will say Start
 		JButton Start = new JButton("Start");
 		//This sets the dimensions for the button
 		Start.setSize(100, 100);
 		
 		//Creating a new button and inside, it will say Back
 		JButton Back = new JButton("Back");
 		//This sets the dimensions for the button
 		Back.setSize(100, 100);
 		
 		//Creating a new button and inside, it will say Game modes.
 		JButton modes = new JButton("Game modes");
 		//This sets the dimensions for the button.
 		modes.setSize(100, 100);
 		
 		//This creates the 3 buttons for the modes and sets the dimensions for them.
 		JButton useApples= new JButton("Two Apples");
  		useApples.setSize(50, 30);
  		JButton useBlocks= new JButton("Blocks");
  		useBlocks.setSize(50, 30);
  	    JButton endless= new JButton("Endless");
  	    endless.setSize(50, 30);
 		//Creating the back button for the game modes panel.
 		JButton Back2 = new JButton("Back");
 		Back2.setSize(100, 100);
 		
 		//Creating the back button for the game modes panel.
 		JButton Back3 = new JButton("Back");
 		Back.setSize(100, 100);
 		//Creating the leaderboard button to access the top scores.
 		JButton Leaderboard = new JButton("Leaderboard");
 		Leaderboard.setSize(100, 100);
 		
 		
 		panel = new Graphic();
 		panel.setPreferredSize(new Dimension(500, 500));
 		panel.setBackground(Color.white);
 		
 		
 		//This means that it waits for an action to happen to the button ( getting clicked)
 		Start.addActionListener(new ActionListener() {
			
			@Override
			//This is what will occur when the button is clicked.
			public void actionPerformed(ActionEvent e) {
				//The main menu is no longer visible.
				menu.setVisible(false);
				//The window, which contains the graphic panel is now visible.
				window.setVisible(true);
				//This will give the graphic panel the input focus.
				panel.useApple=false;
				panel.useEndless=false;
				panel.useBlock=false;

				  if(panel.dead) {
	  					panel.totalLength=2;
	  					panel.Snake[0].x=200;
	  					panel.Snake[0].y=200;
	  					panel.apple=new Apple();
	  					panel.totalBlocks=0;
	   					panel.score=0;


	  					panel.dead=false;

	  				    panel.timer.restart();

	  					
	  					System.out.println("I am clicked");
	  				
	                 }
					panel.requestFocusInWindow();				
			  }
			

		  });
 		
 		Leaderboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//The menu is no longer visible.
				menu.setVisible(false);
				//The topScores frame is now visible.
				topScores.setVisible(true);
				//This creates a new arraylist to add the scores from the text file.
				ArrayList<String> lines = new ArrayList<String>();
				//This creates a string builder to add the scores.
				StringBuilder board = new StringBuilder();
				
				
				try {
					//Creates a new file instance of the text file for the scores.
				      File myObj = new File("Scores.txt");
				      //Creates a scanner to read through the text file.
				      Scanner myReader = new Scanner(myObj);
				      //This loops through until there are no more lines left in the text file.
				      while (myReader.hasNextLine()) {
				    	//The value from the text file is stored in the variable.  
				        String data = myReader.nextLine();
				        // This value is added to the arraylist.
				        lines.add(data);
				      }
				      
				      myReader.close();
				      
				    } catch (FileNotFoundException e1) {
				    	//If there was an issue with the file.
				      System.out.println("An error occurred.");
				      e1.printStackTrace();
				    }
				//This sorts the arraylist into ascending order.
			    Collections.sort(lines);
			    //This will reverse the order of the arraylist.
			    Collections.reverse(lines);
			    
			    //This for loop is used to get the first 5 numbers in the arraylist.
				for (int j = 0; j < 5;j++) 
			    { 		      
			          System.out.println(lines.get(j)); 
			          //The 5 scores are added into the string builder.
			          board.append(lines.get(j)).append(",");
			         
			          
			    }  
				//The 5 scores are then copied to the Jlabel.
				topFive.setText(board.toString());
			  }
			

		  });
 		
 		//This means that it waits for an action to happen to the button ( getting clicked)
 		modes.addActionListener(new ActionListener() {
			
			@Override
			//This is what will occur when the button is clicked.
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				gameModes.setVisible(true);
				
			
			  }
			

		  });
 		
 		
 		//This means that it waits for an action to happen to the button ( getting clicked)
 		Back.addActionListener(new ActionListener() {
			//This is what will occur when the button is clicked.
			@Override
			public void actionPerformed(ActionEvent e) {
				// The menu will now be visible.
				menu.setVisible(true);
				// The window with the actual game will no longer be visible.
				window.setVisible(false);

				
			
			  }
			

		  });
 		
 		Back2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				gameModes.setVisible(false);

				System.out.println(panel.dead);
				
			
			  }
			

		  });
 		
 		Back3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				topScores.setVisible(false);

				System.out.println(panel.dead);
				
			
			  }
			

		  });
 		
 		
 		//This is the what happens when the 2 apples button is clicked.
 		useApples.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//The game panel is now visible.
				window.setVisible(true);
				//The game modes panel is no longer visible.
				gameModes.setVisible(false);
				//The other game modes are set to false and only 2 apples is true.
				panel.useApple=true;
                panel.useBlock=false;
                panel.useEndless=false;


                //This is so that if the snake is dead, it returns to how it was originally.
				  if(panel.dead) {
  					panel.totalLength=2;			
  					panel.apple=new Apple();
   					panel.score=0;
   					//The snake goes back to the centre.
   					panel.Snake[0].x=200;
  					panel.Snake[0].y=200;
   					//The snake is no longer dead.
  					panel.dead=false;
  				    panel.timer.restart();

  					  				
                 }
				 // The graphics panel is now the receiving end for any user input. 
				panel.requestFocusInWindow();

				
			
			  }
			

		  });
 		
 		//This is the what happens when the 2 apples button is clicked.
 		useBlocks.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					window.setVisible(true);
					gameModes.setVisible(false);
					//The other game modes are set to false and only blocks mode is true.
					panel.useApple=false;
	                panel.useBlock=true;
	                panel.useEndless=false;


	                //This is so that if the snake is dead, it returns to how it was originally.
					  if(panel.dead) {
	  					panel.totalLength=2;
	  					//Snake returns back to the middle.
	  					panel.Snake[0].x=200;
	  					panel.Snake[0].y=200;
	  					//A new apple is created.
	  					panel.apple=new Apple();
	  					// The total number of blocks resets.
	  					panel.totalBlocks=0;
	   					panel.score=0;
	  					panel.dead=false;

	  				    panel.timer.restart();
	  						  				
	                 }
					// The graphics panel is now the receiving end for any user input. 

					panel.requestFocusInWindow();			
				
				  }
				
		});
 		
 		//This is the what happens when the 2 apples button is clicked.
 		endless.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//This sets the actual game to be visible.
						window.setVisible(true);
						gameModes.setVisible(false);
						//The only mode that is true is the endless variable.
						panel.useApple=false;
		                panel.useBlock=false;
		                panel.useEndless=true;

		                //This is to reset the game back to how it was originally.
						  if(panel.dead) {
							//The snake is back to its normal size.  
		  					panel.totalLength=2;
		  					//The snake is back to the middle.
		  					panel.Snake[0].x=200;
		  					panel.Snake[0].y=200;
		  					//A new apple is created.
		  					panel.apple=new Apple();
		  					//The score is set back to 0.
		   					panel.score=0;
		   					// The snake is no longer dead since a new game has begun.
		  					panel.dead=false;
		  					//The timer should be reset since it is a new game.
		  				    panel.timer.restart();

		  					
		  				
		                 }
						// The graphics panel is now the receiving end for any user input. 
						panel.requestFocusInWindow();
						
					
					  }
					

		});
 		
 		
 		//This will add a new panel to the actual frame.
 		menu.add(navPanel);
 		//This will add the button to the new panel.
         navPanel.add(Start);
  		//This will add the button to the new panel.
         navPanel.add(modes);
         
         //This adds the panels to the frame.
         gameModes.add(modePanel);
         modePanel.add(gamePanel);
         //This adds the game modes and the back buttons to the panel.
         gamePanel.add(Back2);
         gamePanel.add(useApples);
         gamePanel.add(useBlocks);
         gamePanel.add(endless);



 		
 	
         //A larger panel is added to the frame.
 		 window.add(outerPanel);
 		 //The panel will consist of 2 panels: one for the game and one for the back button.
 		 outerPanel.add(backPanel );
 		 outerPanel.add(panel);
 		 //This adds the back button.
 		 backPanel.add(Back);
 		 //Adds the leaderboard button to the menu.
         navPanel.add(Leaderboard);
      
         //Adds the 2 panels to the frame topScores.
         topScores.add(scorePanel);
         scorePanel.add(scores);
         //Adds the back button and the Jlabel with the scores to the scores panel.
         scores.add(Back3);
         scores.add(topFive);


         menu.pack();
         gameModes.pack();
         topScores.pack();

         
 		 window.pack();
 		
    	
   }
    
  
         
 }


   
       