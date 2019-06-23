
package data;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name="database")
@XmlAccessorType(XmlAccessType.FIELD)
public class Database {

    @XmlElement(required = true)
    protected PeopleType people;
    @XmlElement(required = true)
    protected HousesType houses;
    @XmlElement(required = true)
    protected PhonesType phones;
    @XmlElement(required = true)
    protected EmailsType emails;
    @XmlElement(required = true)
    protected CreditcardsType creditcards;
    @XmlElement(required = true)
    protected BusinessType business;
    @XmlElement(required = true)
    protected ProductsType products;
    @XmlElement(required = true)
    protected AdministratorsType administrators;

    public PeopleType getPeople() {
        return people;
    }

    public void setPeople(PeopleType value) {
        this.people = value;
    }

    public HousesType getHouses() {
        return houses;
    }

    public void setHouses(HousesType value) {
        this.houses = value;
    }

    public PhonesType getPhones() {
        return phones;
    }

    public void setPhones(PhonesType value) {
        this.phones = value;
    }

    public EmailsType getEmails() {
        return emails;
    }

    public void setEmails(EmailsType value) {
        this.emails = value;
    }

    public CreditcardsType getCreditcards() {
        return creditcards;
    }

    public void setCreditcards(CreditcardsType value) {
        this.creditcards = value;
    }

    public BusinessType getBusiness() {
        return business;
    }

    public void setBusiness(BusinessType value) {
        this.business = value;
    }

    public ProductsType getProducts() {
        return products;
    }

    public void setProducts(ProductsType value) {
        this.products = value;
    }

    public AdministratorsType getAdministrators() {
        return administrators;
    }

    public void setAdministrators(AdministratorsType value) {
        this.administrators = value;
    }

}
