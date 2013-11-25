package factory;

import java.util.ArrayList;

import model.EventNode;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import scene.visual.content.DialogueContent;
import scene.visual.content.MenuContent;
import scene.visual.dynamic.described.BasicTextSprite;
import scene.visual.dynamic.described.TextSprite;

/**
 * Factory which both creates the EventNode tree, and constructs it
 * by creating MenuContent objects as we parse a provided xml file
 * with a format of:
 * 
 * <content> : <dialogue> | <choice>
 * <dialogue>: <bern> | <prof>
 * <choice>	 : <option>
 * <bern>	 : text...
 * <prof>	 : text...
 * <option>	 : text...
 * 
 * @author Daniel Hardgrove
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code
 * 11/22/13
 */
public class MenuFactory 
{
	
	/**
	 * Entry point of the parse of the xml file and constructs
	 * an EventNode<MenuContent> tree. Makes use of a private
	 * recursive method for constructing the tree.
	 * 
	 * @param xml - the xml document to parse
	 * @return parent - the root EventNode, which contains all
	 * 					children.
	 */
	public static EventNode<MenuContent> createDialogue(Document xml)
	{
		//Initialize the parent at "Root".
		EventNode<MenuContent> parent = 
				new EventNode<MenuContent>(new DialogueContent
						(0, new BasicTextSprite("Root")));
		
		//Get the child nodes of the roor of the document
		NodeList startingList;
		startingList = xml.getChildNodes();
		
		//Begin the parse, and construct the EventNode tree.
		buildChildren(parent, startingList);
		
		return parent;
	}
	
	/**
	 * Recursively creates the EventNode<MenuContent> tree
	 * 
	 * @param parent - originally root, but updates depending on
	 * 				   this previous active node.
	 * @param nodeList - the children of the parent.
	 */
	private static String buildChildren(EventNode<MenuContent> parent, NodeList nodeList)
	{
		//Create method variables here----------------------------------------
		Node currentNode = null;
		ArrayList<Node> childNodes;
		NodeList list;
		String currentNodeString = "";
		String text;
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
			/*for (int i = 0; i < list.getLength(); i++) 
			{
				Node listNode = list.item(i); // One node in the list of children
				//If the node is of type <prof>, <bern>, <select> or <option>
				if (listNode.getNodeType() == Node.ELEMENT_NODE) {
					childNodes.add(list.item(i));
					
				}
			}*/
			
			if (currentNode.getNodeName().equals("content"))
				buildChildren(parent, list);
			else if (currentNode.getNodeName().equals("dialogue"))
			{
				//CREATE DIALOGUE CONTENT
				DialogueContent dContent;
				TextSprite singleDialogue;
			}
			else if (currentNode.getNodeName().equals("choice"))
			{
				//CREATE CHOICE CONTENT
			}
			else if (currentNode.getNodeName().equals("prof") ||
				currentNode.getNodeName().equals("bern"))
			{
				if (list.getLength() > 0)
					buildChildren(parent, list);
			}
			else if (currentNode.getNodeName().equals("option"))
			{
				if (list.getLength() > 0)
					buildChildren(parent, list);
			}
			
			
			//Debugging by printing out all of the child nodes of current
			for (int i = 0; i < childNodes.size(); i++)
				System.out.printf("Node %d in %s: %s\n", i, currentNodeString, childNodes.get(i).getNodeName());
			
			System.out.printf("Number of nodes in %s: %d\n", currentNode.getNodeName(), list.getLength());
			
			//Repeat this method recursively for all child element nodes
			
			System.out.println(currentNode.getNodeName() + "'s type: " + currentNode.getNodeType());
		}
		
		return "";
	}
}
