package app;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import data.*;
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
    private final SimpleStringProperty houseid;
    private final SimpleStringProperty position;

    public Person(SimpleStringProperty personid, SimpleStringProperty firstname, SimpleStringProperty middlename,
                  SimpleStringProperty lastname, SimpleStringProperty birthday, SimpleStringProperty height,
                  SimpleStringProperty heightUnit, SimpleStringProperty weight, SimpleStringProperty weightUnit,
                  SimpleStringProperty companyid, SimpleStringProperty houseid, SimpleStringProperty position) {
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
        this.houseid = houseid;
        this.position = position;
    }

    public Person(String personid, String firstname, String middlename,
                  String lastname, String birthday, String height,
                  String heightUnit, String weight, String weightUnit,
                  String companyid, String houseid, String position) {
        this.personid = new SimpleStringProperty(personid);
        this.firstname = new SimpleStringProperty(firstname);
        this.middlename = new SimpleStringProperty(middlename);
        this.lastname = new SimpleStringProperty(lastname);
        this.birthday = new SimpleStringProperty(birthday);
        this.height = new SimpleStringProperty(height);
        this.heightUnit = new SimpleStringProperty(heightUnit);
        this.weight = new SimpleStringProperty(weight);
        this.weightUnit = new SimpleStringProperty(weightUnit);
        this.companyid = new SimpleStringProperty(companyid);
        this.houseid = new SimpleStringProperty(houseid);
        this.position = new SimpleStringProperty(position);
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
        this.houseid = new SimpleStringProperty(personType.getHouse());
        this.position = new SimpleStringProperty(personType.getWork().getPosition());
    }

    public PersonType mapToPersonType(){
        PersonType personType = new PersonType();
        personType.setPersonid(this.personid.getValue());
        personType.setFirstname(this.firstname.getValue());
        personType.setMiddlename(this.middlename.getValue());
        personType.setLastname(this.lastname.getValue());
        personType.setBirthday(this.birthday.getValue());

        PhysicalcharacteristicsType physicalcharacteristicsType = new PhysicalcharacteristicsType();
        GrowthinmetersType growthinmetersType = new GrowthinmetersType();
        WeightinkilogramsType weightinkilogramsType = new WeightinkilogramsType();

        growthinmetersType.setHeightUnit(this.heightUnit.getValue());
        weightinkilogramsType.setWeightUnit(this.weightUnit.getValue());

        growthinmetersType.setValue(this.height.getValue());
        weightinkilogramsType.setValue(this.weight.getValue());

        physicalcharacteristicsType.setGrowthinmeters(growthinmetersType);
        physicalcharacteristicsType.setWeightinkilograms(weightinkilogramsType);

        personType.setPhysicalcharacteristics(physicalcharacteristicsType);

        WorkType workType = new WorkType();
        workType.setPosition(this.position.getValue());
        workType.setCompanyid(this.companyid.getValue());
        personType.setWork(workType);
        personType.setHouse(this.houseid.getValue());

        return personType;
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

    public String getHouseid() {
        return houseid.get();
    }

    public SimpleStringProperty houseidProperty() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid.set(houseid);
    }

    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }
}
