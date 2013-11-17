import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JPanel;

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
		Stage stage = new Stage(75);
		TextSprite spr = new TextSprite("Hello there. I've lived in the USA for 15 years.", true);
		TextSprite spr2 = new TextSprite("Yo dawg, hey. I heard you like texing", true);
		stage.add(spr);
		stage.add(spr2);
		VisualizationView view = stage.getView();
		
		view.setBounds(new Rectangle(400,600));
		
		
		contentPane.add(view);
		contentPane.setVisible(true);
		
		spr2.setLocation(0, 50);
		stage.start();
		
			
	}
}
