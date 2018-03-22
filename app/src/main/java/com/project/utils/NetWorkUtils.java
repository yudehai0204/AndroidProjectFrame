package com.project.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.utils
 * email : yudehai0204@163.com
 *
 * @describe
 */

public class NetWorkUtils {


    private static NetworkInfo getNetWorkInfo(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return manager.getActiveNetworkInfo();

    }

    /***
     *
     * @param context
     * @return  是否有网
     */
    public static Boolean isNetWorkAvailable(Context context){
        NetworkInfo networkInfo = getNetWorkInfo(context);
        if(networkInfo==null)
            return false;
        return networkInfo.isAvailable();
    }

    /***
     *
     * @param context
     * @return 判断网络类型
     */
    public static Boolean isWifi(Context context){
        NetworkInfo networkInfo = getNetWorkInfo(context);
        if(networkInfo==null)
            return false;
        return networkInfo.getType()==ConnectivityManager.TYPE_WIFI;
    }
}
