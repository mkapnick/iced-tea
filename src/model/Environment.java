package model;

import java.util.ArrayList;

/**
 * Stores model for particular environments. The strings
 * represent the file-names.
 * 
 * @author Daniel Hardgrove, Michael Kapnick, Brian Brown
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 * 11/15/13
 */
public enum Environment {

    INTRO("",null,""),
	CITY("",null,""),
	FOREST("",null,""),
	MOUNTAINS("",null,""),
	SNOW("",null,""),
    FINAL("",null,"");

	private String              background, ground;
    private ArrayList<String>   foreground;
	
	Environment(String background, ArrayList<String> foreground, String ground)
	{
		this.background = background;
		this.foreground = foreground;
		this.ground     = ground;
	}
	
	public ArrayList<String> getForeground()
	{
		return this.foreground;
	}
	
	public String getBackground()
	{
		return this.background;
	}
	
	public String getGround()
	{
		return this.ground;
	}

    public void setForeground(ArrayList<String> foreground)
    {
         this.foreground = foreground;
    }

    public void setBackground(String background)
    {
        this.background = background;
    }

    public void setGround(String ground)
    {
        this.ground = ground;
    }
}
