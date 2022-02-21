package MathQuestionGeneratorXML.input.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLFileHandler {

    private Document xmlDocument;
    private final File file;

    public XMLFileHandler(File file) {
        this.file = file;
    }

    public void prepareParse() {
        convertFileToDocument(this.file);
    }

    private void convertFileToDocument(File file) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            xmlDocument = dBuilder.parse(file);

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return this.file;
    }

    public Document getXmlDocument() {
        return this.xmlDocument;
    }

}
