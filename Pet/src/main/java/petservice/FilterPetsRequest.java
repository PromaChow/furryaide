
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
 *         &lt;element name="filterBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "filterBy"
})
@XmlRootElement(name = "filterPetsRequest", namespace = "http://www.furryaide/ws/PetService")
public class FilterPetsRequest {

    @XmlElement(namespace = "http://www.furryaide/ws/PetService", required = true)
    protected String filterBy;

    /**
     * Gets the value of the filterBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterBy() {
        return filterBy;
    }

    /**
     * Sets the value of the filterBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterBy(String value) {
        this.filterBy = value;
    }

}
