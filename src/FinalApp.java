import app.AbstractMultimediaApp;
import data.Environment;
import data.Script;
import data.View;
import io.ResourceFinder;
import scene.visual.Scene;
import scene.visual.SceneFactory;
import visual.VisualizationView;
import visual.dynamic.described.RuleBasedSprite;
import visual.dynamic.described.Sprite;
import visual.dynamic.described.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/15/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */

public class FinalApp extends AbstractMultimediaApp
{
    private Stage stage;
    private VisualizationView stageView;

    public FinalApp()
    {
        stage = new Stage(50);
        stageView = stage.getView();
        stage.setBackground(new Color(158,209,144));
        stageView.setBounds(0, 0, 640, 480);
    }

    public void init()
    {

        startUp();
        JPanel contentPane = (JPanel) rootPaneContainer.getContentPane();
        contentPane.add(stageView);
        System.out.println("Before stage start");
        stage.start();
        System.out.println("stage started");
        contentPane.setVisible(true);
        System.out.println("After");

    }

    public void startUp()
    {
        ResourceFinder finder;
        BufferedReader br;
        InputStream is;
        Scene introScene, cityScene, forestScene, mountainScene, snowScene, finalScene;

        finder = ResourceFinder.createInstance(this);
        System.out.println("JUST BEFORE SCENE FACTORY CALL");

        //Construct all possible scenes
        introScene      = SceneFactory.createScene(Environment.INTRO, View.BIRDSEYE,
                                                    Script.INTRO_SCRIPT, finder, "introScene.xml");
        addSceneToStage(introScene);

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



    }

    private void addSceneToStage(Scene scene)
    {
        ArrayList<Sprite> movingSprites;
        RuleBasedSprite[]  slidingSprites;

        slidingSprites  = scene.getSlidingSprites();
        movingSprites   = scene.getMovingSprites();

        stage.add(slidingSprites[0]);

        for(int j =0; j < slidingSprites.length; j++)
        {
            if(slidingSprites[j] != null)
            {
                System.out.println(slidingSprites[j]);
                stage.add(slidingSprites[j]);
            }
        }

        for(int i =0; i < movingSprites.size(); i++)
        {
            if(movingSprites.get(i) != null)
            {
                System.out.println(movingSprites.get(i));
                stage.add(movingSprites.get(i));
            }
        }
    }
}
