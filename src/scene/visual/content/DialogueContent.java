package scene.visual.content;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.GlyphVector;

import scene.visual.dynamic.described.TextSprite;
import visual.dynamic.described.Sprite;

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

	private long curTime;
	private int numToRender = 2;
	private int curIndex;
	private TextSprite d1, d2;
	
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
		
	}
	
	/**
	 * Renders the dialogue depending on how many should be
	 * rendered at the given time.
	 * 
	 * @param g - the graphics object
	 */
	public void render(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		
		d1.render(g2);
		
		if (d1.getGlyphText().getNumGlyphs() == d1.getText().length()) {
			d2.setLocation(x, y + 20);
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
		
		if (d1.getGlyphText().getNumGlyphs() == d1.getText().length())
		{
			d2.handleTick(time);
		}
		
		GlyphVector d2Glyphs = d2.getGlyphText();
		if (d2 != null && d2Glyphs != null && d2Glyphs.getNumGlyphs() == d2.getText().length())
		{
			d1 = text[curIndex];
			d2 = text[curIndex + 1];
			
			if (curIndex < text.length - 2)
				curIndex += 2;
		}
			
		
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
