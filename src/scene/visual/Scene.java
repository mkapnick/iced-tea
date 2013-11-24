package scene.visual;

import data.Environment;
import scene.visual.content.MenuContent;
import visual.dynamic.described.RuleBasedSprite;
import visual.dynamic.described.Sprite;
import visual.statik.TransformableContent;

import java.util.ArrayList;
import java.util.HashMap;

public class Scene
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

}
