package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuChanger;

public class OldConfigurationMenu extends AbstractMenu {

    public OldConfigurationMenu(MenuChanger menuChanger) {
        super(menuChanger);
    }

    @Override
    public void processInput(String line) {

        switch (line) {
            case "1" -> this.menuChanger.changeMenu(new ChooseOldConfigurationMenu(menuChanger));
            case "0" -> this.menuChanger.changeMenu(new MainMenu(menuChanger));
        }

    }

    @Override
    public void displayMenu() {

        displayOption(1,"Choose Old Configuration");
        displayOption(0,"Go Back");

    }
}
