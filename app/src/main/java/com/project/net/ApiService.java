package com.project.net;

import com.project.mvp.model.ShowApiGifModel;
import com.project.mvp.model.ShowApiModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 于德海 on 2018/3/21.
 * package com.project.net
 * email : yudehai0204@163.com
 *
 * @describe Api接口类
 */

public interface ApiService {
    String BASE_URL = "https://route.showapi.com/";

    @GET("341-1")
    Observable<ShowApiModel.Bean> getShowApiData(@Query("page")int page, @Query("maxResult")int maxResult);
    @GET("341-3")
    Observable<ShowApiGifModel.Bean> getShowApiGifData(@Query("page")int page, @Query("maxResult")int maxResult);//Gif

    @GET("Model/Fun")
    Observable<String> getApi(@Query("id")String id);//示例

    @FormUrlEncoded
    @POST("Model/fun")
    Observable<String> postApi(@QueryMap Map<String,String> map);//示例




}
