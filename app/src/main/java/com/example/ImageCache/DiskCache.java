package com.example.ImageCache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.MessageDigest;

public class DiskCache implements ImageCache{

    private static final String CACHE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()+"/PhotoTempCache";

    /**
     * 從本地讀取圖片
     * @param id
     */
    public Bitmap getBitmapFromLocal(String id){

        try {
            File file = new File(CACHE_PATH,id);
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));

            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Bitmap get(String id) {
        return getBitmapFromLocal(id);
    }

    @Override
    public void put(String id, Bitmap bitmap) throws Exception {

        String md5 = MD5Encoder.encode(id);

        Log.e("url",md5);
        File baseFile = new File(CACHE_PATH);

        if (!baseFile.exists() || !baseFile.isDirectory()) {
            baseFile.mkdirs();
        }

        File bitemapFile = new File(baseFile, md5);

        try {
            FileOutputStream fos = new FileOutputStream(bitemapFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
