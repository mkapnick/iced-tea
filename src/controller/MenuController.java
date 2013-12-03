package controller;

import model.EventNode;
import scene.visual.content.ChoiceContent;
import scene.visual.content.MenuContent;

/**
 * Controller for any menu content.
 * 
 * @author Daniel Hardgrove
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code
 * 12/3/13
 *
 */
public class MenuController
{
	private EventNode<MenuContent> currentNode;

	/**
	 * 
	 * @param content
	 * @param numToRender
	 */
	public MenuController(EventNode<MenuContent> content)
	{
		this.currentNode = content;
	}
	
	/**
	 * Advances to the next SIBLING
	 */
	public void advanceContent()
	{
		EventNode<MenuContent> parent, tempNode;
		int currentIndex;
		
		parent = currentNode.getParent();
		currentIndex = parent.getIndex(currentNode);
		currentIndex++;
		
		tempNode = parent.getChildAt(currentIndex);
		
		if (tempNode != null && tempNode.getElement() instanceof ChoiceContent)
			currentNode = tempNode;
	}
	
	/**
	 * 
	 * @return the current content
	 */
	public MenuContent getCurrentContent()
	{
		return currentNode.getElement();
	}
	
	
	/**
	 * 
	 * @return the type of the current content
	 */
	public String getCurrentContentType()
	{
		if (currentNode.getElement() instanceof ChoiceContent)
			return "ChoiceContent";
		
		return "DialogueContent";
	}
	
	/**
	 * Resets the content to the beginning
	 */
	public void reset()
	{
		if (currentNode.getParent() != null)
		{
			currentNode = currentNode.getParent();
			reset();
		}
	}
	
	/**
	 * Sets the current content based on the index passed in.
	 */
	public void setCurrentContentToIndex(int index)
	{
		EventNode<MenuContent> tempNode = null;
		
		if (currentNode.getChildCount() > index)
			tempNode = currentNode.getChildAt(index);
		
		if (tempNode.getElement() instanceof ChoiceContent)
			tempNode = currentNode.getChildAt(index + 1);
		
		currentNode = tempNode;
	}
	
	

}
