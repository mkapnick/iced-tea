package scene.visual;

import io.ResourceFinder;
import model.Environment;
import model.Script;
import model.View;
import scene.io.XMLReader;
import scene.visual.dynamic.sampled.SlidingSprite;
import visual.dynamic.described.RuleBasedSprite;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;

import java.util.ArrayList;


public class SceneFactory {

	public static Scene createScene(Environment env, View view, Script script, ResourceFinder finder, String fileName)
	{
        Scene scene;
        scene = null;

        try
        {
            System.out.println("ABOUT TO CALL XML PARSE FILE");
            XMLReader.parseXMLFile(fileName, env, script, finder);
            System.out.println("Parsed XML file");
            scene = createScene(env, script, finder);
            System.out.println("Created scene!");
        }
        catch(Exception e)
        {
            System.out.println("Exception thrown");
            //scene will just be null
        }
        return scene;

    }
    private static Scene createScene(Environment env, Script script, ResourceFinder finder)
    {
        Scene               scene;
        ContentFactory      contentFactory;
        Content             content;
        RuleBasedSprite []  slidingSprites;
        RuleBasedSprite     rbSprite;
        ArrayList<String>   foreground;
        int                 i;


        // Sliding Sprites
        contentFactory  = new ContentFactory(finder);
        foreground      = env.getForeground();
        slidingSprites  = new SlidingSprite [foreground.size() + 2];
        i               = 0;

        for(i =0; i < foreground.size(); i++)
        {
            content             = contentFactory.createContent(foreground.get(i), false);
            rbSprite            = new SlidingSprite(content, 4, 640,480);
            slidingSprites[i]   = rbSprite;
        }

        if (env.getBackground() != null)
        {
            content             = contentFactory.createContent(env.getBackground(), false);
            rbSprite            = new SlidingSprite(content, 4, 640,480);
            slidingSprites[i++] = rbSprite;
        }

        if(env.getGround() != null)
        {
            content             = contentFactory.createContent(env.getGround(), false);
            rbSprite            = new SlidingSprite(content, 4, 640,480);
            slidingSprites[i++] = rbSprite;
        }

        scene = new Scene(slidingSprites, script.getSprites(), env, null, null);

        return scene;
    }
}
