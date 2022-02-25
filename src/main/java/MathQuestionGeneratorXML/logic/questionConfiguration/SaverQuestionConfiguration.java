package MathQuestionGeneratorXML.logic.questionConfiguration;


import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class SaverQuestionConfiguration {


    public static void saveConfiguration(SetOfQuestionsConfiguration setOfQuestionsConfiguration) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("configurations",setOfQuestionsConfiguration.getConfiguration());
        jsonObject.put("configurationName", setOfQuestionsConfiguration.getConfigurationName());

        try {
            FileWriter myWriter = new FileWriter("/home/jaco/IdeaProjects/MathGeneratorXMLQuestions/src/main/resources/configurations/config1.json");
            myWriter.write(jsonObject.toString(4));
            myWriter.close();
            System.out.println("Sucessfully saved configuration: " + setOfQuestionsConfiguration.getConfigurationName() );
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
