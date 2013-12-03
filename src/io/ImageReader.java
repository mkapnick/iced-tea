package io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageReader {

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
            System.out.println("Could not read in image " + fileName +". Inside the ImageReader class");
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