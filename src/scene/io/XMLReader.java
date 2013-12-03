package scene.io;

import io.ImageReader;
import io.ResourceFinder;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.Environment;
import model.Script;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import scene.visual.dynamic.described.MovingSprite;
import visual.dynamic.described.Sprite;
import visual.statik.sampled.Content;
import visual.statik.sampled.ContentFactory;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/23/13
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLReader {

	ResourceFinder finder;
	
	public XMLReader()
	{
		finder = ResourceFinder.createInstance(this);
	}
	
    public void parseXMLFile(String file, Environment env, Script script) throws Exception
    {
        //Declarations for parsing XML file
        DocumentBuilderFactory docBuilderFactory;
        DocumentBuilder docBuilder;
        Document doc;
        InputStream stream = finder.findInputStream(file);
        //Initialize XML variables
        docBuilderFactory   = DocumentBuilderFactory.newInstance();
        docBuilder          = docBuilderFactory.newDocumentBuilder();
        doc                 = docBuilder.parse (stream);

        doc.getDocumentElement().normalize();

        System.out.println("About to parse sliding sprites");
        parseSlidingSprites(doc, env);
        System.out.println("About to parse moving sprites");
        parseMovingSprites(doc, script);
        System.out.println("Finished parsing");
    }

    private void parseSlidingSprites(Document doc, Environment env)
    {

        NodeList                slidingSpriteList,imageTags, nameTag;
        Node                    slidingSpriteNode;
        Element                 element;
        int                     index;
        String                  imageValue, backgroundValue, groundValue, nameValue;

        slidingSpriteList   = doc.getElementsByTagName("slidingSprite");
        index               = 0;

        System.out.println(slidingSpriteList.getLength());
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

    private void parseMovingSprites(Document doc, Script script)
    {
        //Variables associated with the XML file
        NodeList                movingSpriteList, keyTimeTags, imageTag;
        Node                    movingSpriteNode;
        Element                 element;
        String                  imageValue, keyTime;
        int                     index;
        int                     current=0;
        int                     maxKeyTime=-1, minKeyTime=1000000000;

        //Variables associated with a scene
        BufferedImage           spriteImage;
        ArrayList<Sprite>       sprites;
        Sprite                  sprite;
        ContentFactory          contentFactory;
        Content                 content;

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
                addKeyTime(keyTime, sprite, finder);
                current = ((MovingSprite) sprite).getKeyTime();

                if(current > maxKeyTime)
                    maxKeyTime = current;

                if(current < minKeyTime)
                    minKeyTime = current;

                index++;
            }
            ((MovingSprite) sprite).setEndState();
            sprites.add(sprite);
        }

        System.out.println("ok, parsed moving sprites");
        script.setSprites(sprites);
        script.setStartTime(minKeyTime);
        script.setEndTime(maxKeyTime);
    }
    private void addKeyTime(String keyTime, Sprite sprite,ResourceFinder finder)
    {
        String []       times;
        int             time=0;
        double          x=0,y=0,r=0,s=0;
        String          content;
        Content         c;
        BufferedImage   spriteImage;
        ContentFactory  contentFactory;


        contentFactory  = new ContentFactory(finder);
        c               = null;
        times           = keyTime.split(",");

        //parse key time
        try
        {
            time    = Integer.parseInt(times[0]);
            x       = Double.parseDouble(times[1]);
            y       = Double.parseDouble(times[2]);
            r       = Double.parseDouble(times[3]);
            s       = Double.parseDouble(times[4]);
            content = times[5];

            if(!content.equalsIgnoreCase("null"))
            {
                System.out.println("Doesn't equal null! String is " + content);
                spriteImage     = ImageReader.readFile(content, finder);
                c               = contentFactory.createContent(spriteImage, true);
            }
        }
        catch (Exception e)
        {
            //Something wrong with the XML file here
            System.out.println("Something wrong with xml file");

        }

        ((MovingSprite) sprite).setKeyTime(time);
        ((MovingSprite) sprite).addKeyTime(time, x, y, r, s, c);
    }

    private String getValueOfNode(NodeList tags, int index, Element element)
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
