package com.project.utils;

import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.project.R;
import com.project.base.BaseApplication;

/**
 * Created by 于德海 on 2018/3/21.
 * package com.project.utils
 * email : yudehai0204@163.com
 *
 * @describe
 */

public class ToastManager {
    private static TextView toast_view;
    private static Toast sToast;
    public static void showSnack(View parent, String text){
        Snackbar.make(parent,text,Snackbar.LENGTH_SHORT).show();
    }

    public static void shotToast(String text){
        if(toast_view==null){
            toast_view = (TextView) LayoutInflater.from(BaseApplication.applicationContext).inflate(R.layout.toast_view,null,false);
            sToast = new Toast(BaseApplication.applicationContext);
            sToast.setView(toast_view);
            sToast.setDuration(Toast.LENGTH_SHORT);
        }
        toast_view.setText(text);
        sToast.show();
    }

}
