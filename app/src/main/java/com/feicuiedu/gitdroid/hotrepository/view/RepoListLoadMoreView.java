package com.feicuiedu.gitdroid.hotrepository.view;

import java.util.List;

/**
 * 上拉加载更多
 * Created by he.xx on 2016/7/28.
 */
public interface RepoListLoadMoreView {
    void showLoadMoreLoading();//显示出加载出更多的信息

    void hideLoadMore();//隐藏加载更多的视图

    void showLoadMoreErro(String erroMsg);//如果加载更多失败显示信息

    void addMoreData(List<String> datas);//加载更多的数据
}
