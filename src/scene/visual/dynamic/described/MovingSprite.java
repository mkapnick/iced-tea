package scene.visual.dynamic.described;

import visual.dynamic.described.SampledSprite;
import visual.statik.TransformableContent;
import visual.statik.sampled.Content;

import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/16/13
 * Time: 9:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class MovingSprite extends SampledSprite
{
    private Content content;
    private int     keyTime;

    public MovingSprite(Content content)
    {
        super();
        this.content = content;
    }

    public void addKeyTime(int time, double x, double y, double r, double s, Content c)
    {
        if(c == null)
            addKeyTime(time, new Point2D.Double(x, y), new Double(r), new Double(s), this.content);
        else
            addKeyTime(time, new Point2D.Double(x, y), new Double(r), new Double(s), c);


    }

    public void setEndState()
    {
        setEndState(REMAIN);
    }

    public TransformableContent getContent()
    {
        return this.content;
    }

    public void setKeyTime(int keyTime)
    {
        this.keyTime = keyTime;
    }

    public int getKeyTime()
    {
        return this.keyTime;
    }

}
