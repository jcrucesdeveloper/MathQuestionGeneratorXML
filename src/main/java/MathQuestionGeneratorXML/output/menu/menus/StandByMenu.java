package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.Main;
import MathQuestionGeneratorXML.logic.questionConfiguration.SetOfQuestionsConfiguration;
import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuChanger;

import java.util.Objects;


public class StandByMenu extends AbstractMenu  {

    private SetOfQuestionsConfiguration setOfQuestionsConfiguration;
    
    public StandByMenu(MenuChanger menuChanger) {
        super(menuChanger);
    }

    @Override
    public void processInput(String line) {
        switch (line) {
            case "1":
                ProcessingConfigurationMenu processingConfigurationMenu =
                        new ProcessingConfigurationMenu(menuChanger);
                processingConfigurationMenu.setSetOfQuestionsConfiguration(setOfQuestionsConfiguration);
                this.menuChanger.changeMenu(processingConfigurationMenu);
                break;
            case "2":
                this.menuChanger.changeMenu(new MainMenu(menuChanger));
                break;
        }
    }

    @Override
    public void displayMenu() {
        displayInBoxFormatted("Select an option");
        displayOption(1,"Generate another set of Questions using this configuration");
        displayOption(2,"Go back to Main Menu");
    }

    public void setConfigurations(SetOfQuestionsConfiguration configurations) {
        this.setOfQuestionsConfiguration = configurations;
    }
}
