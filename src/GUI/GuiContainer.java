package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import visual.VisualizationView;
import visual.dynamic.described.Stage;

/**
 * Container for the GUI buttons and the JLabel
 * 
 * @author Brian Brown, Mike Kapnick
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code
 * 12/3/13
 */
public class GuiContainer implements ActionListener {


    private JButton nancyButton;
    private JButton mayfieldButton;
    private JButton foxButton;
    private JPanel  contentPane;
    private Stage [] dialogueStages;
    private VisualizationView [] dialogueViews;


    /**
     * Initializes variables
     * 
     * @param contentPane
     * @param dialogueStages
     * @param views
     * @param label1
     * @param label2
     * @param label3
     */
    public GuiContainer(JPanel contentPane, 
    		Stage[] dialogueStages, VisualizationView [] views,  
    		String label1, String label2, String label3)
    {
        this.contentPane    = contentPane;
        this.dialogueStages = dialogueStages;
        this.dialogueViews  = views;
        nancyButton         = new JButton(label1);
        mayfieldButton      = new JButton(label2);
        foxButton           = new JButton(label3);

        createSimpleGui();

    }

    /**
     * Creates the buttons and labels for the gui
     */
    public void createSimpleGui()
    {
        JPanel panel;
        JLabel title;
        
        title = new JLabel("CS Professors in Cars Getting Coffee");
        title.setFont(new Font("Arial", Font.ITALIC, 11));
        

        panel = new JPanel();
        panel.setSize(200,200);
        panel.setLocation(660,200);

        nancyButton.addActionListener(this);
        mayfieldButton.addActionListener(this);
        foxButton.addActionListener(this);


        nancyButton.setEnabled(false);
        mayfieldButton.setEnabled(false);
        foxButton.setEnabled(false);

        panel.setBackground(new Color(255, 248, 220));
        panel.add(title);
        panel.add(nancyButton);
        panel.add(mayfieldButton);
        panel.add(foxButton);
        

        nancyButton.setVisible(true);
        mayfieldButton.setVisible(true);
        foxButton.setVisible(true);
        panel.setVisible(true);

        this.contentPane.add(panel);

    }

    /**
     * Decides if the button should be clickable yet.
     * @param enable
     */
    public void setButtonEnabled(boolean enable)
    {

        this.nancyButton.setEnabled(enable);
        this.mayfieldButton.setEnabled(enable);
        this.foxButton.setEnabled(enable);

    }

    /**
     * Shows the button or not.
     * @param visible
     */
    public void setButtonVisible(boolean visible)
    {
        this.nancyButton.setVisible(visible);
        this.mayfieldButton.setVisible(visible);
        this.foxButton.setVisible(visible);
    }

    /**
     * Depending on which button is clicked, load a particular stage
     */
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getActionCommand().equalsIgnoreCase(this.nancyButton.getActionCommand()))
        {
            dialogueStages[1].start();
            this.contentPane.add(dialogueViews[1]);


        }
        else if(actionEvent.getActionCommand().equalsIgnoreCase(this.mayfieldButton.getActionCommand()))
        {
            dialogueStages[0].start();
            this.contentPane.add(dialogueViews[0]);


        }
        else
        {
            dialogueStages[2].start();
            this.contentPane.add(dialogueViews[2]);

        }

        setButtonVisible(false);

    }
}
