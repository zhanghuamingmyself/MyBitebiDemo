package com.zhanghuaming.mybitebidemo;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * Created by zhang on 2017/7/3.
 */

public class MyApplication extends Application {

    //单例模式
    private static MyApplication mApplication;
    //okhttp
    private OkHttpClient okHttpClient;

    public static synchronized MyApplication getInstance() {
        if (mApplication != null)
            return mApplication;
        else {
            mApplication = new MyApplication();
            return mApplication;
        }
    }

    public OkHttpClient getOkHttpClient() {
        if (okHttpClient != null) {
            return okHttpClient;
        } else {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(8, TimeUnit.SECONDS);
            builder.writeTimeout(8, TimeUnit.SECONDS);
            builder.readTimeout(8, TimeUnit.SECONDS);
            builder.retryOnConnectionFailure(false);
            okHttpClient = builder.build();
            //okHttpClient = new OkHttpClient();
            return okHttpClient;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
