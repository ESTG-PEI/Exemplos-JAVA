package soapValidation;

import core.GestorXML;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "XMLValidation")
public class XMLValidation {

    private final static String SUCCESS_MESSAGE = "Documento válido";
    private final static String UNSUCCESS_MESSAGE = "Documento inválido";

    @WebMethod(operationName = "validateXML")
    public String validateXML(@WebParam(name = "xmlFile") String xml, @WebParam(name = "xsdFile") String xsd) {
        GestorXML gestor = new GestorXML(xml, xsd); // Cria gestor com xml e xsd associado
        if (gestor.validateFromString(true)) { // Valida xml de acordo com o xsd, sem xsd retorna true, ex:  GestorXML(xml, null);           
            return XMLValidation.SUCCESS_MESSAGE;
        } else {
            return XMLValidation.UNSUCCESS_MESSAGE;
        }
    }
}
