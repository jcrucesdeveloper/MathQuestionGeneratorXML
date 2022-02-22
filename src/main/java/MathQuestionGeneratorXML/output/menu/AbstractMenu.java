package MathQuestionGeneratorXML.output.menu;

import java.awt.*;

public abstract class AbstractMenu implements IMenu {

    protected MenuHandler menuHandler;

    public final int menuWidth = 16;
    public String line1;

    public AbstractMenu(MenuHandler menuHandler) {
        createLine();
        this.menuHandler = menuHandler;
    }

    public void displayOption(int number, String msg) {
        System.out.printf("[%d] %s\n",number,msg);
    }

    public void displayInBoxFormatted(String msg) {
        System.out.println(line1);
        System.out.printf("= %s =\n", msg);
        System.out.println(line1);

    }

    private void createLine() {
        line1 = "";
        for (int i = 0; i < menuWidth; i++) {
            line1+="=";
        }

    }


}
