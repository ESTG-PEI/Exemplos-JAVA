
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import core.exceptions.XpathNoResultsException;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Node;


public class XpathEvaluator {

    public static String applyXpathExpressionToString(String xpathExpression, Document document) throws XpathNoResultsException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            return (String) xPath.compile(xpathExpression).evaluate(document, XPathConstants.STRING);

        } catch (XPathExpressionException ex) {
            Logger.getLogger(GestorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new XpathNoResultsException();
    }

    public static Double applyXpathExpressionToNumber(String xpathExpression, Document document) throws XpathNoResultsException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            return (Double) xPath.compile(xpathExpression).evaluate(document, XPathConstants.NUMBER);

        } catch (XPathExpressionException ex) {
            Logger.getLogger(GestorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new XpathNoResultsException();
    }

    public static Boolean applyXpathExpressionToBoolean(String xpathExpression, Document document) throws XpathNoResultsException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            return (Boolean) xPath.compile(xpathExpression).evaluate(document, XPathConstants.BOOLEAN);

        } catch (XPathExpressionException ex) {
            Logger.getLogger(GestorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new XpathNoResultsException();
    }

    public static Node applyXpathExpressionToNode(String xpathExpression, Document document) throws XpathNoResultsException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            return (Node) xPath.compile(xpathExpression).evaluate(document, XPathConstants.NODE);

        } catch (XPathExpressionException ex) {
            Logger.getLogger(GestorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new XpathNoResultsException();
    }

    public static Node applyXpathExpressionToNodeSet(String xpathExpression, Document document) throws XpathNoResultsException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            return (Node) xPath.compile(xpathExpression).evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(GestorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new XpathNoResultsException();
    }
}
