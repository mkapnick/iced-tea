package view;

import controller.SceneController;
import event.Metronome;
import model.EventNode;
import scene.visual.Scene;
import scene.visual.content.SceneContent;
import visual.VisualizationView;
import visual.dynamic.described.RuleBasedSprite;
import visual.dynamic.described.Sprite;
import visual.dynamic.described.Stage;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class StoryView implements Sprite {

    private SceneController         controller;
    private VisualizationView       view;
    private Stage                   stage;
    private EventNode<SceneContent> parentNode, curNode;
    private int                     indexOfNode;

    public StoryView(SceneController controller, VisualizationView view, Stage stage, EventNode<SceneContent> parent)
    {
        this.controller         = controller;
        this.view               = view;
        this.stage              = stage;
        this.parentNode         = parent;
        this.curNode            = parent;
        this.indexOfNode= 0;
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
        Scene       curScene;

        curScene    = controller.getCurrentScene();

        if(!curScene.isOnStage())
        {
            System.out.println(curScene.getMovingSprites().size());
            addContentsOfSceneToStage(curScene);
        }


        if(time >= 10000) //static right now
        {
            removeAllSpritesFromStage(curScene);
            System.out.println("index of this node is: " + indexOfNode);
            this.curNode   = this.parentNode.getChildAt(indexOfNode);


            if(this.curNode == null)
                System.out.println("this.node IS NULL!");

            this.controller.nextScene(indexOfNode);
            indexOfNode++;

            metronome   = stage.getMetronome();
            metronome.reset();
            stage.setBackground(this.controller.getCurrentScene().getBackgroundColor());
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
