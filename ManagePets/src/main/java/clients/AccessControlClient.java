package clients;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static clients.XMLUtils.getParsedOutput;

public class AccessControlClient {
    private static final String ACCESS_CONTROL_URL = "http://localhost:3002/wsdlfirst/accessControlService";

    public static boolean checkPermission(String token, String permission) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:acc=\"http://www.furryaide.com/accesscontrol\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <acc:checkPermissionRequest>" +
                "         <acc:token>" + token + "</acc:token>" +
                "         <acc:permission>" + permission + "</acc:permission>" +
                "      </acc:checkPermissionRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput, ACCESS_CONTROL_URL);
        System.out.println(Boolean.parseBoolean(document.getElementsByTagName("ns2:hasPermission").item(0).getTextContent()));
        return Boolean.parseBoolean(document.getElementsByTagName("ns2:hasPermission").item(0).getTextContent());
    }
}
