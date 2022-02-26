package logic.questionConfiguration;

import MathQuestionGeneratorXML.logic.questionConfiguration.QuestionConfiguration;
import MathQuestionGeneratorXML.logic.questionConfiguration.SaverQuestionConfiguration;
import MathQuestionGeneratorXML.logic.questionConfiguration.SetOfQuestionsConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSaverQuestionConfiguration {

    private SaverQuestionConfiguration saverQuestionConfiguration;

    @BeforeEach
    public void setUp() {
        saverQuestionConfiguration = new SaverQuestionConfiguration();
    }

    @Test
    public void testSaveConfiguration() {

        SetOfQuestionsConfiguration setOfQuestionsConfiguration = new SetOfQuestionsConfiguration();
        setOfQuestionsConfiguration.setConfigurationName("configuration1");

        QuestionConfiguration questionConfiguration1 = new QuestionConfiguration();
        questionConfiguration1.setFileName("lol.xml");
        questionConfiguration1.setDifficulty("1");
        questionConfiguration1.setNumberQuestions("2");

        setOfQuestionsConfiguration.addQuestionConfiguration(questionConfiguration1);

        saverQuestionConfiguration.saveConfiguration(setOfQuestionsConfiguration);
    }



}
