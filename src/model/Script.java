package model;

import visual.dynamic.described.Sprite;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/20/13
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
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

    Script(ArrayList<Sprite> sprites)
    {
        this.sprites = sprites;
    }

    public void setSprites(ArrayList<Sprite> sprites)
    {
        this.sprites = sprites;
    }

    public ArrayList<Sprite> getSprites()
    {
        return this.sprites;
    }

    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime)
    {
        this.endTime = endTime;
    }

    public int getStartTime()
    {
        return this.startTime;
    }

    public int getEndTime()
    {
        return this.endTime;
    }


}
