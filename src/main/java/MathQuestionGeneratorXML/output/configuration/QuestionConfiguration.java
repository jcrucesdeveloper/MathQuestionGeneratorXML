package MathQuestionGeneratorXML.output.configuration;

public class QuestionConfiguration {

    private String fileName;
    private int numberQuestions;
    private int difficulty;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public void setNumberQuestions(String numberQuestions) {
        this.numberQuestions = Integer.parseInt(numberQuestions);
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = Integer.parseInt(difficulty);
    }

}
