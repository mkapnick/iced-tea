package io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * Reads image files and returns BufferedImages.
 * Factory Class.
 * 
 * @author Mike Kapnick
 * @version 1.0
 * 
 * This work complies with the JMU Honor COde
 * 12/3/13
 *
 */
public class ImageReader {

	/**
	 * Reads an image
	 * 
	 * @param fileName
	 * @param finder
	 * @return
	 */
    public static BufferedImage readFile(String fileName, ResourceFinder finder)
    {
        InputStream is;
        BufferedImage image;

        // Read the image
        image = null;
        try
        {
            is = finder.findInputStream(fileName);
            System.out.println("The input stream: " + is);
            if(is != null)
            {
                image = ImageIO.read(is);
                is.close();
            }
        }
        catch (IOException io)
        {
            System.out.println("Could not read in image " + fileName +
            		". Inside the ImageReader class");
        }

        return image;
    }

    public BufferedImage readFile (String fileName)
    {
        ResourceFinder finder;
        finder = ResourceFinder.createInstance(this);

        return readFile(fileName, finder);
    }
}