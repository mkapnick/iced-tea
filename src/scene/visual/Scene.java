package scene.visual;

import model.Environment;
import scene.visual.content.MenuContent;
import visual.dynamic.described.RuleBasedSprite;
import visual.dynamic.described.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Mike Kapnick
 * @version 1.0
 *
 * A scene is made up of two kinds of sprites. Sprites are either
 * rule based or tweened. Thus, a scene must take in rule based and
 * tweening sprites. A scene acts an xml file.
 *
 * NOTE: SlidingMap and menuContent attributes are always
 * null. We had plans to associate a scene with them, but for now we
 * didn't have time to implement them, so when constructing a scene
 * the last 2 variables passed in are always null.
 *
 */
public class Scene
{

    private Color                               backgroundColor;
    private ArrayList<Sprite>                   movingSprites;
    private RuleBasedSprite []                  slidingSprites;
    private Environment                         environment;
    private boolean                             onStage;
    private HashMap<RuleBasedSprite, Integer>   slidingMap;
    private MenuContent[]                       menuContent;

    /*
     * Constructor for a Scene object. All scene objects must take in rule based sprites,
     * tweening sprites, and an environment. SlidingMap and menuContent are useless
     * and are always null
     */
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

    /*
     * Gets the tweening sprites associated with a Scene instance
     */
    public ArrayList<Sprite> getMovingSprites()
    {
        return this.movingSprites;
    }

     /*
     * Gets the rule based sprites associated with a Scene instance
     */

    public RuleBasedSprite [] getSlidingSprites()
    {
        return this.slidingSprites;
    }

    /*
      Sets the backgroud color associated with a Scene instance
     */

    public void setBackgroundColor(Color color)
    {
        this.backgroundColor = color;
    }

     /*
      Gets the backgroud color associated with a Scene instance
     */

    public Color getBackgroundColor()
    {
        return this.backgroundColor;
    }

     /*
      Gets the environment associated with a Scene instance
     */

    public Environment getEnvironment()
    {
        return this.environment;
    }

    /*
     * If all of the sprites associated with a particular scene have
     * already been added to the stage, then this method will return true.
     * Otherwise, it will return false
     */

    public boolean isOnStage()
    {
        return this.onStage;
    }

    /*
     * Every time a scene's sprites are added to the stage, this method
     * is called and is passed true
     */

    public void setOnStage(boolean onStage)
    {
        this.onStage = onStage;

    }
}
