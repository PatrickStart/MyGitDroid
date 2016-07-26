package com.feicuiedu.gitdroid.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.feicuiedu.gitdroid.splash.Page0;
import com.feicuiedu.gitdroid.splash.Page1;
import com.feicuiedu.gitdroid.splash.Page2;

/**
 * Created by he.xx on 2016/7/26.
 */
public class SplashAdapter extends PagerAdapter {
    private final View[] views;

    public SplashAdapter(Context mC) {
        views = new View[]{new Page0(mC),new Page1(mC),new Page2(mC)};
    }

    @Override
    public int getCount() {
        return views.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views[position],0);
        return views[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(views[position]);
    }
}
