import javax.swing.SwingUtilities;

import app.MultimediaApplication;


public class Application extends MultimediaApplication {
	
	public static void main(String[] args) throws Exception
	{
		SwingUtilities.invokeAndWait(new Application(args, 600,400));
	}
	
	public Application(String[] args, int height, int width)
	{
		super(args, new TextTester(), height, width);
	}

}
