package scene.visual;

import io.ImageReader;
import io.ResourceFinder;
import model.Environment;
import model.View;
import scene.visual.dynamic.sampled.SlidingSprite;
import visual.dynamic.described.RuleBasedSprite;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;

import java.awt.image.BufferedImage;


public class SceneFactory {

	public static Scene createScene(Environment env, View view, ResourceFinder finder)
	{
        String              background, ground;
        String []           foreground;
        BufferedImage []    foregroundImages;
        BufferedImage       backgroundImage, groundImage;
        Scene               scene;

        scene       = null;
        background  = env.getBackground();
        foreground  = env.getForeground();
        ground      = env.getGround();

        switch (view)
        {
            case BIRDSEYE:
                foregroundImages    = parseForeGround(foreground, finder);  //Always a sliding sprite
                groundImage         = ImageReader.readFile(ground, finder); //Always a sliding sprite
                scene               = turnIntoSprites(foregroundImages, groundImage, null, finder);
                break;
            case SIDEVIEW:
                foregroundImages    = parseForeGround(foreground, finder);
                backgroundImage     = ImageReader.readFile(background, finder);
                groundImage         = ImageReader.readFile(ground, finder);
                scene               = turnIntoSprites(foregroundImages, groundImage, backgroundImage, finder);
                break;
            case INCAR:
                backgroundImage     = ImageReader.readFile(background, finder); //Always a sliding sprite
                scene               = turnIntoSprites(null, null, backgroundImage, finder);
                break;
        }
		return scene;
	}

    private static BufferedImage [] parseForeGround(String [] foreground, ResourceFinder finder)
    {
        BufferedImage       image;
        BufferedImage []    foregrounds;

        foregrounds = new BufferedImage[foreground.length];

        for (int i =0; i < foreground.length; i++)
        {
            image = ImageReader.readFile(foreground[i], finder);
            foregrounds[i] = image;
        }

        return foregrounds;
    }

    private static Scene turnIntoSprites(BufferedImage [] foregroundImages, BufferedImage groundImage,
                                        BufferedImage backgroundImage, ResourceFinder finder)
    {
        ContentFactory      contentFactory;
        Content             content;
        RuleBasedSprite     rbSprite;
        Scene               scene;
        RuleBasedSprite []  slidingSprites;
        RuleBasedSprite []  addedSprites;
        int                 i;

        //ArrayList<RuleBasedSprite>  slidingSprites, addedSprites;

        scene               = null;
        i                   = 0;
        slidingSprites      = new RuleBasedSprite [foregroundImages.length +2];
        addedSprites        = new RuleBasedSprite [2];
        contentFactory      = new ContentFactory(finder);

        if (foregroundImages != null)
        {
            for (i=0; i < foregroundImages.length; i++)
            {
                content             = contentFactory.createContent(foregroundImages[i], false);
                rbSprite            = new SlidingSprite(content, 4, 640,480);
                slidingSprites[i]   = rbSprite;
            }
        }

        /* Wasn't sure if groundImage and backgroundImage are always sliding sprites, in this case,
           I just decided to add both of them as sliding sprite. This can be easily changed though
         */
        if (groundImage != null)
        {
            content             = contentFactory.createContent(groundImage, false);
            rbSprite            = new SlidingSprite(content, 4, 640,480);
            slidingSprites[i++] = rbSprite;
        }

        if(backgroundImage != null)
        {
            content             = contentFactory.createContent(backgroundImage, false);
            rbSprite            = new SlidingSprite(content, 4, 640,480);
            slidingSprites[i++] = rbSprite;
        }

        //scene = new Scene(...);
        return scene;
    }
}
