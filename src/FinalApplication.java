import app.MultimediaApplication;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class FinalApplication extends MultimediaApplication {
	
	public static void main(String[] args) throws Exception
	{
		SwingUtilities.invokeAndWait(new FinalApplication(args, 900,600));
	}
	
	public FinalApplication(String[] args, int height, int width) throws Exception, ParserConfigurationException, SAXException, IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		super(args, new FinalApp(
				), height, width);
	}

}
