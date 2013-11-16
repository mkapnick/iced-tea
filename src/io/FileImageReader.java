package io;

import scene.visual.dynamic.described.SlidingSprite;
import scene.visual.dynamic.described.Vehicle;
import visual.dynamic.described.Sprite;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;
import visual.statik.sampled.ImageFactory;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/16/13
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileImageReader {

    public static ArrayList<Sprite> readFile(String fileName, ResourceFinder finder)
    {
        ArrayList<Sprite> sceneParts;
        InputStream is;
        BufferedReader br;
        String readLine;
        Sprite sprite;

        sceneParts  = new ArrayList<Sprite>();
        is          = finder.findInputStream("/" +fileName);

        try
        {
            if(is == null)
                br = new BufferedReader(new FileReader(fileName));
            else
                br = new BufferedReader(new InputStreamReader(is));

            while((readLine = br.readLine()) != null)
            {
                sprite = parseLine(readLine);
                sceneParts.add(sprite);
                //bi = ImageReader.readFile(readLine);
                //sceneParts.add(bi);
            }
        }
        catch (Exception e)
        {
            System.out.println("Could not open file " + fileName);
        }

       return sceneParts;
    }

    private static Sprite parseLine(String readLine)
    {
        StringTokenizer st;
        Sprite s;
        String spriteType;
        String concreteType;
        BufferedImage bi;

        st          = new StringTokenizer(readLine, ",");
        s           = null;
        spriteType  = st.nextToken();

        if (spriteType.equalsIgnoreCase("SlidingSprite"))
        {
            ImageFactory imageFactory;
            ContentFactory contentFactory;
            Content content;
            ResourceFinder finder;
            int speed;
            double x,y;

            speed   = Integer.parseInt(st.nextToken());
            x       = Double.parseDouble(st.nextToken());
            y       = Double.parseDouble(st.nextToken());

            finder          = ResourceFinder.createInstance();
            imageFactory    = new ImageFactory(finder);
            contentFactory  = new ContentFactory(finder);
            bi              = imageFactory.createBufferedImage(st.nextToken());
            content         = contentFactory.createContent(bi, false);
            s               = new SlidingSprite(content,speed,x,y);
        }

        else if (spriteType.equalsIgnoreCase("MovingSprite"))
        {
            //prob need to make moving Sprite abstract, and have concrete classes
            // that encapsulate their key times
            concreteType = st.nextToken();

            if(concreteType.equalsIgnoreCase("Vehicle"))
            {
                 s = new Vehicle(st.nextToken());
            }
        }

        return s;
    }
}
