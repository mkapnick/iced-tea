package scene.visual.dynamic.described;

import data.View;
import view.BirdsEye;
import view.InCar;
import view.SideView;
import view.ViewBehavior;
import visual.statik.TransformableContent;

import java.util.ArrayList;

public class SlidingSprite extends AbstractSlidingSprite
{
    private ViewBehavior    viewBehavior;
    private View            view;

    public SlidingSprite(View view, ArrayList<TransformableContent> tc, int speed, double x, double y)
    {
        super(tc);
        decorate(view);
        this.view           = view;
        this.maxX           = x;
        this.maxY           = y;
        this.speed          = speed;
        this.x              = viewBehavior.getX();
        this.y              = viewBehavior.getY();
        this.index          = 0;
        setVisible(true);
    }

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

    private void decorate(View v)
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
