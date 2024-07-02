
package notificationservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Notification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Notification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vibrationType" type="{http://www.furryaide/ws/vibrationType}vibrationType"/>
 *         &lt;element name="channel" type="{http://www.furryaide/ws/channel}channel"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Notification", namespace = "http://www.furryaide/ws/Notification", propOrder = {
    "type",
    "message",
    "vibrationType",
    "channel"
})
public class Notification {

    @XmlElement(namespace = "http://www.furryaide/ws/Notification", required = true)
    protected String type;
    @XmlElement(namespace = "http://www.furryaide/ws/Notification", required = true)
    protected String message;
    @XmlElement(namespace = "http://www.furryaide/ws/Notification", required = true)
    protected VibrationType vibrationType;
    @XmlElement(namespace = "http://www.furryaide/ws/Notification", required = true)
    protected Channel channel;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the vibrationType property.
     * 
     * @return
     *     possible object is
     *     {@link VibrationType }
     *     
     */
    public VibrationType getVibrationType() {
        return vibrationType;
    }

    /**
     * Sets the value of the vibrationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link VibrationType }
     *     
     */
    public void setVibrationType(VibrationType value) {
        this.vibrationType = value;
    }

    /**
     * Gets the value of the channel property.
     * 
     * @return
     *     possible object is
     *     {@link Channel }
     *     
     */
    public Channel getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Channel }
     *     
     */
    public void setChannel(Channel value) {
        this.channel = value;
    }

}
