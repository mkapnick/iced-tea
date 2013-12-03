import app.AbstractMultimediaApp;
import controller.SceneController;
import factory.MenuFactory;
import factory.SceneFactory;
import io.ResourceFinder;
import model.Environment;
import model.EventNode;
import model.Script;
import model.View;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import scene.io.DialogueReader;
import scene.visual.Scene;
import scene.visual.content.MenuContent;
import scene.visual.content.SceneContent;
import view.MenuView;
import view.StoryView;
import visual.VisualizationView;
import visual.dynamic.described.Stage;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/15/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */

public class FinalApp extends AbstractMultimediaApp
{
    private Stage stage, stage2;
    private VisualizationView stageView, stageView2;
    private EventNode<SceneContent> content;
    private EventNode<MenuContent> menuContent;
    private MenuView menuView;

    public FinalApp() throws ParserConfigurationException, SAXException, IOException
    {
        stage = new Stage(50);
        stage2 = new Stage(50);
        stageView2 = stage2.getView();
        stageView = stage.getView();
        stageView.setBackground(new Color(158,209,144));
        //stage.setBackground();
        stageView.setBounds(0, 0, 640, 480);
        stageView2.setBounds(0, 480, 640, 480);
        
        DialogueReader reader = new DialogueReader("Chris", ResourceFinder.createInstance());
		Document xml = reader.getXML();
		menuContent = MenuFactory.createDialogue("Chris", xml);
    }

    public void init()
    {

        startUp();
        JPanel contentPane = (JPanel) rootPaneContainer.getContentPane();
        contentPane.setLayout(null);
        //contentPane.setSize(600,400);

        contentPane.add(stageView);
        contentPane.add(stageView2);
        System.out.println("Before stage start");
        stage.start();
        stage2.start();
        System.out.println("stage started");
        contentPane.setVisible(true);
        System.out.println("After");

    }

    public void startUp()
    {

        ResourceFinder          finder;
        BufferedReader          br;
        InputStream             is;
        ArrayList<Scene>        scenes;
        StoryView               storyView;
        SceneController         sceneController;

        finder = ResourceFinder.createInstance(this);
        scenes = new ArrayList<Scene>();
        System.out.println("JUST BEFORE SCENE FACTORY CALL");

        //Construct all possible scenes
        scenes.add(SceneFactory.createScene(Environment.INTRO, View.BIRDSEYE,
                Script.INTRO_SCRIPT, finder, "introScene.xml"));
        scenes.get(0).setBackgroundColor(new Color(158, 209, 144));


        scenes.add(SceneFactory.createScene(Environment.CITY, View.SIDEVIEW,
                Script.CITY_SCRIPT, finder, "cityScene.xml"));
        scenes.get(1).setBackgroundColor(new Color(111, 174, 223));


        scenes.add(SceneFactory.createScene(Environment.FOREST, View.SIDEVIEW,
                Script.FOREST_SCRIPT, finder, "forestScene.xml"));
        scenes.get(2).setBackgroundColor(new Color(0, 0, 0));


        scenes.add(SceneFactory.createScene(Environment.MOUNTAINS, View.SIDEVIEW,
                Script.MOUNTAIN_SCRIPT, finder, "mountainScene.xml"));
        scenes.get(3).setBackgroundColor(new Color(255, 255, 255));


        scenes.add(SceneFactory.createScene(Environment.FINAL, View.SIDEVIEW,
                Script.FINAL_SCRIPT, finder, "finalScene.xml"));
        scenes.get(4).setBackgroundColor(new Color(255, 255, 255));

        //build a tree that represents a story from these scenes


        sceneController = new SceneController(scenes);
        storyView   = new StoryView(sceneController,stageView, stage);
        menuView = new MenuView(menuContent.getElement().getMenuController(), stageView2);
        menuView.setMouseListeners(stageView2);
		menuView.setMouseMotionListeners(stageView2);
        stage2.add(menuView);
        stage.add(storyView);
        
    }
}
