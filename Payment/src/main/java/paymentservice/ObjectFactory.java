
package paymentservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the paymentservice package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: paymentservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidatePaymentResponse }
     * 
     */
    public ValidatePaymentResponse createValidatePaymentResponse() {
        return new ValidatePaymentResponse();
    }

    /**
     * Create an instance of {@link MakePaymentRequest }
     * 
     */
    public MakePaymentRequest createMakePaymentRequest() {
        return new MakePaymentRequest();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link MakePaymentResponse }
     * 
     */
    public MakePaymentResponse createMakePaymentResponse() {
        return new MakePaymentResponse();
    }

    /**
     * Create an instance of {@link ValidatePaymentRequest }
     * 
     */
    public ValidatePaymentRequest createValidatePaymentRequest() {
        return new ValidatePaymentRequest();
    }

    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

}
