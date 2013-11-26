package view;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/26/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class BirdsEye implements ViewBehavior {

    private boolean changeContent;
    private boolean stop;
    private double  x;
    private double  y;
    private int     index;

    public BirdsEye()
    {
        this.changeContent  = false;
        this.stop           = false;
        this.index          = 0;
        this.x = 0;
        this.y = -800;

    }

    @Override
    public void setLocation(double x, double y)
    {
        this.y = y+=1;
        this.x = x;

    }

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
