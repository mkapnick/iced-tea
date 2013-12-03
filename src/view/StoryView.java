package view;

import controller.SceneController;
import event.Metronome;
import scene.visual.Scene;
import visual.VisualizationView;
import visual.dynamic.described.RuleBasedSprite;
import visual.dynamic.described.Sprite;
import visual.dynamic.described.Stage;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class StoryView implements Sprite {

    private SceneController         controller;
    private Scene                   currentScene;
    private VisualizationView       view;
    private Stage                   stage;
    private Scene                   previousScene;

    public StoryView(SceneController controller, VisualizationView view, Stage stage)
    {
        this.controller         = controller;
        this.view               = view;
        this.stage              = stage;
        this.currentScene       = controller.getCurrentScene();
        //System.out.println("SIZE AGAIN IS: " + this.node.children().size());
        //controller.setCurrentContentToIndex(0);
    }

    private void addContentsOfSceneToStage(Scene currentScene)
    {
        ArrayList<Sprite> movingSprites;
        RuleBasedSprite[]  slidingSprites;

        slidingSprites  = currentScene.getSlidingSprites();
        movingSprites   = currentScene.getMovingSprites();

        for(int j =0; j < slidingSprites.length; j++)
        {
            if(slidingSprites[j] != null)
            {
                System.out.println(slidingSprites[j]);
                stage.add(slidingSprites[j]);
            }
        }

        for(int i =0; i < movingSprites.size(); i++)
        {
            if(movingSprites.get(i) != null)
            {
                System.out.println(movingSprites.get(i));
                stage.add(movingSprites.get(i));
            }
        }

        currentScene.setOnStage(true);
    }

    private void removeAllSpritesFromStage(Scene currentScene)
    {
        ArrayList<Sprite> movingSprites;
        RuleBasedSprite[]  slidingSprites;

        slidingSprites  = currentScene.getSlidingSprites();
        movingSprites   = currentScene.getMovingSprites();

        for(int j =0; j < slidingSprites.length; j++)
        {
            if(slidingSprites[j] != null)
            {
                stage.remove(slidingSprites[j]);
            }
        }

        for(int i =0; i < movingSprites.size(); i++)
        {
            if(movingSprites.get(i) != null)
            {
                stage.remove(movingSprites.get(i));
            }
        }
    }


    @Override
    public void handleTick(int time) {
        Metronome   metronome;

        previousScene       = this.currentScene;
        this.currentScene   = controller.getCurrentScene();

        if(!currentScene.isOnStage())
        {
            if(this.currentScene != previousScene)
                removeAllSpritesFromStage(previousScene);

            addContentsOfSceneToStage(this.currentScene);

            metronome   = stage.getMetronome();
            metronome.reset();
            stage.setBackground(this.currentScene.getBackgroundColor());
            stage.start();
        }



    }

    @Override
    public Rectangle2D getBounds2D(boolean arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLocation(double arg0, double arg1) {
        // TODO Auto-generated method stub

    }

    public void setMouseListeners(VisualizationView view)
    {

    }

    public void setMouseMotionListeners(VisualizationView view)
    {

    }
    @Override
    public void setRotation(double arg0, double arg1, double arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setScale(double arg0, double arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(Graphics arg0) {

        //controller.getCurrentScene().render(arg0);

    }

}
