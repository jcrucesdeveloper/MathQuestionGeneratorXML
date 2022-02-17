package MathQuestionGeneratorXML.logic.Question;

public class Alternative {
    private final int number;
    private final String alternative;

    public Alternative(int number, String alternative) {
        this.number = number;
        this.alternative = alternative;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return this.alternative;
    }
}
