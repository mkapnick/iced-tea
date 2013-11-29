import factory.MenuFactory;
import io.ResourceFinder;

import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import model.EventNode;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import scene.io.DialogueReader;
import scene.visual.content.ChoiceContent;
import scene.visual.content.DialogueContent;
import scene.visual.content.MenuContent;
import scene.visual.dynamic.described.ChoiceSprite;
import scene.visual.dynamic.described.MergingTextSprite;
import scene.visual.dynamic.described.ScrollingTextSprite;
import scene.visual.dynamic.described.TextSprite;
import visual.VisualizationView;
import visual.dynamic.described.Stage;
import app.AbstractMultimediaApp;


public class TextTester extends AbstractMultimediaApp {

	private EventNode<MenuContent> content;
	
	public TextTester() throws ParserConfigurationException, SAXException, IOException
	{
		DialogueReader reader = new DialogueReader("Chris", ResourceFinder.createInstance());
		Document xml = reader.getXML();
		content = MenuFactory.createDialogue("Chris", xml);
	}
	
	public void init()
	{
		JPanel contentPane = (JPanel)rootPaneContainer.getContentPane();
		contentPane.setSize(600,400);
		Stage stage = new Stage(50);
		System.out.println(content.children().get(0).getElement().getText()[0].getText());
		stage.add(content.children().get(0).getElement());
		
		VisualizationView view = stage.getView();
		view.setBounds(new Rectangle(600,300));
		
		contentPane.add(view);
		
		contentPane.setVisible(true);
		stage.start();
		
			
	}
}
