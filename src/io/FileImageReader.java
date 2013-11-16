package io;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/16/13
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileImageReader {

    public static ArrayList<BufferedImage> readFile(String fileName, ResourceFinder finder)
    {
        ArrayList<BufferedImage> sceneParts;
        InputStream is;
        BufferedReader br;
        BufferedImage bi;
        String readLine;

        sceneParts  = new ArrayList<BufferedImage>();
        is          = finder.findInputStream("/" +fileName);
        readLine    = "";
        br          = null;

        try
        {
            if(is == null)
                br = new BufferedReader(new FileReader(fileName));
            else
                br = new BufferedReader(new InputStreamReader(is));


            while((readLine = br.readLine()) != null)
            {
                bi = ImageReader.readFile(readLine);
                sceneParts.add(bi);
            }
        }
        catch (Exception e)
        {
            System.out.println("Could not open file " + fileName);
        }

       return sceneParts;
    }
}
