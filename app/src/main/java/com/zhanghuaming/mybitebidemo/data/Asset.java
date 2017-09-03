package com.zhanghuaming.mybitebidemo.data;

/**
 * Created by zhang on 2017/9/3.
 */

public class Asset {
    private String total;
    private String net;


    @Override
    public String toString() {
        return "Asset{" +
                "net='" + net + '\'' +
                ", total='" + total + '\'' +
                '}';
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
