
package authenticationservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import utils.*;

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
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expiresIn" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="role" type="{http://www.furryaide.com/authentication/roles}UserRole"/>
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
    "token",
    "expiresIn",
    "role"
})
@XmlRootElement(name = "loginResponse", namespace = "http://www.furryaide.com/authentication")
public class LoginResponse {

    @XmlElement(namespace = "http://www.furryaide.com/authentication", required = true)
    protected String token;
    @XmlElement(namespace = "http://www.furryaide.com/authentication")
    protected int expiresIn;
    @XmlElement(namespace = "http://www.furryaide.com/authentication", required = true)
    @XmlSchemaType(name = "string")
    protected UserRole role;

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
     * Gets the value of the expiresIn property.
     * 
     */
    public int getExpiresIn() {
        return expiresIn;
    }

    /**
     * Sets the value of the expiresIn property.
     * 
     */
    public void setExpiresIn(int value) {
        this.expiresIn = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link UserRole }
     *     
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserRole }
     *     
     */
    public void setRole(UserRole value) {
        this.role = value;
    }

}
