import java.awt.AlphaComposite;
import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class Snake {
	
	//Attributes for this class.	
	double x;
	double y;	
	RoundRectangle2D.Double square1;
	double width=40;
	double height=40;
    int direction,nextDirection;
    Snake next;
    double totalLength=2;
    boolean collision=false;   
	Color squareColor= Color.green;



	//Constructor method
	public Snake(double x,double y) {
		
		//Sets the coordinate for the snake
		this.x=x;
		this.y=y;
		
		
	}
	
	//This actually draws the snake.
	public void draw(Graphics2D g) {
		square1=new RoundRectangle2D.Double(x, y, 25, 25,15,15);
		//This gives the snake a green colour.
        g.setColor(squareColor);
		g.draw(square1);
		g.fill(square1);
		g.setComposite(AlphaComposite.SrcOver.derive(0.65f));
	}
}