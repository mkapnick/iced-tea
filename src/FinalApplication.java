import app.MultimediaApplication;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class FinalApplication extends MultimediaApplication {
	
	public static void main(String[] args) throws Exception
	{
		SwingUtilities.invokeAndWait(new FinalApplication(args, 600,400));
	}
	
	public FinalApplication(String[] args, int height, int width) throws ParserConfigurationException, SAXException, IOException
	{
		super(args, new FinalApp(), height, width);
	}

}
