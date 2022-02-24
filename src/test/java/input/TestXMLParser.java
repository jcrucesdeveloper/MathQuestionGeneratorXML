package input;

import MathQuestionGeneratorXML.input.xml.TagGroup;
import MathQuestionGeneratorXML.input.xml.XMLParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestXMLParser {

    private XMLParser xmlParser;
    private TagGroup tagGroup0;



    @BeforeEach
    public void setUp() {
        xmlParser = new XMLParser("/home/jaco/IdeaProjects/MathGeneratorXMLQuestions/src/test/resources/questions.xml");
        xmlParser.setParentTag("question");
        tagGroup0 = xmlParser.getTagGroupByNumber(0);
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
    public void testGetAttribute() {
        assertEquals("3",xmlParser.getTagGroupByNumber(0).getAttribute("difficulty"));
    }

    @Test
    public void testGetSizeQuestions() {
        assertEquals(1,xmlParser.getSizeQuestions());

    }

    @Test
    public void testGetNameFirstChildByName() {
        assertEquals("alternative1",tagGroup0.getChildTagByName("alternative1").getName());
    }

    @Test
    public void testGetValueFirstChildByName() {
        assertEquals("5",tagGroup0.getChildTagByName("alternative1").getValue());

    }

    @Test
    public void testGetNameFirstChildByNumber() {
        assertEquals("alternative1",tagGroup0.getChildTagByNumber(2).getName());
    }

    @Test
    public void testGetValueFirstChildByNumber() {
        assertEquals("alternative1",tagGroup0.getChildTagByNumber(1).getValue());

    }


}
