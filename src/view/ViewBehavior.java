package view;

/**
 *
 * @author Mike Kapnick
 * @version 1.0
 *
 * Each view has a certain behavior that it performs (differently).
 * These methods define what it takes to be of type ViewBehavior
 *
 */
public interface ViewBehavior {

    public void setLocation(double x, double y);
    public double [] checkLocation(double maxX, double maxY, int size);
    public boolean changeContent();
    public boolean stop();
    public double getX();
    public double getY();


}
