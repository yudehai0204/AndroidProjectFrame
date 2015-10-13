package com.example.jalen.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Jalen on 2015/7/28.
 */
public class ToastUtils {
    private Context mContext;
    private Toast mToast;

    public ToastUtils(Context mContext) {
        this.mContext = mContext;
    }


    public void showToast(String text){
        if(mToast==null) {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
        }else {
            mToast.setText(text);
        }
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.setGravity(Gravity.CENTER,0,0);
        mToast.show();
    }
    public void cancle(){
        mToast.cancel();
        mToast=null;
    }

}
