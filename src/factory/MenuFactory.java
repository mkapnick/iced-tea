package factory;

import java.awt.Color;
import java.util.ArrayList;

import model.EventNode;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import scene.visual.content.ChoiceContent;
import scene.visual.content.DialogueContent;
import scene.visual.content.MenuContent;
import scene.visual.dynamic.described.BasicTextSprite;
import scene.visual.dynamic.described.ScrollingTextSprite;
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
	public static int level = 0;
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
		///System.out.println(xml.toString());
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
		int curLevel = level;
		level++;
		
		//Create method variables here----------------------------------------
		Node currentNode = null;
		ArrayList<Node> childNodes;
		NodeList childList;
		String currentNodeName = "";
		String currentNodeString = "";
		String text = "";
		//End variable declaration--------------------------------------------
		System.out.println("Current nodelist.length: " + nodeList.getLength());
		//We need to parse each Node in the nodeList passed in
		for (int j = 0; j < nodeList.getLength(); j++) {
			
			currentNode = nodeList.item(j); //Set the current node
			
			
			currentNodeName = currentNode.getNodeName();
			if (currentNodeName.equals("option"))
				System.out.println("IN OPTION");
			currentNodeString = currentNode.toString();
			System.out.println("Current Node: " + currentNodeString);
			
			childList = currentNode.getChildNodes(); // The child nodes of current 
			
			
			System.out.println(currentNodeName + "'s number of nodes: " + childList.getLength());
			
			
			for (int i = 0; i < childList.getLength(); i++)
			{
				System.out.println(currentNodeName + "'s node " + i + ": " + childList.item(i));
			}
			if (currentNodeName.equals("content"))
				buildChildren(parent, childList);
			else if (currentNodeName.equals("option"))
				buildChildren(parent, childList);
			else if (currentNodeName.equals("dialogue") ||
					currentNodeName.equals("choice"))
			{
				//CREATE DIALOGUE CONTENT
				ArrayList<String> texts;
				EventNode<MenuContent> contentNode;
				MenuContent content;
				String curText = "";
				TextSprite[] textForContent = null;
				NodeList curNodeList;
				
				texts = new ArrayList<String>();
				
				if (currentNodeName.equals("dialogue")) {
					texts = getTextFrom(childList);
					textForContent = new TextSprite[texts.size()];
					
					for (String i : texts)
						System.out.println(i);
					
					for (int i = 0; i < textForContent.length; i++)
					{
						textForContent[i] = new ScrollingTextSprite(texts.get(i), true);
					}
					
					content = new DialogueContent(2000, textForContent);
				
				}
				else {
					texts = getValueFrom(childList);
					textForContent = new TextSprite[texts.size()];
					
					for (String i : texts)
						System.out.println(i);
					
					for (int i = 0; i < textForContent.length; i++)
					{
						textForContent[i] = new BasicTextSprite(texts.get(i));
					}
					content = new ChoiceContent(false, Color.blue, Color.yellow, textForContent);
					
				}
				
				//Creating the dialogue content from the texts and placing
				//in an EventNode.
				
				contentNode = new EventNode<MenuContent>(content);
				
				//Append this new node to the parent 
				parent.addNode(contentNode);	
				
				buildChildren(contentNode, childList);
			}
		}
		System.out.println("Current level: " + curLevel + "\tText: " + text);
		return text;
	}
	
	private static ArrayList<String> getTextFrom(NodeList list)
	{
		ArrayList<String> text = new ArrayList<String>();
		String curText = "";
		Node curNode = null;
		NodeList textNodes;
		for (int i = 0; i < list.getLength(); i++)
		{
			curNode = list.item(i);
			textNodes = curNode.getChildNodes();
			
			if (textNodes.getLength() > 0)
			{
				curText = textNodes.item(0).getNodeValue();
				text.add(curText);
			}
		}
		
		return text;
	}
	
	private static ArrayList<String> getValueFrom(NodeList list)
	{
		ArrayList<String> text = new ArrayList<String>();
		String curText = "";
		Element curNode = null;
		NodeList textNodes;
		System.out.println(list.toString() + "List's length: " + list.getLength());
		for (int i = 0; i < list.getLength(); i++)
		{
			
			if (list.item(i).getNodeName().equals("option")) {
				curNode = (Element)list.item(i);
				System.out.println("Attribute: " + curNode.getAttribute("value"));
				text.add(curNode.getAttribute("value"));
			}
		}
		
		return text;
	}
}
