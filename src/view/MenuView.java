package view;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import scene.visual.content.ChoiceContent;
import scene.visual.content.MenuContent;
import scene.visual.dynamic.described.ChoiceSprite;
import scene.visual.dynamic.described.TextSprite;
import visual.VisualizationView;
import visual.dynamic.described.Sprite;
import controller.MenuController;

public class MenuView implements Sprite {

	private MenuController controller;
	private VisualizationView view;
	
	public MenuView(MenuController controller, VisualizationView view)
	{
		this.controller = controller;
		this.view = view;
		controller.setCurrentContentToIndex(0);
	}
	
	
	@Override
	public void handleTick(int arg0) {
		MenuContent curContent = controller.getCurrentContent();
		
		if (curContent instanceof ChoiceContent)
		{
			setMouseListeners(view);
			setMouseMotionListeners(view);
		}
		
		curContent.handleTick(arg0);
	}

	@Override
	public Rectangle2D getBounds2D(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLocation(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}

	public void setMouseListeners(VisualizationView view)
	{
		//System.out.println("In setMouseListeners.");
		MenuContent c;
		TextSprite[] sprites;
		
		c = controller.getCurrentContent();
		sprites = c.getText();
		
		if (c instanceof ChoiceContent)
		{
			for (int i = 0; i < sprites.length; i++)
			{
				//System.out.println(sprites[i].getText());
				view.addMouseListener((ChoiceSprite)sprites[i]);
			}
		}
	}
	
	public void setMouseMotionListeners(VisualizationView view)
	{
		//System.out.println("In set MouseMotionListeners");
		MenuContent c;
		TextSprite[] sprites;
		
		c = controller.getCurrentContent();
		sprites = c.getText();
		
		if (c instanceof ChoiceContent)
		{
			for (int i = 0; i < sprites.length; i++)
			{
				view.addMouseMotionListener((ChoiceSprite)sprites[i]);
			}
		}
	}
	@Override
	public void setRotation(double arg0, double arg1, double arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScale(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics arg0) {
		
		controller.getCurrentContent().render(arg0);
		
	}

}
