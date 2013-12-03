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

	private int curTime;		//The current metronome time after handle tick
	private int curIndex;		//The current text sprite to render
	private TextSprite d1, d2;	//Dialogue 1 and 2
	private int waitTime;		//How long to wait until continuing
	private int timeSoFar;		//How much time elapsed since an event
	
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
		
		waitTime = 3000; //Delay at 1.5 seconds

	}
	
	/**
	 * Renders the dialogue depending on how many should be
	 * rendered at the given time.
	 * 
	 * @param g - the graphics object
	 */
	public void render(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		
		//The encapsulating rectangle
		g2.setColor(rectangleColor);
		textRectangle.x = x;
		textRectangle.y = y;
		g2.fill(textRectangle);
		g2.setColor(Color.black);
		g2.draw(textRectangle);
		d1.setLocation(x, y + 30);
		d1.render(g2);
		
		//Only render d2 if d1 is done rendering
		if (d1.isFullyRendered() && d2 != null) {
			d2.setLocation(x, 30 + y + d1.getFont().getSize() + 20);
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
		
		//Always show d1, since d1 is first
		d1.handleTick(time);
		
		//Only update d2 once d1 has finished with all text
		if (d1.isFullyRendered())
			d2.handleTick(time);
		
		//Start tracking time since d2 finished
		if (d2.isFullyRendered())
			timeSoFar += time - curTime;
		
		//Advance to the text two text sprites in the dialogue
		//Only after we have waited long enough
		if (d2.isFullyRendered() && curIndex < text.length
				&& timeSoFar >= waitTime)
		{
			timeSoFar = 0;
			d1 = text[curIndex];
			incrementIndex();
			d2 = text[curIndex];
			incrementIndex();
		}
		
		//Advance the controller's content if the dialogue is finished
		if (isDoneRenderingAll()) {
			timeSoFar += time - curTime;
			
			//Wait before advancing
			if (timeSoFar >= waitTime)
				menuController.advanceContent();
		}
		
		curTime = time;
	}

	/**
	 * Returns true if each text sprite of the dialogue has been
	 * rendered and finished.
	 * @return if true.
	 */
	public boolean isDoneRenderingAll()
	{
		if (curIndex >= text.length - 1) {
			if (d1.isFullyRendered() && d2.isFullyRendered())
				return true;
		}
		return false;
	}
	
	/**
	 * Incrememnts our index within bounds
	 */
	public void incrementIndex()
	{
		if (curIndex < text.length - 1)
			curIndex++;
	}
	
	public void setRotation(double arg0, double arg1, double arg2) {	}
	public void setScale(double arg0, double arg1) {}
}
