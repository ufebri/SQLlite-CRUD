package com.bedboy.crudsqlite.model;

import java.util.Date;

public class Customer {
    private int intCustomerID;
    private String txtCustomerName;
    private String txtCustomerAddress;
    private boolean bitGender;
    private Date Inserted;

    public int getIntCustomerID() {
        return intCustomerID;
    }

    public void setIntCustomerID(int intCustomerID) {
        this.intCustomerID = intCustomerID;
    }

    public String getTxtCustomerName() {
        return txtCustomerName;
    }

    public void setTxtCustomerName(String txtCustomerName) {
        this.txtCustomerName = txtCustomerName;
    }

    public String getTxtCustomerAddress() {
        return txtCustomerAddress;
    }

    public void setTxtCustomerAddress(String txtCustomerAddress) {
        this.txtCustomerAddress = txtCustomerAddress;
    }

    public boolean isBitGender() {
        return bitGender;
    }

    public void setBitGender(boolean bitGender) {
        this.bitGender = bitGender;
    }

    public Date getInserted() {
        return Inserted;
    }

    public void setInserted(Date inserted) {
        Inserted = inserted;
    }
}
