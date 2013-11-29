package controller;

import model.EventNode;
import scene.visual.content.MenuContent;

public class MenuController
{
	private EventNode<MenuContent> currentNode;
	private int numToRender;
	
	public MenuController(EventNode<MenuContent> content, int numToRender)
	{
		this.currentNode = content;
		this.numToRender = numToRender;
	}
	
	public int getNumToRender()
	{
		return this.numToRender;
	}
	
	public MenuContent getCurrentContent()
	{
		return currentNode.getElement();
	}
	
	

}
