package com.zhanghuaming.mybitebidemo.data;

/**
 * Created by zhang on 2017/9/3.
 */

public class Union_fund {
    private String btc;
    private String ltc;

    @Override
    public String toString() {
        return "Union_fund{" +
                "btc='" + btc + '\'' +
                ", ltc='" + ltc + '\'' +
                '}';
    }

    public String getBtc() {
        return btc;
    }

    public void setBtc(String btc) {
        this.btc = btc;
    }

    public String getLtc() {
        return ltc;
    }

    public void setLtc(String ltc) {
        this.ltc = ltc;
    }
}
