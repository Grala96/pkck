
package data;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "geolocationType", propOrder = {
    "latitude",
    "longitude"
})
public class GeolocationType {

    @XmlElement(required = true)
    protected String latitude;
    @XmlElement(required = true)
    protected String longitude;


    public String getLatitude() {
        return latitude;
    }


    public void setLatitude(String value) {
        this.latitude = value;
    }


    public String getLongitude() {
        return longitude;
    }


    public void setLongitude(String value) {
        this.longitude = value;
    }

}
