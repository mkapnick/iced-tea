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

    INTRO("","birds_eye_view_first_scene_no_car.png","main_car.png"),
	CITY("city_theme_base.png","",""),
	FOREST("","",""),
	MOUNTAINS("","",""),
	SNOW("","",""),
    FINAL("coffee_shop.png", "", "");
	//TODO Add more environments here
	
	private String background, ground, foreground;  //delimit foreground with a comma
	
	Environment(String background, String ground, String foreground)
	{
		this.background = background;
		this.ground = ground;
		this.foreground = foreground;
	}
	
	public String getForeground()
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
