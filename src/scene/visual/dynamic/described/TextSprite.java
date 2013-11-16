package scene.visual.dynamic.described;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;

import visual.dynamic.described.Sprite;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/16/13
 * Time: 9:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class TextSprite implements Sprite
{
	public final int SCROLL_SPEED = 5;
	private boolean isScrolling;
	private int numLettersPrinted;
	private String text;
	
	public TextSprite(String text, boolean isScrolling)
	{
		this.isScrolling = isScrolling;
		this.text = text;
		
		if (isScrolling)
			numLettersPrinted = 1;
		else
			numLettersPrinted = text.length();
	}
	
	public void handleTick(int time)
	{
		numLettersPrinted++;
	}

	@Override
	public Rectangle2D getBounds2D(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLocation(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRotation(double arg0, double arg1, double arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScale(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		
		FontRenderContext fc = g2.getFontRenderContext();
		Font f = new Font("Arial",Font.BOLD, 18);
		GlyphVector glyphs = f.createGlyphVector(fc, text.substring(0, numLettersPrinted));
		Shape s = glyphs.getOutline(0.0f,100.0f);
		
	}
}
