package input;

import MathQuestionGeneratorXML.input.xml.XMLParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestXMLParser {

    private XMLParser xmlParser;



    @BeforeEach
    public void setUp() {
        xmlParser = new XMLParser("/home/jaco/IdeaProjects/MathGeneratorXMLQuestions/src/test/resources/questions.xml");
        xmlParser.setParentTag("question");

    }

    @Test
    public void testReadFileXML() {
        assertNotEquals(null, xmlParser.getXMLFile());
    }

    @Test
    public void testGetParentTagName() {
        assertEquals("question", xmlParser.getParentTagName());
    }


    @Test
    public void testGetNameFirstChildByName() {
        assertEquals("alternative1",xmlParser.getChildTagByName("alternative1").getName());
    }

    @Test
    public void testGetValueFirstChildByName() {
        assertEquals("alternative1",xmlParser.getChildTagByName("alternative1").getValue());

    }

    @Test
    public void testGetNameFirstChildByNumber() {
        assertEquals("alternative1",xmlParser.getChildTagByNumber(1).getName());
    }

    @Test
    public void testGetValueFirstChildByNumber() {
        assertEquals("alternative1",xmlParser.getChildTagByNumber(1).getValue());

    }


}
