package scene.visual;

import model.Environment;
import scene.visual.content.MenuContent;
import visual.dynamic.described.RuleBasedSprite;

import java.awt.image.BufferedImage;
import java.util.HashMap;

<<<<<<< HEAD
public class Scene {

	private RuleBasedSprite []                  movingSprites;
	private RuleBasedSprite []                  slidingSprites;
	private Environment                         environment;
	private HashMap<RuleBasedSprite, Integer>   slidingMap;
	private MenuContent[]                       menuContent; //Change?
	//private TreeNode<MenuContent>				menuContent;
	//TODO Instead of an array of MenuContents, how about a TreeNode<MenuContent>?
	//Each scene will have a part of the conversation, but more than one question/answer.
	//From the look of SceneNode, it acts very similarly to TreeNode, so why not just use
	//that for Scenes as well? - Daniel
	public Scene(BufferedImage... slidingImages)
	{
		
	}

    public Scene (RuleBasedSprite [] movingSprites, RuleBasedSprite [] slidingSprites,
                  Environment env, HashMap<RuleBasedSprite, Integer> slidingMap, MenuContent [] menuContent)
=======
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
>>>>>>> 963f4f216ee0f858d5f4618353a2cf1d719c3561
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

<<<<<<< HEAD
=======
    public ArrayList<Sprite> getMovingSprites()
    {
        return this.movingSprites;
    }

    public RuleBasedSprite [] getSlidingSprites()
    {
        return this.slidingSprites;
    }

>>>>>>> 963f4f216ee0f858d5f4618353a2cf1d719c3561
}
