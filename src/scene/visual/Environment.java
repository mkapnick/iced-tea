package scene.visual;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/15/13
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Environment {

    CITY (new String[0], "-1", "-1"),  //default
    FOREST(new String[0], "-1", "-1"),
    MOUNTAINS(new String[0], "-1", "-1");

    private String [] foreground;
    private String background;
    private String ground;


    Environment(String [] foreground, String background, String ground)
    {
        this.foreground = foreground;
        this.background = background;
        this.ground     = ground;
    }

    public String [] getForeground()
    {
        return this.foreground;
    }

    public String getGround()
    {
        return this.ground;
    }

    public String getBackground()
    {
        return this.background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setForeground(String[] foreground) {
        this.foreground = foreground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }



}
