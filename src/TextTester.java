import java.awt.Rectangle;

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
		stage.add(new TextSprite("Hello there. I've lived in the USA for 15 years.", true));
		VisualizationView view = stage.getView();
		
		view.setBounds(new Rectangle(400,600));
		
		contentPane.add(view);
		contentPane.setVisible(true);
		
		stage.start();
	}
}
