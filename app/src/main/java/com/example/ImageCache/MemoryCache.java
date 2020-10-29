package com.example.ImageCache;

import android.graphics.Bitmap;
import android.util.LruCache;

public class MemoryCache implements ImageCache{
    private LruCache<String,Bitmap> mMemoryCache;

    public MemoryCache(){
        //初始化Lru快取
        initImageCache();
    }

    private void initImageCache() {
        //計算可使用的最大記憶體
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一可使用的記憶體作為快取
        final int cacheSize = maxMemory / 4;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {

            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }



    @Override
    public Bitmap get(String id) {
        return mMemoryCache.get(id);
    }

    @Override
    public void put(String id, Bitmap bitmap) {
        mMemoryCache.put(id,bitmap);
    }
}
