
package data;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "physicalcharacteristicsType", propOrder = {
    "growthinmeters",
    "weightinkilograms"
})
public class PhysicalcharacteristicsType {

    @XmlElement(required = true)
    protected GrowthinmetersType growthinmeters;
    @XmlElement(required = true)
    protected WeightinkilogramsType weightinkilograms;


    public GrowthinmetersType getGrowthinmeters() {
        return growthinmeters;
    }


    public void setGrowthinmeters(GrowthinmetersType value) {
        this.growthinmeters = value;
    }


    public WeightinkilogramsType getWeightinkilograms() {
        return weightinkilograms;
    }


    public void setWeightinkilograms(WeightinkilogramsType value) {
        this.weightinkilograms = value;
    }

}
