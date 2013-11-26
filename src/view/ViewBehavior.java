package view;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/26/13
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ViewBehavior {

    public void setLocation(double x, double y);
    public double [] checkLocation(double maxX, double maxY, int size);
    public boolean changeContent();
    public boolean stop();
    public double getX();
    public double getY();


}
