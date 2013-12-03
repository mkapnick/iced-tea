package controller;

import java.util.ArrayList;

import model.EventNode;
import scene.visual.Scene;
import scene.visual.content.SceneContent;

/**
 * @author Brian Brown, Daniel Hardgrove, Mike Kapnick
 * Contains the EventNode<SceneContent>tree and handles scene changing.
 * 
 * This work complies with the JMU Honor Code
 * 12/3/13
 */
public class SceneController {

	private ArrayList<Scene> scenes;
	private int	  curIndex;
	
	/**
	 * This constructor should be passed the root node of a
	 * completed tree of SceneNodes.
	 * 
	 * @param sceneTree
	 * The top node in the tree of SceneNodes.
	 */
	public SceneController(ArrayList<Scene> scenes)
	{
		this.scenes = scenes;
		this.curIndex = 0;

	}
	
	/**
	 * Returns the current scene.
	 * 
	 * @return
	 * The current scene.
	 */
	public Scene getCurrentScene()
	{
		return scenes.get(curIndex);
	}
	
	/**
	 * Steps to the next EventNode<SceneContent>at the specified index,
	 * setting it to be the current scene.
	 * 
	 * @param index
	 * The index of the next scene.
	 */
	public void nextScene()
	{
		curIndex++;
	}

	
	/**
	 * Sets the current node back to the root of the tree,
	 * starting the scenes over from the beginning.
	 */
	public void reset()
	{
		curIndex = 0;
	}
	
}
