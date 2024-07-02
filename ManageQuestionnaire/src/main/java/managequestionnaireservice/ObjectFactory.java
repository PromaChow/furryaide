
package managequestionnaireservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the managequestionnaireservice package. 
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

    private final static QName _QuestionnaireFault_QNAME = new QName("http://www.furryaide/ws/ManageQuestionnaire", "questionnaireFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: managequestionnaireservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateQuestionnaireResponse }
     * 
     */
    public UpdateQuestionnaireResponse createUpdateQuestionnaireResponse() {
        return new UpdateQuestionnaireResponse();
    }

    /**
     * Create an instance of {@link ApproveQuestionnaireResponse }
     * 
     */
    public ApproveQuestionnaireResponse createApproveQuestionnaireResponse() {
        return new ApproveQuestionnaireResponse();
    }

    /**
     * Create an instance of {@link CreateQuestionnaireRequest }
     * 
     */
    public CreateQuestionnaireRequest createCreateQuestionnaireRequest() {
        return new CreateQuestionnaireRequest();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link SubmitQuestionnaireRequest }
     * 
     */
    public SubmitQuestionnaireRequest createSubmitQuestionnaireRequest() {
        return new SubmitQuestionnaireRequest();
    }

    /**
     * Create an instance of {@link SubmitQuestionnaireResponse }
     * 
     */
    public SubmitQuestionnaireResponse createSubmitQuestionnaireResponse() {
        return new SubmitQuestionnaireResponse();
    }

    /**
     * Create an instance of {@link CreateQuestionnaireResponse }
     * 
     */
    public CreateQuestionnaireResponse createCreateQuestionnaireResponse() {
        return new CreateQuestionnaireResponse();
    }

    /**
     * Create an instance of {@link ApproveQuestionnaireRequest }
     * 
     */
    public ApproveQuestionnaireRequest createApproveQuestionnaireRequest() {
        return new ApproveQuestionnaireRequest();
    }

    /**
     * Create an instance of {@link UpdateQuestionnaireRequest }
     * 
     */
    public UpdateQuestionnaireRequest createUpdateQuestionnaireRequest() {
        return new UpdateQuestionnaireRequest();
    }

    /**
     * Create an instance of {@link GetQuestionnaireByIdRequest }
     * 
     */
    public GetQuestionnaireByIdRequest createGetQuestionnaireByIdRequest() {
        return new GetQuestionnaireByIdRequest();
    }

    /**
     * Create an instance of {@link GetQuestionnaireByIdResponse }
     * 
     */
    public GetQuestionnaireByIdResponse createGetQuestionnaireByIdResponse() {
        return new GetQuestionnaireByIdResponse();
    }

    /**
     * Create an instance of {@link Questionnaire }
     * 
     */
    public Questionnaire createQuestionnaire() {
        return new Questionnaire();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.furryaide/ws/ManageQuestionnaire", name = "questionnaireFault")
    public JAXBElement<String> createQuestionnaireFault(String value) {
        return new JAXBElement<String>(_QuestionnaireFault_QNAME, String.class, null, value);
    }

}
