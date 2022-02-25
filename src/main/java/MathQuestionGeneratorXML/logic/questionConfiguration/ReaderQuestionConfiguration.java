package MathQuestionGeneratorXML.logic.questionConfiguration;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderQuestionConfiguration {


    private final String FILEPATH = "/home/jaco/IdeaProjects/MathGeneratorXMLQuestions/src/main/resources/configurations/";

    public SetOfQuestionsConfiguration readConfiguration(String file) throws FileNotFoundException {

        SetOfQuestionsConfiguration setOfQuestionsConfiguration = new SetOfQuestionsConfiguration();

        JsonElement jsonElement = JsonParser.parseReader(new FileReader("/home/jaco/IdeaProjects/MathGeneratorXMLQuestions/src/main/resources/configurations/" + file));
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String configurationName = String.valueOf(jsonObject.get("configurationName"));
        setOfQuestionsConfiguration.setConfigurationName(configurationName);

        JsonArray jsonArray = jsonObject.getAsJsonArray("configurations");

        jsonArray.forEach(jsonElementTemp -> {

            QuestionConfiguration questionConfigurationTemp = new QuestionConfiguration();

            String difficulty = String.valueOf(jsonElementTemp.getAsJsonObject().get("difficulty"));
            String fileName = String.valueOf(jsonElementTemp.getAsJsonObject().get("fileName"));
            String numberQuestions = String.valueOf(jsonElementTemp.getAsJsonObject().get("numberQuestions"));

            questionConfigurationTemp.setDifficulty(difficulty);
            questionConfigurationTemp.setFileName(fileName);
            questionConfigurationTemp.setNumberQuestions(numberQuestions);

            setOfQuestionsConfiguration.addQuestionConfiguration(questionConfigurationTemp);
        });

        return setOfQuestionsConfiguration;
    }

    public ArrayList<String> getConfigsFilePath() {
        File file = new File(FILEPATH);
        return new ArrayList<String>(List.of(file.list()));
    }
}
