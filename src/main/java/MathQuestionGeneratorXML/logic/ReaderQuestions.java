package MathQuestionGeneratorXML.logic;


import MathQuestionGeneratorXML.input.xml.TagGroup;
import MathQuestionGeneratorXML.input.xml.XMLParser;
import MathQuestionGeneratorXML.logic.questionConfiguration.QuestionConfiguration;
import MathQuestionGeneratorXML.model.Question.Question;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ReaderQuestions {

    public final String FILEPATH = "./src/main/resources/";

    private ArrayList<String> filePaths;

    public ReaderQuestions() {
        this.filePaths = getQuestionFilePaths();
    }

    public ArrayList<Question> readFileQuestions(String name) {

        XMLParser xmlParser = new XMLParser(FILEPATH + name);
        xmlParser.setParentTag("question");

        ArrayList<Question> questions = new ArrayList<>();

        for(int i = 0; i < xmlParser.getSizeQuestions(); i++) {
            Question question = parseTagGroupToQuestion(xmlParser.getTagGroupByNumber(i));
            questions.add(question);
        }
        return questions;
    }

    public ArrayList<Question> getQuestionsUsingConfiguration(QuestionConfiguration configuration) {

        // Configuration
        String filename = configuration.getFileName();
        int difficulty = configuration.getDifficulty();
        int quantity = configuration.getNumberQuestions();

        ArrayList<Question> questions = readFileQuestions(filename);
        questions.removeIf(question -> (question.getDifficulty() != difficulty));
        return selectRandomQuestionFromList(questions, quantity);
    }

    public ArrayList<Question> selectRandomQuestionFromList(ArrayList<Question> questions, int n) {

        ArrayList<Question> questionsOut = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int randomIndex = rand.nextInt(questions.size());
            Question randomQuestion = questions.get(randomIndex);
            questionsOut.add(randomQuestion);
            questions.remove(randomIndex);
        }
        return questionsOut;
    }


    public Question parseTagGroupToQuestion(TagGroup tagGroup) {

        int difficulty;
        if (tagGroup.getAttribute("difficulty").equals("")) {
            difficulty = 1;
        } else {
            difficulty = Integer.parseInt(tagGroup.getAttribute("difficulty"));
        }

        String stringAlternative1 = tagGroup.getChildTagByName("alternative1").getValue();
        String stringAlternative2 = tagGroup.getChildTagByName("alternative2").getValue();
        String stringAlternative3 = tagGroup.getChildTagByName("alternative3").getValue();
        String stringCorrectAlternative = tagGroup.getChildTagByName("correctAlternative").getValue();

        Question question = new Question();
        question.setDifficulty(difficulty);
        question.addAlternative(1,stringAlternative1);
        question.addAlternative(2,stringAlternative2);
        question.addAlternative(3,stringAlternative3);
        question.setCorrectAlternative(stringCorrectAlternative);
        return question;
    }

    public ArrayList<String> getQuestionFilePaths() {
        File file = new File(FILEPATH);
        return new ArrayList<String>(List.of(file.list()));
    }
}


