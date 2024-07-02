package clients;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static clients.XMLUtils.getParsedOutput;

public class NotificationClient {
    private static final String NOTIFICATION_SERVICE_URL = "http://localhost:5005/wsdlfirst/NotificationService";

    public static boolean sendNotification(String token, String type, String message, String pattern, String duration, String channelType, String address) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:not=\"http://www.furryaide/ws/NotificationService\" xmlns:not1=\"http://www.furryaide/ws/Notification\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <not:sendNotificationRequest>" +
                "         <not:notification>" +
                "            <not1:type>" + type + "</not1:type>" +
                "            <not1:message>" + message + "</not1:message>" +
                "            <not1:vibrationType>" +
                "               <not:pattern>" + pattern + "</not:pattern>" +
                (duration != null ? "               <not:duration>" + duration + "</not:duration>" : "") +
                "            </not1:vibrationType>" +
                "            <not1:channel>" +
                "               <not:type>" + channelType + "</not:type>" +
                (address != null ? "               <not:address>" + address + "</not:address>" : "") +
                "            </not1:channel>" +
                "         </not:notification>" +
                "      </not:sendNotificationRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput, NOTIFICATION_SERVICE_URL);
        return Boolean.parseBoolean(document.getElementsByTagName("ns2:code").item(0).getTextContent());
    }
}
