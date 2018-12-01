package com.project.ui.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import com.project.R;


/**
 * Created by 于德海 on 2018/8/30.
 * package rjh.yilin.ui.widgets
 * email : yudehai0204@163.com
 *
 * @describe 自定义下拉颜色的swipe
 */
public class CustomSwipeRefresh extends SwipeRefreshLayout {
    public CustomSwipeRefresh(@NonNull Context context) {
        this(context,null);
    }

    public CustomSwipeRefresh(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setColorSchemeResources(R.color.app_theme_color);

    }
}
