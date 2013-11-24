package model;

import scene.visual.Scene;

import java.util.ArrayList;


/**
 * @author brianbrown
 * @deprecated Use EventNode<Scene> for scenes.
 * A class for containing Scenes as a tree structure.
 */
public class SceneNode {

	private Scene scene;
	private ArrayList<SceneNode> children;
	
	/**
	 * Constructs a SceneNode with no children.
	 * 
	 * @param scene	
	 * The scene to be contained by this node.
	 */
	public SceneNode(Scene scene)
	{
		this.scene = scene;
		this.children = new ArrayList<SceneNode>();
	}
	
	/**
	 * @return
	 * Returns the Scene contained by this node.
	 */
	public Scene getScene()
	{
		return this.scene;
	}
	
	/**
	 * Use this method to add a Scene's children. Child indexes will be
	 * respective to the order that they are added.
	 * 
	 * @param node
	 * The child node to be added.
	 */
	public void addNode(SceneNode node)
	{
		children.add(node);
	}
	
	
	/**
	 * Returns the child node at the specified index.
	 * 
	 * @param index
	 * The index of the child.
	 * 
	 * @return
	 * The child at the index in the parameter.
	 */
	public SceneNode getChild(int index)
	{
		if (children.size() == 0)
		{
			throw new IndexOutOfBoundsException("Node has no children.");
		}
		
		return children.get(index);
	}
	
	
	
	/**
	 * @return
	 * Returns the number of child nodes stored in this node.
	 */
	public int getNumChildren()
	{
		return children.size();
	}
	
	
}
