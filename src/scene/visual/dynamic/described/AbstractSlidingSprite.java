package scene.visual.dynamic.described;

import visual.dynamic.described.RuleBasedSprite;
import visual.statik.TransformableContent;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/25/13
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractSlidingSprite extends RuleBasedSprite
{
    public ArrayList<TransformableContent>   listOfContents;
    public int                               index;
    public int                               speed;
    public double                            x, y, maxX, maxY;

    public AbstractSlidingSprite(ArrayList<TransformableContent> tc)
    {
        super(tc.get(0));
        this.listOfContents = tc;
    }

    @Override
    public abstract void handleTick(int time);


}
