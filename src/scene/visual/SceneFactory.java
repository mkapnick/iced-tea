package scene.visual;

import io.FileImageReader;
import io.ResourceFinder;
import model.Environment;
import model.View;
import visual.dynamic.described.Sprite;

import java.util.ArrayList;

public class SceneFactory {

	public static Scene createScene(Environment env, View view, ResourceFinder finder, String sceneFileName)
	{
        Scene scene;
        env.setFileName(sceneFileName);
        scene = null;

        switch (env)
        {
            case INTRO:
                scene = helperIntro(finder, sceneFileName);
                break;
            case CITY:
                break;
            case FOREST:
                break;
            case MOUNTAINS:
                break;
            case SNOW:
                break;
        }
        return scene;
	}

    private static Scene helperIntro(ResourceFinder finder,String sceneFileName)
    {
        ArrayList<Sprite> sceneParts = FileImageReader.readFile(sceneFileName, finder);
        return  null;

    }
}
