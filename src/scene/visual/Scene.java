package scene;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import visual.content.MenuContent;
import visual.dynamic.described.RuleBasedSprite;
import visual.statik.sampled.ContentFactory;
import data.Environment;

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
