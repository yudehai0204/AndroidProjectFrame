package com.project.utils;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.project.R;


/**
 * Created by 于德海 on 2018/9/4.
 * package rjh.yilin.utils
 * email : yudehai0204@163.com
 *
 * @describe  弹窗工具类 把一些通用的可以添加到这个里边
 */
public class MaterialDesignDialogUtils {

    public static void showDeleteDialog(Context context, MaterialDialog.ButtonCallback callback){
        showDeleteDialog(context,"是否删除此条数据?",callback);
    }
    public static void showDeleteDialog(Context context,String content, MaterialDialog.ButtonCallback callback){
        new MaterialDialog.Builder(context)
                .title("亿林提示")
                .content(content)
                .positiveText("确认")
                .negativeText("取消")
                .positiveColorRes(R.color.app_theme_color)
                .callback(callback)
                .show();
    }








    public static MaterialDialog showDownloadDialog(Context context,String content,MaterialDialog.SingleButtonCallback callback){
        return  new MaterialDialog.Builder(context)
                .title("版本更新")
                .content(content)
                .cancelable(false)
                .autoDismiss(false)
                .progress(false,100)
                .widgetColorRes(R.color.app_theme_color)
                .positiveText("确定下载")
                .negativeText("下次再说")
                .positiveColorRes(R.color.app_theme_color)
                .onPositive(callback)
                .onNegative(callback)
                .show();
    }
}
