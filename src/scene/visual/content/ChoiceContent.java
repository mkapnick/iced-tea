package scene.visual.content;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import scene.visual.Scene;
import scene.visual.dynamic.described.ChoiceSprite;
import scene.visual.dynamic.described.TextSprite;

/**
 * Encapsulates all choices in a menu.
 * 
 * @author Daniel Hardgrove
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code
 * 11/19/13
 *
 */
public class ChoiceContent extends MenuContent {

	private Color curColor, defaultColor, hoverColor;
	private boolean isTopDownView;
	
	public ChoiceContent(boolean vert, TextSprite... text) {
		this(vert, Color.BLACK, Color.BLUE, text);
	}
	
	public ChoiceContent(boolean vert, Color defaultColor, Color hoverColor, TextSprite... text)
	{
		super(text);
		this.defaultColor = defaultColor;
		this.hoverColor = hoverColor;
		this.curColor = this.hoverColor;
		this.isTopDownView = vert;
	}

	@Override
	public void handleTick(int arg0) {
		for (TextSprite i : text)
			i.handleTick(arg0);
		
		int whichClicked = whichClicked();
		
		if (whichClicked != -1) {
			System.out.println("Which clicked: " + whichClicked);
			menuController.setCurrentContentToIndex(whichClicked);
			sceneController.nextScene();
			System.out.println(sceneController.getCurrentScene());
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
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(rectangleColor);
		g2.fill(textRectangle);
		g2.draw(textRectangle);
		for (int i = 0; i < text.length; i++)
		{
			if (isTopDownView) 	text[i].setLocation(x, y + (i * 2)  * text[i].getFont().getSize());
			else 				text[i].setLocation(i * text[i].getText().length() + i * 100, 0);
			
			text[i].render(g);
			
		}
		
	}
	
	public int whichClicked()
	{
		for (int i = 0; i < text.length; i++)
			if (((ChoiceSprite)text[i]).wasClicked())
				return i;
		
		return -1;
	}

	
	
}
