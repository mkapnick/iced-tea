package view;


/**
 *
 * @author Mike Kapnick
 * @version 1.0
 *
 * A SideView is responsible for keeping track
 * of each sliding sprite that is of type View.SideView.
 * Encapsulates the rules for a view of type View.SideView
 *
 */
public class SideView implements ViewBehavior {

    private boolean changeContent;
    private boolean stop;
    private double  x;
    private double  y;
    private int     index;

    /*
     * Initializes variables according to what it means to be a SideView
     */
    public SideView()
    {
        this.changeContent  = false;
        this.stop           = false;
        this.index          = 0;
        this.x              = 640;
        this.y              = 0;
    }

    /*
     * After every tick from the SlidingSprite class, the location must be
     * updated
     */
    @Override
    public void setLocation(double x, double y)
    {
        this.y = y;
        this.x = x-=1;

    }

    /*
     * Checks the location after every tick from the SlidingSprite and
     * updates as necessary
     */
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
