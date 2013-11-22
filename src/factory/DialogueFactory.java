package factory;

import model.EventNode;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import scene.visual.content.DialogueContent;

public class DialogueFactory 
{
	
	
	public static EventNode<DialogueContent> createDialogue(Document xml)
	{
		DialogueContent curContent;
		EventNode<DialogueContent> parent = new EventNode<DialogueContent>();
		NodeList startingList;
		startingList = xml.getChildNodes();
		
		//xml.normalize();
		buildChildren(startingList, parent);
		
		return parent;
		
	}
	
	private static void buildChildren(NodeList nodeList, EventNode<DialogueContent> parent)
	{
		Node currentNode = null;
		Node[] innerNodes;
		NodeList list;
		String currentNodeString = "";
		
		if (nodeList.getLength() != 0) {
			currentNode = nodeList.item(0);
			currentNodeString = currentNode.getNodeName();
			System.out.println("Current Node: " + currentNodeString);
		}
		
		list = currentNode.getChildNodes();
		innerNodes = new Node[list.getLength()];
		
		
		System.out.println("Number of nodes within " + currentNodeString + ": " + innerNodes.length);
		
		for (int i = 0; i < list.getLength(); i++)
		{
			innerNodes[i] = list.item(i);
			System.out.printf("Node %d in %s: %s\n", i, currentNodeString, innerNodes[i].getNodeName());
		}
		
		
		
	}
}
