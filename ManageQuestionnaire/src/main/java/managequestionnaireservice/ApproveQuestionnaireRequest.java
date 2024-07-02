
package managequestionnaireservice;

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
 *         &lt;element name="questionnaireId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "questionnaireId",
    "username",
    "token"
})
@XmlRootElement(name = "approveQuestionnaireRequest", namespace = "http://www.furryaide/ws/ManageQuestionnaire")
public class ApproveQuestionnaireRequest {

    @XmlElement(namespace = "http://www.furryaide/ws/ManageQuestionnaire")
    protected long questionnaireId;
    @XmlElement(namespace = "http://www.furryaide/ws/ManageQuestionnaire", required = true)
    protected String username;
    @XmlElement(namespace = "http://www.furryaide/ws/ManageQuestionnaire", required = true)
    protected String token;

    /**
     * Gets the value of the questionnaireId property.
     * 
     */
    public long getQuestionnaireId() {
        return questionnaireId;
    }

    /**
     * Sets the value of the questionnaireId property.
     * 
     */
    public void setQuestionnaireId(long value) {
        this.questionnaireId = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
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
