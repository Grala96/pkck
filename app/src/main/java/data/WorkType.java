
package data;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workType", propOrder = {
    "position"
})
public class WorkType {

    @XmlElement(required = true)
    protected String position;
    @XmlAttribute(name = "companyid")
    protected String companyid;


    public String getPosition() {
        return position;
    }


    public void setPosition(String value) {
        this.position = value;
    }


    public String getCompanyid() {
        return companyid;
    }


    public void setCompanyid(String value) {
        this.companyid = value;
    }

}
