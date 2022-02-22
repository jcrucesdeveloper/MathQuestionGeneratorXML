package logic;

import MathQuestionGeneratorXML.logic.ReaderQuestions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestReaderQuestions {

    private ReaderQuestions readerQuestions;

    @BeforeEach
    public void setUp() {

    }
    @Test
    public void testListQuestionsFile() {

        ArrayList<String> files = readerQuestions.getQuestionFilePaths();
        assertNotEquals(0, files.size());
    }

}
