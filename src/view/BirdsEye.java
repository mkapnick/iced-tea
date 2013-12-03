package view;

/**
 *
 * @author Mike Kapnick
 * @version 1.0
 *
 * BirdsEye is responsible for keeping track
 * of each sliding sprite that is of type View.BIRDSEYE.
 * Encapsulates the rules for a view of type View.BIRDSEYE
 *
 */
public class BirdsEye implements ViewBehavior {

    private boolean changeContent;
    private boolean stop;
    private double  x;
    private double  y;
    private int     index;

    /*
    * Initializes variables according to what it means to be BIRDSEYE
    */
    public BirdsEye()
    {
        this.changeContent  = false;
        this.stop           = false;
        this.index          = 0;
        this.x              = 0;
        this.y              = -800;

    }

    /*
     * After every tick from the SlidingSprite class, the location must be
     * updated
     */
    @Override
    public void setLocation(double x, double y)
    {
        this.y = y+=1;
        this.x = x;

    }

    /*
     * Checks the location after every tick from the SlidingSprite and
     * updates as necessary
     */
    @Override
    public double[] checkLocation(double maxX, double maxY, int size)
    {
        changeContent = false;
        if(y >= maxY)
        {
            index++;
            changeContent = true;
            if(index < size)
            {
                this.y = -800;
            }
            else
            {
                this.stop = true;
            }
        }
        return new double [] {x,y};
    }

    @Override
    public boolean changeContent()
    {
        return changeContent;
    }

    @Override
    public boolean stop()
    {
        return stop;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }
}
