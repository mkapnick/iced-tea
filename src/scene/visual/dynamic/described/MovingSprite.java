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

    public MovingSprite(Content content)
    {
        super();
        this.content = content;
    }

    public void addKeyTime(int time, double x, double y, double r, double s)
    {
        addKeyTime(time, new Point2D.Double(x, y), new Double(r), new Double(s), this.content);
    }

    public void setEndState()
    {
        setEndState(REMAIN);
    }

    public TransformableContent getContent()
    {
        return this.content;
    }

}
