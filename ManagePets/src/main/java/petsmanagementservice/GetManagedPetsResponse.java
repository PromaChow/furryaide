
package petsmanagementservice;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="pets" type="{http://www.furryaide/ws/Pet}Pet" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statusCode" type="{http://www.furryaide/ws/StatusCodeService}statusCode"/>
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
    "pets",
    "statusCode"
})
@XmlRootElement(name = "getManagedPetsResponse", namespace = "http://www.furryaide/ws/PetsManagementService")
public class GetManagedPetsResponse {

    @XmlElement(namespace = "http://www.furryaide/ws/PetsManagementService")
    protected List<Pet> pets;
    @XmlElement(namespace = "http://www.furryaide/ws/PetsManagementService", required = true)
    protected StatusCode statusCode;

    /**
     * Gets the value of the pets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pet }
     * 
     * 
     */
    public List<Pet> getPets() {
        if (pets == null) {
            pets = new ArrayList<Pet>();
        }
        return this.pets;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link StatusCode }
     *     
     */
    public StatusCode getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusCode }
     *     
     */
    public void setStatusCode(StatusCode value) {
        this.statusCode = value;
    }

}
