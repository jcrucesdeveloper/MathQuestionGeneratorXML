package MathQuestionGeneratorXML.model.Question;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Question {

    private int questionNumber;

    public String questionLabel;
    public String questionTitle;

    private int difficulty = 1;

    private ArrayList<Alternative> alternatives;
    private Alternative correctAlternative;

    public Question() {
        alternatives = new ArrayList<Alternative>();
    }


    public void setQuestionLabel(String questionLabel) {
        this.questionLabel = questionLabel;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public void addAlternative(int number, String value) {
        alternatives.add(new Alternative(number, value));
    }

    public void setCorrectAlternative(String value) {
        correctAlternative = new Alternative(-1, value);
    }

    public Alternative getAlternativeByNumber(int number) {
        return alternatives.get(number);
    }

    public Alternative getCorrectAlternative() {
        return this.correctAlternative;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
