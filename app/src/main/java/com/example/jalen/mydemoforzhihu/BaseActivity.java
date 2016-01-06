package com.example.jalen.mydemoforzhihu;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Jalen on 2015/7/21.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{


    public abstract void weightClick(View v);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initViews();
        initDates();
    }


    @Override
    public void onClick(View v) {
        weightClick(v);
    }

    /***
     * 初始化View
     */
    abstract  void initViews();

    /***
     * 操作事件
     */
    abstract  void initDates();

}
