import io.ResourceFinder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import scene.io.DialogueReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class DialogueXMLTester {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		DialogueReader reader = new DialogueReader("Chris", ResourceFinder.createInstance());
		Document xml = reader.readXML();
		
		//DialogueFactory.createDialogue(xml);
	}
}
