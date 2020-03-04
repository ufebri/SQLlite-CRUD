package com.bedboy.crudsqlite.model;

import java.util.Date;

public class Product {
    private int intProductID;
    private String txtProductCode;
    private String txtProductName;
    private Date dtInserted;
    private int intBrandID;
    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getIntProductID() {
        return intProductID;
    }

    public void setIntProductID(int intProductID) {
        this.intProductID = intProductID;
    }

    public String getTxtProductCode() {
        return txtProductCode;
    }

    public void setTxtProductCode(String txtProductCode) {
        this.txtProductCode = txtProductCode;
    }

    public String getTxtProductName() {
        return txtProductName;
    }

    public void setTxtProductName(String txtProductName) {
        this.txtProductName = txtProductName;
    }

    public Date getDtInserted() {
        return dtInserted;
    }

    public void setDtInserted(Date dtInserted) {
        this.dtInserted = dtInserted;
    }

    public int getIntBrandID() {
        return intBrandID;
    }

    public void setIntBrandID(int intBrandID) {
        this.intBrandID = intBrandID;
    }
}
