
package tutorialservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TutorialTypes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TutorialTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tutorials" type="{http://www.wstutorial.com/ws/TutorialService}TutorialType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TutorialTypes", namespace = "http://www.wstutorial.com/ws/TutorialService", propOrder = {
    "tutorials"
})
public class TutorialTypes {

    @XmlElement(namespace = "http://www.wstutorial.com/ws/TutorialService")
    protected List<TutorialType> tutorials;

    /**
     * Gets the value of the tutorials property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tutorials property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTutorials().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TutorialType }
     * 
     * 
     */
    public List<TutorialType> getTutorials() {
        if (tutorials == null) {
            tutorials = new ArrayList<TutorialType>();
        }
        return this.tutorials;
    }

}
