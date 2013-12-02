package scene.visual;

import model.Environment;
import scene.visual.content.MenuContent;
import visual.dynamic.described.RuleBasedSprite;
import visual.dynamic.described.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Scene
{

    private Color                               backgroundColor;
    private ArrayList<Sprite>                   movingSprites;
    private RuleBasedSprite []                  slidingSprites;
    private Environment                         environment;
    private boolean                             onStage;
    private HashMap<RuleBasedSprite, Integer>   slidingMap;
    private MenuContent[]                       menuContent;

    public Scene (RuleBasedSprite [] slidingSprites,ArrayList<Sprite> movingSprites,
                  Environment env, HashMap<RuleBasedSprite, Integer> slidingMap, MenuContent [] menuContent)

    {
        this.movingSprites  = movingSprites;
        this.slidingSprites = slidingSprites;
        this.environment    = env;
        this.slidingMap     = slidingMap;
        this.menuContent    = menuContent;
        this.onStage        = false;
    }

    public ArrayList<Sprite> getMovingSprites()
    {
        return this.movingSprites;
    }

    public RuleBasedSprite [] getSlidingSprites()
    {
        return this.slidingSprites;
    }

    public void setBackgroundColor(Color color)
    {
        this.backgroundColor = color;
    }

    public Color getBackgroundColor()
    {
        return this.backgroundColor;
    }

    public Environment getEnvironment()
    {
        return this.environment;
    }

    public boolean isOnStage()
    {
        return this.onStage;
    }

    public void setOnStage(boolean onStage)
    {
        this.onStage = onStage;

    }
}
