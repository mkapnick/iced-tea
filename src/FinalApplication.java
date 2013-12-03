import app.MultimediaApplication;

import javax.swing.*;


public class FinalApplication extends MultimediaApplication {
	
	public static void main(String[] args) throws Exception
	{
		SwingUtilities.invokeAndWait(new FinalApplication(args, 900,600));
	}
	
	public FinalApplication(String[] args, int height, int width) 
			throws Exception
	{
		super(args, new FinalApp(
				), height, width);
	}

}
