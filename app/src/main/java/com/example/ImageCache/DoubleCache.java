package com.example.ImageCache;

import android.graphics.Bitmap;

public class DoubleCache implements ImageCache{
    ImageCache mMemoryCache = new MemoryCache();
    ImageCache mDiskCache = new DiskCache();


    @Override
    public Bitmap get(String id) {
        Bitmap bitmap = mMemoryCache.get(id);
        if(bitmap == null){
            bitmap = mDiskCache.get(id);
        }
        return bitmap;
    }

    @Override
    public void put(String id, Bitmap bitmap) throws Exception {
        mMemoryCache.put(id,bitmap);
        mDiskCache.put(id,bitmap);
    }
}
