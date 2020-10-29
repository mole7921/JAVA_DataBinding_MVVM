package com.example.ImageCache;

import android.graphics.Bitmap;

public interface ImageCache {
    Bitmap get(String id);
    void put(String id , Bitmap bitmap) throws Exception;
}
