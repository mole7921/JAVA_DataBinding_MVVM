package com.example.retrofit;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    // Singleton
    private static RetrofitManager mInstance = new RetrofitManager();
    private final static String ApiUrl = "https://jsonplaceholder.typicode.com/";
    private ApiService myAPIService;
    private static final int DEFAULT_CONNECT_TIME = 10;
    private static final int DEFAULT_WRITE_TIME = 30;
    private static final int DEFAULT_READ_TIME = 30;
    private final OkHttpClient okHttpClient;

    private RetrofitManager() {

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIME, TimeUnit.SECONDS)//連接超時
                .writeTimeout(DEFAULT_WRITE_TIME, TimeUnit.SECONDS)//寫入操作超時
                .readTimeout(DEFAULT_READ_TIME, TimeUnit.SECONDS)//讀取操作超時
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
         /*
         1.設置baseUrl即要連的網站
         2.混合使用OKHTTP網路請求
         3.addConverterFactory用Gson作為資料處理Converter
         4.採用RXJAVA3回調機制
         */

        myAPIService = retrofit.create(ApiService.class);
    }

    public static RetrofitManager getInstance() {
        return mInstance;
    }

    public ApiService getAPI() {
        return myAPIService;
    }

}
