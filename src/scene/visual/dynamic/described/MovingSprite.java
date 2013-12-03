package scene.visual.dynamic.described;

import visual.dynamic.described.SampledSprite;
import visual.statik.TransformableContent;
import visual.statik.sampled.Content;

import java.awt.geom.Point2D;

/**
 * Creates a sampled sprite with key times
 * @author Mike Kapnick
 * @version 1.0
 *
 * This work complies with the JMU Honor Code
 * 12/3/13
 *
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

    /*
     * Always set the end state of these moving sprites to remain on the stage
     */
    public void setEndState()
    {
        setEndState(REMAIN);
    }

    /*
     * Gets the content associated with the sprite
     */

    public TransformableContent getContent()
    {
        return this.content;
    }

    /*
     * Each moving sprite has many key times associated with itself. Every key time we
     * parse in the xml file, we set the keyTime to which ever instance is being built
     * in the XML reader class.
     *
     */

    public void setKeyTime(int keyTime)
    {
        this.keyTime = keyTime;
    }

    /*
     * Gets the key time for a particular instance of this class
     */

    public int getKeyTime()
    {
        return this.keyTime;
    }

}
