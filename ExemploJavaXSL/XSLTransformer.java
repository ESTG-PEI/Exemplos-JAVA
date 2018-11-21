
import demos.DemoXSLT;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XSLTransformer {
    public static void transform(String path, String xmlDocument, String xslDocument, String outputFileName){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            File stylesheet = new File(path + xslDocument);
            File datafile = new File(path + xmlDocument);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(datafile);

            TransformerFactory tFactory = TransformerFactory.newInstance();
            StreamSource stylesource = new StreamSource(stylesheet);
            Transformer transformer = tFactory.newTransformer(stylesource);

            DOMSource source = new DOMSource(document);
            //StreamResult result = new StreamResult(System.out); //console output
            StreamResult result = new StreamResult(new File(path+outputFileName));
            transformer.transform(source, result);    
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            Logger.getLogger(DemoXSLT.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
