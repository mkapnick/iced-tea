package scene.io;

import io.ResourceFinder;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Created with IntelliJ IDEA.
 * Date: 11/16/13
 * To change this template use File | Settings | File Templates.
 */
public class DialogueReader{

		private String professor;
		private ResourceFinder finder;
		
       public DialogueReader(String professor, ResourceFinder finder)
       {
    	   this.professor = professor;
    	   this.finder = finder;
       }

    public Document getXML() throws ParserConfigurationException, SAXException, IOException
    {
    	File dialogueFile = new File("dialogueTree.xml");
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	Document doc = dBuilder.parse(dialogueFile);
    	
    	return doc;
    }

}
