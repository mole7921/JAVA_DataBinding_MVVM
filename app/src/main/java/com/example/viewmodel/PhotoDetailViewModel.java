package com.example.viewmodel;


import android.view.View;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.example.ImageCache.DoubleCache;
import com.example.ImageCache.ImageLoader;
import com.example.ImageCache.MD5Encoder;
import com.example.vo.Photo;
import java.util.Observable;

public class PhotoDetailViewModel extends Observable {

    private Photo photo;
    private NavgateTo navgateTo;

    public void setNavgateTo(NavgateTo navgateTo){
        this.navgateTo = navgateTo;
    }


    public PhotoDetailViewModel(Photo photo) {
        this.photo = photo;
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
        navgateTo.naviTo(null);
    }

}
