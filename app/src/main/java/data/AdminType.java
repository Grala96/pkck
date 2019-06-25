
package data;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adminType", propOrder = {
        "name",
        "index"
})
public class AdminType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String index;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String value) {
        this.index = value;
    }

}
