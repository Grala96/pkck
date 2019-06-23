
package data;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressType", propOrder = {
        "streetaddress",
        "city",
        "country",
        "zipcode"
})
public class AddressType {

    @XmlElement(required = true)
    protected String streetaddress;
    @XmlElement(required = true)
    protected String city;
    @XmlElement(required = true)
    protected String country;
    @XmlElement(required = true)
    protected String zipcode;

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String value) {
        this.streetaddress = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String value) {
        this.zipcode = value;
    }

}
