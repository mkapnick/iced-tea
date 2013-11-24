package io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageReader {

    public static BufferedImage readFile(String fileName, ResourceFinder finder)
    {
        System.out.println("IN IMAGEREADER");
        InputStream is;
        BufferedImage image;

        // Read the image
        image = null;
        try
        {
            is = finder.findInputStream("/" + fileName);
            if(is != null)
            {
                image = ImageIO.read(is);
                System.out.println("Successfully read in image");
                is.close();
            }
            else
            {
                image = ImageIO.read(new File(fileName));
            }
        }
        catch (IOException io)
        {
            System.out.println("Could not read in image " + fileName +". Inside the ImageReader class");
        }

        return image;
    }

    public static BufferedImage readFile (String fileName)
    {
        ResourceFinder finder;
        finder = ResourceFinder.createInstance();

        return readFile(fileName, finder);
    }
}