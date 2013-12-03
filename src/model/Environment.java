package model;


import java.util.ArrayList;


/**
 *
 * @author Daniel Hardgrove, Michael Kapnick, Brian Brown
 * @version 1.0
 * This work complies with the JMU Honor Code.
 *
 * An environment represents the foreground, background and ground of each scene.
 * These variables are represented as Strings
 * 11/15/13
 */

public enum Environment
{
    INTRO(null, null, null),
    CITY(null, null, null),
    FOREST(null, null, null),
    MOUNTAINS(null, null, null),
    SNOW(null, null, null),
    FINAL(null, null, null);

    private String background, ground;
    private ArrayList<String> foreground;


    /* An Environment enum consists of a background, a ground, and
     * a list of foregrounds
     *
     */
    Environment(String background, ArrayList<String> foreground, String ground) {

        this.background = background;
        this.foreground = foreground;
        this.ground = ground;

    }

    /*
     * Gets the the list of foregrounds associated with a particular
     * Environment
     */

    public ArrayList<String> getForeground() {
        return this.foreground;
    }

    /*
     * Gets the background associated with a particular Environment
     */
    public String getBackground()
    {
        return this.background;
    }


    /*
    * Gets the ground associated with a particular Environment
    */
    public String getGround()
    {
        return this.ground;
    }


    /*
     * Sets the the list of foregrounds associated with a particular
     * Environment
     */
    public void setForeground(ArrayList<String> foreground)

    {

        this.foreground = foreground;

    }


    /*
     * Sets the background associated with a particular Environment
     */
    public void setBackground(String background)

    {

        this.background = background;

    }


    /*
    * Sets the ground associated with a particular Environment
    */
    public void setGround(String ground)

    {

        this.ground = ground;

    }

}