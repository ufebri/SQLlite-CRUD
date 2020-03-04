package com.bedboy.crudsqlite.model;

import java.util.Date;

public class Brand {
    private int intBrandID;
    private String txtBrandName;
    private Date dtInserted;

    public Brand() {
    }

    public Brand(String txtBrandName) {
        this.txtBrandName = txtBrandName;
        this.dtInserted = new Date();

    }

    public int getIntBrandID() {
        return intBrandID;
    }

    public void setIntBrandID(int intBrandID) {
        this.intBrandID = intBrandID;
    }

    public String getTxtBrandName() {
        return txtBrandName;
    }

    public void setTxtBrandName(String txtBrandName) {
        this.txtBrandName = txtBrandName;
    }

    public Date getDtInserted() {
        return dtInserted;
    }

    public void setDtInserted(Date dtInserted) {
        this.dtInserted = dtInserted;
    }
}
