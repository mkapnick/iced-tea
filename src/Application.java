import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import app.MultimediaApplication;


public class Application extends MultimediaApplication {
	
	public static void main(String[] args) throws Exception
	{
		SwingUtilities.invokeAndWait(new Application(args, 600,400));
	}
	
	public Application(String[] args, int height, int width) throws ParserConfigurationException, SAXException, IOException
	{
		super(args, new TextTester(), height, width);
	}

}
