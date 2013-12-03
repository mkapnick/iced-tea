package GUI;

import visual.VisualizationView;
import visual.dynamic.described.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 12/2/13
 * Time: 9:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuiContainer implements ActionListener {


    private JButton nancyButton;
    private JButton mayfieldButton;
    private JButton foxButton;
    private JPanel  contentPane;
    private Stage [] dialogueStages;
    private VisualizationView [] dialogueViews;


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

    public void createSimpleGui()
    {
        JPanel panel;


        panel = new JPanel();
        panel.setSize(200,200);
        panel.setLocation(660,200);

        nancyButton.addActionListener(this);
        mayfieldButton.addActionListener(this);
        foxButton.addActionListener(this);


        nancyButton.setEnabled(false);
        mayfieldButton.setEnabled(false);
        foxButton.setEnabled(false);

        panel.add(nancyButton);
        panel.add(mayfieldButton);
        panel.add(foxButton);

        nancyButton.setVisible(true);
        mayfieldButton.setVisible(true);
        foxButton.setVisible(true);
        panel.setVisible(true);

        this.contentPane.add(panel);

    }

    public void setButtonEnabled(boolean enable)
    {

        this.nancyButton.setEnabled(enable);
        this.mayfieldButton.setEnabled(enable);
        this.foxButton.setEnabled(enable);

    }

    public void setButtonVisible(boolean visible)
    {
        this.nancyButton.setVisible(visible);
        this.mayfieldButton.setVisible(visible);
        this.foxButton.setVisible(visible);
    }

    @Override
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
