package scene.visual.content;

import controller.SceneController;
import scene.visual.Scene;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 12/1/13
 * Time: 6:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class SceneContent
{
    private Scene           scene;
    private SceneController sceneController;

    public SceneContent(Scene scene)
    {
        this.scene = scene;
    }

    public void setSceneController(SceneController sceneController)
    {
        this.sceneController = sceneController;
    }

    public SceneController getSceneController()
    {
        return this.sceneController;
    }

    public Scene getScene()
    {
       return this.scene;

    }
}
