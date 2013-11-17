import java.awt.Rectangle;

import javax.swing.JPanel;

import scene.visual.content.DialogueContent;
import scene.visual.dynamic.described.ChoiceSprite;
import scene.visual.dynamic.described.ScrollingTextSprite;
import scene.visual.dynamic.described.TextSprite;
import visual.VisualizationView;
import visual.dynamic.described.Stage;
import app.AbstractMultimediaApp;


public class TextTester extends AbstractMultimediaApp {

	public TextTester()
	{
		
	}
	
	public void init()
	{
		JPanel contentPane = (JPanel)rootPaneContainer.getContentPane();
		contentPane.setSize(400,600);
		Stage stage = new Stage(20);
		
		
		TextSprite spr = new ScrollingTextSprite("Hello there. I've lived in the USA for 15 years.", true);
		TextSprite spr2 = new ScrollingTextSprite("Yo dawg, hey. I heard you like texskajfbving", true);
		TextSprite spr3 = new ScrollingTextSprite("The above sentence is defiantly spelled wrong.", true);
		
		TextSprite choice = new ChoiceSprite("Blue");
		
		DialogueContent dialogue = new DialogueContent(1000, spr, spr2, spr3, choice);
		//dialogue.addMouseListener((ChoiceSprite)choice);
		stage.add(dialogue);
		VisualizationView view = stage.getView();
		
		view.setBounds(new Rectangle(400,600));
		
		
		contentPane.add(view);
		contentPane.setVisible(true);
		stage.start();
		
			
	}
}
