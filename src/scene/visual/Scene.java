package scene.visual;

import model.Environment;
import scene.visual.content.MenuContent;
import visual.dynamic.described.RuleBasedSprite;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Scene {

	private ArrayList<RuleBasedSprite>          addedSprites;
	private ArrayList<RuleBasedSprite>          slidingSprites;
	private Environment                         environment;
	private HashMap<RuleBasedSprite, Integer>   slidingMap;
	private MenuContent[]                       menuContent;
	
	public Scene(BufferedImage... slidingImages)
	{
		
	}

    public Scene(ArrayList<BufferedImage> images)
    {

    }

    public Scene (ArrayList<RuleBasedSprite> addedSprites, ArrayList<RuleBasedSprite> slidingSprites)
                  //Environment env, HashMap<RuleBasedSprite, Integer> slidingMap, MenuContent [] menuContent)
    {
        this.addedSprites   = addedSprites;
        this.slidingSprites = slidingSprites;
        //this.environment    = env;
        //this.slidingMap     = slidingMap;
        //this.menuContent    = menuContent;
    }
	
	public ArrayList<RuleBasedSprite> getAddedSprites()
	{
		return this.addedSprites;
	}
	
	public ArrayList<RuleBasedSprite> getSlidingSprites()
	{
		return this.slidingSprites;
	}

}
