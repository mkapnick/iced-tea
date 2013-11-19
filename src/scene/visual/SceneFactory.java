package scene.visual;

import io.ImageReader;
import io.ResourceFinder;
import model.Environment;
import model.View;
import scene.visual.dynamic.sampled.MovingSprite;
import scene.visual.dynamic.sampled.SlidingSprite;
import visual.dynamic.described.RuleBasedSprite;
import visual.dynamic.described.SampledSprite;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;

import java.awt.image.BufferedImage;


public class SceneFactory {

	public static Scene createScene(Environment env, View view, ResourceFinder finder)
	{
        String              background, ground;
        String []           foreground, movingSprites;
        BufferedImage []    foregroundImages, movingSpriteImages;
        BufferedImage       backgroundImage, groundImage;
        Scene               scene;

        scene           = null;
        background      = env.getBackground();
        foreground      = env.getForeground();
        ground          = env.getGround();
        movingSprites   = env.getMovingSprites();

        switch (view)
        {
            case BIRDSEYE:
                foregroundImages    = parseArrayOfImages(foreground, finder);  //Always a sliding sprite
                movingSpriteImages  = parseArrayOfImages(movingSprites, finder); //Always a moving sprite
                groundImage         = ImageReader.readFile(ground, finder); //Always a sliding sprite
                scene               = turnIntoScene(foregroundImages, movingSpriteImages, groundImage,
                                                    null, finder);
                break;
            case SIDEVIEW:
                foregroundImages    = parseArrayOfImages(foreground, finder);
                movingSpriteImages  = parseArrayOfImages(movingSprites, finder);
                backgroundImage     = ImageReader.readFile(background, finder); //Always a sliding sprite
                groundImage         = ImageReader.readFile(ground, finder);
                scene               = turnIntoScene(foregroundImages, movingSpriteImages, groundImage,
                                                    backgroundImage, finder);
                break;
            case INCAR:
                movingSpriteImages  = parseArrayOfImages(movingSprites, finder);
                backgroundImage     = ImageReader.readFile(background, finder);
                scene               = turnIntoScene(null, movingSpriteImages, null, backgroundImage, finder);
                break;
        }
		return scene;
	}

    private static BufferedImage [] parseArrayOfImages(String [] arrayOfImages, ResourceFinder finder)
    {
        BufferedImage       image;
        BufferedImage []    images;

        images = new BufferedImage[arrayOfImages.length];

        for (int i =0; i < arrayOfImages.length; i++)
        {
            image = ImageReader.readFile(arrayOfImages[i], finder);
            images[i] = image;
        }

        return images;
    }

    private static Scene turnIntoScene(BufferedImage [] foregroundImages, BufferedImage [] movingSpriteImages,
                                         BufferedImage groundImage,BufferedImage backgroundImage, ResourceFinder finder)
    {
        ContentFactory      contentFactory;
        Content             content;
        RuleBasedSprite     rbSprite;
        SampledSprite       sampledSprite;
        Scene               scene;
        RuleBasedSprite []  slidingSprites;
        RuleBasedSprite []  movingSprites;
        int                 i;


        scene               = null;
        i                   = 0;
        movingSprites       = new RuleBasedSprite [movingSpriteImages.length];
        contentFactory      = new ContentFactory(finder);

        if(foregroundImages == null && groundImage == null)
            slidingSprites  = new RuleBasedSprite [1]; //IN-CAR only has a background
        else if (backgroundImage == null)
            slidingSprites  = new RuleBasedSprite [foregroundImages.length +1]; //BIRDSEYE only has foreground and ground
        else
            slidingSprites  = new RuleBasedSprite [foregroundImages.length +2]; //SIDEVIEW has foreground, ground, and background


        if (foregroundImages != null)
        {
            for (i=0; i < foregroundImages.length; i++)
            {
                content             = contentFactory.createContent(foregroundImages[i], false);
                rbSprite            = new SlidingSprite(content, 4, 640,480);
                slidingSprites[i]   = rbSprite;
            }
        }

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

        for (int j =0; j < movingSprites.length; j++)
        {
            content             = contentFactory.createContent(movingSpriteImages[i], false);
            sampledSprite       = new MovingSprite(content);
            //movingSprites[i]    = sampledSprite; //Design flaw here
        }

        //scene = new Scene(...);
        return scene;
    }
}
