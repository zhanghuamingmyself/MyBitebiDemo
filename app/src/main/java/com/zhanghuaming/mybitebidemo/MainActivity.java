package com.zhanghuaming.mybitebidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhanghuaming.mybitebidemo.data.History;
import com.zhanghuaming.mybitebidemo.data.MyInfo;
import com.zhanghuaming.mybitebidemo.data.TradeItem;
import com.zhanghuaming.mybitebidemo.utils.MD5Util;
import com.zhanghuaming.mybitebidemo.utils.NetConstant;
import com.zhanghuaming.mybitebidemo.utils.SLog;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 中国站 apiKey:
 * 中国站 secretKey:
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String apiKey = 你的apiKey;
    private String secretKey = 你的secretKey;

    private Button btnGetInfo, btnGetHistory, btnSpend;
    private TextView tv;

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gson = new Gson();
        initView();

    }

    private void initView() {
        btnGetHistory = (Button) findViewById(R.id.btn_gethistory);
        btnGetInfo = (Button) findViewById(R.id.btn_getinfo);
        btnSpend = (Button) findViewById(R.id.btn_spend);
        btnGetHistory.setOnClickListener(this);
        btnGetInfo.setOnClickListener(this);
        btnSpend.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_gethistory:
                getHistory("110", "btc_cny");
                break;
            case R.id.btn_getinfo:
                getMyInfo();
                break;
            case R.id.btn_spend:
                getTrade("buy", "btc_cny", "0", "0");
                break;
            default:
                break;
        }
    }

    private void uiPrintf(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (tv != null) {
                    tv.setText(str);
                }
            }
        });
    }

    public void getMyInfo() {
        String baseURL = NetConstant.getMyInfoAddr;
        OkHttpClient okHttpClient = MyApplication.getInstance().getOkHttpClient();
        Request.Builder builder = new Request.Builder();

        Map<String, String> map = new HashMap<>();
        map.put("api_key", apiKey);
        String sign = MD5Util.buildMysignV1(map, secretKey);
        FormBody body = new FormBody.Builder()
                .add("api_key", apiKey)
                .add("sign", sign)
                .build();
        Request request = builder.url(baseURL).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "ok  get fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseString = response.body().string();
                //SLog.i(TAG, "Response   body  is " +responseString );

                try {
                    java.lang.reflect.Type type = new TypeToken<MyInfo>() {}.getType();
                    MyInfo jsonBean = gson.fromJson(responseString, type);
                    //SLog.i(TAG, "数据为----------" + jsonBean.toString());
                    uiPrintf("数据为----------" + jsonBean.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    SLog.i(TAG, e.toString());
                }
            }
        });
    }


    public void getHistory(String since, String symbol) {
        String baseURL = NetConstant.getHistoryAddr;
        OkHttpClient okHttpClient = MyApplication.getInstance().getOkHttpClient();
        Request.Builder builder = new Request.Builder();

        Map<String, String> map = new HashMap<>();
        map.put("api_key", apiKey);
        map.put("since", since);
        map.put("symbol", symbol);

        String sign = MD5Util.buildMysignV1(map, secretKey);
        FormBody body = new FormBody.Builder().add("api_key", apiKey)
                .add("symbol", symbol)
                .add("since", since)
                .add("sign", sign)
                .build();
        Request request = builder.url(baseURL).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                SLog.e(TAG, "ok  get fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseString = response.body().string();
                SLog.i(TAG, "Response   body  is " + responseString);

                try {
                    Type lt = new TypeToken<List<History>>() {}.getType();
                    final List<History> list = gson.fromJson(responseString, lt);
                    StringBuffer listString = new StringBuffer("数据为=======");
                    for (History h : list) {
                        listString.append(h.toString());
                    }
                    SLog.i(TAG, listString.toString());
                    uiPrintf(listString.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    SLog.i(TAG, e.toString());
                }
            }
        });
    }

    public void getTrade(String type, String symbol, String price, String amount) {
        String baseURL = NetConstant.getTradeAddr;
        OkHttpClient okHttpClient;
        okHttpClient = MyApplication.getInstance().getOkHttpClient();
        Request.Builder builder = new Request.Builder();

        Map<String, String> map = new HashMap<>();
        if (amount != null) map.put("amount", amount);
        map.put("api_key", apiKey);
        if (price != null) map.put("price", price);
        map.put("symbol", symbol);
        map.put("type", type);

        String sign = MD5Util.buildMysignV1(map, secretKey);
        FormBody body = new FormBody.Builder()
                .add("api_key", apiKey)
                .add("symbol", symbol)
                .add("type", type)
                .add("price", price)
                .add("amount", amount)
                .add("sign", sign)
                .build();
        Request request = builder.url(baseURL).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "ok  get fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseString = response.body().string();
                SLog.i(TAG, "Response   body  is " + responseString);

                try {
                    java.lang.reflect.Type type = new TypeToken<TradeItem>() {
                    }.getType();
                    TradeItem jsonBean = gson.fromJson(responseString, type);
                    SLog.i(TAG, "数据为----------" + jsonBean.toString());
                    uiPrintf("数据为----------" + jsonBean.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    SLog.i(TAG, e.toString());
                }
            }
        });
    }
}
