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

    CLASSIC_SCRIPT(null),
    MODERN_SCRIPT(null),
    UNIQUE_SCRIPT(null);

    private ArrayList<Sprite> sprites;

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


}
