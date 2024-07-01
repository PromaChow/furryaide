package clients;

import adoptionselectionservice.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static clients.XMLUtils.getParsedOutput;

public class QuestionnaireServiceClient {
    private static final String QUESTIONNAIRE_SERVICE_URL = "http://localhost:3005/wsdlfirst/questionnaireService";

    public static boolean createQuestionnaire(Long petId, List<Question> questions) throws IOException, ParserConfigurationException, SAXException {
        StringBuilder questionsXml = new StringBuilder();
        for (Question question : questions) {
            questionsXml.append("<adp:question>")
                    .append("<adp:id>").append(question.getId()).append("</adp:id>")
                    .append("<adp:text>").append(question.getText()).append("</adp:text>")
                    .append("<adp:type>").append(question.getType()).append("</adp:type>");
            for (String option : question.getOptions()) {
                questionsXml.append("<adp:options>").append(option).append("</adp:options>");
            }
            questionsXml.append("</adp:question>");
        }

        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:adp=\"http://www.furryaide/ws/AdoptionSelectionService\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <adp:createQuestionnaireRequest>" +
                "         <adp:petId>" + petId + "</adp:petId>" +
                "         <adp:questionnaire>" + questionsXml.toString() + "</adp:questionnaire>" +
                "      </adp:createQuestionnaireRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput, QUESTIONNAIRE_SERVICE_URL);
        NodeList statusCodeNodes = document.getElementsByTagName("statusCode");

        return statusCodeNodes.item(0).getTextContent().equals("200");
    }

    public static boolean selectQuestionnaire(Long petId, Long questionnaireId) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:adp=\"http://www.furryaide/ws/AdoptionSelectionService\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <adp:selectQuestionnaireRequest>" +
                "         <adp:petId>" + petId + "</adp:petId>" +
                "         <adp:questionnaireId>" + questionnaireId + "</adp:questionnaireId>" +
                "      </adp:selectQuestionnaireRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput, QUESTIONNAIRE_SERVICE_URL);
        NodeList statusCodeNodes = document.getElementsByTagName("statusCode");

        return statusCodeNodes.item(0).getTextContent().equals("200");
    }
}
