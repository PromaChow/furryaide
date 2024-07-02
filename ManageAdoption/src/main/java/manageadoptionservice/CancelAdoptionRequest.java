
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
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cancellationReason" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "reason",
    "token",
    "cancellationReason"
})
@XmlRootElement(name = "cancelAdoptionRequest", namespace = "http://www.furryaide/ws/AdoptionManagement")
public class CancelAdoptionRequest {

    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement")
    protected long adoptionRequestID;
    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement", required = true)
    protected String reason;
    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement", required = true)
    protected String token;
    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement", required = true)
    protected String cancellationReason;

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
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
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

    /**
     * Gets the value of the cancellationReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancellationReason() {
        return cancellationReason;
    }

    /**
     * Sets the value of the cancellationReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancellationReason(String value) {
        this.cancellationReason = value;
    }

}
