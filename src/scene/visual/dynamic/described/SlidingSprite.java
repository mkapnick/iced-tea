package scene.visual.dynamic.described;

import visual.dynamic.described.RuleBasedSprite;
import visual.statik.TransformableContent;

public class SlidingSprite extends RuleBasedSprite {

	private int speed;
	private double x, y, maxX, maxY;
	
	public SlidingSprite(TransformableContent c, int speed, double x, double y)
	{
		super(c);
        this.maxX = x;
        this.maxY = y;
		this.speed = speed;
		this.x = 0;
		this.y = 0;
        setVisible(true);
	}
	
	@Override
	public void handleTick(int time)
    {
        y +=1;
        if(y >= (maxY /2) + 10 )
        {
            y = 0;
        }
        setLocation(x, y);
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
