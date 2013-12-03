package view;

/**
 *
 * @author Mike Kapnick
 * @version 1.0
 *
 * InCar is responsible for keeping track
 * of each sliding sprite that is of type View.InCar.
 * Encapsulates the rules for a view of type View.InCar
 *
 */
public class InCar implements ViewBehavior
{
    private boolean changeContent;
    private boolean stop;
    private double  x;
    private double  y;
    private int     index;

    /*
  * Initializes variables according to what it means to be InCar
  */
    public InCar()
    {
        this.changeContent  = false;
        this.stop           = false;
        this.index          = 0;
        this.x              = 0;
        this.y              = 0;
    }

    /*
     * After every tick from the SlidingSprite class, the location must be
     * updated
     */
    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double[] checkLocation(double maxX, double maxY, int size)
    {
        // nothing should be moving with an InCar view. Background should be static content
        return null;
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

    @Override
    public double getX()
    {
        return this.x;
    }

    @Override
    public double getY()
    {
        return this.y;
    }
}
