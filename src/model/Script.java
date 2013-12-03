package model;

import visual.dynamic.described.Sprite;

import java.util.ArrayList;

/**
 *
 * @author Michael Kapnick
 * @version 1.0
 * This work complies with the JMU Honor Code.
 *
 * A script represents the actors (sprites) and their roles
 * associated with a particular scene. Every Scene object has its own
 * Script, because every Scene object has sprites that have roles,
 * which thus form a Script for that Scene
 * 11/15/13
 */
public enum Script
{

    INTRO_SCRIPT(null),
    CITY_SCRIPT(null),
    FOREST_SCRIPT(null),
    MOUNTAIN_SCRIPT(null),
    SNOW_SCRIPT(null),
    FINAL_SCRIPT(null);

    private ArrayList<Sprite>   sprites;
    private int                 startTime;
    private int                 endTime;

    /*
     * A script takes in an ArrayList of Sprites.
     */
    Script(ArrayList<Sprite> sprites)
    {
        this.sprites = sprites;
    }

    /*
     * Sets the sprites for a particular script
     */
    public void setSprites(ArrayList<Sprite> sprites)
    {
        this.sprites = sprites;
    }

    /*
     * Gets the sprites associated with a script
     */
    public ArrayList<Sprite> getSprites()
    {
        return this.sprites;
    }

    /*
     * Every script starts @ some time
     */
    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }

    /*
     * Every script ends @ some time
     */
    public void setEndTime(int endTime)
    {
        this.endTime = endTime;
    }

    /*
     * Gets the start time associated with a Script
     */
    public int getStartTime()
    {
        return this.startTime;
    }

    /*
     * Gets the end time associated with a Script
     */
    public int getEndTime()
    {
        return this.endTime;
    }


}
