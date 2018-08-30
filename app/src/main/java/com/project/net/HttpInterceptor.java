package com.project.net;

import com.project.app.AppConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.net
 * email : yudehai0204@163.com
 *
 * @describe  设置公共请求头
 */

public class HttpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        //设置请求头
        Request request =originalRequest.newBuilder()
                            .header("imei", AppConfig.IMEI)
                            .method(originalRequest.method(),originalRequest.body())
                            .build();
        //设置公共参数
        HttpUrl httpUrl = request.url().newBuilder()
                            .addQueryParameter("imei",AppConfig.IMEI)
                            .build();
        request = request.newBuilder().url(httpUrl).build();
        return chain.proceed(request);
    }
}
