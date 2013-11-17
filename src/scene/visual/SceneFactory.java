package scene.visual;

import io.ResourceFinder;

import java.awt.image.BufferedImage;

import model.Environment;
import model.View;

public class SceneFactory {

	public static Scene createScene(Environment env, View view, ResourceFinder finder)
	{
		Scene scene;
		BufferedImage background;
		BufferedImage[] foregrounds;
		BufferedImage ground;
		String[] foreground = env.getForeground();
		
		switch(view)
		{
			case SIDEVIEW:
				
				foregrounds = new BufferedImage[foreground.length];
				
				background = readFile(env.getBackground());
				
				for (int i = 0; i < foreground.length; i++)
				{
					foregrounds[i] = readFile(foreground[i]);
				}
				break;
				
			case BIRDSEYE:
				break;
			case INCAR:
				break;
			default:
				break;
		}
		
		
		
		return scene;
	}
	
	public static BufferedImage readFile(String fileName)
	{
		
	}
	
	
}
