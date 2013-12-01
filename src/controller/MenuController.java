package controller;

import model.EventNode;
import scene.visual.content.ChoiceContent;
import scene.visual.content.MenuContent;

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
	 * 
	 */
	public void advanceContent()
	{
		EventNode<MenuContent> parent, tempNode;
		int currentIndex;
		parent = currentNode.getParent();
		
		currentIndex = parent.getIndex(currentNode);
		
		//if (currentIndex < parent.getChildCount() - 1)
			currentIndex++;
		
		tempNode = parent.getChildAt(currentIndex);
		
		if (tempNode != null && tempNode.getElement() instanceof ChoiceContent)
			currentNode = tempNode;
	}
	
	/**
	 * 
	 * @return
	 */
	public MenuContent getCurrentContent()
	{
		return currentNode.getElement();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getCurrentContentType()
	{
		if (currentNode.getElement() instanceof ChoiceContent)
			return "ChoiceContent";
		
		return "DialogueContent";
	}
	
	/**
	 * 
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
	 * 
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
