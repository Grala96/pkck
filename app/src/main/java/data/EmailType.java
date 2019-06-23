
package data;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "emailType", propOrder = {
    "emailaddress",
    "password",
    "creationdate"
})
public class EmailType {

    @XmlElement(required = true)
    protected String emailaddress;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String creationdate;
    @XmlAttribute(name = "emailid")
    protected String emailid;
    @XmlAttribute(name = "ownerid")
    protected String ownerid;


    public String getEmailaddress() {
        return emailaddress;
    }


    public void setEmailaddress(String value) {
        this.emailaddress = value;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String value) {
        this.password = value;
    }


    public String getCreationdate() {
        return creationdate;
    }


    public void setCreationdate(String value) {
        this.creationdate = value;
    }


    public String getEmailid() {
        return emailid;
    }


    public void setEmailid(String value) {
        this.emailid = value;
    }


    public String getOwnerid() {
        return ownerid;
    }


    public void setOwnerid(String value) {
        this.ownerid = value;
    }

}
