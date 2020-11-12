package com.example.viewmodel;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import com.example.ImageCache.DoubleCache;
import com.example.ImageCache.ImageLoader;
import com.example.ImageCache.MD5Encoder;
import com.example.vo.Photo;

public class PhotoItemViewModel extends BaseObservable {

    private Photo photo;
    NavgateTo navgateTo;

    public void setNavgateTo(NavgateTo navgateTo){
        this.navgateTo = navgateTo;
    }

    public PhotoItemViewModel(Photo photo,NavgateTo navgateTo) {
        this.photo = photo;
        this.setNavgateTo(navgateTo);
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView view, String url) {

        String md5 = null;
        try {
            md5 = MD5Encoder.encode(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        view.setTag(md5);

        ImageLoader.getInstance(new DoubleCache()).displayImage(url,view);
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        notifyChange();
    }

    public String getImageUrl() {
        return photo.getThumbnailUrl();
    }

    public String getTitle() {
        return photo.getTitle();
    }

    public String getId(){
        return photo.getId();
    }

    public void onItemClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("photo",photo);
        navgateTo.naviTo(bundle);
    }

}
