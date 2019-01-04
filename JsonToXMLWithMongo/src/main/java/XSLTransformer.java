
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Classe de exemplo já disponibilizada: "ExemploJavaXSL", modificada para aceitar um documento XML como string ao
 * invés de um ficheiro.
 */
public class XSLTransformer {
    public static void transform(String path, String xmlDocument, String xslDocument, String outputFileName){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            File stylesheet = new File(path + xslDocument);
            InputSource is = new InputSource(new StringReader(xmlDocument));
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(is);

            TransformerFactory tFactory = TransformerFactory.newInstance();
            StreamSource stylesource = new StreamSource(stylesheet);
            Transformer transformer = tFactory.newTransformer(stylesource);

            DOMSource source = new DOMSource(document);
            //StreamResult result = new StreamResult(System.out); //console output
            StreamResult result = new StreamResult(new File(path+outputFileName));
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
