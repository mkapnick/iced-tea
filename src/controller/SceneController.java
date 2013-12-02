package controller;

import model.EventNode;
import scene.visual.Scene;
import scene.visual.content.SceneContent;

/**
 * @author brianbrown
 * Contains the EventNode<SceneContent>tree and handles scene changing.
 */
public class SceneController {

	private EventNode<SceneContent>curNode;
	private EventNode<SceneContent> topNode;
	
	/**
	 * This constructor should be passed the root node of a
	 * completed tree of SceneNodes.
	 * 
	 * @param sceneTree
	 * The top node in the tree of SceneNodes.
	 */
	public SceneController(EventNode<SceneContent>sceneTree)
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
	public Scene getCurrentScene()
	{
		return curNode.getElement().getScene();
	}
	
	/**
	 * Steps to the next EventNode<SceneContent>at the specified index,
	 * setting it to be the current scene.
	 * 
	 * @param index
	 * The index of the next scene.
	 */
	public void nextScene(int index)
	{
		curNode = topNode.getChildAt(index);
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
