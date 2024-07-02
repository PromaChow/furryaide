
package userauthservice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UserRole">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CUSTOMER"/>
 *     &lt;enumeration value="PET_RELINQUISHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UserRole", namespace = "http://www.furryaide.com/authentication/roles")
@XmlEnum
public enum UserRole {

    CUSTOMER,
    PET_RELINQUISHER;

    public String value() {
        return name();
    }

    public static UserRole fromValue(String v) {
        return valueOf(v);
    }

}
