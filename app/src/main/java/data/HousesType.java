
package data;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "housesType", propOrder = {
    "house"
})
public class HousesType {

    protected List<HouseType> house;


    public List<HouseType> getHouse() {
        if (house == null) {
            house = new ArrayList<HouseType>();
        }
        return this.house;
    }

}
