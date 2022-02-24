package MathQuestionGeneratorXML.output.xml;

import MathQuestionGeneratorXML.model.Question.Alternative;
import MathQuestionGeneratorXML.model.Question.Question;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class OutputXML {

    private final String filename;

    public OutputXML(String filename) {
        this.filename = filename;

    }

    public void outputFile(ArrayList<Question> questions) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("questions");
        doc.appendChild(rootElement);

        for (Question question: questions) {

            Element questionElement = doc.createElement("question");

            // Question Label
            Element questionLabel = doc.createElement("questionLabel");
            questionLabel.setTextContent(question.getQuestionLabel());

            questionElement.appendChild(questionLabel);


            for (Alternative alternative: question.getAlternatives()) {

                String alternativeStr = "alternative" + alternative.getNumber();
                Element tempAlternative = doc.createElement(alternativeStr);
                tempAlternative.setTextContent(alternative.getValue());
                questionElement.appendChild(tempAlternative);
            }
            Element correctAlternative = doc.createElement("correctAlternative");
            correctAlternative.setTextContent(question.getCorrectAlternative().getValue());

            questionElement.appendChild(correctAlternative);

            rootElement.appendChild(questionElement);
        }
        try (FileOutputStream output =
                     new FileOutputStream("/home/jaco/IdeaProjects/MathGeneratorXMLQuestions/src/main/build/" + this.filename + ".xml")) {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // write doc to output stream
    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}
