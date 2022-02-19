package input;

import MathQuestionGeneratorXML.input.XMLFileHandler;
import MathQuestionGeneratorXML.input.XMLParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestXMLParser {

    private XMLParser xmlParser;


    @BeforeEach
    public void setUP() {
        xmlParser = new XMLParser("/questions.xml");
    }

    @Test
    public void testReadFileXML() {
        assertNotEquals(null, xmlParser.getXMLFile());
    }

    @Test
    public void testGetParentTagName() {
        xmlParser.setParentTag("question");
        assertEquals("question", xmlParser.getParentTagName());
    }

    @Test
    public void testGetValueFirstChildByName() {
        assertEquals("alternative1",xmlParser.getChild("alternative1").getValue());
    }

    @Test


}
