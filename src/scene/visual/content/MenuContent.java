package scene.visual.content;




import scene.visual.dynamic.described.TextSprite;
import visual.dynamic.described.Sprite;

import java.awt.geom.Rectangle2D;


/**
 * Abstract representation of text that will be rendered to the screen.
 * 
 * @author Daniel Hardgrove
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code
 * 11/19/13
 *
 */
public abstract class MenuContent implements Sprite {

	protected TextSprite[] 	text;	//Text to be rendered
	protected double 		x, y;	//Content's position
	
	/**
	 * 
	 * @param text - the array of text to be rendered
	 */
	public MenuContent(TextSprite... text)
	{
		this.text = text;
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * 
	 * @return the collection of text
	 */
	public TextSprite[] getText()
	{
		return this.text;
	}
	
	/**
	 * @return bounds - the bounds of this content.
	 */
	public Rectangle2D getBounds2D(boolean ofTransformed) {
		
		Rectangle2D.Double bounds;
		double x, y, width, height;
		
		x = this.x;
		y = this.y;
		height = text.length * 20;
		width = getWidth();
		
		bounds = new Rectangle2D.Double(x, y, height, width);
		
		return bounds;
		
	}

	/**
	 * 
	 * @return the maximum width of the content
	 */
	protected double getWidth()
	{
		double longest = 0;
		
		for (TextSprite i : text)
		{
			if (i.getText().length() >= longest)
				longest = i.getText().length();
		}
		
		return longest;
	}

	
	/**
	 * Sets the location to the appropriate coordinates
	 */
	public void setLocation(double arg0, double arg1) {
		this.x = arg0;
		this.y = arg1;
		
	}
}
