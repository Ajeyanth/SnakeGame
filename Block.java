import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

public class Block {
	//Global variables for this class.
	double x2;
	double y2;
	Random rnd=new Random();

	Rectangle.Double square;
	String name;
	double width=40;
	double height=40;
    int direction,nextDirection;
    int total=0;



	//Constructor for the block.
	public Block(double x2,double y2) {
		
		//Sets the x and y coordinates for the block
		this.x2=x2;
		this.y2=y2;
		//Actually creates the x and y coordinates.
		x2=rnd.nextInt(500);
		y2=rnd.nextInt(500);
		//Ensures the block is within the grid.
		int remainder=(int) (x2%25);
		x2-=remainder;
		remainder=(int) (y2%25);
		y2-=remainder;
	
	}
	
	//This is to draw the block/
	public void draw(Graphics2D g) {
		square=new Rectangle.Double(x2, y2, 25, 25);	
		
		g.draw(square);
		g.fill(square);
	}
	

}
