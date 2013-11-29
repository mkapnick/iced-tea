package controller;

import model.EventNode;
import scene.visual.content.ChoiceContent;
import scene.visual.content.MenuContent;

public class MenuController
{
	private EventNode<MenuContent> currentNode;
	
	public MenuController(EventNode<MenuContent> content, int numToRender)
	{
		this.currentNode = content;
	}
	
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
	
	public MenuContent getCurrentContent()
	{
		return currentNode.getElement();
	}
	
	public void setCurrentContent(EventNode<MenuContent> content)
	{
		this.currentNode = content;
	}
	
	public String getCurrentContentType()
	{
		if (currentNode.getElement() instanceof ChoiceContent)
			return "ChoiceContent";
		
		return "DialogueContent";
	}
	
	public void reset()
	{
		if (currentNode.getParent() != null)
		{
			currentNode = currentNode.getParent();
			reset();
		}
	}
	
	public void setCurrentContentToFirstChild()
	{
		if (currentNode.getChildCount() > 0)
			currentNode = currentNode.getChildAt(0);
	}
	
	

}
