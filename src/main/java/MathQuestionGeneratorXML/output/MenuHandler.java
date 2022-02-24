package MathQuestionGeneratorXML.output;

import MathQuestionGeneratorXML.output.menu.IMenu;
import MathQuestionGeneratorXML.output.menu.menus.MainMenu;
import MathQuestionGeneratorXML.output.menu.MenuChanger;

import java.util.Objects;
import java.util.Scanner;

public class MenuHandler {

    public void startMenu() {

        Scanner scanner = new Scanner(System.in);

        MenuChanger menuChanger = new MenuChanger();
        IMenu mainMenu = new MainMenu(menuChanger);

        menuChanger.changeMenu(mainMenu);

        String valueMenu = null;

        do {
            try {
                IMenu currentMenu = menuChanger.getMenu();
                currentMenu.displayMenu();
                valueMenu = scanner.nextLine();
                currentMenu.processInput(valueMenu);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while(!Objects.equals(valueMenu, "-1"));
    }

}
