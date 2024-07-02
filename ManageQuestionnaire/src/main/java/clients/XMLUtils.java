package clients;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class XMLUtils {

    public static Document getParsedOutput(String xmlInput, String link) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL(link);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        byte[] buffer = xmlInput.getBytes();
        httpConn.setRequestProperty("Content-Length", String.valueOf(buffer.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", "");
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        OutputStream request = httpConn.getOutputStream();
        request.write(buffer);
        request.close();

        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
        BufferedReader in = new BufferedReader(isr);

        String responseString;
        StringBuilder outputString = new StringBuilder();
        while ((responseString = in.readLine()) != null) {
            outputString.append(responseString);
        }
        in.close();
//        System.out.println(outputString.toString());
//        String formattedSOAPResponse = formatXML(outputString.toString());
//        System.out.println("Response: " + formattedSOAPResponse);

        return parseXmlFile(outputString.toString());
    }

    private static String formatXML(String unformattedXml) {
        try {
            Document document = parseXmlFile(unformattedXml);
            NodeList nodeList = document.getElementsByTagName("ns2:isValid");
            return nodeList.item(0).getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Document parseXmlFile(String in) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(in));
        return db.parse(is);
    }


}
