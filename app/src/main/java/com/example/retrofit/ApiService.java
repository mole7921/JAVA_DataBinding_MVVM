package com.example.retrofit;

import com.example.vo.Photo;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    // 測試網站      https://jsonplaceholder.typicode.com/
    // GET網址      https://jsonplaceholder.typicode.com/photos
    // POST網址     https://jsonplaceholder.typicode.com/photos
    // ...typicode.com/[這裡就是API的路徑]



    @GET("photos")    // 設置一個GET連線，路徑為photos
    Observable<List<Photo>> getDatas();    // 取得的回傳資料用Albums物件接收，連線名稱取為getDatas

    @GET("photos/{id}") // 用{}表示路徑參數，@Path會將參數帶入至該位置
    Call<Photo> getAlbumsById(@Path("id") int id);

    @POST("photos") // 用@Body表示要傳送Body資料
    Call<Photo> postAlbums(@Body Photo xxxxx);

//    測試網址的POST是用Body方式收參數所以我們用@Body，若是要用問號帶在網址後的參數如?id=1則應改用@Query
}
