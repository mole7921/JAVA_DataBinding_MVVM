package com.example.viewmodel;


import com.example.retrofit.ApiService;
import com.example.retrofit.RetrofitManager;
import com.example.vo.Photo;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class PhotoViewModel extends Observable {
    private List<Photo> photos;
    private ApiService myAPIService;

    public PhotoViewModel() {
        photos = new ArrayList<>();
        fetchPhotos();
    }

    private void fetchPhotos() {
        myAPIService = RetrofitManager.getInstance().getAPI();
        myAPIService.getDatas()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(photos -> changePhotos(photos));
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    private void changePhotos(List<Photo> photos) {
        this.photos.addAll(photos);
        setChanged();
        notifyObservers();
    }


}
