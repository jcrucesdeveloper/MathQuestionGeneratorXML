package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.logic.ReaderQuestions;
import MathQuestionGeneratorXML.logic.questionConfiguration.QuestionConfiguration;
import MathQuestionGeneratorXML.logic.questionConfiguration.SaverQuestionConfiguration;
import MathQuestionGeneratorXML.logic.questionConfiguration.SetOfQuestionsConfiguration;
import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuChanger;

import java.util.Objects;

public class NewConfigurationMenu extends AbstractMenu {

    private final ReaderQuestions readerQuestions;
    private SetOfQuestionsConfiguration setOfQuestionsConfiguration;
    private QuestionConfiguration tempQuestionConfiguration;

    private PhasesNewConfiguration phase;

    public NewConfigurationMenu(MenuChanger menuChanger) {
        super(menuChanger);
        this.readerQuestions = new ReaderQuestions();
        this.setOfQuestionsConfiguration = new SetOfQuestionsConfiguration();
        this.phase = PhasesNewConfiguration.NAME;
    }

    @Override
    public void processInput(String input) {
        switch (phase) {
            case NAME:
                processInputNameConfiguration(input);
                break;
            case FILE:
                processInputFileXMLQuestion(input);
                break;
            case NUMBER:
                processInputNumberQuestion(input);
                break;
            case DIFFICULTY:
                processInputDifficulty(input);
                break;
            case STAND_BY:
                processInputStandBy(input);
                break;
        }

    }

    public void processInputNameConfiguration(String input) {
        setOfQuestionsConfiguration.setConfigurationName(input);
        this.phase = PhasesNewConfiguration.FILE;
    }

    public void processInputFileXMLQuestion(String input) {
        tempQuestionConfiguration = new QuestionConfiguration();
        int posFileName = Integer.parseInt(input) - 1;
        String fileName = readerQuestions.getQuestionFilePaths().get(posFileName);
        tempQuestionConfiguration.setFileName(fileName);
        this.phase = PhasesNewConfiguration.NUMBER;
    }

    public void processInputNumberQuestion(String input) {
        tempQuestionConfiguration.setNumberQuestions(input);
        this.phase = PhasesNewConfiguration.DIFFICULTY;
    }

    public void processInputDifficulty(String input) {
        tempQuestionConfiguration.setDifficulty(input);
        setOfQuestionsConfiguration.addQuestionConfiguration(tempQuestionConfiguration);
        System.out.println(setOfQuestionsConfiguration);
        tempQuestionConfiguration = null;
        this.phase = PhasesNewConfiguration.STAND_BY;


    }

    public void processInputStandBy(String input) {

        if (Objects.equals(input, "1")) {
            this.phase = PhasesNewConfiguration.FILE;
        } else {
            System.out.println("Final Configuration Saved: ");
            System.out.println(setOfQuestionsConfiguration);

            // Save configuration
            SaverQuestionConfiguration saverQuestionConfiguration = new SaverQuestionConfiguration();
            saverQuestionConfiguration.saveConfiguration(setOfQuestionsConfiguration);


            ProcessingConfigurationMenu processingConfigurationMenu = new ProcessingConfigurationMenu(menuChanger);
            processingConfigurationMenu.setSetOfQuestionsConfiguration(setOfQuestionsConfiguration);

            this.menuChanger.changeMenu(processingConfigurationMenu);
        }

    }

    @Override
    public void displayMenu() {
        switch (phase) {
            case NAME -> displayNameConfiguration();
            case FILE -> displayFileConfiguration();
            case NUMBER -> displayNumberQuestion();
            case DIFFICULTY -> displayDifficulty();
            case STAND_BY -> displayStandBy();
        }
    }

    public void displayNameConfiguration() {
        displayInBoxFormatted("Write a name for the new Configuration");
        System.out.print("Name new Configuration:  ");
    }

    public void displayFileConfiguration() {
        displayInBoxFormatted("Select a file to add Questions: ");

        int counter = 1;
        for(String questionStr: readerQuestions.getQuestionFilePaths()) {
            displayOption(counter,questionStr);
            counter++;
        }
    }

    public void displayNumberQuestion() {
        displayInBoxFormatted("Write the number of questions from this file");
    }

    public void displayDifficulty() {
        displayInBoxFormatted("Select difficulty from this file");
        for (int i = 1 ; i <= 5; i++) {
            displayOption(i, "Difficulty %d".formatted(i));
        }
    }

    public void displayStandBy() {
        displayInBoxFormatted("Want to add more questions?");
        displayOption(1,"Yes");
        displayOption(2,"No, the Configuration is Ready.");
    }
}
