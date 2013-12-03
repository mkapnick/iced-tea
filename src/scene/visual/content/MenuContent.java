package scene.visual.content;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import scene.visual.dynamic.described.TextSprite;
import visual.dynamic.described.Sprite;
import controller.MenuController;
import controller.SceneController;

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
	protected MenuController menuController;
	protected SceneController sceneController;
	
	protected Rectangle2D.Double textRectangle;
	protected Color rectangleColor;
	
	
	/**
	 * 
	 * @param text - the array of text to be rendered
	 */
	public MenuContent(TextSprite... text)
	{
		this.text = text;
		this.x = 0;
		this.y = 0;
		
		textRectangle = new Rectangle2D.Double(0, 0, 640, 200);
		rectangleColor = new Color(255, 248, 220);
		
	}
	
	public MenuController getMenuController()
	{
		return this.menuController;
	}
	public void setMenuController(MenuController controller)
	{
		this.menuController = controller;
	}
	
	public SceneController getSceneController()
	{
		return this.sceneController;
	}
	public void setSceneController(SceneController controller)
	{
		this.sceneController = controller;
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
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
		
	}
	

	public String toString()
	{
		String string = "";
		
		for (TextSprite i : text)
		{
			string += i.getText() + "\n";
		}
		
		return string;
	}
}
