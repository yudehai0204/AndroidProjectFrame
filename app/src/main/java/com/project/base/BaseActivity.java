package com.project.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.base
 * email : yudehai0204@163.com
 *
 * @describe
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam(getIntent().getExtras());
        setContentView(getLayoutId());
        initView();
        initData();
        initListener();
    }

    protected abstract void initParam(Bundle param);
    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.getRefWatcher().watch(this);
    }
}
