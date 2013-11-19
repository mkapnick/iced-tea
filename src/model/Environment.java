package model;

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

    INTRO("", new String [] {"birds_eye_view_first_scene_no_car.png"},"", new String [] {"main_car.png"}),
	CITY("",new String [] {"city_theme_base.png"}, "",new String [] {""}),
	FOREST("",new String [] {""}, "", new String [] {""}),
	MOUNTAINS("",new String [] {""}, "",new String [] {""}),
	SNOW("",new String [] {""},"", new String [] {""}),
    FINAL("",new String [] {"coffee_shop.png"}, "", new String [] {""});
	//TODO Add more environments here
	
	private String      background, ground;
    private String []   foreground, movingSprites;
	
	Environment(String background, String [] foreground, String ground,String [] movingSprites)
	{
		this.background = background;
		this.foreground = foreground;
		this.ground     = ground;
        this.movingSprites    = movingSprites;
	}
	
	public String [] getForeground()
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
    public String [] getMovingSprites()
    {
        return this.movingSprites;
    }
}
