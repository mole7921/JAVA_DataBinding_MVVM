package com.example.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    // 以Singleton模式建立
    private static RetrofitManager mInstance = new RetrofitManager();
    private final static String ApiUrl = "https://jsonplaceholder.typicode.com/";
    private ApiService myAPIService;

    private RetrofitManager() {

        // 設置baseUrl即要連的網站，addConverterFactory用Gson作為資料處理Converter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        myAPIService = retrofit.create(ApiService.class);
    }

    public static RetrofitManager getInstance() {
        return mInstance;
    }

    public ApiService getAPI() {
        return myAPIService;
    }
}
