package com.project.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by 于德海 on 2018/11/26.
 * package rjh.yilin.ui.widgets
 * email : yudehai0204@163.com
 *
 * @describe  带滚动监听的ScrollView
 */
public class ObserveScrollView extends ScrollView {
    public interface ScrollViewListener{
        void onScroll(ScrollView view, int x, int y, int oldx, int oldy);
    }
    private ScrollViewListener listener;
    public ObserveScrollView(Context context) {
        super(context);
    }

    public ObserveScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObserveScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setListener(ScrollViewListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(listener!=null){
            listener.onScroll(this,l,t,oldl,oldt);
        }
    }
}
