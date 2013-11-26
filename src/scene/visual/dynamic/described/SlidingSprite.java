package scene.visual.dynamic.described;

import visual.statik.TransformableContent;

import java.util.ArrayList;

public class SlidingSprite extends AbstractSlidingSprite
{

	private int speed;
	private double x, y, maxX, maxY;

	
	public SlidingSprite(ArrayList<TransformableContent> tc, int speed, double x, double y)
	{
        super(tc);
        this.maxX = x;
        this.maxY = y;
		this.speed = speed;
		this.x = 0;
		this.y = -800;
        this.index = 0;
        setVisible(true);
	}
	
	@Override
	public void handleTick(int time)
    {
        y +=1;
        if(y >= maxY)
        {
            if(++this.index < this.listOfContents.size())
            {
                this.content = this.listOfContents.get(index);
                y = -800;
            }
            else
            {
                System.out.println("TIME TO STOP");
            }
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
