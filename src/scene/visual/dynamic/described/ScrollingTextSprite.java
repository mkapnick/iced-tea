package scene.visual.dynamic.described;

import java.awt.*;
import java.awt.font.FontRenderContext;

public class ScrollingTextSprite extends TextSprite {

	private int numLettersPrinted;
	
	public ScrollingTextSprite(String text, boolean isScrolling)
	{
		super(text);
		
		if (isScrolling)
			numLettersPrinted = 1;
		else
			numLettersPrinted = text.length();
	}
	
	public void handleTick(int time)
	{
		if (numLettersPrinted < text.length())
            //System.out.println("weee");
			numLettersPrinted++;
	}
	
	public void render(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		FontRenderContext fc = g2.getFontRenderContext();
		glyphText = font.createGlyphVector(fc, text.substring(0, numLettersPrinted));
		Shape s = glyphText.getOutline((float)x,(float)y + font.getSize());
		g2.setColor(color);
		g2.setStroke(new BasicStroke());
		g2.fill(s);
		g2.draw(s);
		
	}
}
