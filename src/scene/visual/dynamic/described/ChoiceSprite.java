package scene.visual.dynamic.described;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.font.FontRenderContext;

public class ChoiceSprite extends TextSprite implements 
									MouseMotionListener, MouseListener {

	private Color defaultColor, hoverColor, curColor;
	private boolean wasClicked;
	
	public ChoiceSprite(String choice)
	{
		this(choice, Color.BLACK, Color.BLUE);
	}
	
	public ChoiceSprite(String choice, Color defaultColor, Color hoverColor)
	{
		super(choice);
		this.defaultColor = defaultColor;
		this.hoverColor = hoverColor;
		curColor = defaultColor;
		wasClicked = false;
	}
	
	public boolean wasClicked()
	{
		return wasClicked;
	}
	
	/**
	 * 
	 * @param evt
	 * @return true if the mouse position is within the glyph vector.
	 */
	private boolean mouseInBounds(MouseEvent evt)
	{
		boolean result = false;
		double mouseX, mouseY;
		double width;
		
		width = this.glyphText.getOutline().getBounds().getMaxX();
		mouseX = evt.getX();
		mouseY = evt.getY();
		
		//System.out.println(mouseX + "   " + mouseY);
		
		if (mouseX >= this.x && mouseX <= this.x + width &&
			mouseY >= this.y && mouseY <= this.y + this.getFont().getSize())
			result = true;
		
		return result;
		
	}

	@Override
	public void render(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		setColor(curColor);

		FontRenderContext fc = g2.getFontRenderContext();
		glyphText = font.createGlyphVector(fc, text);
		Shape s = glyphText.getOutline((float)x,(float)y + font.getSize());
		g2.setColor(color);
		g2.setStroke(new BasicStroke());
		g2.fill(s);
		g2.draw(s);
		
		
	}

	public void mouseMoved(MouseEvent evt) {
		
		if (mouseInBounds(evt))
			curColor = hoverColor;
		else
			curColor = defaultColor;
		
	}

	@Override
	public void handleTick(int time) {
       // System.out.println("Waiting?");
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		if (mouseInBounds(e))
			wasClicked = true;
		else
			wasClicked = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
