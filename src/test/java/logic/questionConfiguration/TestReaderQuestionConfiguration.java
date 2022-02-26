package logic.questionConfiguration;

import MathQuestionGeneratorXML.logic.ReaderQuestions;
import MathQuestionGeneratorXML.logic.questionConfiguration.ReaderQuestionConfiguration;
import MathQuestionGeneratorXML.logic.questionConfiguration.SetOfQuestionsConfiguration;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestReaderQuestionConfiguration {

    private ReaderQuestionConfiguration readerQuestionConfiguration;

    @BeforeEach
    public void setUp() {
        readerQuestionConfiguration = new ReaderQuestionConfiguration();
    }

    @Test
    public void testReaderConfiguration() throws FileNotFoundException {

        SetOfQuestionsConfiguration setOfQuestionsConfiguration;
        ReaderQuestionConfiguration readerQuestionConfiguration = new ReaderQuestionConfiguration();

        setOfQuestionsConfiguration = readerQuestionConfiguration.readConfiguration("config1.json");

        System.out.println(setOfQuestionsConfiguration);

    }

    @Test
    public void testFilePaths() {
        ArrayList<String> filePaths;
        filePaths = readerQuestionConfiguration.getConfigsFilePath();
        filePaths.forEach(System.out::println);
        assertNotEquals(0,filePaths.size());
    }
}
