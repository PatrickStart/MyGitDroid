package com.feicuiedu.gitdroid.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.feicuiedu.gitdroid.R;
import com.feicuiedu.gitdroid.base.MyBaseAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by he.xx on 2016/7/27.
 */
public class RepoListAdapter extends MyBaseAdapter {
    List<String> strList;

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public RepoListAdapter(Context mC, List mList) {
        super(mC, mList);
    }

    @Override
    public View getItemView(int position, View view) {
        view = mInflater.inflate(R.layout.test_listview_item, null);
        ViewHolder holder = new ViewHolder(view);
        holder.testItemTv.setText(strList.get(position));
        return view;
    }


    static class ViewHolder {
        @Bind(R.id.test_item_tv)
        TextView testItemTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
