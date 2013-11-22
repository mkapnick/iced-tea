package factory;

import java.util.ArrayList;

import model.EventNode;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import scene.visual.content.DialogueContent;
import scene.visual.content.MenuContent;
import scene.visual.dynamic.described.BasicTextSprite;

public class MenuFactory 
{
	
	
	public static EventNode<MenuContent> createDialogue(Document xml)
	{
		MenuContent curContent;
		
		EventNode<MenuContent> parent = 
				new EventNode<MenuContent>(new DialogueContent
						(0, new BasicTextSprite("Root")));
		
		NodeList startingList;
		startingList = xml.getChildNodes();
		
		//xml.normalize();
		buildChildren(parent, startingList);
		System.out.println(parent);
		
		return parent;
		
	}
	
	private static void buildChildren(EventNode<MenuContent> parent, NodeList nodeList)
	{
		//Create method variables here----------------------------------------
		Node currentNode = null;
		ArrayList<Node> childNodes;
		NodeList list;
		String currentNodeString = "";
		//End variable declaration--------------------------------------------
		
		//We need to parse each Node in the nodeList passed in
		for (int j = 0; j < nodeList.getLength(); j++) {
			
			currentNode = nodeList.item(j); //Set the current node
			currentNodeString = currentNode.toString();
			System.out.println("Current Node: " + currentNodeString);
			
			list = currentNode.getChildNodes(); // The child nodes of current 
			childNodes = new ArrayList<Node>();
			
			//For now, this loop will construct content based on what the nodes of 
			//child nodes of current
			for (int i = 0; i < list.getLength(); i++) 
			{
				Node listNode = list.item(i); // One node in the list of children
				//If the node is of type <prof>, <bern>, <select> or <option>
				if (listNode.getNodeType() == Node.ELEMENT_NODE) {
					childNodes.add(list.item(i));
					
					if (listNode.getNodeName().equals("prof") ||
						listNode.getNodeName().equals("bern"))
					{
						//CREATE DIALOGUE ELEMENT
					}
					else if (listNode.getNodeName().equals("option"))
					{
						//CREATE CHOICE ELEMENT
					}
				}
			}
			
			//Debugging by printing out all of the child nodes of current
			for (int i = 0; i < childNodes.size(); i++)
				System.out.printf("Node %d in %s: %s\n", i, currentNodeString, childNodes.get(i).getNodeName());
			
			System.out.printf("Number of nodes in %s: %d\n", currentNode.getNodeName(), list.getLength());
			
			//Repeat this method recursively for all child element nodes
			
				System.out.println(currentNode.getNodeName() + "'s type: " + currentNode.getNodeType());
				
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
					if (list.getLength() > 0)
						buildChildren(parent, list);
					
				}
			
			
		
		}
		
		
		
	}
}
