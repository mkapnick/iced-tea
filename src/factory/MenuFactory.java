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
	public static String professor;
	
	/**
	 * Entry point of the parse of the xml file and constructs
	 * an EventNode<MenuContent> tree. Makes use of a private
	 * recursive method for constructing the tree.
	 * 
	 * @param xml - the xml document to parse
	 * @return parent - the root EventNode, which contains all
	 * 					children.
	 */
	public static EventNode<MenuContent> createDialogue(String prof, Document xml)
	{
		NodeList startingList;
		professor = prof;
		
		//Initialize the parent at "Root".
		EventNode<MenuContent> parent = 
				new EventNode<MenuContent>(new DialogueContent
						(new BasicTextSprite("Root")));
		
		//Get the child nodes of the root of the document
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
		NodeList childList;
		String currentNodeName = "";
		String text = "";
		//End variable declaration--------------------------------------------
		
		//We need to parse each Node in the nodeList passed in
		for (int j = 0; j < nodeList.getLength(); j++) {
			
			currentNode = nodeList.item(j); //Set the current node
			currentNodeName = currentNode.getNodeName();
			childList = currentNode.getChildNodes(); // The child nodes of current 
			
			//Recurse if we have a content
			if (currentNodeName.equals("content"))
				buildChildren(parent, childList);
			
			//Recurse if we have an option
			else if (currentNodeName.equals("option"))
				buildChildren(parent, childList);
			
			//Recurse at the end with these. This part will make
			//use of the private methods below.
			else if (currentNodeName.equals("dialogue") ||
					currentNodeName.equals("choice"))
			{
				ArrayList<String> texts;
				EventNode<MenuContent> contentNode;
				MenuContent content;
				TextSprite[] textForContent = null;
				
				texts = new ArrayList<String>();
				
				//Calls the getTextFrom method for dialogue
				if (currentNodeName.equals("dialogue")) {
					texts = getTextFrom(childList);
					textForContent = new TextSprite[texts.size()];
					
					for (int i = 0; i < textForContent.length; i++)
					{
						textForContent[i] = new ScrollingTextSprite(texts.get(i), true);
					}
					
					content = new DialogueContent(textForContent);
				}
				//Calls the getValueFrom method for options
				else {
					texts = getValueFrom(childList);
					textForContent = new TextSprite[texts.size()];
					
					for (int i = 0; i < textForContent.length; i++)
					{
						textForContent[i] = new BasicTextSprite(texts.get(i));
					}
					content = new ChoiceContent(false, Color.blue, Color.yellow, textForContent);
					
				}
				
				//Creating the content from the texts and placing
				//in an EventNode.
				contentNode = new EventNode<MenuContent>(content);
				
				//Append this new node to the parent 
				parent.addNode(contentNode);	
				
				//Recurse for more.
				buildChildren(contentNode, childList);
			}
		}
		return text;
	}
	
	/**
	 * Get's all text elements from the given nodelist. This method
	 * assumes we are in a dialogue tag, and that we have bern and 
	 * prof tags within it.
	 * 
	 * @param list - the list of berns and profs
	 * @return an array list of text for the dialogue
	 */
	private static ArrayList<String> getTextFrom(NodeList list)
	{
		ArrayList<String> text = new ArrayList<String>();
		String curText = "";
		Node curNode = null;
		NodeList textNodes;
		String profToUse = "";
		
		for (int i = 0; i < list.getLength(); i++)
		{
			curNode = list.item(i);
			textNodes = curNode.getChildNodes();
			
			if (curNode.getNodeName().equals("bern"))
				profToUse = "Bernstein: ";
			else if (curNode.getNodeName().equals("prof"))
				profToUse = professor + ": ";
			
			if (textNodes.getLength() > 0)
			{
				curText = profToUse + textNodes.item(0).getNodeValue();
				text.add(curText);
			}
		}
		
		return text;
	}
	
	/**
	 * Used primarily for options, because they use a value
	 * attribute rather than text within.
	 * 
	 * @param list - the list of options.
	 * @return a text array list of all the options.
	 */
	private static ArrayList<String> getValueFrom(NodeList list)
	{
		ArrayList<String> text = new ArrayList<String>();
		String curText = "";
		Element curNode = null;
		NodeList textNodes;
		
		for (int i = 0; i < list.getLength(); i++)
		{
			if (list.item(i).getNodeName().equals("option")) {
				curNode = (Element)list.item(i);
				text.add(curNode.getAttribute("value"));
			}
		}
		
		return text;
	}
}
