import app.AbstractMultimediaApp;
import data.Environment;
import data.Script;
import data.View;
import io.ResourceFinder;
import scene.visual.Scene;
import scene.visual.SceneFactory;
import visual.VisualizationView;
import visual.dynamic.described.Stage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStream;

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
    }

    public void init()
    {

        start();
        JPanel contentPane = (JPanel) rootPaneContainer.getContentPane();
        stageView = stage.getView();
        stageView.setBounds(0, 0, 1000, 1000);
        contentPane.add(stageView);
        stage.start();
        contentPane.setVisible(true);
    }

    public void start()
    {
        ResourceFinder finder;
        BufferedReader br;
        InputStream is;
        Scene introScene, cityScene, forestScene, mountainScene, snowScene, finalScene;

        finder = ResourceFinder.createInstance();
        System.out.println("JUST BEFORE SCENE FACTORY CALL");

        //Construct all possible scenes
        introScene      = SceneFactory.createScene(Environment.INTRO, View.BIRDSEYE,
                                                Script.INTRO_SCRIPT, finder, "introScene.xml");
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
        stage.add(introScene);


    }
}

