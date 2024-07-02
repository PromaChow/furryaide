
package manageadoptionservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the manageadoptionservice package. 
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

    private final static QName _AdoptionFault_QNAME = new QName("http://www.furryaide/ws/AdoptionManagement", "adoptionFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: manageadoptionservice
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ApproveAdoptionResponse }
     *
     */
    public ApproveAdoptionResponse createApproveAdoptionResponse() {
        return new ApproveAdoptionResponse();
    }

    /**
     * Create an instance of {@link CancelAdoptionRequest }
     *
     */
    public CancelAdoptionRequest createCancelAdoptionRequest() {
        return new CancelAdoptionRequest();
    }

    /**
     * Create an instance of {@link GetAdoptionDetailsResponse }
     *
     */
    public GetAdoptionDetailsResponse createGetAdoptionDetailsResponse() {
        return new GetAdoptionDetailsResponse();
    }

    /**
     * Create an instance of {@link Adoption }
     *
     */
    public Adoption createAdoption() {
        return new Adoption();
    }

    /**
     * Create an instance of {@link RejectAdoptionResponse }
     *
     */
    public RejectAdoptionResponse createRejectAdoptionResponse() {
        return new RejectAdoptionResponse();
    }

    /**
     * Create an instance of {@link RejectAdoptionRequest }
     *
     */
    public RejectAdoptionRequest createRejectAdoptionRequest() {
        return new RejectAdoptionRequest();
    }

    /**
     * Create an instance of {@link GetAdoptionStatusRequest }
     *
     */
    public GetAdoptionStatusRequest createGetAdoptionStatusRequest() {
        return new GetAdoptionStatusRequest();
    }

    /**
     * Create an instance of {@link RequestAdoptionResponse }
     *
     */
    public RequestAdoptionResponse createRequestAdoptionResponse() {
        return new RequestAdoptionResponse();
    }

    /**
     * Create an instance of {@link RequestAdoptionRequest }
     *
     */
    public RequestAdoptionRequest createRequestAdoptionRequest() {
        return new RequestAdoptionRequest();
    }

    /**
     * Create an instance of {@link GetAdoptionStatusResponse }
     *
     */
    public GetAdoptionStatusResponse createGetAdoptionStatusResponse() {
        return new GetAdoptionStatusResponse();
    }

    /**
     * Create an instance of {@link GetAdoptionDetailsRequest }
     *
     */
    public GetAdoptionDetailsRequest createGetAdoptionDetailsRequest() {
        return new GetAdoptionDetailsRequest();
    }

    /**
     * Create an instance of {@link CancelAdoptionResponse }
     *
     */
    public CancelAdoptionResponse createCancelAdoptionResponse() {
        return new CancelAdoptionResponse();
    }

    /**
     * Create an instance of {@link ApproveAdoptionRequest }
     *
     */
    public ApproveAdoptionRequest createApproveAdoptionRequest() {
        return new ApproveAdoptionRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.furryaide/ws/AdoptionManagement", name = "adoptionFault")
    public JAXBElement<String> createAdoptionFault(String value) {
        return new JAXBElement<String>(_AdoptionFault_QNAME, String.class, null, value);
    }

}