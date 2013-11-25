<<<<<<< HEAD
=======
import app.AbstractMultimediaApp;
import io.ResourceFinder;
import scene.visual.Scene;
import scene.visual.dynamic.described.SlidingSprite;
import visual.VisualizationView;
import visual.dynamic.described.RuleBasedSprite;
import visual.dynamic.described.Sprite;
import visual.dynamic.described.Stage;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;
import visual.statik.sampled.ImageFactory;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;

>>>>>>> 963f4f216ee0f858d5f4618353a2cf1d719c3561
/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/15/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class FinalApp {

<<<<<<< HEAD

=======
public class FinalApp extends AbstractMultimediaApp
{
    private Stage stage;
    private VisualizationView stageView;

    public FinalApp()
    {
        stage = new Stage(50);
        stageView = stage.getView();
    }

    public void init()
    {

        startUp();

    }

    public void startUp()
    {
        ResourceFinder finder;
        BufferedReader br;
        InputStream is;
        Scene introScene, cityScene, forestScene, mountainScene, snowScene, finalScene;

        finder = ResourceFinder.createInstance();
        System.out.println("JUST BEFORE SCENE FACTORY CALL");

        //Construct all possible scenes
        //introScene      = SceneFactory.createScene(Environment.INTRO, View.BIRDSEYE,
        //                                        Script.INTRO_SCRIPT, finder, "introScene.xml");
        /*
        cityScene       = SceneFactory.createScene(Environment.CITY, View.SIDEVIEW,
                                                Script.CITY_SCRIPT, finder, "cityScene.xml");

        forestScene     = SceneFactory.createScene(Environment.FOREST, View.SIDEVIEW,
                                                Script.FOREST_SCRIPT, finder, "forestScene.xml");

        mountainScene   = SceneFactory.createScene(Environment.MOUNTAINS, View.SIDEVIEW,
                                                Script.MOUNTAIN_SCRIPT, finder, "mountainScene.xml");

        snowScene       = SceneFactory.createScene(Environment.SNOW, View.SIDEVIEW,
                                                Script.SNOW_SCRIPT, finder, "snowScene.xml");

        finalScene      = SceneFactory.createScene(Environment.FINAL, View.SIDEVIEW,
                                                Script.FINAL_SCRIPT, finder, "finalScene.xml");

        */

        System.out.println("Constructed all scenes");
        //addSceneToStage(introScene);
        justGetSomethingOnTheScreen(finder);
    }

    private void justGetSomethingOnTheScreen(ResourceFinder finder)
    {
        System.out.println("Before");
        Content content;
        ContentFactory factory;
        ImageFactory imageFactory;
        Image image;
        Sprite slidingSprite;

        System.out.println("Here");

        factory = new ContentFactory(finder);
        imageFactory = new ImageFactory(finder);
        stage.setBackground(Color.BLUE);

        System.out.println("image factory before");
        image = imageFactory.createBufferedImage("birds_eye_view_first_scene_no_car.png", 4);
        System.out.println("image factory after");
        content = factory.createContent(image,false);
        System.out.println("After content");
        Fish fish;
        fish = new Fish(content, 640, 480, 3.);
        slidingSprite = new SlidingSprite(content, 10, 0,0);
        System.out.println("Maybe?");
        stage.add(fish);

        System.out.println("Here 2");

        System.out.println("Added scene to stage");
        JPanel contentPane = (JPanel) rootPaneContainer.getContentPane();
        stageView = stage.getView();
        stageView.setBounds(0, 0, 1000, 1000);
        contentPane.add(stageView);
        System.out.println("Before stage start");
        stage.start();
        System.out.println("stage started");
        contentPane.setVisible(true);
        //justGetSomethingOnTheScreen(finder);
        System.out.println("After");
    }

    private void addSceneToStage(Scene scene)
    {
        ArrayList<Sprite> movingSprites;
        RuleBasedSprite[]  slidingSprites;

        slidingSprites  = scene.getSlidingSprites();
        movingSprites   = scene.getMovingSprites();

        for(int i =0; i < slidingSprites.length; i++)
        {
            if(slidingSprites[i] != null)
            {
                System.out.println(slidingSprites[i]);
                stage.add(slidingSprites[i]);
            }
        }

        /*for(int j =0; j < movingSprites.size(); j++)
        {
            System.out.println(movingSprites.get(j));
            stage.add(movingSprites.get(j));
        }*/

    }
>>>>>>> 963f4f216ee0f858d5f4618353a2cf1d719c3561
}
