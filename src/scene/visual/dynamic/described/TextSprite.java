package scene.visual.dynamic.described;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import visual.dynamic.described.Sprite;
import visual.statik.SimpleContent;
import visual.statik.described.AggregateContent;

/**
 * Abstract representation of text.
 * 
 * @author Daniel Hardgrove
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 * 11/16/13
 */
public abstract class TextSprite extends AggregateContent implements Sprite, SimpleContent
{
	
	protected String text;
	protected Font font;
	protected Shape shape;
	protected double x;
	protected double y;
	protected Color color;
	
	/**
	 * @param text - the text to be rendered
	 * @param isScrolling - controls if the text will appear at once 
	 * 						or over time.
	 */
	public TextSprite(String text)
	{
		this.text = text; 
		
		this.font = new Font("Arial", Font.PLAIN, 18);
		this.color = Color.black;
	}
	
	public Font getFont()
	{
		return this.font;
	}
	
	public Point2D.Double getLocation()
	{
		return new Point2D.Double(x, y);
	}
	
	public String getText()
	{
		return this.text;
	}
	
	/**
	 * The number of letters rendered is incremented for each
	 * time the method is called.
	 */
	public abstract void handleTick(int time);

	@Override
	public Rectangle2D getBounds2D(boolean arg0) {
		return null;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public void setFont(Font font)
	{
		this.font = font;
	}
	
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
		
	}
	

	public void setRotation(double arg0, double arg1, double arg2) {}
	public void setScale(double horiz, double vert) {}
	public abstract void render(Graphics g);
}
