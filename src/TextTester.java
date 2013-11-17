import java.awt.Rectangle;

import javax.swing.JPanel;

import scene.visual.content.DialogueContent;
import scene.visual.dynamic.described.ChoiceSprite;
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
		TextSprite spr = new TextSprite("Hello there. I've lived in the USA for 15 years.", true);
		TextSprite spr2 = new TextSprite("Yo dawg, hey. I heard you like texskajfbving", true);
		TextSprite spr3 = new TextSprite("The above sentence is defiantly spelled wrong.", true);
		
		ChoiceSprite choice = new ChoiceSprite("Blue");
		
		DialogueContent dialogue = new DialogueContent(5000, spr, spr2, spr3, choice);
		stage.add(dialogue);
		//choice.addMouseListener(choice);
		VisualizationView view = stage.getView();
		
		view.setBounds(new Rectangle(400,600));
		
		
		contentPane.add(view);
		contentPane.setVisible(true);
		stage.start();
		
			
	}
}
