package scene.io;

import io.ImageReader;
import io.ResourceFinder;
import data.Environment;
import data.Script;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import scene.visual.dynamic.described.MovingSprite;
import visual.dynamic.described.Sprite;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/23/13
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLReader {

    public static void parseXMLFile(String file, Environment env, Script script, ResourceFinder finder) throws Exception
    {
        //Declarations for parsing XML file
        DocumentBuilderFactory docBuilderFactory;
        DocumentBuilder docBuilder;
        Document doc;

        //Initialize XML variables
        docBuilderFactory   = DocumentBuilderFactory.newInstance();
        docBuilder          = docBuilderFactory.newDocumentBuilder();
        doc                 = docBuilder.parse (new File(file));

        doc.getDocumentElement().normalize();

        System.out.println("About to parse sliding sprites");
        parseSlidingSprites(doc, env, finder);
        System.out.println("About to parse moving sprites");
        parseMovingSprites(doc, script, finder);
        System.out.println("Finished parsing");
    }

    private static void parseSlidingSprites(Document doc, Environment env, ResourceFinder finder)
    {

        NodeList                slidingSpriteList,imageTags, nameTag;
        Node                    slidingSpriteNode;
        Element                 element;
        int                     index;
        String                  imageValue, backgroundValue, groundValue, nameValue;

        slidingSpriteList   = doc.getElementsByTagName("slidingSprite");
        index               = 0;

        //Parse all Sliding sprites in the XML file
        for(int i = 0; i < slidingSpriteList.getLength(); i++)
        {
            slidingSpriteNode   = slidingSpriteList.item(i);
            element             = (Element) slidingSpriteNode;
            nameTag             = element.getElementsByTagName("name");
            imageTags           = element.getElementsByTagName("image");
            index               = 0;

            nameValue           = getValueOfNode(nameTag, 0, element);

            if(nameValue.equalsIgnoreCase("foreground"))
            {
                ArrayList<String> foregroundList;
                foregroundList = new ArrayList<String>();
                while(index < imageTags.getLength())
                {
                    imageValue  = getValueOfNode(imageTags, index, element);
                    foregroundList.add(imageValue);
                    index++;
                }
                env.setForeground(foregroundList);
            }
            else if(nameValue.equalsIgnoreCase("background"))
            {
                backgroundValue = getValueOfNode(imageTags, 0, element);
                env.setBackground(backgroundValue);
            }
            else
            {
                groundValue     = getValueOfNode(imageTags, 0, element);
                env.setGround(groundValue);
            }
        }
    }

    private static void parseMovingSprites(Document doc, Script script, ResourceFinder finder)
    {
        //Variables associated with the XML file
        NodeList                movingSpriteList, keyTimeTags, imageTag;
        Node                    movingSpriteNode;
        Element                 element;
        String                  imageValue, keyTime;
        int                     index;

        //Variables associated with a scene
        BufferedImage           spriteImage;
        ArrayList<Sprite>       sprites;
        Sprite                  sprite;
        ContentFactory contentFactory;
        Content content;

        sprites            = new ArrayList<Sprite>();
        contentFactory     = new ContentFactory(finder);
        movingSpriteList   = doc.getElementsByTagName("movingSprite");

        for(int i =0; i < movingSpriteList.getLength(); i++)
        {
            movingSpriteNode    = movingSpriteList.item(i);
            element             = (Element) movingSpriteNode;
            imageTag            = element.getElementsByTagName("image");
            keyTimeTags         = element.getElementsByTagName("keyTime");

            imageValue          = getValueOfNode(imageTag, 0, element);
            spriteImage         = ImageReader.readFile(imageValue, finder);

            content             = contentFactory.createContent(spriteImage, true);
            sprite              = new MovingSprite(content);
            index               = 0;

            while (index < keyTimeTags.getLength())
            {
                keyTime = getValueOfNode(keyTimeTags, index, element);
                System.out.println("Key time is: " + keyTime);
                addKeyTime(keyTime, sprite);
                index++;
            }

            ((MovingSprite) sprite).setEndState();
            sprites.add(sprite);
        }

        System.out.println("ok, parsed moving sprites");
        script.setSprites(sprites);
    }
    private static void addKeyTime(String keyTime, Sprite sprite)
    {
        String []   times;
        int         time=0;
        double      x=0,y=0,r=0,s=0;

        times   = keyTime.split(",");

        try
        {
            time    = Integer.parseInt(times[0]);
            x       = Double.parseDouble(times[1]);
            y       = Double.parseDouble(times[2]);
            r       = Double.parseDouble(times[3]);
            s       = Double.parseDouble(times[4]);
        }
        catch (Exception e)
        {
            //Something wrong with the XML file here
            System.out.println("Something wrong with xml file");

        }

        ((MovingSprite) sprite).addKeyTime(time, x, y, r, s);
    }

    private static String getValueOfNode(NodeList tags, int index, Element element)
    {
        NodeList    dummyList;
        Node        dummyNode;
        String      valueOfNode;

        dummyList   = tags.item(index).getChildNodes();
        dummyNode   = dummyList.item(0);
        valueOfNode = dummyNode.getNodeValue();

        return valueOfNode;
    }
}
