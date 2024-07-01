
package petsmanagementservice;

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
 *         &lt;element name="pet" type="{http://www.furryaide/ws/Pet}Pet"/>
 *         &lt;element name="status" type="{http://www.furryaide/ws/StatusCodeService}statusCode"/>
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
    "pet",
    "status"
})
@XmlRootElement(name = "getManagedPetDetailsResponse", namespace = "http://www.furryaide/ws/PetsManagementService")
public class GetManagedPetDetailsResponse {

    @XmlElement(namespace = "http://www.furryaide/ws/PetsManagementService", required = true)
    protected Pet pet;
    @XmlElement(namespace = "http://www.furryaide/ws/PetsManagementService", required = true)
    protected StatusCode status;

    /**
     * Gets the value of the pet property.
     * 
     * @return
     *     possible object is
     *     {@link Pet }
     *     
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Sets the value of the pet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pet }
     *     
     */
    public void setPet(Pet value) {
        this.pet = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusCode }
     *     
     */
    public StatusCode getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusCode }
     *     
     */
    public void setStatus(StatusCode value) {
        this.status = value;
    }

}
