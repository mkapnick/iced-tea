import factory.MenuFactory;
import io.ResourceFinder;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import model.EventNode;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import scene.io.DialogueReader;
import scene.visual.content.DialogueContent;
import scene.visual.content.MenuContent;
import scene.visual.dynamic.described.TextSprite;


public class DialogueXMLTester {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		DialogueReader reader = new DialogueReader("Chris", ResourceFinder.createInstance());
		Document xml = reader.getXML();
		
		EventNode<MenuContent> content = MenuFactory.createDialogue("Chris", xml);
		
		printAllContent(content);
	}
	
	public static void printAllContent(EventNode<MenuContent> content)
	{
		String text;
		ArrayList<EventNode<MenuContent>> children;
		children = content.children();
		
		for (EventNode<MenuContent> c : children)
		{
			TextSprite[] sprites;
			sprites = c.getElement().getText();
			MenuContent theContent = c.getElement();
			for (TextSprite i : sprites) {
			
			if (theContent instanceof DialogueContent)
			{
				System.out.println("DIALOGUE: " + i.getText());
			}
			else
				System.out.println("CHOICE: " + i.getText());
			
			}
			printAllContent(c);
		}
		
		
	}
}
