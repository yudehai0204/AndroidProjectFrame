package com.project.net;

import com.project.Constants;
import com.project.base.BaseApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 于德海 on 2018/3/21.
 * package com.project.net
 * email : yudehai0204@163.com
 *
 * @describe  Refrofit封装类
 * 使用方式  RetrofitManager.getRetrofit().getApiService()
 */

public class RetrofitManager {
    private static OkHttpClient client =null;
    private static Retrofit retrofit=null;

    /***
     *
     * @return  网络请求类
     */
    public static ApiService getApiService(){
        return getRetrofit().create(ApiService.class);
    }

    private RetrofitManager(){

    }

    private static  Retrofit getRetrofit(){
        if(retrofit==null){
            synchronized (RetrofitManager.class)
            {
                if(retrofit==null){
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    if(Constants.APP_DEBUG)
                        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//设置Log日志
                    else
                        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);//

                    //缓存设置
                    File cacheFile = new File(BaseApplication.context.getCacheDir(),"cache");
                    Cache cache = new Cache(cacheFile,50*1024*1024);//50M

                    //设置Client
                    client = new OkHttpClient().newBuilder()
                            .addInterceptor(interceptor)//设置日志拦截器
                            .addInterceptor(new HttpInterceptor())//设置公共头，参数
                            .cache(cache)
                            .connectTimeout(60L, TimeUnit.SECONDS)
                            .readTimeout(60L,TimeUnit.SECONDS)
                            .writeTimeout(100L,TimeUnit.SECONDS)//上传时间100L
                            .build();

                    //获取retrofit实例
                    retrofit = new Retrofit.Builder()
                            .baseUrl(ApiService.BASE_URL)
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//关联rxjava  Observable 代替call
                            .addConverterFactory(GsonConverterFactory.create())//Data解析
                            .build();

                }
            }
        }


        return retrofit;
    }
}
