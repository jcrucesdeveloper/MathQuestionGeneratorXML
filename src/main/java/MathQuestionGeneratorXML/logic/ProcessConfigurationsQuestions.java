package MathQuestionGeneratorXML.logic;

import MathQuestionGeneratorXML.logic.questionConfiguration.QuestionConfiguration;
import MathQuestionGeneratorXML.logic.questionConfiguration.SetOfQuestionsConfiguration;
import MathQuestionGeneratorXML.model.Question.Question;

import java.util.ArrayList;


public class ProcessConfigurationsQuestions {

    private ReaderQuestions readerQuestions;
    private SetOfQuestionsConfiguration setOfQuestionsConfiguration;

    public void setSetOfQuestionsConfiguration(SetOfQuestionsConfiguration setOfQuestionsConfiguration) {
        this.setOfQuestionsConfiguration = setOfQuestionsConfiguration;
    }

    public void process() {

        ArrayList<QuestionConfiguration> questionConfigurations = this.setOfQuestionsConfiguration.getConfiguration();
        ArrayList<Question> questions = new ArrayList<Question>();

        for (QuestionConfiguration configuration : questionConfigurations) {
            ArrayList<Question> questionsTemp;
            questions.addAll(readerQuestions.getQuestionsUsingConfiguration(configuration));
        }
    }


}
