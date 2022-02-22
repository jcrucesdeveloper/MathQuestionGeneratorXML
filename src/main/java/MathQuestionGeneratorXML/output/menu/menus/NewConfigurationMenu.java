package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.Main;
import MathQuestionGeneratorXML.logic.ReaderQuestions;
import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuHandler;

public class NewConfigurationMenu extends AbstractMenu {

    private ReaderQuestions readerQuestions;

    public NewConfigurationMenu(MenuHandler menuHandler) {
        super(menuHandler);
        this.readerQuestions = new ReaderQuestions();
    }

    @Override
    public void processInput(int input) {

        switch (input) {
            case 0 -> this.menuHandler.changeMenu(new MainMenu(menuHandler));
        }


    }

    @Override
    public void displayMenu() {

        int i = 0;
        for (String questionStr: readerQuestions.getQuestionFilePaths()) {
            displayOption(i,questionStr);
            i++;
        }

        displayInBoxFormatted("Select an option");

        displayOption(0,"GoBack");

    }
}
