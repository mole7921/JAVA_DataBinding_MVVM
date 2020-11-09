package com.example.viewmodel;


import android.util.Log;

import com.example.retrofit.ApiService;
import com.example.retrofit.HttpEngine;
import com.example.vo.Photo;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;



public class PhotoViewModel extends Observable {
    private List<Photo> photos;

    public PhotoViewModel() {
        photos = new ArrayList<>();
        initData();
    }

    private void initData() {
      HttpEngine.fetchPhotos(
              photos -> changePhotos(photos),
              throwable -> Log.e("Error:",throwable.getMessage()),
              () -> Log.e("onComplete:","Task onComplete")
      );

      /* lambda精簡前寫法
        HttpEngine.fetchPhotos(new Consumer<List<Photo>>() {
            @Override
            public void accept(@NonNull List<Photo> photos) throws Exception {
                changePhotos(photos);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                //對應onError()
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                //對應onComplete()
            }
        });
      */
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
