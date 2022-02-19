package MathQuestionGeneratorXML.input;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.File;

public class XMLParser {

    private final XMLFileHandler xmlFileHandler;
    private final Document documentParser;

    // Nodes
    private Node ParentTagNode;

    public XMLParser(String path) {
        xmlFileHandler = new XMLFileHandler(path);
        documentParser = xmlFileHandler.getXmlDocument();
        documentParser.normalize();
    }

    public File getXMLFile() {
        return xmlFileHandler.getFile();
    }

    public void setParentTag(String nameParent) {


    }

}
