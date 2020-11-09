package com.example.retrofit;

import com.example.vo.Photo;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HttpEngine {

    //統一API調用
    private static ApiService myAPIService = RetrofitManager.getInstance().getAPI();

    public static void fetchPhotos(Consumer<List<Photo>> D, Consumer<Throwable> T, Action A){
        setSubscribe(myAPIService.getDatas(), D , T , A);
    }

    private static <T> void setSubscribe(Observable<T> observable,Consumer<T> D, Consumer<Throwable> T, Action A) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(D,T,A);
    }

}
