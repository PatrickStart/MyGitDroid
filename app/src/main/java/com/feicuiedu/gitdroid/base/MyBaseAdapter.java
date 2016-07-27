package com.feicuiedu.gitdroid.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by he.xx on 2016/7/27.
 */
public abstract class MyBaseAdapter<HEXI> extends BaseAdapter {
    //context对象
    public Context mC;
    //数据集合
    public List<HEXI> mList;
    //布局渲染器
    public LayoutInflater mInflater;

    public MyBaseAdapter(Context mC, List<HEXI> mList) {
        this.mC = mC;
        mList = new ArrayList<HEXI>();
        mInflater = (LayoutInflater) mC.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public List<HEXI> getmList() {
        return mList;
    }

    public void setmList(List<HEXI> mList) {
        this.mList = mList;
    }

    /**
     * 获取上下文对象
     * @return
     */
    public Context getContext() {
        return mC;
    }

    /**
     * 获取数据长度
     * @return
     */
    @Override
    public int getCount() {
        return this.mList!=null? this.mList.size(): 0;
    }

    /**
     * 获取当前item
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        if (position == getCount()  || mList == null) {
            return null;
        }
        return mList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position,convertView);
    }

    public abstract View getItemView(int position,View view);

    /**
     * 更新数据
     * @param values
     */
    public void update(List<HEXI> values) {
        mList = values;
        notifyDataSetInvalidated();
        notifyDataSetChanged();
    }
}
