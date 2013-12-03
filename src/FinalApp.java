import io.ResourceFinder;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
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
 * Initializes our final app and starts the stages
 * 
 * @author Brian Brown, Daniel Hardgrove, Mike Kapnick
 * @version 1.0
 * 
 * This work complies with the jMU Honor Code
 * 12/3/13
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

    public FinalApp() throws Exception
    {
        sceneStage = new Stage(50);
        sceneStageView = sceneStage.getView();
        
        sceneStageView.setBounds(0, 0, 640, 480);
        sceneStageView.setBackground(new Color(158,209,144));
        
        scenes = new ArrayList<Scene>();
        sceneController = new SceneController(scenes);
        
        setUpDialogueStages();
        setUpDialogue("Chris", dialogueStages[0], dialogueStageView[0], 
        		      "mayfield.xml");
        setUpDialogue("Nancy", dialogueStages[1], dialogueStageView[1], 
        		      "harris.xml");
        setUpDialogue("Fox", dialogueStages[2], dialogueStageView[2], 
        		      "fox.xml");
    }

    /**
     * Initializaes the dialogue stages (One stage for each)
     * This is simply extra functionality for our purpose.
     * This helps with our beginning buttons to decide which
     * professor to drive.
     */
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

    /**
     * Sets up one dialogue
     * @param name
     * @param sceneStage
     * @param view
     * @param xmlFile
     * @throws Exception
     */
    private void setUpDialogue(String name, Stage sceneStage, 
    		VisualizationView view, String xmlFile) throws Exception
    {
        DialogueReader reader = new DialogueReader(name, xmlFile);
        Document xml = reader.getXML();
        menuContent = MenuFactory.createDialogue(name, xml, sceneController);
        menuView = new MenuView(menuContent.getElement().getMenuController(), 
        		   view);
        menuView.setMouseListeners(view);
        menuView.setMouseMotionListeners(view);
        sceneStage.add(menuView);
    }

    /**
     * Initializes the content pane and others
     */
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
     
        sceneStage.start();
      
        contentPane.setVisible(true);
        

    }

    /**
     * Does a lot of the original set up work like init.
     */
    public void startUp()
    {
        ResourceFinder          finder;
        BufferedReader          br;
        InputStream             is, audioIs;
        StoryView               storyView;
        
        //Sets up the audio
        finder = ResourceFinder.createInstance(this);
        audioIs = finder.findInputStream("cs1-1pre.mid");
        
        try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
	        									(audioIs);
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        FloatControl volume = (FloatControl) clip.getControl
	        					  (FloatControl.Type.MASTER_GAIN);
	        volume.setValue(-15);
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


        scenes.add(SceneFactory.createScene(Environment.MOUNTAINS, 
        		View.SIDEVIEW,
                Script.MOUNTAIN_SCRIPT, finder, "mountainScene.xml"));
        
        scenes.get(3).setBackgroundColor(new Color(255, 255, 255));


        scenes.add(SceneFactory.createScene(Environment.FINAL, View.SIDEVIEW,
                Script.FINAL_SCRIPT, finder, "finalScene.xml"));
        scenes.get(4).setBackgroundColor(new Color(255, 255, 255));


        storyView   = new StoryView(sceneController,sceneStageView, sceneStage, 
        			 this.guiContainer);
        sceneStage.add(storyView);

    }
}
