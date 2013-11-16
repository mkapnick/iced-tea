package scene.visual;

import model.Environment;
import scene.visual.content.MenuContent;
import visual.dynamic.described.RuleBasedSprite;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public abstract class Scene {

	private RuleBasedSprite[] addedSprites;
	private RuleBasedSprite[] slidingSprites;
	private Environment environment;
	private HashMap<RuleBasedSprite, Integer> slidingMap;
	private MenuContent[] menuContent;
	
	public Scene(BufferedImage... slidingImages)
	{
		
	}
	
	public RuleBasedSprite[] getAddedSprites()
	{
		return this.addedSprites;
	}
	
	public RuleBasedSprite[] getSlidingSprites()
	{
		return this.slidingSprites;
	}

}
