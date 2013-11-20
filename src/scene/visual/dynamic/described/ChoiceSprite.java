package scene.visual.dynamic.described;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

public class ChoiceSprite extends TextSprite implements MouseListener {

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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if (curColor == Color.gray)
			System.out.println(this.text);
		
	}

	@Override
	public void mouseEntered(MouseEvent event) {
//TODO Messed up.
		System.out.println("In mouse entered");
		
		
		
			xPart = event.getLocationOnScreen().getX();
			yPart = event.getLocationOnScreen().getY();
		
		
		int tolerance = 20;
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		curColor = defaultColor;
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleTick(int time) {
		
		double mouseX, mouseY;
		
		mouseX = MouseInfo.getPointerInfo().getLocation().getX();
		mouseY = MouseInfo.getPointerInfo().getLocation().getY();
	
		if (mouseX <= this.x + 40 && mouseX >= this.x && 
			mouseY >= this.y + 24 && mouseY <= this.y + this.getFont().getSize() + 24)
			curColor = Color.gray;
		else
			curColor = Color.black;
		
	}

}
