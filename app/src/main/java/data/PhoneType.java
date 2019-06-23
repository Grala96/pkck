
package data;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "phoneType", propOrder = {
    "value"
})
public class PhoneType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "phoneid")
    protected String phoneid;
    @XmlAttribute(name = "ownerid")
    protected String ownerid;


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public String getPhoneid() {
        return phoneid;
    }


    public void setPhoneid(String value) {
        this.phoneid = value;
    }


    public String getOwnerid() {
        return ownerid;
    }


    public void setOwnerid(String value) {
        this.ownerid = value;
    }

}
