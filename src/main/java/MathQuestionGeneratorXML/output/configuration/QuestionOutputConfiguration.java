package MathQuestionGeneratorXML.output.configuration;

import MathQuestionGeneratorXML.model.Question.Question;

import java.util.ArrayList;

public class QuestionOutputConfiguration {

    private String configurationName;
    private ArrayList<QuestionConfiguration> configurations;

    public void addQuestionConfiguration(QuestionConfiguration questionConfiguration) {
        configurations.add(questionConfiguration);
    }

    public void saveConfiguration() {

    }

}
