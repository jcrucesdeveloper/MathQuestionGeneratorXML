package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.logic.questionConfiguration.ReaderQuestionConfiguration;
import MathQuestionGeneratorXML.logic.questionConfiguration.SetOfQuestionsConfiguration;
import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuChanger;

import java.io.FileNotFoundException;

public class OldConfigurationMenu extends AbstractMenu {

    private final ReaderQuestionConfiguration readerQuestionConfiguration;

    public OldConfigurationMenu(MenuChanger menuChanger) {
        super(menuChanger);
        readerQuestionConfiguration = new ReaderQuestionConfiguration();
    }

    @Override
    public void processInput(String line) {

        if (line.equals("0")) {
            this.menuChanger.changeMenu(new MainMenu(this.menuChanger));
        }

        int posFileName = Integer.parseInt(line) - 1;
        String fileName = readerQuestionConfiguration.getConfigsFilePath().get(posFileName);
        SetOfQuestionsConfiguration setOfQuestionsConfiguration = new SetOfQuestionsConfiguration();

        try {
            setOfQuestionsConfiguration = readerQuestionConfiguration.readConfiguration(fileName);
            System.out.println(setOfQuestionsConfiguration);


        } catch (Exception e) {
            e.printStackTrace();
        }

        ProcessingConfigurationMenu processingConfigurationMenu = new ProcessingConfigurationMenu(menuChanger);
        processingConfigurationMenu.setSetOfQuestionsConfiguration(setOfQuestionsConfiguration);

        this.menuChanger.changeMenu(processingConfigurationMenu);
    }

    @Override
    public void displayMenu() {


        displayInBoxFormatted("Select a configuration");
        int counter = 1;
        for(String questionStr: readerQuestionConfiguration.getConfigsFilePath()) {
            displayOption(counter,questionStr);
            counter++;
        }
        displayOption(0,"Go Back");
    }
}
