package data;


import java.util.ArrayList;


/**
 * Stores model for particular environments. The strings
 * <p/>
 * represent the filenames.
 *
 * @author Daniel Hardgrove, Michael Kapnick, Brian Brown
 * @version 1.0
 *          <p/>
 *          <p/>
 *          <p/>
 *          This work complies with the JMU Honor Code.
 *          <p/>
 *          11/15/13
 */

public enum Environment {
    INTRO(null, null, null),
    CITY(null, null, null),
    FOREST(null, null, null),
    MOUNTAINS(null, null, null),
    SNOW(null, null, null),
    FINAL(null, null, null);

    private String background, ground;
    private ArrayList<String> foreground;


    Environment(String background, ArrayList<String> foreground, String ground) {

        this.background = background;
        this.foreground = foreground;
        this.ground = ground;

    }

    public ArrayList<String> getForeground() {
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