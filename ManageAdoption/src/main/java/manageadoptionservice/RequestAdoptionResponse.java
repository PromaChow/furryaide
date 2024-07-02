
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
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "status"
})
@XmlRootElement(name = "requestAdoptionResponse", namespace = "http://www.furryaide/ws/AdoptionManagement")
public class RequestAdoptionResponse {

    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement")
    protected long adoptionRequestID;
    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement", required = true)
    protected String status;

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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
