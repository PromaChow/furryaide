
package manageadoptionservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Adoption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Adoption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="customerID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="petID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="status" type="{http://www.furryaide/ws/AdoptionManagement}Status"/>
 *         &lt;element name="relinquisherID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adoption", namespace = "http://www.furryaide/ws/AdoptionManagement", propOrder = {
    "id",
    "customerID",
    "petID",
    "status",
    "relinquisherID"
})
public class Adoption {

    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement")
    protected long id;
    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement")
    protected long customerID;
    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement")
    protected long petID;
    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement", required = true)
    @XmlSchemaType(name = "string")
    protected Status status;
    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionManagement")
    protected long relinquisherID;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the customerID property.
     * 
     */
    public long getCustomerID() {
        return customerID;
    }

    /**
     * Sets the value of the customerID property.
     * 
     */
    public void setCustomerID(long value) {
        this.customerID = value;
    }

    /**
     * Gets the value of the petID property.
     * 
     */
    public long getPetID() {
        return petID;
    }

    /**
     * Sets the value of the petID property.
     * 
     */
    public void setPetID(long value) {
        this.petID = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the relinquisherID property.
     * 
     */
    public long getRelinquisherID() {
        return relinquisherID;
    }

    /**
     * Sets the value of the relinquisherID property.
     * 
     */
    public void setRelinquisherID(long value) {
        this.relinquisherID = value;
    }

}
