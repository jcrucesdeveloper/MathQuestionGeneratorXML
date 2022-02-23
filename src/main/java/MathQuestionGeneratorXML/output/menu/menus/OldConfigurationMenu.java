package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuHandler;

public class OldConfigurationMenu extends AbstractMenu {

    public OldConfigurationMenu(MenuHandler menuHandler) {
        super(menuHandler);
    }

    @Override
    public void processInput(String line) {

        switch (line) {
            case "1" -> this.menuHandler.changeMenu(new ChooseOldConfigurationMenu(menuHandler));
            case "0" -> this.menuHandler.changeMenu(new MainMenu(menuHandler));
        }

    }

    @Override
    public void displayMenu() {

        displayOption(1,"Choose Old Configuration");
        displayOption(0,"Go Back");

    }
}
