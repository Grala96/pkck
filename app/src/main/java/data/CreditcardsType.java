
package data;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditcardsType", propOrder = {
    "card"
})
public class CreditcardsType {

    protected List<CardType> card;


    public List<CardType> getCard() {
        if (card == null) {
            card = new ArrayList<CardType>();
        }
        return this.card;
    }

}
