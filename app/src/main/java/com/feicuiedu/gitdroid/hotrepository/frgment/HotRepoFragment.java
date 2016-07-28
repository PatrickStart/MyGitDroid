package com.feicuiedu.gitdroid.hotrepository.frgment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feicuiedu.gitdroid.R;
import com.feicuiedu.gitdroid.adapter.HotRepoAdapter;
import com.feicuiedu.gitdroid.base.MyBaseFragment;
import com.feicuiedu.gitdroid.hotrepository.frgment.RepoListPtrFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by he.xx on 2016/7/27.
 */
public class HotRepoFragment extends MyBaseFragment {
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    HotRepoAdapter adapter;
    List<Fragment> list;
    List<String> strList;

    @Override
    public View createView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hot_repo, container, false);
    }

    @Override
    public void ViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        loadData();
        adapter = new HotRepoAdapter(getChildFragmentManager());
        adapter.setList(list);
        adapter.setStrList(strList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void loadData() {
        list = new ArrayList<Fragment>();
        strList = new ArrayList<String>();
        list.add(new RepoListPtrFragment());
        list.add(new RepoListPtrFragment());
        list.add(new RepoListPtrFragment());
        list.add(new RepoListPtrFragment());

        strList.add("JAVA");
        strList.add("HTML");
        strList.add("GO");
        strList.add("C#");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
