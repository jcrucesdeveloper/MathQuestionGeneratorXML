package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.logic.ProcessorQuestionConfigurations;
import MathQuestionGeneratorXML.logic.questionConfiguration.SetOfQuestionsConfiguration;
import MathQuestionGeneratorXML.model.Question.Question;
import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuChanger;
import MathQuestionGeneratorXML.output.xml.OutputXML;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;

public class ProcessingConfigurationMenu extends AbstractMenu {

    private SetOfQuestionsConfiguration setOfQuestionsConfiguration;
    private ArrayList<Question> questionsToOutput;

    public ProcessingConfigurationMenu(MenuChanger menuChanger) {
        super(menuChanger);
    }


    @Override
    public void processInput(String line) {

        OutputXML xmlOutput = new OutputXML(line);
        try {
            xmlOutput.outputFile(this.questionsToOutput);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        displayInBoxFormatted("File output in build/" + line + ".xml");

        StandByMenu standByMenu = new StandByMenu(this.menuChanger);
        standByMenu.setConfigurations(this.setOfQuestionsConfiguration);
        this.menuChanger.changeMenu(standByMenu);
    }

    @Override
    public void displayMenu() {
        displayInBoxFormatted("PROCESSING CONFIGURATION");
        questionsToOutput = this.processConfiguration();
        displayInBoxFormatted("EVERYTHING DONE!");
        System.out.println("Write name for the output configuration: ");
    }

    private ArrayList<Question> processConfiguration() {

        ProcessorQuestionConfigurations processorQuestionConfigurations = new ProcessorQuestionConfigurations();
        ArrayList<Question> questions =
                processorQuestionConfigurations.processConfigurations(this.setOfQuestionsConfiguration);

        return questions;
    }

    public void setSetOfQuestionsConfiguration(SetOfQuestionsConfiguration setOfQuestionsConfiguration) {
        this.setOfQuestionsConfiguration = setOfQuestionsConfiguration;
    }
}
