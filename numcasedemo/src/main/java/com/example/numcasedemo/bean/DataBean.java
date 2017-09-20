package com.example.numcasedemo.bean;

/**
 * Created by Administrator on 2017/9/20.
 */

public class DataBean {
    private int price;
    private int sales;

    public DataBean(int price, int sales) {
        this.price = price;
        this.sales = sales;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
