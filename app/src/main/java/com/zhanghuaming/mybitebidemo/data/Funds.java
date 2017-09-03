package com.zhanghuaming.mybitebidemo.data;

import java.io.Serializable;

/**
 * Created by zhang on 2017/9/3.
 */

public class Funds {

    private Borrow borrow;
    private Asset asset;
    private Free free;
    private Freezed freezed;

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Free getFree() {
        return free;
    }

    public void setFree(Free free) {
        this.free = free;
    }

    public Freezed getFreezed() {
        return freezed;
    }

    public void setFreezed(Freezed freezed) {
        this.freezed = freezed;
    }

    @Override
    public String toString() {
        return "Funds{" +
                "borrow=" + borrow +
                ", asset=" + asset +
                ", free=" + free +
                ", freezed=" + freezed +
                '}';
    }
}
