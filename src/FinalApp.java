import io.ResourceFinder;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import model.Environment;
import model.EventNode;
import model.Script;
import model.View;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import scene.io.DialogueReader;
import scene.visual.Scene;
import scene.visual.content.MenuContent;
import view.MenuView;
import view.StoryView;
import visual.VisualizationView;
import visual.dynamic.described.Stage;
import GUI.GuiContainer;
import app.AbstractMultimediaApp;
import controller.SceneController;
import factory.MenuFactory;
import factory.SceneFactory;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/15/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */

public class FinalApp extends AbstractMultimediaApp
{
    private Stage                       sceneStage;
    private Stage[]                     dialogueStages;
    private VisualizationView           sceneStageView;
    private VisualizationView[]         dialogueStageView;
    private EventNode<MenuContent>      menuContent;
    private MenuView                    menuView;
    private ArrayList<Scene>            scenes;
    private SceneController             sceneController;
    private JPanel                      contentPane;
    private GuiContainer                guiContainer;

    public FinalApp() throws Exception, ParserConfigurationException, SAXException, IOException
    {
        sceneStage = new Stage(50);
        sceneStageView = sceneStage.getView();
        sceneStageView.setBounds(0, 0, 640, 480);
        sceneStageView.setBackground(new Color(158,209,144));
        scenes = new ArrayList<Scene>();
        sceneController = new SceneController(scenes);
        
        setUpDialogueStages();
        setUpDialogue("Chris", dialogueStages[0], dialogueStageView[0], "mayfield.xml");
        setUpDialogue("Nancy", dialogueStages[1], dialogueStageView[1], "harris.xml");
        setUpDialogue("Fox", dialogueStages[2], dialogueStageView[2], "fox.xml");

        



    }

    private void setUpDialogueStages()
    {


        dialogueStages = new Stage[3];
        dialogueStageView = new VisualizationView[3];

        for (int i =0; i < dialogueStages.length; i++)
        {
            dialogueStages[i]        = new Stage(70);
            dialogueStageView[i]    = dialogueStages[i].getView();
            dialogueStageView[i].setBounds(0,480,640,480);

        }
    }

    private void setUpDialogue(String name, Stage sceneStage, VisualizationView view, String xmlFile) throws Exception
    {
        DialogueReader reader = new DialogueReader(name, xmlFile);
        Document xml = reader.getXML();
        menuContent = MenuFactory.createDialogue(name, xml, sceneController);
        menuView = new MenuView(menuContent.getElement().getMenuController(), view);
        menuView.setMouseListeners(view);
        menuView.setMouseMotionListeners(view);
        sceneStage.add(menuView);
    }

    public void init()
    {

        this.contentPane = (JPanel) rootPaneContainer.getContentPane();
        contentPane.setBackground(new Color(255, 248, 220));
        this.guiContainer = new GuiContainer(this.contentPane, 
        		this.dialogueStages, this.dialogueStageView, 
        		"Pick up Prof. Harris", "Pick up Prof. Mayfield", 
        		"Pick up Prof. Fox");

        startUp();
        
       
        
        contentPane.setLayout(null);
        contentPane.add(sceneStageView);
        System.out.println("Before sceneStage start");
        sceneStage.start();
        System.out.println("sceneStage started");
        contentPane.setVisible(true);
        System.out.println("After");

    }

    public void startUp()
    {

        ResourceFinder          finder;
        BufferedReader          br;
        InputStream             is, audioIs;
        StoryView               storyView;
        
        

        finder = ResourceFinder.createInstance(this);
        audioIs = finder.findInputStream("cello_suite.wav");
        
        try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioIs);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
        }
        catch (Exception e) {}
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


        storyView   = new StoryView(sceneController,sceneStageView, sceneStage, this.guiContainer);
        sceneStage.add(storyView);

    }
}
