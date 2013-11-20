import java.awt.Rectangle;

import javax.swing.JPanel;

import scene.visual.content.ChoiceContent;
import scene.visual.content.DialogueContent;
import scene.visual.dynamic.described.ChoiceSprite;
import scene.visual.dynamic.described.MergingTextSprite;
import scene.visual.dynamic.described.SlidingTextSprite;
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
		
		
		TextSprite spr = new SlidingTextSprite("Hello there, Chris. My name is David", 0, 1);
		TextSprite spr2 = new SlidingTextSprite("Hey David. How's it going?", 1, 1);
		TextSprite spr3 = new SlidingTextSprite("Pretty well, Chris. Favorite color?", 2, 1);
		
		spr.setLocation(50, 50);
		spr2.setLocation(100, 100);
		spr3.setLocation(150, 150);
		
		TextSprite choice = new ChoiceSprite("Blue");
		TextSprite choice2 = new ChoiceSprite("Green");
		TextSprite choice3 = new ChoiceSprite("Magenta");
		TextSprite merging = new MergingTextSprite("Hello", 0);
		DialogueContent dialogue = new DialogueContent(2000, spr, spr2, spr3);
		ChoiceContent choices = new ChoiceContent(false, choice, choice2, choice3);
		
		merging.setLocation(200, 100);
		//dialogue.addMouseListener((ChoiceSprite)choice);
		stage.add(dialogue);
		stage.add(choices);
		stage.add(merging);
		
		VisualizationView view = stage.getView();
		view.addMouseListener((ChoiceSprite)choice);
		view.addMouseListener((ChoiceSprite) choice2);
		view.setBounds(new Rectangle(400,600));
		
		
		contentPane.add(view);
		
		contentPane.setVisible(true);
		stage.start();
		
			
	}
}
