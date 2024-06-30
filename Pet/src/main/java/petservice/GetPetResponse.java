
package petservice;

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
 *         &lt;element name="Pet" type="{http://www.furryaide/ws/Pet}Pet" minOccurs="0"/>
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
    "pet"
})
@XmlRootElement(name = "getPetResponse", namespace = "http://www.furryaide/ws/PetService")
public class GetPetResponse {

    @XmlElement(name = "Pet", namespace = "http://www.furryaide/ws/PetService")
    protected Pet pet;

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

}
