
package adoptionselectionservice;

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
 *         &lt;element name="petId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="questionnaireId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "petId",
    "questionnaireId"
})
@XmlRootElement(name = "selectQuestionnaireRequest", namespace = "http://www.furryaide/ws/AdoptionSelectionService")
public class SelectQuestionnaireRequest {

    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionSelectionService")
    protected long petId;
    @XmlElement(namespace = "http://www.furryaide/ws/AdoptionSelectionService")
    protected long questionnaireId;

    /**
     * Gets the value of the petId property.
     * 
     */
    public long getPetId() {
        return petId;
    }

    /**
     * Sets the value of the petId property.
     * 
     */
    public void setPetId(long value) {
        this.petId = value;
    }

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

}
