
package data;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "houseType", propOrder = {
    "address",
    "geolocation"
})
public class HouseType {

    @XmlElement(required = true)
    protected AddressType address;
    @XmlElement(required = true)
    protected GeolocationType geolocation;
    @XmlAttribute(name = "houseid")
    protected String houseid;


    public AddressType getAddress() {
        return address;
    }


    public void setAddress(AddressType value) {
        this.address = value;
    }


    public GeolocationType getGeolocation() {
        return geolocation;
    }


    public void setGeolocation(GeolocationType value) {
        this.geolocation = value;
    }


    public String getHouseid() {
        return houseid;
    }


    public void setHouseid(String value) {
        this.houseid = value;
    }

}
