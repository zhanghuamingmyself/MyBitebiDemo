package com.zhanghuaming.mybitebidemo.data;

/**
 * Created by zhang on 2017/9/3.
 */

public class TradeItem {
    private String result;
    private String order_id;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TradeItem{" +
                "result='" + result + '\'' +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
