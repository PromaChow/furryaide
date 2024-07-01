package clients;

import adoptionrequestservice.Question;
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
    private static final String QUESTIONNAIRE_SERVICE_URL = "http://localhost:6000/wsdlfirst/questionnaireService";

    public static List<Question> getQuestionnaire(Long petId) throws IOException, ParserConfigurationException, SAXException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ques=\"http://www.furryaide/ws/QuestionnaireService\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <ques:getQuestionnaireRequest>" +
                "         <ques:id>" + petId + "</ques:id>" +
                "      </ques:getQuestionnaireRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput, QUESTIONNAIRE_SERVICE_URL);
        NodeList questionsNodes = document.getElementsByTagName("question");

        List<Question> questions = new ArrayList<Question>();
        for (int i = 0; i < questionsNodes.getLength(); i++) {
            NodeList childNodes = questionsNodes.item(i).getChildNodes();
            Question question = new Question();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node child = childNodes.item(j);
                String nodeName = child.getNodeName();
                String nodeValue = child.getTextContent();
                if ("id".equals(nodeName)) {
                    question.setId(Long.parseLong(nodeValue));
                } else if ("text".equals(nodeName)) {
                    question.setText(nodeValue);
                } else if ("type".equals(nodeName)) {
                    question.setType(nodeValue);
                } else if ("options".equals(nodeName)) {
                    question.getOptions().add(nodeValue);
                }
            }
            questions.add(question);
        }
        return questions;
    }
}
