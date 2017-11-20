package com.example.newsshow.mvp.ui.adapters.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/11/20.
 */

public class PostFragmentAdapter extends FragmentPagerAdapter {
private List<Fragment> mPostFragmentList;
    private final List<String> mTitles;

    public PostFragmentAdapter(FragmentManager fm, List<Fragment> mPostFragmentList, List<String> mTitles) {
        super(fm);
        this.mPostFragmentList = mPostFragmentList;
        this.mTitles = mTitles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mPostFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return  mPostFragmentList==null?0:mPostFragmentList.size();
    }
}
