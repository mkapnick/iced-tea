package factory;

import controller.SceneController;
import model.EventNode;
import scene.visual.Scene;
import scene.visual.content.SceneContent;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 12/1/13
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class StoryFactory {


    public static EventNode<SceneContent> createAStory(Scene[] scenes)
    {
        EventNode<SceneContent> parent;
        EventNode<SceneContent> node;
        SceneContent            sceneContent;

        parent = null;
        if(scenes != null)
        {
            parent = new EventNode<SceneContent>(new SceneContent(scenes[0]));
            parent.getElement().setSceneController(new SceneController(parent));
        }

        for (int i = 1; i < scenes.length; i++)
        {
            sceneContent    = new SceneContent(scenes[i]);
            node            = new EventNode<SceneContent>(sceneContent);
            node.getElement().setSceneController(parent.getElement().getSceneController());
            parent.addNode(node);
        }

        System.out.println("SIZE IS: ------ " + "" + parent.children().size());

        return parent;
    }
}
