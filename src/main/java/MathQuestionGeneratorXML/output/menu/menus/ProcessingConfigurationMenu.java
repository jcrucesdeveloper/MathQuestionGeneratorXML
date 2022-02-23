package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.output.configuration.SetOfQuestionsConfiguration;
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

    }

    public void setSetOfQuestionsConfiguration(SetOfQuestionsConfiguration setOfQuestionsConfiguration) {
        this.setOfQuestionsConfiguration = setOfQuestionsConfiguration;
    }
}
