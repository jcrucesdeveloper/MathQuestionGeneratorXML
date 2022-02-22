package MathQuestionGeneratorXML.output;

import MathQuestionGeneratorXML.output.menu.IMenu;
import MathQuestionGeneratorXML.output.menu.menus.MainMenu;
import MathQuestionGeneratorXML.output.menu.MenuHandler;

import java.util.Scanner;

public class OutputHandler {

    public void start() {

        Scanner scanner = new Scanner(System.in);

        MenuHandler menuHandler = new MenuHandler();
        IMenu mainMenu = new MainMenu(menuHandler);

        menuHandler.changeMenu(mainMenu);

        int valueMenu;

        do {
            IMenu currentMenu = menuHandler.getMenu();

            currentMenu.displayMenu();
            valueMenu = scanner.nextInt();
            currentMenu.processInput(valueMenu);
        } while(valueMenu != -1 );
    }

}
