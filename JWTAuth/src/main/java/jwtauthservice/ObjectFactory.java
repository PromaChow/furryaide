
package jwtauthservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jwtauthservice package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jwtauthservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidateTokenRequest }
     * 
     */
    public ValidateTokenRequest createValidateTokenRequest() {
        return new ValidateTokenRequest();
    }

    /**
     * Create an instance of {@link ValidateTokenResponse }
     * 
     */
    public ValidateTokenResponse createValidateTokenResponse() {
        return new ValidateTokenResponse();
    }

    /**
     * Create an instance of {@link HashPasswordRequest }
     * 
     */
    public HashPasswordRequest createHashPasswordRequest() {
        return new HashPasswordRequest();
    }

    /**
     * Create an instance of {@link HashPasswordResponse }
     * 
     */
    public HashPasswordResponse createHashPasswordResponse() {
        return new HashPasswordResponse();
    }

    /**
     * Create an instance of {@link GenerateTokenResponse }
     * 
     */
    public GenerateTokenResponse createGenerateTokenResponse() {
        return new GenerateTokenResponse();
    }

    /**
     * Create an instance of {@link GenerateTokenRequest }
     * 
     */
    public GenerateTokenRequest createGenerateTokenRequest() {
        return new GenerateTokenRequest();
    }

}
