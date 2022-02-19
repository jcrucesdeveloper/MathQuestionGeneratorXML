package MathQuestionGeneratorXML.input;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class XMLFileHandler{

    private Document xmlDocument;
    private File file;

    public XMLFileHandler(String path) {
        file = new File(path);
        xmlDocument = convertFileToDocument(this.file);
    }

    private Document convertFileToDocument(File mfile) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
             return dBuilder.parse(mfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public File getFile() {
        return this.file;
    }
    public Document getXmlDocument() {
        return this.xmlDocument;
    }

}
