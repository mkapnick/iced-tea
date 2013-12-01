package view;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/26/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class SideView implements ViewBehavior {

    private boolean changeContent;
    private boolean stop;
    private double  x;
    private double  y;
    private int     index;

    public SideView()
    {
        this.changeContent  = false;
        this.stop           = false;
        this.index          = 0;
        this.x              = 640;
        this.y              = 0;
    }

    @Override
    public void setLocation(double x, double y)
    {
        this.y = y;
        this.x = x-=1;

    }

    @Override
    public double[] checkLocation(double maxX, double maxY, int size) {
        changeContent = false;
        if(this.x <= -640)
        {
            index++;
            changeContent = true;
            if(index < size)
            {
                this.x = 640;
            }
            else
            {
                this.stop = true;
            }
        }
        return new double [] {x,y};
    }

    @Override
    public boolean changeContent() {
        return changeContent;
    }

    @Override
    public boolean stop() {
        return stop;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }
}
