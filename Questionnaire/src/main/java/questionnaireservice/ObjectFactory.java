
package questionnaireservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the questionnaireservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _QuestionnaireFault_QNAME = new QName("http://www.furryaide/ws/Question", "questionnaireFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: questionnaireservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link Questions }
     * 
     */
    public Questions createQuestions() {
        return new Questions();
    }

    /**
     * Create an instance of {@link GetQuestionResponse }
     * 
     */
    public GetQuestionResponse createGetQuestionResponse() {
        return new GetQuestionResponse();
    }

    /**
     * Create an instance of {@link DeleteQuestionRequest }
     * 
     */
    public DeleteQuestionRequest createDeleteQuestionRequest() {
        return new DeleteQuestionRequest();
    }

    /**
     * Create an instance of {@link CreateQuestionRequest }
     * 
     */
    public CreateQuestionRequest createCreateQuestionRequest() {
        return new CreateQuestionRequest();
    }

    /**
     * Create an instance of {@link CreateQuestionResponse }
     * 
     */
    public CreateQuestionResponse createCreateQuestionResponse() {
        return new CreateQuestionResponse();
    }

    /**
     * Create an instance of {@link StatusCode }
     * 
     */
    public StatusCode createStatusCode() {
        return new StatusCode();
    }

    /**
     * Create an instance of {@link UpdateQuestionResponse }
     * 
     */
    public UpdateQuestionResponse createUpdateQuestionResponse() {
        return new UpdateQuestionResponse();
    }

    /**
     * Create an instance of {@link ListQuestionsResponse }
     * 
     */
    public ListQuestionsResponse createListQuestionsResponse() {
        return new ListQuestionsResponse();
    }

    /**
     * Create an instance of {@link UpdateQuestionRequest }
     * 
     */
    public UpdateQuestionRequest createUpdateQuestionRequest() {
        return new UpdateQuestionRequest();
    }

    /**
     * Create an instance of {@link DeleteQuestionResponse }
     * 
     */
    public DeleteQuestionResponse createDeleteQuestionResponse() {
        return new DeleteQuestionResponse();
    }

    /**
     * Create an instance of {@link GetQuestionRequest }
     * 
     */
    public GetQuestionRequest createGetQuestionRequest() {
        return new GetQuestionRequest();
    }

    /**
     * Create an instance of {@link ListQuestionsRequest }
     * 
     */
    public ListQuestionsRequest createListQuestionsRequest() {
        return new ListQuestionsRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.furryaide/ws/Question", name = "questionnaireFault")
    public JAXBElement<String> createQuestionnaireFault(String value) {
        return new JAXBElement<String>(_QuestionnaireFault_QNAME, String.class, null, value);
    }

}
