
package data;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "companyType", propOrder = {
    "companyname"
})
public class CompanyType {

    @XmlElement(required = true)
    protected String companyname;
    @XmlAttribute(name = "companyid")
    protected String companyid;


    public String getCompanyname() {
        return companyname;
    }


    public void setCompanyname(String value) {
        this.companyname = value;
    }


    public String getCompanyid() {
        return companyid;
    }


    public void setCompanyid(String value) {
        this.companyid = value;
    }

}
