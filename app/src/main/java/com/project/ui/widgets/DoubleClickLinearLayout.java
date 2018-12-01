package com.project.ui.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by 于德海 on 2018/7/31.
 * package inter.baisong.widgets
 * email : yudehai0204@163.com
 *
 * @describe
 */
public class DoubleClickLinearLayout extends LinearLayout {
    private volatile int clickcount;
    private volatile boolean isLongClick;
    public interface OnDoubleClickListener{
        void onDoubleClick(View view);
    }

    private OnDoubleClickListener mListener;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(clickcount==0){
                isLongClick=true;
            }else {
                handler.sendEmptyMessage(clickcount);
            }
        }
    };
    public DoubleClickLinearLayout(Context context) {
        this(context,null);
    }

    public DoubleClickLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DoubleClickLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        clickcount = 0;
        isLongClick = false;
    }

    public void setOnDoubleClick(OnDoubleClickListener listener){
        this.mListener = listener;
    }
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(mListener!=null&&msg.what>1){
                mListener.onDoubleClick(DoubleClickLinearLayout.this);
            }
            clickcount=0;
            return true;
        }
    });

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(clickcount==0)
                    handler.postDelayed(runnable,500);
                break;
            case MotionEvent.ACTION_UP:
                clickcount++;
                if(isLongClick){
                    isLongClick=false;
                    clickcount=0;
                }
                break;
        }

        return super.onTouchEvent(event);
    }
}
