import app.AbstractMultimediaApp;
import controller.SceneController;
import io.ResourceFinder;
import model.Environment;
import model.EventNode;
import model.Script;
import model.View;
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
        stageView.setBackground(new Color(111,174,223));
        //stage.setBackground();
        stageView.setBounds(0, 0, 640, 480);
    }

    public void init()
    {

        startUp();

        SceneController     sceneController;
        EventNode<Scene>    eventNode;


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
        //introScene.setBackgroundColor(new Color(158,209,144));
        addSceneToStage(introScene);



        //cityScene       = SceneFactory.createScene(Environment.CITY, View.SIDEVIEW,
        //        Script.CITY_SCRIPT, finder, "cityScene.xml");
        //cityScene.setBackgroundColor(new Color(111,174,223));
        //addSceneToStage(cityScene);




        //forestScene     = SceneFactory.createScene(Environment.FOREST, View.SIDEVIEW,
        //Script.FOREST_SCRIPT, finder, "forestScene.xml");
        //forestScene.setBackgroundColor(new Color(0,0,0));
        //addSceneToStage(forestScene);



        //mountainScene   = SceneFactory.createScene(Environment.MOUNTAINS, View.SIDEVIEW,
        //Script.MOUNTAIN_SCRIPT, finder, "mountainScene.xml");
        //mountainScene.setBackgroundColor(new Color(255,255,255));
        //addSceneToStage(mountainScene);

        //snowScene       = SceneFactory.createScene(Environment.SNOW, view.SIDEVIEW,
        //                                       Script.SNOW_SCRIPT, finder, "snowScene.xml");

        //finalScene      = SceneFactory.createScene(Environment.FINAL, View.SIDEVIEW,
        //                                         Script.FINAL_SCRIPT, finder, "finalScene.xml");
        //finalScene.setBackgroundColor(new Color(255,255,255));
        //addSceneToStage(finalScene);



    }

    private void addSceneToStage(Scene scene)
    {
        ArrayList<Sprite> movingSprites;
        RuleBasedSprite[]  slidingSprites;

        slidingSprites  = scene.getSlidingSprites();
        movingSprites   = scene.getMovingSprites();



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
