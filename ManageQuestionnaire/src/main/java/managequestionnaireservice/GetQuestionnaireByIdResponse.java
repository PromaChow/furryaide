
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
 *         &lt;element name="questionnaire" type="{http://www.furryaide/ws/ManageQuestionnaire}Questionnaire"/>
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
    "questionnaire"
})
@XmlRootElement(name = "getQuestionnaireByIdResponse", namespace = "http://www.furryaide/ws/ManageQuestionnaire")
public class GetQuestionnaireByIdResponse {

    @XmlElement(namespace = "http://www.furryaide/ws/ManageQuestionnaire", required = true)
    protected Questionnaire questionnaire;

    /**
     * Gets the value of the questionnaire property.
     * 
     * @return
     *     possible object is
     *     {@link Questionnaire }
     *     
     */
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    /**
     * Sets the value of the questionnaire property.
     * 
     * @param value
     *     allowed object is
     *     {@link Questionnaire }
     *     
     */
    public void setQuestionnaire(Questionnaire value) {
        this.questionnaire = value;
    }

}
