package scene.visual.dynamic.described;

import io.ResourceFinder;
import visual.dynamic.described.SampledSprite;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;

import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/16/13
 * Time: 9:12 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class MovingSprite extends SampledSprite
{
    private String imageName;
    protected Content content;

    public MovingSprite(String imageName)
    {
        super();
        this.imageName = imageName;

        init();
    }

    private void init()
    {
        visual.statik.sampled.ContentFactory factory;

        factory = new ContentFactory(ResourceFinder.createInstance(this));
        content = factory.createContent(this.imageName);
    }

    protected void addKeyTime(int time, double x, double y, double r, double s, Content c)
    {
        addKeyTime(time, new Point2D.Double(x,y), new Double(r), new Double(s), c);
    }



}
