package com.project.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by 于德海 on 2018/3/26.
 * package com.project.base
 * email : yudehai0204@163.com
 *
 * @describe
 */

public abstract class BaseFragment extends RxFragment implements View.OnClickListener{
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext= context;
    }
    protected void showLoading(){
        ((BaseActivity) getActivity()).showLoading();
    }
    protected void dissLoading(){
        ((BaseActivity) getActivity()).dismissLoading();
    }
    protected abstract int getLayoutId();

    protected abstract void initView(View view, Bundle savedInstanceState);
    protected abstract void initData();
    protected abstract void initListener();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(getLayoutId(),container,false);
        initView(view,savedInstanceState);
        initData();
        initListener();
        return view;
    }
}
