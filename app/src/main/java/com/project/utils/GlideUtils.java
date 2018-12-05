package com.project.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.project.R;



public class GlideUtils {





  /**
     * 加载图片
     *
     * @param context  context
     * @param iv       imageView
     * @param url      图片地址
     *
     */
    public static void loadImage(Context context, ImageView iv, String url) {
        if (!TextUtils.isEmpty(url)) {
            GlideApp.with(context)
                    .load(url)
                    .error(R.drawable.default_bg)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(iv);
        } else {
            loadImage(context, iv, R.drawable.default_bg, R.drawable.default_bg);
        }
    }
    public static void loadImage(Context context, ImageView iv, String url,int default_res) {
        if (!TextUtils.isEmpty(url)) {
            GlideApp.with(context)
                    .load(url)
                    .error(default_res)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(iv);
        } else {
            loadImage(context, iv,default_res, default_res);
        }
    }
    /**
     * 加载圆角图片
     *
     * @param context  context
     * @param iv       imageView
     * @param url      图片地址
     *
     */
    public static void loadRoundImage(Context context, ImageView iv, String url) {
        if (!TextUtils.isEmpty(url)) {
            GlideApp.with(context)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .transform(new RoundedCorners(20)).into(iv);
        } else {
            loadRoundImage(context, iv, R.drawable.default_bg, R.drawable.default_bg);
        }
    }

    /**
     * 加载圆形图片
     *
     * @param context  context
     * @param iv       imageView
     * @param url      图片地址
     * @param emptyImg 默认展位图
     */
    public static void loadCircleImage(Context context, ImageView iv, String url, int emptyImg) {
        if (!TextUtils.isEmpty(url)) {
            GlideApp.with(context)
                    .load(url)
                    .error(emptyImg)
                    .placeholder(iv.getDrawable())
                    .transform(new CircleCrop()).into(iv);
        } else {
            loadCircleImage(context, iv, emptyImg, emptyImg);
        }
    }

    /**
     * 加载drawable中的图片资源
     *
     * @param context  context
     * @param iv       imageView
     * @param resId    图片地址
     * @param emptyImg 默认展位图
     */
    public static void loadImage(Context context, ImageView iv, int resId, int emptyImg) {
        GlideApp.with(context).load(resId).placeholder(emptyImg).into(iv);
    }

    /**
     * 加载drawable中的图片资源 圆角
     *
     * @param context  context
     * @param iv       imageView
     * @param resId    图片地址
     * @param emptyImg 默认展位图
     */
    public static void loadRoundImage(Context context, ImageView iv, int resId, int emptyImg) {
        GlideApp.with(context).load(emptyImg).placeholder(emptyImg).transform(new RoundedCorners(20)).into(iv);
    }

    /**
     * 加载drawable中的图片资源 圆形
     *
     * @param context  context
     * @param iv       imageView
     * @param resId    图片地址
     * @param emptyImg 默认展位图
     */
    public static void loadCircleImage(Context context, ImageView iv, int resId, int emptyImg) {
        GlideApp.with(context).load(emptyImg).placeholder(emptyImg).transform(new CircleCrop()).into(iv);
    }


}
