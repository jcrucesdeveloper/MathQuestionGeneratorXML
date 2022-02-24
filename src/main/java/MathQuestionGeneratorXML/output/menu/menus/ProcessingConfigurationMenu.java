package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.logic.questionConfiguration.SetOfQuestionsConfiguration;
import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuHandler;

public class ProcessingConfigurationMenu extends AbstractMenu {

    private SetOfQuestionsConfiguration setOfQuestionsConfiguration;

    public ProcessingConfigurationMenu(MenuHandler menuHandler) {
        super(menuHandler);
    }

    @Override
    public void processInput(String line) {

    }

    @Override
    public void displayMenu() {
        displayInBoxFormatted("PROCESSING CONFIGURATION");
    }

    public void setSetOfQuestionsConfiguration(SetOfQuestionsConfiguration setOfQuestionsConfiguration) {
        this.setOfQuestionsConfiguration = setOfQuestionsConfiguration;
    }
}
