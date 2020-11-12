package com.example.okhttp;


import android.widget.ImageView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class okHttpUtil {

    private OkHttpClient okhttpClient = new OkHttpClient();
    private WeakReference<ImageView> imageViewWeakReference;
    Onhttp mOnhttp;

    public void setOnhttp(Onhttp Onhttp){
        this.mOnhttp = Onhttp;
    }
    /**
     * 功能說明：向指定URL發送GET方法的請求
     * @param url 發送請求的URL
     * @param param 請求參數，請求參數應該是 name1=value1&name2=value2 的形式。
     * @return 響應結果
     * @throws IOException
     */
    public void sendGet(String url, String param) throws IOException {
        String result = "";

        String urlNameString =  !param.equals("") ? url + "?" + param : url;

        Request req = new Request.Builder().url(urlNameString).build();
        okhttpClient.newCall(req).enqueue(new Callback() {

            @Override
            public void onFailure(Call arg0, IOException arg1) {

            }

            @Override
            public void onResponse(Call arg0, Response res) throws IOException {
                if(res.isSuccessful()){



                }
            }

        });
    }

}
