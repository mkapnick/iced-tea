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

    public InCar()
    {
        this.changeContent  = false;
        this.stop           = false;
    }

    @Override
    public void setLocation(double x, double y) {
        //this.x = x;
        //this.y = y;
    }

    @Override
    public double[] checkLocation(double maxX, double maxY, int size)
    {
        return new double[0];
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
    public double getX() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getY() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
