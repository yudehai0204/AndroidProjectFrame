package com.example.jalen.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Jalen on 2015/8/4.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter{

    private Fragment frags[];
    private String titles []={"热门推荐","热门收藏","本月热榜","今日热榜"};


    public MainViewPagerAdapter(FragmentManager fm, Fragment[] frags) {
        super(fm);
        this.frags = frags;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return frags[position];
    }

    @Override
    public int getCount() {
        return frags.length;
    }
}
