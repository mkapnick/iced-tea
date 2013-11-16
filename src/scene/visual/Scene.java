package scene.visual;

import visual.dynamic.described.RuleBasedSprite;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/15/13
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Scene {

    private RuleBasedSprite [] addedSprites;
    private RuleBasedSprite [] slidingSprites;
    private Environment environment;
    private HashMap <RuleBasedSprite, Integer> slidingMap;
    private MenuContent [] menuContents;

    public Scene(RuleBasedSprite [] addedSprites, RuleBasedSprite [] slidingSprites,
                 Environment environment, HashMap<RuleBasedSprite, Integer> slidingMap,
                 MenuContent [] menuContents)
    {

        this.addedSprites       = addedSprites;
        this.slidingSprites     = slidingSprites;
        this.environment        = environment;
        this.slidingMap         = slidingMap;
        this.menuContents       = menuContents;
    }

    public RuleBasedSprite[] getAddedSprites() {
        return addedSprites;
    }
    public Environment getEnvironment() {
        return environment;
    }

    public MenuContent[] getMenuContents() {
        return menuContents;
    }

    public HashMap<RuleBasedSprite, Integer> getSlidingMap() {
        return slidingMap;
    }

    public RuleBasedSprite[] getSlidingSprites() {
        return slidingSprites;
    }

    public void setAddedSprites(RuleBasedSprite[] addedSprites) {
        this.addedSprites = addedSprites;
    }

    public void setSlidingSprites(RuleBasedSprite[] slidingSprites) {
        this.slidingSprites = slidingSprites;
    }
}
