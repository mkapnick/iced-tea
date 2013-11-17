package scene.visual.content;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import scene.visual.dynamic.described.TextSprite;
import visual.dynamic.described.Sprite;
import event.Metronome;

public class DialogueContent implements Sprite {

	private TextSprite[] dialogue;
	private long curTime;
	private long delay;
	private int numToRender;
	
	
	public DialogueContent(long delayForText, TextSprite ... sprites)
	{
		this.dialogue = sprites;
		curTime = 0;
		delay = delayForText;
		numToRender = 1;
	}
	
	public TextSprite[] getDialogue()
	{
		return this.dialogue;
	}

	@Override
	public void render(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		
		for (int i = 0; i < numToRender; i++) {
			dialogue[i].setLocation(0, i * dialogue[i].getFont().getSize());
			dialogue[i].render(g2);
			//System.out.println("Rendering");
		}
	}
	

	@Override
	public void handleTick(int time) {
		
		curTime = time;
		
		numToRender = (int)(curTime / delay) + 1;
		
		if (numToRender >= dialogue.length)
			numToRender = dialogue.length;
		
		for (int i = 0; i < numToRender; i++)
			dialogue[i].handleTick(time);
		
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

	@Override
	public void setRotation(double arg0, double arg1, double arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScale(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}


}
