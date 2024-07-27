import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

// This creates a new class called Grid.
public class Grid {
	
	//These are the attributes for the class grid.
	
	//These are for the coordinates of individual squares in the grid.
	double x1;
	double y1;	
	//This would be the shape that makes up the grid.
	Rectangle.Double square;
	//These are the dimensions of an individual square in the grid.
	double width=25;
	double height=25;
	//This is for the colour of the square.
	Color gridColor;
	//Each square in the grid is numbered.
	int gridNumber;



	//This is the constructor method for the class Grid.
	public Grid(double x,double y,int gridNumber) {
		
		
		this.x1=x;
		this.y1=y;
		this.gridNumber=gridNumber;
		//This is to make the colour change every square.
		if (gridNumber%2==0) {
			this.gridColor=new Color(192,192,192);
		}
		else this.gridColor=new Color(255,255,255);
		
	}
	
	//This method actually sketches the square in the grid.
	public void sketchGrid(Graphics2D g) {
		//This creates and draws the new square.
		square=new Rectangle.Double(x1, y1, width,height);      
		g.setColor(gridColor);
		g.fill(square);
		g.setColor(Color.BLACK);
		g.draw(square);
	}
	


}