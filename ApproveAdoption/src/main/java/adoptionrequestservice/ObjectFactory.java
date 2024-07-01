
package adoptionrequestservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the adoptionrequestservice package. 
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

    private final static QName _PetFault_QNAME = new QName("http://www.furryaide/ws/Pet", "petFault");
    private final static QName _QuestionnaireFault_QNAME = new QName("http://www.furryaide/ws/Question", "questionnaireFault");
    private final static QName _AdoptionRequestFault_QNAME = new QName("http://www.furryaide/ws/AdoptionRequestService", "AdoptionRequestFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: adoptionrequestservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pet }
     * 
     */
    public Pet createPet() {
        return new Pet();
    }

    /**
     * Create an instance of {@link StatusCode }
     * 
     */
    public StatusCode createStatusCode() {
        return new StatusCode();
    }

    /**
     * Create an instance of {@link Permission }
     * 
     */
    public Permission createPermission() {
        return new Permission();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link SubmitQuestionnaireRequest }
     * 
     */
    public SubmitQuestionnaireRequest createSubmitQuestionnaireRequest() {
        return new SubmitQuestionnaireRequest();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link SubmitQuestionnaireResponse }
     * 
     */
    public SubmitQuestionnaireResponse createSubmitQuestionnaireResponse() {
        return new SubmitQuestionnaireResponse();
    }

    /**
     * Create an instance of {@link GetPetListResponse }
     * 
     */
    public GetPetListResponse createGetPetListResponse() {
        return new GetPetListResponse();
    }

    /**
     * Create an instance of {@link GetPetListRequest }
     * 
     */
    public GetPetListRequest createGetPetListRequest() {
        return new GetPetListRequest();
    }

    /**
     * Create an instance of {@link Questions }
     * 
     */
    public Questions createQuestions() {
        return new Questions();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.furryaide/ws/Pet", name = "petFault")
    public JAXBElement<String> createPetFault(String value) {
        return new JAXBElement<String>(_PetFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.furryaide/ws/Question", name = "questionnaireFault")
    public JAXBElement<String> createQuestionnaireFault(String value) {
        return new JAXBElement<String>(_QuestionnaireFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.furryaide/ws/AdoptionRequestService", name = "AdoptionRequestFault")
    public JAXBElement<String> createAdoptionRequestFault(String value) {
        return new JAXBElement<String>(_AdoptionRequestFault_QNAME, String.class, null, value);
    }

}
