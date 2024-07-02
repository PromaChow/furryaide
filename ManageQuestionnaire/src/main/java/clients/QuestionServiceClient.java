package clients;

import managequestionnaireservice.Question;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static clients.XMLUtils.getParsedOutput;


public class QuestionServiceClient {
    private static final String QUESTION_SERVICE_URL = "http://localhost:3001/wsdlfirst/questionService";

    public long createQuestion(Question question) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ques=\"http://www.furryaide/ws/QuestionnaireService\" xmlns:ques1=\"http://www.furryaide/ws/Question\">" +
                "   <soapenv:Header/>" +
                "   <soapenv:Body>" +
                "      <ques:createQuestionRequest>" +
                "         <ques:Question>" +
                "            <ques1:id>" + question.getId() + "</ques1:id>" +
                "            <ques1:text>" + question.getText() + "</ques1:text>" +
                "            <ques1:type>" + question.getType() + "</ques1:type>";

        if (question.getOptions() != null) {
            for (String option : question.getOptions()) {
                xmlInput += "            <ques1:options>" + option + "</ques1:options>";
            }
        }

        xmlInput += "         </ques:Question>" +
                "      </ques:createQuestionRequest>" +
                "   </soapenv:Body>" +
                "</soapenv:Envelope>";

        Document document = getParsedOutput(xmlInput,QUESTION_SERVICE_URL);
        return Long.parseLong(document.getElementsByTagName("ques1:id").item(0).getTextContent());
    }
}
