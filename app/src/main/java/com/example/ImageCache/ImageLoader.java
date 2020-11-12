package com.example.ImageCache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ImageLoader {
    private static ImageLoader instance;
    //圖片快取
    private static ImageCache mImageCache;
    private ExecutorService mExecutorService = Executors.newFixedThreadPool
            (Runtime.getRuntime().availableProcessors());


    public static ImageLoader getInstance(ImageCache cache){
        mImageCache = cache;

        if(instance == null){
            instance = new ImageLoader();
        }
        return instance;
    }

    public void displayImage(String url, ImageView imageView){
        String md5 = "";
        try {
             md5 = MD5Encoder.encode(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Bitmap bitmap = mImageCache.get(md5);
        if(bitmap != null){
            if(md5.equals(imageView.getTag())) {
                imageView.setImageBitmap(bitmap);
            }
            return;
        }

        submitLoadRequest(url, imageView);
    }

    private void submitLoadRequest(final String url,final ImageView imageView){
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = null;
                try {
                    bitmap = downloadImage(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(bitmap == null){
                    return;
                }

                try {
                    String md5 = MD5Encoder.encode(url);
                    if(md5.equals(imageView.getTag())) {
                        imageView.setImageBitmap(bitmap);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


                try {
                    mImageCache.put(url,bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Bitmap downloadImage(String url) throws IOException{
        OkHttpClient okhttpClient = new OkHttpClient();
        Bitmap bitmap = null;
        Request req = new Request.Builder().url(url).header("user-agent", "Chrome 74 on Windows 10").build();
        Response response = okhttpClient.newCall(req).execute();

        if (!response.isSuccessful())
        {
            throw new IOException("Unexpected code " + response);
        }
        if (response.body().contentType().toString().toLowerCase().contains("application/json") || response.body().contentType().toString().toLowerCase().contains("text/plain")) {
            throw new IOException("下載資源失敗,下載地址為=" + url);
        }
        else
        {
            bitmap = BitmapFactory.decodeStream(
                    new BufferedInputStream(response.body().byteStream()));
        }


        return bitmap;
    }


}
