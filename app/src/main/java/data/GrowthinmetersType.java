
package data;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "growthinmetersType", propOrder = {
    "value"
})
public class GrowthinmetersType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "heightUnit")
    protected String heightUnit;


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public String getHeightUnit() {
        return heightUnit;
    }


    public void setHeightUnit(String value) {
        this.heightUnit = value;
    }

}
