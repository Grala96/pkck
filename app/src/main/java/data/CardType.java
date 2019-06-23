
package data;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardType", propOrder = {
    "issuer",
    "number",
    "expires"
})
public class CardType {

    @XmlElement(required = true)
    protected String issuer;
    @XmlElement(required = true)
    protected String number;
    @XmlElement(required = true)
    protected String expires;
    @XmlAttribute(name = "cardid")
    protected String cardid;
    @XmlAttribute(name = "ownerid")
    protected String ownerid;


    public String getIssuer() {
        return issuer;
    }


    public void setIssuer(String value) {
        this.issuer = value;
    }


    public String getNumber() {
        return number;
    }


    public void setNumber(String value) {
        this.number = value;
    }


    public String getExpires() {
        return expires;
    }


    public void setExpires(String value) {
        this.expires = value;
    }


    public String getCardid() {
        return cardid;
    }


    public void setCardid(String value) {
        this.cardid = value;
    }


    public String getOwnerid() {
        return ownerid;
    }


    public void setOwnerid(String value) {
        this.ownerid = value;
    }

}
