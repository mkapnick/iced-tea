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
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SceneFactory {

	public static Scene createScene(Environment env, View view, ResourceFinder finder)
	{
        String                      background, ground, foreground;
        ArrayList<BufferedImage>    foregroundImages;
        BufferedImage               backgroundImage, groundImage;
        Scene                       scene;

        scene       = null;
        background  = env.getBackground();
        foreground  = env.getForeground();
        ground      = env.getGround();

        switch (view)
        {
            case BIRDSEYE:
                foregroundImages    = parseForeGround(foreground, finder);  //Moving Sprite..
                groundImage         = ImageReader.readFile(ground, finder); //Always a sliding sprite
                scene               = turnIntoSprites(foregroundImages, groundImage, null, finder);
                break;
            case SIDEVIEW:
                foregroundImages    = parseForeGround(foreground, finder);
                backgroundImage     = ImageReader.readFile(background, finder); //Always a sliding sprite
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

    private static ArrayList<BufferedImage> parseForeGround(String foreground, ResourceFinder finder)
    {
        StringTokenizer             st;
        ArrayList<BufferedImage>    images;
        BufferedImage               image;

        st     = new StringTokenizer(foreground, ",");
        images = new ArrayList<BufferedImage>();

        while (st.hasMoreTokens())
        {
            image = ImageReader.readFile(st.nextToken(), finder);
            images.add(image);
        }

        return images;

    }

    private static Scene turnIntoSprites(ArrayList<BufferedImage> foregroundImages, BufferedImage groundImage,
                                        BufferedImage backgroundImage, ResourceFinder finder)
    {
        ContentFactory              contentFactory;
        Content                     content;
        RuleBasedSprite             rbSprite;
        Scene                       scene;
        ArrayList<RuleBasedSprite>  slidingSprites, addedSprites;

        scene               = null;
        slidingSprites      = new ArrayList<RuleBasedSprite>();
        addedSprites        = new ArrayList<RuleBasedSprite>();
        contentFactory      = new ContentFactory(finder);

        if (groundImage != null)
        {
            content             = contentFactory.createContent(groundImage, false);
            rbSprite            = new SlidingSprite(content, 4, 640,480);
            slidingSprites.add(rbSprite);
        }

        if(backgroundImage != null)
        {
            content             = contentFactory.createContent(backgroundImage, false);
            rbSprite            = new SlidingSprite(content, 4, 640,480);
            slidingSprites.add(rbSprite);
        }

        if (foregroundImages != null)
        {
            //Moving sprite or Rule based sprite ?.....
            for (int i =0; i < foregroundImages.size(); i++)
            {
                // For now, foreground images are rule based sprites for simplicity
                content     = contentFactory.createContent(foregroundImages.get(i), false);
                rbSprite    = new SlidingSprite(content, 4, 640,480);
                addedSprites.add(rbSprite);
            }

            scene = new Scene(slidingSprites, addedSprites);
        }

        return scene;
    }
}
