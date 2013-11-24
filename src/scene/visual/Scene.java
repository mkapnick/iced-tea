package scene.visual;

import data.Environment;
import scene.visual.content.MenuContent;
import scene.visual.dynamic.described.SlidingSprite;
import visual.dynamic.described.AbstractSprite;
import visual.dynamic.described.RuleBasedSprite;
import visual.dynamic.described.Sprite;
import visual.statik.TransformableContent;

import java.util.ArrayList;
import java.util.HashMap;

public class Scene extends AbstractSprite
{

    private ArrayList<Sprite>                   movingSprites;
    private RuleBasedSprite []                  slidingSprites;
    private Environment                         environment;
    private HashMap<RuleBasedSprite, Integer>   slidingMap;
    private MenuContent[]                       menuContent;
    private TransformableContent                content;


    public Scene(RuleBasedSprite[] slidingSprites, ArrayList<Sprite> movingSprites,
                    Environment env, HashMap<RuleBasedSprite, Integer> slidingMap, MenuContent[] menuContent)
    {
        this.movingSprites  = movingSprites;
        this.slidingSprites = slidingSprites;
        this.environment    = env;
        this.slidingMap     = slidingMap;
        this.menuContent    = menuContent;
    }

    public ArrayList<Sprite> getMovingSprites()
    {
            return this.movingSprites;
    }

    public RuleBasedSprite [] getSlidingSprites()
    {
        return this.slidingSprites;
    }

    @Override
    public void handleTick(int i)
    {
        for(int j =0; j < slidingSprites.length; j++)
        {
            this.content = (SlidingSprite) slidingSprites[j].getContent();
            slidingSprites[j].handleTick(i);
        }

    }


    @Override
    public TransformableContent getContent()
    {
        return this.content;
    }
}
