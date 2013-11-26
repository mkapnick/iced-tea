package controller;

import model.SceneNode;
import scene.visual.Scene;
/**
 * @author brianbrown
 * Contains the SceneNode tree and handles scene changing.
 */
public class SceneController {

	private SceneNode curNode;
	private SceneNode topNode;
	
	/**
	 * This constructor should be passed the root node of a
	 * completed tree of SceneNodes.
	 * 
	 * @param sceneTree
	 * The top node in the tree of SceneNodes.
	 */
	public SceneController(SceneNode sceneTree)
	{
		this.curNode = sceneTree;
		this.topNode = sceneTree;
	}
	
	/**
	 * Returns the current scene.
	 * 
	 * @return
	 * The current scene.
	 */
	public Scene getScene()
	{
		return curNode.getScene();
	}
	
	/**
	 * Steps to the next SceneNode at the specified index,
	 * setting it to be the current scene.
	 * 
	 * @param index
	 * The index of the next scene.
	 */
	public void nextScene(int index)
	{
		curNode = curNode.getChild(index);
	}
	
	/**
	 * Sets the current node back to the root of the tree,
	 * starting the scenes over from the beginning.
	 */
	public void reset()
	{
		curNode = topNode;
	}
	
}
