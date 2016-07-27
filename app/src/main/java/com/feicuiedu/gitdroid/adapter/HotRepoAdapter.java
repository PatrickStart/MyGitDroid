package com.feicuiedu.gitdroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by he.xx on 2016/7/27.
 */
public class HotRepoAdapter extends FragmentPagerAdapter {
    List<Fragment> list;
    List<String> strList;

    public HotRepoAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<Fragment>();
        strList = new ArrayList<String>();
    }

    public List<Fragment> getList() {
        return list;
    }

    public void setList(List<Fragment> list) {
        this.list = list;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strList.get(position);
    }
}
