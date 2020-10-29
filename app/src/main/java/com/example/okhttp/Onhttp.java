package com.example.okhttp;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.vo.Photo;

import java.lang.ref.WeakReference;
import java.util.List;

public interface Onhttp{
    void getlist(List<Photo> list);
}
