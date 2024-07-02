
package accesscontrolservice;

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
 *         &lt;element name="hasPermission" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "hasPermission"
})
@XmlRootElement(name = "checkPermissionResponse", namespace = "http://www.furryaide.com/accesscontrol")
public class CheckPermissionResponse {

    @XmlElement(namespace = "http://www.furryaide.com/accesscontrol")
    protected boolean hasPermission;

    /**
     * Gets the value of the hasPermission property.
     * 
     */
    public boolean isHasPermission() {
        return hasPermission;
    }

    /**
     * Sets the value of the hasPermission property.
     * 
     */
    public void setHasPermission(boolean value) {
        this.hasPermission = value;
    }

}
