package MathQuestionGeneratorXML.logic;

import java.util.Scanner;

public class OutputHandler {

    public final String line1 = "==========================================================";


    public void start() {
        Scanner scanner = new Scanner(System.in);
        int valueMenu;
        do {
            displayMenu();
            valueMenu = scanner.nextInt();
            System.out.println("lol");
        } while(valueMenu != -1 );
    }

    public void displayMenu() {
        System.out.println(line1);
        System.out.println("Welcome to MathGeneratorxml");
    }
}
