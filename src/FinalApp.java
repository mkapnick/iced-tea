import app.AbstractMultimediaApp;
import io.ResourceFinder;
import model.Environment;
import model.Script;
import model.View;
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
        Scene introScene, cityScene, forestScene, mountainScene, snowScene;

        finder = ResourceFinder.createInstance();

        System.out.println("JUST BEFORE SCENEFACTORY CALL");
        introScene = SceneFactory.createScene(Environment.INTRO, View.BIRDSEYE,
                                              Script.CLASSIC_SCRIPT, finder, "introScene.xml");
        System.out.println("Constructed introscene");
        stage.add(introScene);

        //cityScene = SceneFactory.createScene(Environment.CITY, View.SIDEVIEW,finder, "CitySceneFile.txt");
        //forestScene = SceneFactory.createScene(Environment.FOREST, View.SIDEVIEW, finder, "ForestSceneFile.txt");
        //mountainScene = SceneFactory.createScene(Environment.MOUNTAINS, View.SIDEVIEW, finder, "MountainSceneFile.txt");
        //snowScene = SceneFactory.createScene(Environment.SNOW, View.SIDEVIEW, finder, "SnowSceneFile.txt");
    }




}