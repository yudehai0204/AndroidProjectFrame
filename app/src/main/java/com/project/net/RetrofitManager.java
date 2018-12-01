package com.project.net;

import android.util.Log;

import com.project.app.AppConstants;
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
 * @describe Refrofit封装类
 * 使用方式  RetrofitManager.getApiService()
 * or   RetrofitManager.getInstance().create(T.class)
 */

public class RetrofitManager {
    private Retrofit mRetrofit;
    /**
     * RetrofitManager
     *
     * @return
     */
    public static RetrofitManager getInstance() {
        return RetrofitManager.SingletonHolder.INSTANCE;
    }

    /**
     * 获取对应的Service
     *
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

    /***
     *
     * @return 网络请求类
     */
    public static ApiService getApiService() {
        return getInstance().create(ApiService.class);
    }

    private static class SingletonHolder {
        private static final RetrofitManager INSTANCE = new RetrofitManager();
    }

    private RetrofitManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("AndroidFrame",message);
            }
        });
        if (AppConstants.APP_DEBUG)
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//设置Log日志
        else
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);//

        //缓存设置
        File cacheFile = new File(BaseApplication.applicationContext.getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 50 * 1024 * 1024);//50M

        //设置Client
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(interceptor)//设置日志拦截器
                .addInterceptor(new HttpInterceptor())//设置公共头，参数
                .cache(cache)
                .connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(100L, TimeUnit.SECONDS)//上传时间100L
                .build();

        //获取retrofit实例
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//关联rxjava  Observable 代替call
                .addConverterFactory(GsonConverterFactory.create())//Data解析
                .build();
    }


}
