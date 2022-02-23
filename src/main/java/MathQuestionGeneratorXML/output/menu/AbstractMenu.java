package MathQuestionGeneratorXML.output.menu;

import java.awt.*;

public abstract class AbstractMenu implements IMenu {

    protected MenuHandler menuHandler;

    public final int menuWidth = 40;
    public String line1;

    public AbstractMenu(MenuHandler menuHandler) {
        createLine(menuWidth);
        this.menuHandler = menuHandler;
    }

    public void displayOption(int number, String msg) {
        System.out.printf("[%d] %s\n",number,msg);
    }

    public void displayInBoxFormatted(String msg) {
        int width = msg.length() + 4;
        createLine(width);
        System.out.println("");
        System.out.println(line1);
        System.out.printf("= %s =\n", msg);
        System.out.println(line1);

    }

    private void createLine(int width) {
        line1 = "";
        for (int i = 0; i < width; i++) {
            line1+="=";
        }

    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
