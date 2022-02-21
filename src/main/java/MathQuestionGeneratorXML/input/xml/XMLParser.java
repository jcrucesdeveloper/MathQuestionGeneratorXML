package MathQuestionGeneratorXML.input.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;

public class XMLParser {

    private final File xmlFile;
    private final XMLFileHandler xmlFileHandler;
    private final Document documentParser;

    // Nodes
    private NodeList parentTagNodes;

    public XMLParser(String path) {
        xmlFile = new File(path);

        xmlFileHandler = new XMLFileHandler(xmlFile);
        xmlFileHandler.prepareParse();

        documentParser = xmlFileHandler.getXmlDocument();
        documentParser.normalize();
    }


    public File getXMLFile() {
        return this.xmlFile;
    }

    public void setParentTag(String nameParent) {
        parentTagNodes = documentParser.getElementsByTagName(nameParent);
    }

    public String getParentTagName() {
        return parentTagNodes.item(0).getNodeName();
    }

    public int getSizeQuestions() {
        return parentTagNodes.getLength();
    }

    public TagGroup getTagGroupByNumber(int number) {
        return new TagGroup(parentTagNodes.item(number));
    }


}
