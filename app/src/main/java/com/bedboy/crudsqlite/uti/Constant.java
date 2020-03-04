package com.bedboy.crudsqlite.uti;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Constant {

    public static String DBFILE = "kalbe_db.db";


    // brand column
    public static String brandTable = "Brand";
    public static String brandID = "intBrandID";
    public static String brandName = "txtBrandName";
    public static String brandDate = "dtInserted";


    //customer column
    public static String custTable = "Customer";
    public static String custID = "intCustomerID";
    public static String custName = "txtCustomerName";
    public static String custAddres = "txtCustomerAddress";
    public static String custBitGender = "bitGender";
    public static String custInserted = "Inserted";


    //product column
    public static String productTable = "Product";
    public static String prodId = "intProductID";
    public static String prodName = "txtProductName";
    public static String prodCode = "txtProductCode";
    public static String prodBrandId = "intBrandID";
    public static String proddtInserted = "dtInserted";


    //sales column
    public static String saleTable = "Pembelian";
    public static String saleId = "intSalesOrderID";
    public static String saleCustId = "intCustomerID";
    public static String saleProdId = "intProductID";
    public static String saleDate = "dtSalesOrder";
    public static String saleQty = "intQty";


    public static String genderPerempuan = "Perempuan";
    public static String genderLaki = "Laki-Laki";

    public static boolean getBitGender(String gender) {
        if (gender.equals(Constant.genderPerempuan)) return false;
        else return true;
    }

    public static String getStringGender(boolean bitGender) {
        if (bitGender) return Constant.genderLaki;
        else return Constant.genderPerempuan;
    }

    public static boolean intToBoolean(int a) {
        if (a > 0) return true;
        else return false;
    }

    public static int booleanToInt(boolean a) {
        if (a) return 1;
        else return 0;
    }

    public static SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
    }

    public static String getDateNow() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String getAllCustomer = "SELECT * from Customer";
    public static String getAllBrand = "SELECT * FROM Brand";
    public static String getProduct = "SELECT * from Product INNER JOIN Brand on Product.intBrandID = Brand.intBrandID";
    public static String getSales = "SELECT Pembelian.*,Customer.txtCustomerName,Product.txtProductName from Pembelian INNER JOIN Product on Pembelian.intProductID = Product.intProductID INNER JOIN Customer on Pembelian.intCustomerID = Customer.intCustomerID";
}
