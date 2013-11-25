package scene.visual.dynamic.described;

import visual.dynamic.described.RuleBasedSprite;
import visual.statik.TransformableContent;

public class SlidingSprite extends RuleBasedSprite {

	private int speed;
	private double x, y;
	
	public SlidingSprite(TransformableContent c, int speed, double x, double y)
	{
		super(c);
		this.speed = speed;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void handleTick(int time)
    {
        setLocation(x-=5, y);
	}

    public int getSpeed()
    {
        return this.speed;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }
}
