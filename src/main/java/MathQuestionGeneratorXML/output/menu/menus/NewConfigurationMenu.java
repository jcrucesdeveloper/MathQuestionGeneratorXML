package MathQuestionGeneratorXML.output.menu.menus;

import MathQuestionGeneratorXML.Main;
import MathQuestionGeneratorXML.logic.ReaderQuestions;
import MathQuestionGeneratorXML.output.configuration.QuestionConfiguration;
import MathQuestionGeneratorXML.output.menu.AbstractMenu;
import MathQuestionGeneratorXML.output.menu.MenuHandler;

public class NewConfigurationMenu extends AbstractMenu {

    private ReaderQuestions readerQuestions;
    private QuestionConfiguration questionConfiguration;

    private PhasesNewConfiguration phase;

    public NewConfigurationMenu(MenuHandler menuHandler) {
        super(menuHandler);
        this.readerQuestions = new ReaderQuestions();
        this.phase = PhasesNewConfiguration.NAME;
    }

    @Override
    public void processInput(String input) {

        switch (phase) {
            case NAME -> processInputNameConfiguration(input);
            case NUMBER -> processInputNumberQuestion(input);
            case DIFFICULTY -> processInputDifficulty(input);
            case STAND_BY -> processInputStandBy(input);

        }
    }

    public void processInputNameConfiguration(String input) {

    }

    public void processInputFileXMLQuestion(String input) {

    }

    public void processInputNumberQuestion(String input) {

    }

    public void processInputDifficulty(String input) {

    }

    public void processInputStandBy(String input) {

    }

    @Override
    public void displayMenu() {
        switch (phase) {
            case NAME -> displayInputNameConfiguration();
            case NUMBER -> displayInputNumberQuestion();
            case DIFFICULTY -> displayInputDifficulty();
            case STAND_BY -> displayInputStandBy();
        }
    }

    public void displayInputNameConfiguration() {

    }

    public void displayInputNumberQuestion() {

    }

    public void displayInputDifficulty() {

    }

    public void displayInputStandBy() {

    }
}
