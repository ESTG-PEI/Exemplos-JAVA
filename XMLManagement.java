import core.GestorXML;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto <br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PEI - Processamento Estruturado de Informação<br>
 * 2017 / 2018 <br>
 * </h3>
 * <p>
 * <strong>Descrição:</strong>
 * Classe de exemplo que permite validar a sintaxe de um documento XML
 * <br>
 * </p>
 *
 */

public class XMLManagement {
    private final String xmlFile;
    private Document document;

    /**
     *
     * @param xmlFile Documento XML a processar
     */
    public XMLManagement(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    /**
     * Método responsável por ler (parse) um documento XML
     *
     * @param logOnError permite ativar/desativas as mensagens de erro que
     * possam surgir através da linha de comandos
     * @return valor booleano sinalizando sucesso/insucesso da operação
     */
    public boolean read(boolean logOnError) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
            db.setErrorHandler(new MyErrorHandler());
            dbf.setIgnoringComments(true);
            dbf.setIgnoringElementContentWhitespace(true);
            document = db.parse(this.xmlFile);
            document.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            if (logOnError) {
                Logger.getLogger(GestorXML.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
            return false;
        }
        return true;
    }
}
