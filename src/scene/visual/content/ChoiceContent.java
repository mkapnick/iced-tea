package scene.visual.content;

import java.awt.Color;
import java.awt.Graphics;

import scene.visual.dynamic.described.TextSprite;

public class ChoiceContent extends MenuContent {

	private Color curColor, defaultColor, hoverColor;
	
	public ChoiceContent(TextSprite... text) {
		this(Color.BLACK, Color.BLUE, text);
	}
	
	public ChoiceContent(Color defaultColor, Color hoverColor, TextSprite... text)
	{
		super(text);
		this.defaultColor = defaultColor;
		this.hoverColor = hoverColor;
		this.curColor = this.hoverColor;
	}

	@Override
	public void handleTick(int arg0) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	
	
}
