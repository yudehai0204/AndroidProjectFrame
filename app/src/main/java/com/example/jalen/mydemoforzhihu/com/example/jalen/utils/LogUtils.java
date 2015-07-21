package com.example.jalen.mydemoforzhihu.com.example.jalen.utils;

import android.util.Log;

/**
 * Created by Administrator on 2015/7/17.
 */
public class LogUtils {
    private  static  final  String TAG ="YUDEHAI";
    private  static boolean mShowLog = true;


    private static void d(String msg){
        if(mShowLog){
            Log.d(TAG,"--->"+msg+getLineMethod());
        }

    }

    /***
     * 获得在第几行
     * @return
     */
    public static String getLineMethod() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[2];
        StringBuffer toStringBuffer = new StringBuffer("[")
                .append(traceElement.getLineNumber()).append(" | ")
                .append(traceElement.getMethodName()).append("]");
        return toStringBuffer.toString();
    }


}
