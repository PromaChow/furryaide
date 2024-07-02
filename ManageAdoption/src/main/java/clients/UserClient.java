package clients;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static clients.XMLUtils.getParsedOutput;


public class UserClient {
    private static final String JWT_AUTH_SERVICE_URL = "http://localhost:3000/wsdlfirst/authenticationService";

    public static String generateToken(String username, String password) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:aut=\"http://www.furryaide.com/authentication\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <aut:generateTokenRequest>" +
                "         <aut:username>" + username + "</aut:username>" +
                "         <aut:password>" + password + "</aut:password>"+
                "      </aut:generateTokenRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput, JWT_AUTH_SERVICE_URL);

        return document.getElementsByTagName("ns2:token").item(0).getTextContent();
    }

    public static boolean validateToken(String token) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:aut=\"http://www.furryaide.com/authentication\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <aut:validateTokenRequest>" +
                "         <aut:token>" + token + "</aut:token>" +
                "      </aut:validateTokenRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput, JWT_AUTH_SERVICE_URL);
//        System.out.println("hello"+Boolean.parseBoolean(document.getElementsByTagName("ns2:isValid").item(0).getTextContent()));
        return Boolean.parseBoolean(document.getElementsByTagName("ns2:isValid").item(0).getTextContent());
    }
}
