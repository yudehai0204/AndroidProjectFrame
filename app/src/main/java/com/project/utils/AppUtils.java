package com.project.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.security.MessageDigest;

/**
 * Created by 于德海 on 2018/3/21.
 * package com.project.utils
 * email : yudehai0204@163.com
 *
 * @describe  App工具类
 */

public class AppUtils {
    /**
     * 应用运行的最大内存
     */
     public static Long getMaxMemory(){
         return Runtime.getRuntime().maxMemory() / 1024;
     }

    /***
     * 获取版本号
     * @param context
     * @return 版本号
     */
    public static int getAppVersionCode(Context context){
        int version_code = -1;
        if(getPackageInfo(context)!=null)
           version_code= getPackageInfo(context).versionCode;
        return version_code;
    }

    public static PackageInfo getPackageInfo(Context context){
        PackageInfo packageInfo =null;
        try {
            context.getPackageManager().getPackageInfo(context.getPackageName(),0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }

    /***
     * 获取版本名
     * @param context
     * @return 版本号
     */
    public static String getAppVersionName(Context context){
        String version_name = "0";
        if(getPackageInfo(context)!=null)
            version_name= getPackageInfo(context).versionName;
        return version_name;
    }

    /***
     * 返回应用签名
     * @param context
     */
    public String getAppSign(Context context){
        try {
            PackageInfo info =context.getPackageManager().getPackageInfo(context.getPackageName(),PackageManager.GET_SIGNATURES);
            return hexDigest(info.signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 将签名字符串转换成需要的32位签名
     *
     * @param
     * @return 32位签名字符串
     */
    private String hexDigest(byte[] paramArrayOfByte)  {
        char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55,
                56, 57, 97, 98, 99, 100, 101, 102 };
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramArrayOfByte);
            byte[] arrayOfByte = localMessageDigest.digest();
            char[]  arrayOfChar = new char[32];
            int  i = 0;
            int  j = 0;
            while (true) {
                if (i >= 16) {
                    return new String(arrayOfChar);
                }
                int k = arrayOfByte[i];
                arrayOfChar[j] = hexDigits[0xF &k>>>4];
                arrayOfChar[++j] = hexDigits[k & 0xF];
                i++;
                j++;
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
