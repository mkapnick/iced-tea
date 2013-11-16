package model;

/**
 * Stores model for particular environments. The strings
 * represent the file-names.
 * 
 * @author Daniel Hardgrove
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 * 11/15/13
 */
public enum Environment {

    INTRO("","","", ""),
    CITY("","","",""),
	FOREST("","","",""),
	MOUNTAINS("","","",""),
	SNOW("","","","");
    //TODO Add more environments here
	
	private String fileName, background, ground;
	private String[] foreground;
	
	Environment( String fileName, String background, String ground, String... foreground)
	{
        this.fileName = fileName;
		this.background = background;
		this.ground = ground;
		this.foreground = foreground;
	}
	
	public String[] getForeground()
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

    public void setForeground(String [] foreground)
    {
        this.foreground = foreground;
    }

    public void setGround(String ground)
    {
        this.ground = ground;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName()
    {
        return this.fileName;
    }
}
