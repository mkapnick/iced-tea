package scene.visual.dynamic.described;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

public class ChoiceSprite extends TextSprite implements MouseMotionListener {

	private Color defaultColor, hoverColor, curColor;
	private boolean wasClicked;
	private double xPart, yPart;
	
	public ChoiceSprite(String choice)
	{
		this(choice, Color.BLACK, Color.GRAY);
	}
	
	public ChoiceSprite(String choice, Color defaultColor, Color hoverColor)
	{
		super(choice);
		this.defaultColor = defaultColor;
		this.hoverColor = hoverColor;
		curColor = defaultColor;
		wasClicked = false;
	}

	@Override
	public void render(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		setColor(curColor);

		FontRenderContext fc = g2.getFontRenderContext();
		GlyphVector glyphs = font.createGlyphVector(fc, text);
		Shape s = glyphs.getOutline((float)x,(float)y + font.getSize());
		g2.setColor(color);
		g2.setStroke(new BasicStroke());
		g2.fill(s);
		g2.draw(s);
		
		
	}

	public void mouseMoved(MouseEvent evt) {
		System.out.println("MouseX: " + evt.getX());
		System.out.println("Text x: " + this.x + "\tText plus length: " + this.getText().length());
		double mouseX, mouseY;
		
		mouseX = evt.getX();
		mouseY = evt.getY();
		
		if (mouseX >= this.x && mouseX <= this.x + 50 &&
			mouseY >= this.y && mouseY <= this.y + this.getFont().getSize())
		{
			curColor = Color.blue;
		}
		else
			curColor = Color.black;
	}

	@Override
	public void handleTick(int time) {
		
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
