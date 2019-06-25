
package data;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productType", propOrder = {
    "value"
})
public class ProductType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "productid")
    protected String productid;
    @XmlAttribute(name = "companyid")
    protected String companyid;


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public String getProductid() {
        return productid;
    }


    public void setProductid(String value) {
        this.productid = value;
    }


    public String getCompanyid() {
        return companyid;
    }


    public void setCompanyid(String value) {
        this.companyid = value;
    }

}
