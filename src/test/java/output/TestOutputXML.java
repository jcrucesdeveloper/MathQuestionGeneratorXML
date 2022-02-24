package output;

import MathQuestionGeneratorXML.model.Question.Question;
import MathQuestionGeneratorXML.output.xml.OutputXML;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestOutputXML {

    private OutputXML outputXML;
    @BeforeEach
    public void setUp() {
        outputXML = new OutputXML("test");
    }

    @Test
    public void testOuputFile() throws ParserConfigurationException, TransformerException {
        ArrayList<Question> questions = new ArrayList<>();

        Question question = new Question();
        question.setQuestionLabel("questionLabel");
        question.addAlternative(1,"test");
        question.addAlternative(2,"test");

        questions.add(question);
        question.setCorrectAlternative("loool");
        outputXML.outputFile(questions);


        String filePath = "/home/jaco/IdeaProjects/MathGeneratorXMLQuestions/src/main/build/test.xml";
        File file = new File(filePath);

        assertTrue(file.exists());
        assertTrue(!file.isDirectory());

    }
}
