package com.feicuiedu.gitdroid.hotrepository.frgment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.feicuiedu.gitdroid.R;
import com.feicuiedu.gitdroid.base.MyBaseFragment;
import com.feicuiedu.gitdroid.hotrepository.RepoListPresenter;
import com.feicuiedu.gitdroid.hotrepository.view.RepoListView;
import com.feicuiedu.gitdroid.view.RepoListFooterView;
import com.mugen.Mugen;
import com.mugen.MugenCallbacks;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

/**
 * Created by he.xx on 2016/7/27.
 */
public class RepoListPtrFragment extends MyBaseFragment implements RepoListView {

    @Bind(R.id.lvRepos)
    ListView listView;
    @Bind(R.id.emptyView)
    TextView emptyView;
    @Bind(R.id.errorView)
    TextView errorView;
    @Bind(R.id.ptrClassicFrameLayout)
    PtrClassicFrameLayout ptrFrameLayout;

    private ArrayAdapter<String> adapter;
    RepoListPresenter presenter;
    RepoListFooterView footerView;

    @Override
    public View createView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repo_list, container, false);
    }

    @Override
    public void ViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        presenter = new RepoListPresenter(this);
        adapter = new  ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                new ArrayList<String>()
        );
        listView.setAdapter(adapter);

        initPullToRefresh();

        // 初始上拉加载更多
        initLoadMoreScroll();
    }

    private void initLoadMoreScroll() {
        footerView = new RepoListFooterView(getContext());
        Mugen.with(listView, new MugenCallbacks() {
            @Override
            public void onLoadMore() {
                presenter.loadMore();
            }

            @Override
            public boolean isLoading() {
                return listView.getFooterViewsCount() > 0 && footerView.isLoading();
            }

            @Override
            public boolean hasLoadedAllItems() {
                return listView.getFooterViewsCount() > 0 && footerView.isComplete();
            }
        }).start();
    }


    private void initPullToRefresh() {
        // 使用当前对象做为key，来记录上一次的刷新时间,如果两次下拉太近，将不会触发新刷新
        ptrFrameLayout.setLastUpdateTimeRelateObject(this);
        // 关闭header所用时长
        ptrFrameLayout.setDurationToCloseHeader(1500);
        // 下拉刷新监听处理
        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            // 当你"下拉时",将触发此方法
            @Override public void onRefreshBegin(PtrFrameLayout frame) {
            presenter.refresh();

            }
        });
        // 以下代码（只是修改了header样式）
        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.initWithString("I LIKE " + "HEXI");
        header.setPadding(0, 60, 0, 60);
        // 修改Ptr的HeaderView效果
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setBackgroundResource(R.color.colorRefresh);
    }

    //下拉刷新数据       -------------------------------------
    // 刷新的方法
    @Override
    public void showContentView() {
        ptrFrameLayout.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
    }
    @Override
    public void showErrorView(String errorMsg) {
        ptrFrameLayout.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }
    @Override
    public void showEmptyView() {
        ptrFrameLayout.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }

    // 显示提示信息
    @Override
    public void showMessage(String msg) {

    }

    //停止刷新
    @Override
    public void stopRefresh() {
        ptrFrameLayout.refreshComplete();
    }


    // 刷新数据
    @Override
    public void refreshData(List<String> data) {
        adapter.clear();
        adapter.addAll(data);
        adapter.notifyDataSetChanged();
    }

    // 上拉加载更多        ----------------------------------------
    @Override public void showLoadMoreLoading() {
        if (listView.getFooterViewsCount() == 0) {
            listView.addFooterView(footerView);
        }
        footerView.showLoading();
    }

    @Override public void hideLoadMore() {
        listView.removeFooterView(footerView);
    }

    @Override public void showLoadMoreErro(String erroMsg) {
        if (listView.getFooterViewsCount() == 0) {
            listView.addFooterView(footerView);
        }
        footerView.showError(erroMsg);
    }

    @Override public void addMoreData(List<String> datas) {
        adapter.addAll(datas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
