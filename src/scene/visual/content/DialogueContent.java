package scene.visual.content;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import scene.visual.dynamic.described.TextSprite;
import visual.dynamic.described.Sprite;
import visual.statik.SimpleContent;

/**
 * Encapsulates TextSprite objects and controls when each
 * will be rendered. They will be rendered sequentially 
 * with a common delay.
 * 
 * @author Daniel Hardgrove
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code
 * 11/17/13
 *
 */
public class DialogueContent implements Sprite {

	private TextSprite[] dialogue;
	private long curTime;
	private long delay;
	private int numToRender;
	private double x, y;
	
	/**
	 * 
	 * @param delayForText - The amount of time to wait between displaying
	 * 						 each TextSprite
	 * @param sprites	   - The TextSprites being stored in the content
	 * 						 in a sequential order.
	 */
	public DialogueContent(long delayForText, TextSprite ... sprites)
	{
		this.dialogue = sprites;
		curTime = 0;
		delay = delayForText;
		numToRender = 1;
	}
	
	/**
	 * 
	 * @return the collection of text
	 */
	public TextSprite[] getDialogue()
	{
		return this.dialogue;
	}

	/**
	 * Renders the dialogue depending on how many should be
	 * rendered at the given time.
	 * 
	 * @param g - the graphics object
	 */
	public void render(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.draw(new Rectangle(600, 200));
		g2.setColor(Color.green);
		g2.fill(new Rectangle(600, 200));
		//Sets the starting position for each piece
		for (int i = 0; i < numToRender; i++) {
			dialogue[i].setLocation(0, i * dialogue[i].getFont().getSize());
			dialogue[i].render(g2);
		}
	}
	

	/**
	 * Updates the current time, and decides if more sprites
	 * should be rendered.
	 * 
	 * @param time - the time since the Metronome started
	 */
	public void handleTick(int time) {
		
		curTime = time;
		
		numToRender = (int)(curTime / delay) + 1;
		
		if (numToRender >= dialogue.length)
			numToRender = dialogue.length;
		
		for (int i = 0; i < numToRender; i++)
			dialogue[i].handleTick(time);
		
	}

	@Override
	public Rectangle2D getBounds2D(boolean arg0) {
		
		Rectangle2D.Double bounds;
		double x, y, width, height;
		
		x = this.x;
		y = this.y;
		height = dialogue.length * 20;
		width = getWidth();
		
		bounds = new Rectangle2D.Double(x, y, height, width);
		
		return bounds;
		
	}

	public double getWidth()
	{
		double longest = 0;
		
		for (TextSprite i : dialogue)
		{
			if (i.getText().length() >= longest)
				longest = i.getText().length();
		}
		
		return longest;
	}
	
	@Override
	public void setLocation(double arg0, double arg1) {
		this.x = arg0;
		this.y = arg1;
		
	}

	@Override
	public void setRotation(double arg0, double arg1, double arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScale(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}



}
