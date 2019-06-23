
package data;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "businessType", propOrder = {
        "company"
})
public class BusinessType {

    protected List<CompanyType> company;

    public List<CompanyType> getCompany() {
        if (company == null) {
            company = new ArrayList<CompanyType>();
        }
        return this.company;
    }

}
