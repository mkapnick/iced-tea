package scene.visual.dynamic.described;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

import visual.statik.TransformableContent;

public class BasicTextSprite extends TextSprite {

	public BasicTextSprite(String text)
	{
		super(text);
	}
	
	public void render(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		FontRenderContext fc = g2.getFontRenderContext();
		glyphText = font.createGlyphVector(fc, text);
		Shape s = glyphText.getOutline((float)x,(float)y + font.getSize());
		g2.setColor(color);
		g2.setStroke(new BasicStroke());
		g2.fill(s);
		g2.draw(s);
	}

	@Override
	public void handleTick(int time) {
		// TODO Auto-generated method stub
		
	}

}
