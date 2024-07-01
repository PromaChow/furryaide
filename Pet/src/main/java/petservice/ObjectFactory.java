
package petservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the petservice package. 
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
    private final static QName _GetAllPetsRequest_QNAME = new QName("http://www.furryaide/ws/PetService", "getAllPetsRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: petservice
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
     * Create an instance of {@link FilterPetsRequest }
     * 
     */
    public FilterPetsRequest createFilterPetsRequest() {
        return new FilterPetsRequest();
    }

    /**
     * Create an instance of {@link DeletePetResponse }
     * 
     */
    public DeletePetResponse createDeletePetResponse() {
        return new DeletePetResponse();
    }

    /**
     * Create an instance of {@link SearchPetsResponse }
     * 
     */
    public SearchPetsResponse createSearchPetsResponse() {
        return new SearchPetsResponse();
    }

    /**
     * Create an instance of {@link SearchPetsRequest }
     * 
     */
    public SearchPetsRequest createSearchPetsRequest() {
        return new SearchPetsRequest();
    }

    /**
     * Create an instance of {@link SortPetsRequest }
     * 
     */
    public SortPetsRequest createSortPetsRequest() {
        return new SortPetsRequest();
    }

    /**
     * Create an instance of {@link CreatePetRequest }
     * 
     */
    public CreatePetRequest createCreatePetRequest() {
        return new CreatePetRequest();
    }

    /**
     * Create an instance of {@link DeletePetRequest }
     * 
     */
    public DeletePetRequest createDeletePetRequest() {
        return new DeletePetRequest();
    }

    /**
     * Create an instance of {@link GetAllPetsResponse }
     * 
     */
    public GetAllPetsResponse createGetAllPetsResponse() {
        return new GetAllPetsResponse();
    }

    /**
     * Create an instance of {@link SortPetsResponse }
     * 
     */
    public SortPetsResponse createSortPetsResponse() {
        return new SortPetsResponse();
    }

    /**
     * Create an instance of {@link UpdatePetRequest }
     * 
     */
    public UpdatePetRequest createUpdatePetRequest() {
        return new UpdatePetRequest();
    }

    /**
     * Create an instance of {@link GetPetRequest }
     * 
     */
    public GetPetRequest createGetPetRequest() {
        return new GetPetRequest();
    }

    /**
     * Create an instance of {@link UpdatePetResponse }
     * 
     */
    public UpdatePetResponse createUpdatePetResponse() {
        return new UpdatePetResponse();
    }

    /**
     * Create an instance of {@link GetPetResponse }
     * 
     */
    public GetPetResponse createGetPetResponse() {
        return new GetPetResponse();
    }

    /**
     * Create an instance of {@link FilterPetsResponse }
     * 
     */
    public FilterPetsResponse createFilterPetsResponse() {
        return new FilterPetsResponse();
    }

    /**
     * Create an instance of {@link CreatePetResponse }
     * 
     */
    public CreatePetResponse createCreatePetResponse() {
        return new CreatePetResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.furryaide/ws/PetService", name = "getAllPetsRequest")
    public JAXBElement<Object> createGetAllPetsRequest(Object value) {
        return new JAXBElement<Object>(_GetAllPetsRequest_QNAME, Object.class, null, value);
    }

}
