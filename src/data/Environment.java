package data;

/**
 * Stores data for particular environments. The strings
 * represent the file-names.
 * 
 * @author Daniel Hardgrove
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 * 11/15/13
 */
public enum Environment {

	CITY("","",""),
	FOREST("","",""),
	MOUNTAINS("","",""),
	SNOW("","","");
	//TODO Add more environments here
	
	private String background, ground;
	private String[] foreground;
	
	Environment(String background, String ground, String... foreground)
	{
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
}
