package view;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/26/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class InCar implements ViewBehavior
{
    private boolean changeContent;
    private boolean stop;
    private double  x;
    private double  y;
    private int     index;

    public InCar()
    {
        this.changeContent  = false;
        this.stop           = false;
        this.index          = 0;
        this.x              = 0;
        this.y              = 0;
    }

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
