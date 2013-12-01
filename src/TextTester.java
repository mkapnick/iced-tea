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
import scene.visual.content.MenuContent;
import scene.visual.dynamic.described.ChoiceSprite;
import scene.visual.dynamic.described.TextSprite;
import view.MenuView;
import visual.VisualizationView;
import visual.dynamic.described.Stage;
import app.AbstractMultimediaApp;
import controller.MenuController;


public class TextTester extends AbstractMultimediaApp {

	private EventNode<MenuContent> content;
	
	public TextTester() throws ParserConfigurationException, SAXException, IOException
	{
		DialogueReader reader = new DialogueReader("Chris", ResourceFinder.createInstance());
		Document xml = reader.getXML();
		content = MenuFactory.createDialogue("Chris", xml);
		System.out.println(content);
	}
	
	public void init()
	{
		//MenuController menuController = new MenuController(content);
		
		
		JPanel contentPane = (JPanel)rootPaneContainer.getContentPane();
		contentPane.setSize(600,400);
		Stage stage = new Stage(50);
		//System.out.println(menuView);
		
		VisualizationView view = stage.getView();
		MenuView menuView = new MenuView(content.getElement().getController(), view);
		menuView.setMouseListeners(view);
		menuView.setMouseMotionListeners(view);
		stage.add(menuView);
		
		/*for (int i = 0; i < content.children().size(); i++)
		{
			MenuContent c = content.children().get(i).getElement();
			stage.add(c);
			
			if (c instanceof ChoiceContent) {
				for (TextSprite j : c.getText()) {
					view.addMouseMotionListener((ChoiceSprite)j);
					view.addMouseListener((ChoiceSprite)j);
				}
				
			}
			
			
		}*/
		
		
		
		view.setBounds(new Rectangle(600,300));
		
		contentPane.add(view);
		
		contentPane.setVisible(true);
		stage.start();
		
			
	}
}
