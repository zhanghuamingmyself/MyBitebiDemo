package com.zhanghuaming.mybitebidemo.data;

/**
 * Created by zhang on 2017/9/3.
 */

public class MyInfo {
    private Boolean result;
    private Info info;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "MyInfo{" +
                "result='" + result + '\'' +
                ", info=" + info.toString() +
                '}';
    }
}
