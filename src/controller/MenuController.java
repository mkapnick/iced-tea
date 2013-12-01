package controller;

import model.EventNode;
import scene.visual.content.ChoiceContent;
import scene.visual.content.MenuContent;
import visual.dynamic.described.Stage;

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
		EventNode<MenuContent> parent;
		int currentIndex;
		parent = currentNode.getParent();
		
		currentIndex = parent.getIndex(currentNode);
		
		if (currentIndex < parent.getChildCount() - 1)
			currentIndex++;
		
		currentNode = parent.getChildAt(currentIndex);
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
		if (currentNode.getChildCount() > index)
			currentNode = currentNode.getChildAt(index);
	}
	
	

}
