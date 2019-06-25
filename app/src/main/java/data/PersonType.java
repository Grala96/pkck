
package data;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personType", propOrder = {
    "firstname",
    "middlename",
    "lastname",
    "birthday",
    "physicalcharacteristics",
    "work"
})
public class PersonType {

    @XmlElement(required = true)
    protected String firstname;
    @XmlElement(required = true)
    protected String middlename;
    @XmlElement(required = true)
    protected String lastname;
    @XmlElement(required = true)
    protected String birthday;
    @XmlElement(required = true)
    protected PhysicalcharacteristicsType physicalcharacteristics;
    @XmlElement(required = true)
    protected WorkType work;
    @XmlAttribute(name = "personid")
    protected String personid;
    @XmlAttribute(name = "house")
    protected String house;


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String value) {
        this.firstname = value;
    }


    public String getMiddlename() {
        return middlename;
    }


    public void setMiddlename(String value) {
        this.middlename = value;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String value) {
        this.lastname = value;
    }


    public String getBirthday() {
        return birthday;
    }


    public void setBirthday(String value) {
        this.birthday = value;
    }


    public PhysicalcharacteristicsType getPhysicalcharacteristics() {
        return physicalcharacteristics;
    }


    public void setPhysicalcharacteristics(PhysicalcharacteristicsType value) {
        this.physicalcharacteristics = value;
    }


    public WorkType getWork() {
        return work;
    }


    public void setWork(WorkType value) {
        this.work = value;
    }


    public String getPersonid() {
        return personid;
    }


    public void setPersonid(String value) {
        this.personid = value;
    }


    public String getHouse() {
        return house;
    }


    public void setHouse(String value) {
        this.house = value;
    }

}
