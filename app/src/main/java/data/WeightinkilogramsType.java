
package data;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "weightinkilogramsType", propOrder = {
    "value"
})
public class WeightinkilogramsType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "weightUnit")
    protected String weightUnit;


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public String getWeightUnit() {
        return weightUnit;
    }


    public void setWeightUnit(String value) {
        this.weightUnit = value;
    }

}
