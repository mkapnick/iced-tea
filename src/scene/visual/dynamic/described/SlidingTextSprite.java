package scene.visual.dynamic.described;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

public class SlidingTextSprite extends TextSprite {

	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	
	private int direction;
	private double speed;
	
	public SlidingTextSprite(String text, int direction, double speed)
	{
		super(text);
		this.direction = direction;
		this.speed = speed;
	}

	@Override
	public void handleTick(int time) {
		switch(direction)
		{
			case LEFT:
				setLocation(x - speed, y);
				break;
			case RIGHT:
				setLocation(x + speed, y);
				break;
			case UP:
				setLocation(x, y - speed);
				break;
			case DOWN:
				setLocation(x, y + speed);
				break;
			default:
				setLocation(x, y);
				break;
		}
		
	}

	@Override
	public void render(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		FontRenderContext fc = g2.getFontRenderContext();
		GlyphVector glyphs = font.createGlyphVector(fc, text);
		Shape s = glyphs.getOutline((float)x,(float)y + font.getSize());
		g2.setColor(color);
		g2.setStroke(new BasicStroke());
		g2.fill(s);
		g2.draw(s);
		
	}
	
	
}
