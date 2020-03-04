package com.bedboy.crudsqlite.model;

import java.util.Date;

public class Pembelian {
    private int intSalesOrderID;
    private int intCustomerID;
    private String custName;
    private int intProductID;
    private String prodName;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    private Date dtSalesOrder;
    private int intQty;

    public int getIntSalesOrderID() {
        return intSalesOrderID;
    }

    public void setIntSalesOrderID(int intSalesOrderID) {
        this.intSalesOrderID = intSalesOrderID;
    }

    public int getIntCustomerID() {
        return intCustomerID;
    }

    public void setIntCustomerID(int intCustomerID) {
        this.intCustomerID = intCustomerID;
    }

    public int getIntProductID() {
        return intProductID;
    }

    public void setIntProductID(int intProductID) {
        this.intProductID = intProductID;
    }

    public Date getDtSalesOrder() {
        return dtSalesOrder;
    }

    public void setDtSalesOrder(Date dtSalesOrder) {
        this.dtSalesOrder = dtSalesOrder;
    }

    public int getIntQty() {
        return intQty;
    }

    public void setIntQty(int intQty) {
        this.intQty = intQty;
    }
}
