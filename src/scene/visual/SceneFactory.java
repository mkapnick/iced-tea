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
			case SIDEVIEW: //Foregrounds are always sliding 
				
				foregrounds = new BufferedImage[foreground.length];
				
				background = readFile(env.getBackground());
				
				for (int i = 0; i < foreground.length; i++)
				{
					foregrounds[i] = readFile(foreground[i]);
				}
				break;
				
			case BIRDSEYE: //Only takes into account the ground and foreground(road, trees)
				break;
			case INCAR:
				break;
			default:
				break;
		}
		ContentFactory ...
		SlidingSprite road = new SlidingSprite()
		
		return scene;
	}
	
	public static BufferedImage readFile(String fileName)
	{
		
	}
	
	
}
