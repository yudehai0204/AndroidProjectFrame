package com.project.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.project.R;
import com.project.base.BaseFragment;
import com.project.mvp.contract.ShowApiContract;
import com.project.mvp.model.ShowApiModel;
import com.project.mvp.presenter.ShowApiPresenter;
import com.project.ui.adapter.ShowApiAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 于德海 on 2018/3/26.
 * package com.project.ui.fragment
 * email : yudehai0204@163.com
 *
 * @describe
 */

public class ShowApiTextFragment extends BaseFragment implements ShowApiContract.IView {
    private RecyclerView mRecyclerView;
    private RefreshLayout mRefreshLayout;
    private int page;
    private ShowApiContract.IPresenter mPresenter;
    private ShowApiAdapter mAdapter;
    private List<ShowApiModel.Bean.Body.Content> mList;
    @Override
    public int getLayoutId() {
        mPresenter = new ShowApiPresenter();
        mPresenter.attachView(this);
        return R.layout.main_frag_text;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.mRecyclerView);
        mRefreshLayout =view.findViewById(R.id.smartRefresh);
        page=1;
        mAdapter= new ShowApiAdapter(mContext);
        mList= new ArrayList<>();
    }
    @Override
    protected void initData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
        mRefreshLayout.autoRefresh(1000,1,1);

    }

    @Override
    protected void initListener() {
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                mPresenter.getShowApiData(page,30);
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.getShowApiData(page,30);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();

    }
    @Override
    public void initShowApiData(ShowApiModel.Bean bean) {
        endRefresh();
        if(bean.getShowapi_res_body()!=null&&bean.getShowapi_res_body().getContentlist()!=null){
            if (page == 1) {
                mList.clear();
            }
            mList.addAll(bean.getShowapi_res_body().getContentlist());
            mAdapter.setList(mList);
            mAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public void showError(Throwable t) {
        endRefresh();
        page--;
    }

    private void endRefresh(){
        if(page==1){
            mRefreshLayout.finishRefresh();
        }else {
            mRefreshLayout.finishLoadMore();
        }
    }

    @Override
    public void onClick(View view) {

    }
}
