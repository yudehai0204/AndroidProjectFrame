package com.example.jalen.fragment.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.jalen.mydemoforzhihu.R;

/**
 * Created by Jalen on 2015/8/5.
 */
public class MainHotCollectionFrag extends Fragment {

    private static View view ;
    private SwipeRefreshLayout mSwip;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view= LayoutInflater.from(getActivity()).inflate(R.layout.hot_collection,container,false);
        initViews();
        initDatas();
        return view;


    }

    private ListView mListview;
    private void initDatas() {
        mListview.setAdapter(new Myadapter());
        mListview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem ==0){
                    mSwip.setEnabled(true);
                }else{
                    mSwip.setEnabled(false);
                }
            }
        });
        mSwip.setColorSchemeResources(android.R.color.holo_blue_dark, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_green_light);
        mSwip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwip.setRefreshing(false);
                    }
                },3000);
            }
        });
    }

    /***
     * init weights
     */
    private void initViews() {
        mSwip = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        mListview = (ListView) view.findViewById(R.id.listview);

    }

    private class Myadapter extends BaseAdapter {


        @Override
        public int getCount() {
            return 55;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(getActivity()).inflate(R.layout.listview_item,parent,false);
            return convertView;
        }
    }
}
