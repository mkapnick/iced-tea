package scene.visual.dynamic.described;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;

import visual.dynamic.described.Sprite;
import visual.statik.described.AggregateContent;

/**
 * Dynamic text. As time passes, more of the text is rendered.
 * 
 * @author Daniel Hardgrove
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 * 11/16/13
 */
public class TextSprite extends AggregateContent implements Sprite
{
	private int numLettersPrinted;
	private String text;
	private Font font;
	private Shape shape;
	private double x,y;
	
	/**
	 * @param text - the text to be rendered
	 * @param isScrolling - controls if the text will appear at once 
	 * 						or over time.
	 */
	public TextSprite(String text, boolean isScrolling)
	{
		this.text = text; 
		if (isScrolling)
			numLettersPrinted = 1;
		else
			numLettersPrinted = text.length();
		
		this.font = new Font("Arial", Font.PLAIN, 18);
	}
	
	public Font getFont()
	{
		return this.font;
	}
	
	/**
	 * The number of letters rendered is incremented for each
	 * time the method is called.
	 */
	public void handleTick(int time)
	{
		if (numLettersPrinted < text.length())
			numLettersPrinted++;
	}

	@Override
	public Rectangle2D getBounds2D(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFont(Font font)
	{
		this.font = font;
	}
	@Override
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
		
	}

	@Override
	public void setRotation(double arg0, double arg1, double arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScale(double horiz, double vert) {
		
		
	}

	@Override
	public void render(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		//System.out.println("Num letters printed: " + numLettersPrinted);
		FontRenderContext fc = g2.getFontRenderContext();
		GlyphVector glyphs = font.createGlyphVector(fc, text.substring(0, numLettersPrinted));
		Shape s = glyphs.getOutline((float)x,(float)y + font.getSize());
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke());
		g2.fill(s);
		g2.draw(s);
		
	}
}
