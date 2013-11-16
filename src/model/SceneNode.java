package model;

import scene.visual.Scene;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/16/13
 * Time: 9:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class SceneNode {

    private ArrayList<SceneNode> nodes;
    private Scene scene;

    public SceneNode()
    {

    }

    public void add (Scene scene)
    {
        this.scene = scene;
    }

    public Scene getScene()
    {
        return this.scene;
    }

    public int getNumScenes()
    {
        return this.nodes.size();
    }

    public SceneNode getChild (int index) throws Exception
    {
        return this.nodes.get(index);
    }
}
