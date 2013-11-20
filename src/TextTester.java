import java.awt.Rectangle;

import javax.swing.JPanel;

import scene.visual.content.ChoiceContent;
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
		Stage stage = new Stage(50);
		
		
		TextSprite spr = new ScrollingTextSprite("Hello there, Chris. My name is David", true);
		TextSprite spr2 = new ScrollingTextSprite("Hey David. How's it going?", true);
		TextSprite spr3 = new ScrollingTextSprite("Pretty well, Chris. Favorite color?", true);
		
		TextSprite choice = new ChoiceSprite("Blue");
		TextSprite choice2 = new ChoiceSprite("Green");
		TextSprite choice3 = new ChoiceSprite("Magenta");
		
		DialogueContent dialogue = new DialogueContent(3000, spr, spr2, spr3, choice, choice2, choice3);
		//dialogue.addMouseListener((ChoiceSprite)choice);
		stage.add(dialogue);
		
		VisualizationView view = stage.getView();
		view.addMouseListener((ChoiceSprite)choice);
		view.addMouseListener((ChoiceSprite) choice2);
		view.setBounds(new Rectangle(400,600));
		
		
		contentPane.add(view);
		
		contentPane.setVisible(true);
		stage.start();
		
			
	}
}
