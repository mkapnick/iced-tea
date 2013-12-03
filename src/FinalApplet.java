import app.MultimediaApplet;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: michaelk18
 * Date: 11/23/13
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class FinalApplet extends MultimediaApplet
{
    public FinalApplet() throws Exception, ParserConfigurationException, SAXException, IOException, UnsupportedAudioFileException, LineUnavailableException
    {
        super(new FinalApp());
    }
}
