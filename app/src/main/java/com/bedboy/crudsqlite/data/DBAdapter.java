package com.bedboy.crudsqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bedboy.crudsqlite.model.Brand;
import com.bedboy.crudsqlite.model.Customer;
import com.bedboy.crudsqlite.model.Pembelian;
import com.bedboy.crudsqlite.model.Product;
import com.bedboy.crudsqlite.uti.Constant;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DBAdapter extends SQLiteAssetHelper {

    private Context context;

    public DBAdapter(Context context, int version) {
        super(context, Constant.DBFILE, null, version);
        this.context = context;
    }

    public List<Brand> getBrand() {
        List<Brand> brandList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(Constant.getAllBrand, null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            Brand brand = new Brand();
            brand.setIntBrandID(cursor.getInt(cursor.getColumnIndex(Constant.brandID)));
            brand.setTxtBrandName(cursor.getString(cursor.getColumnIndex(Constant.brandName)));
            brandList.add(brand);
        } else {
            while (cursor.moveToNext()) {
                Brand brand = new Brand();
                brand.setIntBrandID(cursor.getInt(cursor.getColumnIndex(Constant.brandID)));
                brand.setTxtBrandName(cursor.getString(cursor.getColumnIndex(Constant.brandName)));
                brandList.add(brand);
            }
        }
        cursor.close();
        return brandList;
    }

    public void persistBrand(Brand brand) {
        DateFormat dateFormat = Constant.getDateFormat();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.brandName, brand.getTxtBrandName());
        contentValues.put(Constant.brandDate, Constant.getDateNow());
        db.insertOrThrow(Constant.brandTable, null, contentValues);
    }

    public List<Customer> getCustomer() {
        List<Customer> customerList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(Constant.getAllCustomer, null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            Customer customer = new Customer();
            customer.setIntCustomerID(cursor.getInt(cursor.getColumnIndex(Constant.custID)));
            customer.setTxtCustomerName(cursor.getString(cursor.getColumnIndex(Constant.custName)));
            customer.setTxtCustomerAddress(cursor.getString(cursor.getColumnIndex(Constant.custAddres)));
            customer.setBitGender(Constant.intToBoolean(cursor.getInt(cursor.getColumnIndex(Constant.custBitGender))));
            try {
                customer.setInserted(Constant.getDateFormat().parse(cursor.getString(cursor.getColumnIndex(Constant.custInserted))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            customerList.add(customer);
        } else {
            while (cursor.moveToNext()) {
                Customer customer = new Customer();
                customer.setIntCustomerID(cursor.getInt(cursor.getColumnIndex(Constant.custID)));
                customer.setTxtCustomerName(cursor.getString(cursor.getColumnIndex(Constant.custName)));
                customer.setTxtCustomerAddress(cursor.getString(cursor.getColumnIndex(Constant.custAddres)));
                customer.setBitGender(Constant.intToBoolean(cursor.getInt(cursor.getColumnIndex(Constant.custBitGender))));
                try {
                    customer.setInserted(Constant.getDateFormat().parse(cursor.getString(cursor.getColumnIndex(Constant.custInserted))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                customerList.add(customer);
            }
        }
        cursor.close();
        return customerList;
    }

    public void persistCust(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.custName, customer.getTxtCustomerName());
        contentValues.put(Constant.custAddres, customer.getTxtCustomerAddress());
        contentValues.put(Constant.custBitGender, Constant.booleanToInt(customer.isBitGender()));
        contentValues.put(Constant.custInserted, Constant.getDateNow());
        db.insertOrThrow(Constant.custTable, null, contentValues);
    }

    public List<Product> getProduct() {
        List<Product> productList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(Constant.getProduct, null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            Product product = new Product();
            product.setIntProductID(cursor.getInt(cursor.getColumnIndex(Constant.prodId)));
            product.setIntBrandID(cursor.getInt(cursor.getColumnIndex(Constant.prodId)));
            product.setTxtProductName(cursor.getString(cursor.getColumnIndex(Constant.prodName)));
            product.setBrandName(cursor.getString(cursor.getColumnIndex(Constant.brandName)));
            product.setTxtProductCode(cursor.getString(cursor.getColumnIndex(Constant.prodCode)));
            try {
                product.setDtInserted(Constant.getDateFormat().parse(cursor.getString(cursor.getColumnIndex(Constant.proddtInserted))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            productList.add(product);
        } else {
            while (cursor.moveToNext()) {
                Product product = new Product();
                product.setIntProductID(cursor.getInt(cursor.getColumnIndex(Constant.prodId)));
                product.setIntBrandID(cursor.getInt(cursor.getColumnIndex(Constant.prodId)));
                product.setTxtProductName(cursor.getString(cursor.getColumnIndex(Constant.prodName)));
                product.setBrandName(cursor.getString(cursor.getColumnIndex(Constant.brandName)));
                product.setTxtProductCode(cursor.getString(cursor.getColumnIndex(Constant.prodCode)));
                try {
                    product.setDtInserted(Constant.getDateFormat().parse(cursor.getString(cursor.getColumnIndex(Constant.proddtInserted))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                productList.add(product);
            }
        }
        cursor.close();
        return productList;
    }

    public void persistProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.prodBrandId, product.getIntBrandID());
        contentValues.put(Constant.prodName, product.getTxtProductName());
        contentValues.put(Constant.prodCode, product.getTxtProductCode());
        contentValues.put(Constant.proddtInserted, Constant.getDateNow());
        db.insertOrThrow(Constant.productTable, null, contentValues);
    }


    public List<Pembelian> getSales() {
        List<Pembelian> saleList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(Constant.getSales, null);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            Pembelian sale = new Pembelian();
            sale.setIntSalesOrderID(cursor.getInt(cursor.getColumnIndex(Constant.saleId)));
            sale.setCustName(cursor.getString(cursor.getColumnIndex(Constant.custName)));
            sale.setIntCustomerID(cursor.getInt(cursor.getColumnIndex(Constant.saleCustId)));
            sale.setIntProductID(cursor.getInt(cursor.getColumnIndex(Constant.saleProdId)));
            sale.setProdName(cursor.getString(cursor.getColumnIndex(Constant.prodName)));
            sale.setIntQty(cursor.getInt(cursor.getColumnIndex(Constant.saleQty)));
            try {
                sale.setDtSalesOrder(Constant.getDateFormat().parse(cursor.getString(cursor.getColumnIndex(Constant.saleDate))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            saleList.add(sale);
        } else {
            while (cursor.moveToNext()) {
                Pembelian sale = new Pembelian();
                sale.setIntSalesOrderID(cursor.getInt(cursor.getColumnIndex(Constant.saleId)));
                sale.setCustName(cursor.getString(cursor.getColumnIndex(Constant.custName)));
                sale.setIntCustomerID(cursor.getInt(cursor.getColumnIndex(Constant.saleCustId)));
                sale.setIntProductID(cursor.getInt(cursor.getColumnIndex(Constant.saleProdId)));
                sale.setProdName(cursor.getString(cursor.getColumnIndex(Constant.prodName)));
                sale.setIntQty(cursor.getInt(cursor.getColumnIndex(Constant.saleQty)));
                try {
                    sale.setDtSalesOrder(Constant.getDateFormat().parse(cursor.getString(cursor.getColumnIndex(Constant.saleDate))));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                saleList.add(sale);
            }
        }
        cursor.close();
        return saleList;
    }

    public void persistSale(Pembelian sale) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.saleCustId, sale.getIntCustomerID());
        contentValues.put(Constant.saleProdId, sale.getIntProductID());
        contentValues.put(Constant.saleQty, sale.getIntQty());
        contentValues.put(Constant.saleDate, Constant.getDateNow());
        db.insertOrThrow(Constant.saleTable, null, contentValues);
    }
}
