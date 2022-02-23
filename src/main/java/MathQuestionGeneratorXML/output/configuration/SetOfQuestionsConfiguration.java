package MathQuestionGeneratorXML.output.configuration;

import java.util.ArrayList;

public class SetOfQuestionsConfiguration {

    private String configurationName;
    private ArrayList<QuestionConfiguration> configurations;

    public SetOfQuestionsConfiguration() {
        configurations = new ArrayList<QuestionConfiguration>();
    }

    public void addQuestionConfiguration(QuestionConfiguration questionConfiguration) {
        configurations.add(questionConfiguration);
    }


    public void saveConfiguration() {

    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    @Override
    public String toString() {

        String out = "";

        out += "========================================================";
        out += "= %s = %s = %s =".formatted();
        return out;
    }
}
