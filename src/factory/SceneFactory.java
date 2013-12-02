package factory;

import model.Environment;
import model.Script;
import model.View;
import io.ResourceFinder;
import scene.io.XMLReader;
import scene.visual.Scene;
import scene.visual.dynamic.described.AbstractSlidingSprite;
import scene.visual.dynamic.described.SlidingSprite;
import visual.dynamic.described.RuleBasedSprite;
import visual.statik.TransformableContent;
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
            scene = createScene(env,view, script, finder);
            System.out.println("Created scene!");
        }
        catch(Exception e)
        {
            //scene will just be null
            System.out.println("Exception thrown");
        }

        return scene;
    }

    private static Scene createScene(Environment env, View view, Script script, ResourceFinder finder)

    {
        Scene                           scene;
        ContentFactory                  contentFactory;
        Content                         content;
        AbstractSlidingSprite           rbSprite;
        RuleBasedSprite []              slidingSprites;
        ArrayList<TransformableContent> listOfContents;
        ArrayList<String>               foreground, background;
        int                             index;

        // Sliding Sprites
        listOfContents  = new ArrayList<TransformableContent>();
        contentFactory  = new ContentFactory(finder);
        foreground      = env.getForeground();
        slidingSprites  = new SlidingSprite[3];
        index           = 0;
        rbSprite        = null;

        if(foreground != null)
        {
            System.out.println(foreground.get(0));
            for (int i = 0; i < foreground.size(); i++)
            {
                content = contentFactory.createContent(foreground.get(i),3, false);
                listOfContents.add(content);
            }
        }

        if(listOfContents.size() > 0)
        {
            rbSprite = new SlidingSprite(view,listOfContents, 3, 640, 480);
            slidingSprites[index] = rbSprite;
        }

        /*if (env.getBackground() != null)

        {
            content             = contentFactory.createContent(env.getBackground(), false);
            rbSprite            = new SlidingSprite(content, 3, 640,480);
            slidingSprites[++index] = rbSprite;
        }

        if(env.getGround() != null)

        {
            content             = contentFactory.createContent(env.getGround(), false);
            rbSprite            = new SlidingSprite(content, 3, 640,480);
            slidingSprites[++index] = rbSprite;
        }*/

        scene = new Scene(slidingSprites, script.getSprites(), env, null, null);
        return scene;
    }


}
