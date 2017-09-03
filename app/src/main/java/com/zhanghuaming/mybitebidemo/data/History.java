package com.zhanghuaming.mybitebidemo.data;

/**
 * Created by zhang on 2017/9/3.
 */

public class History {
    private String amount;
    private String date;
    private String date_ms;
    private String price;
    private String tid;
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_ms() {
        return date_ms;
    }

    public void setDate_ms(String date_ms) {
        this.date_ms = date_ms;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "History{" +
                "date='" + date + '\'' +
                ", date_ms='" + date_ms + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", tid='" + tid + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
