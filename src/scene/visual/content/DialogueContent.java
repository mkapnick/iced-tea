package scene.visual.content;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.GlyphVector;

import scene.visual.dynamic.described.TextSprite;
import visual.dynamic.described.Sprite;
import controller.MenuController;

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
public class DialogueContent extends MenuContent implements Sprite {

	private int curTime;
	private int numToRender = 2;
	private int curIndex;
	private TextSprite d1, d2;
	private int waitTime;
	private int timeSoFar;
	
	/**
	 * 
	 * @param delayForText - The amount of time to wait between displaying
	 * 						 each TextSprite
	 * @param sprites	   - The TextSprites being stored in the content
	 * 						 in a sequential order.
	 */
	public DialogueContent(TextSprite ... sprites)
	{
		super(sprites);
		curTime = 0;
		timeSoFar = 0;
		numToRender = 1;
		this.curIndex = 2;
		if (sprites.length > 0)
		{
			d1 = text[0];
			if (sprites.length > 1)
				d2 = text[1];
			else
				d2 = null;
		}
		else {
			d1 = null;
			d2 = null;
		}
		
		waitTime = 1000;
		
	}
	
	/**
	 * Renders the dialogue depending on how many should be
	 * rendered at the given time.
	 * 
	 * @param g - the graphics object
	 */
	public void render(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(rectangleColor);
		g2.fill(textRectangle);
		g2.draw(textRectangle);
		d1.render(g2);
		
		if (d1.getGlyphText().getNumGlyphs() == d1.getText().length() && d2 != null) {
			d2.setLocation(x, y + 40);
			d2.render(g2);
		}
	}
	

	/**
	 * Updates the current time, and decides if more sprites
	 * should be rendered.
	 * 
	 * @param time - the time since the Metronome started
	 */
	public void handleTick(int time) {
		
		d1.handleTick(time);
		
		if (d1.isFullyRendered())
		{
			timeSoFar += time - curTime;
			curTime = time;
			if (timeSoFar >= waitTime)
			{
				updateDialogue();
				d2.handleTick(time);
			}
		}
		
		if (d2.isFullyRendered())
			timeSoFar = 0;
		
		
		
		//System.out.println(d1.getGlyphText().getNumGlyphs());
		/*if (d1.getGlyphText().getNumGlyphs() == d1.getText().length())
		{
			
		}*/
		
		//System.out.println("Index before:" + curIndex + "\tText length: " + text.length);
		GlyphVector d2Glyphs = d2.getGlyphText();
		
		if (d2 != null && d2Glyphs != null && d2Glyphs.getNumGlyphs() == d2.getText().length() && curIndex < text.length)
		{
			//System.out.println("Index before d1: " + curIndex + "\tText length: " + text.length);
			d1 = text[curIndex];
			incrementIndex();
			//System.out.println("Index before d2: " + curIndex + "\tText length: " + text.length);
			d2 = text[curIndex];
			incrementIndex();
		}
		//System.out.println(curIndex);
		if (isDoneRenderingAll()) {
			//System.out.println("DONE WITH DIALOGUE");
			controller.advanceContent();
			
		}
			
		
	}


	public void updateDialogue()
	{
		
	}
	
	public boolean isDoneRenderingAll()
	{
		if (curIndex >= text.length - 1) {
			if (d1.isFullyRendered() && d2.isFullyRendered())
				return true;
		}
		return false;
	}
	
	public void incrementIndex()
	{
		if (curIndex < text.length - 1)
			curIndex++;
	}
	@Override
	public void setRotation(double arg0, double arg1, double arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScale(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}
	public String toString()
	{
		String string = "Dialogue: ";
		string += super.toString();
		return string;
	}



}
