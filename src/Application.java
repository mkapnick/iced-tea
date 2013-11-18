import app.MultimediaApplication;

import javax.swing.*;


public class Application extends MultimediaApplication {
	
	public static void main(String[] args) throws Exception
	{
		SwingUtilities.invokeAndWait(new Application(args, 400,600));
	}
	
	public Application(String[] args, int height, int width)
	{
		super(args, new TextTester(), height, width);
	}

}
