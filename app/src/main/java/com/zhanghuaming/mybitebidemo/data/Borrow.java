package com.zhanghuaming.mybitebidemo.data;

/**
 * Created by zhang on 2017/9/3.
 */

public class Borrow {
    private String btc;
    private String bcc;
    private String etc;
    private String eth;
    private String ltc;
    private String cny;

    public String getBtc() {
        return btc;
    }

    public void setBtc(String btc) {
        this.btc = btc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getEth() {
        return eth;
    }

    public void setEth(String eth) {
        this.eth = eth;
    }

    public String getLtc() {
        return ltc;
    }

    public void setLtc(String ltc) {
        this.ltc = ltc;
    }

    public String getCny() {
        return cny;
    }

    public void setCny(String cny) {
        this.cny = cny;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "btc='" + btc + '\'' +
                ", bcc='" + bcc + '\'' +
                ", etc='" + etc + '\'' +
                ", eth='" + eth + '\'' +
                ", ltc='" + ltc + '\'' +
                ", cny='" + cny + '\'' +
                '}';
    }
}
