package scene.visual.dynamic.described;

import java.awt.Graphics;

public class MergingTextSprite extends TextSprite {

	public static final int VERTICAL = 0;
	public static final int HORIZONTAL = 1;
	
	private double speed;
	private SlidingTextSprite half1, half2;
	
	public MergingTextSprite(String text, double speed)
	{
		super(text);
		this.speed = speed;
		
		half1 = new SlidingTextSprite(text.substring(0, text.length() / 2), SlidingTextSprite.LEFT, 1);
		half2 = new SlidingTextSprite(text.substring(text.length() / 2), SlidingTextSprite.RIGHT, 1);
	}

	@Override
	public void handleTick(int time) {
		half1.handleTick(time);
		half2.handleTick(time);
	}

	@Override
	public void render(Graphics g) {
		half1.render(g);
		half2.render(g);
		
	}
	
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
}
