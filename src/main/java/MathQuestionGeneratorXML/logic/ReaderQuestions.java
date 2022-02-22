package MathQuestionGeneratorXML.logic;


import MathQuestionGeneratorXML.input.xml.TagGroup;
import MathQuestionGeneratorXML.input.xml.XMLParser;
import MathQuestionGeneratorXML.model.Question.Alternative;
import MathQuestionGeneratorXML.model.Question.Question;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ReaderQuestions {

    public final String FILEPATH = "./src/main/resources/";

    private ArrayList<String> filePaths;

    public ReaderQuestions() {
        this.filePaths = getQuestionFilePaths();
    }

    public ArrayList<Question> readFileQuestions(String name) {

        XMLParser xmlParser = new XMLParser(FILEPATH + name);
        ArrayList<Question> questions = new ArrayList<>();

        for(int i = 0; i < xmlParser.getSizeQuestions(); i++) {
            Question question = parseTagGroupToQuestion(xmlParser.getTagGroupByNumber(i));
            questions.add(question);
        }

        return questions;
    }

    public Question parseTagGroupToQuestion(TagGroup tagGroup) {

        String stringAlternative1 = tagGroup.getChildTagByName("alternative1").getValue();
        String stringAlternative2 = tagGroup.getChildTagByName("alternative2").getValue();
        String stringAlternative3 = tagGroup.getChildTagByName("alternative3").getValue();
        String stringCorrectAlternative = tagGroup.getChildTagByName("correctAlternative").getValue();

        Question question = new Question();
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


