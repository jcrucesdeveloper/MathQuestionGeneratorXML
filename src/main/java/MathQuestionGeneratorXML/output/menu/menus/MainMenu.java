package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuHandler;

public class MainMenu extends AbstractMenu {

    public MainMenu(MenuHandler menuHandler) {
        super(menuHandler);
    }

    @Override
    public void processInput(String line) {
        switch (line) {
            case "1" -> this.menuHandler.changeMenu(new NewConfigurationMenu(this.menuHandler));
            case "2" -> this.menuHandler.changeMenu(new OldConfigurationMenu(this.menuHandler));
        }
    }


    @Override
    public void displayMenu() {
        displayInBoxFormatted("Welcome to MathGeneratorXMLQuestions");
        displayOption(1,"Create a new set of questions with new configuration");
        displayOption(2,"Create a new set of questions using an existing configuration");
        displayOption(0,"Exit");
        System.out.print("Select one of the options above: ");
    }


}
