package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuHandler;

public class OldConfigurationMenu extends AbstractMenu {

    public OldConfigurationMenu(MenuHandler menuHandler) {
        super(menuHandler);
    }

    @Override
    public void processInput(int input) {

        switch (input) {
            case 0 -> this.menuHandler.changeMenu(new MainMenu(menuHandler));
        }

    }

    @Override
    public void displayMenu() {
        displayOption(2,"Old cofiguration");
        displayOption(0,"Go Back");

    }
}
