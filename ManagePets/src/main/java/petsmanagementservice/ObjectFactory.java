
package petsmanagementservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the petsmanagementservice package. 
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

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: petsmanagementservice
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
     * Create an instance of {@link GetManagedPetDetailsResponse }
     * 
     */
    public GetManagedPetDetailsResponse createGetManagedPetDetailsResponse() {
        return new GetManagedPetDetailsResponse();
    }

    /**
     * Create an instance of {@link GetManagedPetDetailsRequest }
     * 
     */
    public GetManagedPetDetailsRequest createGetManagedPetDetailsRequest() {
        return new GetManagedPetDetailsRequest();
    }

    /**
     * Create an instance of {@link GetManagedPetsRequest }
     * 
     */
    public GetManagedPetsRequest createGetManagedPetsRequest() {
        return new GetManagedPetsRequest();
    }

    /**
     * Create an instance of {@link GetManagedPetsResponse }
     * 
     */
    public GetManagedPetsResponse createGetManagedPetsResponse() {
        return new GetManagedPetsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.furryaide/ws/Pet", name = "petFault")
    public JAXBElement<String> createPetFault(String value) {
        return new JAXBElement<String>(_PetFault_QNAME, String.class, null, value);
    }

}
