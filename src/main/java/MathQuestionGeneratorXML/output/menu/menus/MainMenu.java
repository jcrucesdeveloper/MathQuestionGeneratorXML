package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuChanger;

public class MainMenu extends AbstractMenu {

    public MainMenu(MenuChanger menuChanger) {
        super(menuChanger);
    }

    @Override
    public void processInput(String line) {
        switch (line) {
            case "1" -> this.menuChanger.changeMenu(new NewConfigurationMenu(this.menuChanger));
            case "2" -> this.menuChanger.changeMenu(new OldConfigurationMenu(this.menuChanger));
            case "0" -> {
                System.exit(0);
            }
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
