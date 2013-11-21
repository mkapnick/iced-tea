package model;

import java.util.ArrayList;

/**
 * Tree structure for any tree-like object in the program.
 * @author Daniel Hardgrove
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code
 * 11/20/13
 */
public class EventNode<E> {

	private ArrayList<EventNode<E>> children;
	private EventNode<E> parent;
	
	/**
	 * Constructs the children collection
	 */
	public EventNode()
	{
		children = new ArrayList<EventNode<E>>();
	}
	
	/**
	 * Adds an event node to the tree
	 * @param node - the node to add.
	 */
	public void addNode(EventNode<E> node)
	{
		node.parent = this;
		children.add(node);
	}
	
	/**
	 * 
	 * @return the children nodes
	 */
	public ArrayList<EventNode<E>> children() {
		return children;
	}

	/**
	 * 
	 * @param childIndex - the index of the child to get
	 * @return the child node at the index
	 */
	public EventNode<E> getChildAt(int childIndex) {
		EventNode<E> node = null;
		if (childIndex < children.size())
			node = children.get(childIndex);
		return node;
	}

	/**
	 * 
	 * @return the size of the children collection
	 */
	public int getChildCount() {
		return children.size();
	}

	/**
	 * 
	 * @param node
	 * @return the index of the node passed in.
	 */
	public int getIndex(EventNode<E> node) {
		int index = -1;
		
		for (int i = 0; i < children.size(); i++)
		{
			if (node == children.get(i)) {
				index = i;
				break;
			}
		}
		return index;
	}

	/**
	 * Traverses back up the tree.
	 * @return the parent of this node
	 */
	public EventNode<E> getParent() {
		return parent;
	}
}
