
package data;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "administratorsType", propOrder = {
    "admin"
})
public class AdministratorsType {

    protected List<AdminType> admin;

    public List<AdminType> getAdmin() {
        if (admin == null) {
            admin = new ArrayList<AdminType>();
        }
        return this.admin;
    }

}
