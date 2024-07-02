
package manageadoptionservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adoptionRequestID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "adoptionRequestID",
    "token"
})
@XmlRootElement(name = "getAdoptionStatusRequest", namespace = "http://www.furryaide/ws/AdoptionManagement")
public class GetAdoptionStatusRequest {

    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement")
    protected long adoptionRequestID;
    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement", required = true)
    protected String token;

    /**
     * Gets the value of the adoptionRequestID property.
     * 
     */
    public long getAdoptionRequestID() {
        return adoptionRequestID;
    }

    /**
     * Sets the value of the adoptionRequestID property.
     * 
     */
    public void setAdoptionRequestID(long value) {
        this.adoptionRequestID = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

}
