import io.ResourceFinder;
import model.Environment;
import model.View;
import scene.visual.Scene;
import scene.visual.SceneFactory;

import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/15/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class FinalApp
{
    public FinalApp()
    {
        // TBD
    }




    public void init()
    {
        ResourceFinder finder;
        BufferedReader br;
        InputStream is;
        Scene introScene, cityScene, forestScene, mountainScene, snowScene;

        finder = ResourceFinder.createInstance(this);
        introScene = SceneFactory.createScene(Environment.INTRO, View.BIRDSEYE,finder);




        //cityScene = SceneFactory.createScene(Environment.CITY, View.SIDEVIEW,finder, "CitySceneFile.txt");
        //forestScene = SceneFactory.createScene(Environment.FOREST, View.SIDEVIEW, finder, "ForestSceneFile.txt");
        //mountainScene = SceneFactory.createScene(Environment.MOUNTAINS, View.SIDEVIEW, finder, "MountainSceneFile.txt");
        //snowScene = SceneFactory.createScene(Environment.SNOW, View.SIDEVIEW, finder, "SnowSceneFile.txt");

    }
}