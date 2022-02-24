package MathQuestionGeneratorXML.logic;

import MathQuestionGeneratorXML.logic.questionConfiguration.QuestionConfiguration;
import MathQuestionGeneratorXML.logic.questionConfiguration.SetOfQuestionsConfiguration;
import MathQuestionGeneratorXML.model.Question.Question;

import java.util.ArrayList;


public class ProcessorQuestionConfigurations {

    public ArrayList<Question> processConfigurations(SetOfQuestionsConfiguration setOfQuestionsConfiguration) {

        ReaderQuestions readerQuestions = new ReaderQuestions();
        ArrayList<QuestionConfiguration> questionConfigurations = setOfQuestionsConfiguration.getConfiguration();
        ArrayList<Question> questions = new ArrayList<Question>();

        for (QuestionConfiguration configuration : questionConfigurations) {
            questions.addAll(readerQuestions.getQuestionsUsingConfiguration(configuration));
        }
        return questions;
    }


}
