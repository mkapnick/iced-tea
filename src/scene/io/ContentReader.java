package scene.io;

import java.io.BufferedReader;

/**
 * Created with IntelliJ IDEA.
 * Date: 11/16/13
 * To change this template use File | Settings | File Templates.
 */
public abstract class ContentReader
{
    protected BufferedReader bufferedReader;

    public ContentReader (BufferedReader br)
    {
        this.bufferedReader = br;
    }

    public abstract void readLine();



}
