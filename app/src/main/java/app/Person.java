package app;

import data.PersonType;
import javafx.beans.property.SimpleStringProperty;

public class Person {

    private final SimpleStringProperty personid;
    private final SimpleStringProperty firstname;
    private final SimpleStringProperty middlename;
    private final SimpleStringProperty lastname;
    private final SimpleStringProperty birthday;
    private final SimpleStringProperty height;
    private final SimpleStringProperty heightUnit;
    private final SimpleStringProperty weight;
    private final SimpleStringProperty weightUnit;
    private final SimpleStringProperty companyid;

    public Person(SimpleStringProperty personid, SimpleStringProperty firstname, SimpleStringProperty middlename,
                  SimpleStringProperty lastname, SimpleStringProperty birthday, SimpleStringProperty height,
                  SimpleStringProperty heightUnit, SimpleStringProperty weight, SimpleStringProperty weightUnit,
                  SimpleStringProperty companyid) {
        this.personid = personid;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.birthday = birthday;
        this.height = height;
        this.heightUnit = heightUnit;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.companyid = companyid;
    }

    public Person(PersonType personType) {
        this.personid = new SimpleStringProperty(personType.getPersonid());
        this.firstname = new SimpleStringProperty(personType.getFirstname());
        this.middlename = new SimpleStringProperty(personType.getMiddlename());
        this.lastname = new SimpleStringProperty(personType.getLastname());
        this.birthday = new SimpleStringProperty(personType.getBirthday());
        this.height = new SimpleStringProperty(personType.getPhysicalcharacteristics().getGrowthinmeters().getValue());
        this.heightUnit = new SimpleStringProperty(personType.getPhysicalcharacteristics().getGrowthinmeters().getHeightUnit());
        this.weight = new SimpleStringProperty(personType.getPhysicalcharacteristics().getWeightinkilograms().getValue());
        this.weightUnit = new SimpleStringProperty(personType.getPhysicalcharacteristics().getWeightinkilograms().getWeightUnit());
        this.companyid = new SimpleStringProperty(personType.getWork().getCompanyid());
    }

    public String getPersonid() {
        return personid.get();
    }

    public SimpleStringProperty personidProperty() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid.set(personid);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getMiddlename() {
        return middlename.get();
    }

    public SimpleStringProperty middlenameProperty() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename.set(middlename);
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getBirthday() {
        return birthday.get();
    }

    public SimpleStringProperty birthdayProperty() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public String getHeight() {
        return height.get();
    }

    public SimpleStringProperty heightProperty() {
        return height;
    }

    public void setHeight(String height) {
        this.height.set(height);
    }

    public String getHeightUnit() {
        return heightUnit.get();
    }

    public SimpleStringProperty heightUnitProperty() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit.set(heightUnit);
    }

    public String getWeight() {
        return weight.get();
    }

    public SimpleStringProperty weightProperty() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight.set(weight);
    }

    public String getWeightUnit() {
        return weightUnit.get();
    }

    public SimpleStringProperty weightUnitProperty() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit.set(weightUnit);
    }

    public String getCompanyid() {
        return companyid.get();
    }

    public SimpleStringProperty companyidProperty() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid.set(companyid);
    }
}
