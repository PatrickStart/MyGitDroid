package com.feicuiedu.gitdroid.hotrepository.view;

import java.util.List;

/**
 * Created by he.xx on 2016/7/28.
 */
public interface RepoListPtrView {
    void showContentView();//显示下拉刷新的视图
    void showErrorView(String errorMsg);
    void showEmptyView();
    void showMessage(String msg);
    void stopRefresh();//停止刷新
    void refreshData(List<String> data);//下拉加载更多的数据
}
