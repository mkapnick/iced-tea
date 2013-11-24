import factory.DialogueFactory;
import io.ResourceFinder;

import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import scene.io.DialogueReader;
import scene.visual.content.ChoiceContent;
import scene.visual.content.DialogueContent;
import scene.visual.dynamic.described.ChoiceSprite;
import scene.visual.dynamic.described.MergingTextSprite;
import scene.visual.dynamic.described.ScrollingTextSprite;
import scene.visual.dynamic.described.TextSprite;
import visual.VisualizationView;
import visual.dynamic.described.Stage;
import app.AbstractMultimediaApp;


public class TextTester extends AbstractMultimediaApp {

	public TextTester() throws ParserConfigurationException, SAXException, IOException
	{
		DialogueReader reader = new DialogueReader("Chris", ResourceFinder.createInstance());
		Document xml = reader.readXML();
		DialogueFactory.createDialogue(xml);
	}
	
	public void init()
	{
		JPanel contentPane = (JPanel)rootPaneContainer.getContentPane();
		contentPane.setSize(600,400);
		Stage stage = new Stage(50);
		
		
		TextSprite spr = new ScrollingTextSprite("Hello there, Chris. My name is David", true);
		TextSprite spr2 = new ScrollingTextSprite("Hey David. How's it going?", true);
		TextSprite spr3 = new ScrollingTextSprite("Pretty well, Chris. Favorite color?", true);
		
		/*spr.setLocation(50, 50);
		spr2.setLocation(100, 100);
		spr3.setLocation(150, 150);*/
		
		TextSprite choice = new ChoiceSprite("Blue");
		TextSprite choice2 = new ChoiceSprite("Green");
		TextSprite choice3 = new ChoiceSprite("Magenta");
		TextSprite merging = new MergingTextSprite("Hello", 0);
		DialogueContent dialogue = new DialogueContent(2000, spr, spr2, spr3);
		ChoiceContent choices = new ChoiceContent(true, choice, choice2, choice3);
		
		merging.setLocation(200, 100);
		//dialogue.addMouseListener((ChoiceSprite)choice);
		//stage.add(dialogue);
		stage.add(choices);
		//stage.add(merging);
		//PartialVisualizationView view2;
		
		//VisualizationView otherView = new VisualizationView(stage, new PlainVisualizationRenderer());
		//otherView.setBounds(100,0,500,100);
		//otherView.setBackground(Color.blue);
		//otherView.addMouseListener((ChoiceSprite)choice);
		VisualizationView view = stage.getView();
		view.addMouseMotionListener((ChoiceSprite)choice);
		view.addMouseListener((ChoiceSprite)choice);
		view.addMouseMotionListener((ChoiceSprite) choice2);
		view.setBounds(new Rectangle(600,300));
		
		//contentPane.add(otherView);
		contentPane.add(view);
		
		
		contentPane.setVisible(true);
		stage.start();
		
			
	}
}
