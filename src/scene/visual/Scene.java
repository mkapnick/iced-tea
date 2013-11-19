package scene.visual;

import model.Environment;
import scene.visual.content.MenuContent;
import visual.dynamic.described.RuleBasedSprite;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Scene {

	private RuleBasedSprite []                  movingSprites;
	private RuleBasedSprite []                  slidingSprites;
	private Environment                         environment;
	private HashMap<RuleBasedSprite, Integer>   slidingMap;
	private MenuContent[]                       menuContent;
	
	public Scene(BufferedImage... slidingImages)
	{
		
	}

    public Scene (RuleBasedSprite [] movingSprites, RuleBasedSprite [] slidingSprites,
                  Environment env, HashMap<RuleBasedSprite, Integer> slidingMap, MenuContent [] menuContent)
    {
        this.movingSprites  = movingSprites;
        this.slidingSprites = slidingSprites;
        this.environment    = env;
        this.slidingMap     = slidingMap;
        this.menuContent    = menuContent;
    }
	
	public RuleBasedSprite [] getMovingSprites()
	{
		return this.movingSprites;
	}
	
	public RuleBasedSprite [] getSlidingSprites()
	{
		return this.slidingSprites;
	}

}
