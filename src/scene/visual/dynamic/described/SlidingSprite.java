package scene.visual.dynamic.described;

import model.View;
import view.BirdsEye;
import view.InCar;
import view.SideView;
import view.ViewBehavior;
import visual.statik.TransformableContent;

import java.util.ArrayList;

/*
 * Creates a sampled sprite with key times
 * @author Mike Kapnick
 * @version 1.0
 *
 * This work complies with the JMU Honor Code
 * 12/3/13
 *
 * Sliding sprites are our rule based sprites. Sliding sprites aren't used
 * in any of the xml files for each scene, but this was code we thought could
 * be necessary and helpful to have in the future. Sliding sprites are rule based sprites.
 * Rules depend on the current view of the app. Views can either be birdseye or sideview or
 * in car. Because of this fact, we delegate the rules at runtime to a ViewBehavior object,
 * which can be instantiated as either a BirdsEye, SideView, or InCar class
 *
 */
public class SlidingSprite extends AbstractSlidingSprite
{
    private ViewBehavior    viewBehavior;
    private View            view;

    public SlidingSprite(View view, ArrayList<TransformableContent> tc, int speed, double x, double y)
    {
        super(tc);
        setCurrentView(view);
        this.view           = view;
        this.maxX           = x;
        this.maxY           = y;
        this.speed          = speed;
        this.x              = viewBehavior.getX();
        this.y              = viewBehavior.getY();
        this.index          = 0;
        setVisible(true);
    }

    /* The rules for a sliding sprite are different according to the view the app
     * is currently in. Thus, the handle tick method delegates to a ViewBehavior
     * object, and the rules are determined at runtime.
     */
    @Override
    public void handleTick(int time)
    {
        double location [];
        viewBehavior.setLocation(x,y);

        this.x = viewBehavior.getX();
        this.y = viewBehavior.getY();

        location = viewBehavior.checkLocation(maxX, maxY, this.listOfContents.size());

        if(viewBehavior.changeContent())
        {
            if(!viewBehavior.stop())
            {
                this.content = this.listOfContents.get(++index);
                this.y = viewBehavior.getY();
                this.x = viewBehavior.getX();
            }
            else
            {
                System.out.println("need to stop and transition here");
            }
        }

        setLocation(location[0], location[1]);
    }

    /*
     * Instantiates the viewBehavior object according
     * to the current view the app is in
     */
    private void setCurrentView(View v)
    {
        switch (v)
        {
            case BIRDSEYE:
                this.viewBehavior = new BirdsEye();
                break;
            case SIDEVIEW:
                this.viewBehavior = new SideView();
                break;
            case INCAR:
                this.viewBehavior = new InCar();
                break;
        }
    }


}
