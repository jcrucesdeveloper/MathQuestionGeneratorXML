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

        StringBuilder out = new StringBuilder();

        String outputLabels ="== %35s\t\t\t ==\t %5s\t==\t %5s\t ==\n".formatted("FILENAME", "QUANTITY", "DIFFICULTY");
        String line1 = createLine(outputLabels.length() + 9);

        out.append(line1);
        out.append(outputLabels);
        out.append(line1);

        for(QuestionConfiguration configuration: configurations) {
            out.append("== %40s\t\t ==\t %5d\t\t==\t %5d\t\t ==\n".formatted(
                    configuration.getFileName()
                    , configuration.getNumberQuestions()
                    , configuration.getDifficulty()));
        }
        out.append(line1);
        return out.toString();
    }
    private String createLine(int width) {
        StringBuilder line = new StringBuilder();
        line.append("=".repeat(Math.max(0, width)));
        line.append("\n");
        return line.toString();
    }
}
