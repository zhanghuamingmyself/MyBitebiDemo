package com.zhanghuaming.mybitebidemo.data;

import java.io.Serializable;

/**
 * Created by zhang on 2017/9/3.
 */

public class Info {
    private Funds funds;


    public Funds getFunds() {
        return funds;
    }

    public void setFunds(Funds funds) {
        this.funds = funds;
    }

    @Override
    public String toString() {
        return "Info{" +
                "funds=" + funds.toString() +
                '}';
    }


}
