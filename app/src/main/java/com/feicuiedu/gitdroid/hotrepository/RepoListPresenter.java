package com.feicuiedu.gitdroid.hotrepository;

import android.os.AsyncTask;

import com.feicuiedu.gitdroid.hotrepository.view.RepoListView;

import java.util.ArrayList;

/**
 * Created by he.xx on 2016/7/28.
 */
public class RepoListPresenter {

    private RepoListView repoListView;
    private int count;

    public RepoListPresenter(RepoListView repoListView){
        this.repoListView = repoListView;
    }

    //刷新更多处理
    public void refresh() {
        new RefreshTask().execute();
    }

    // 加载更多处理
    public void loadMore() {
        repoListView.showLoadMoreLoading();
        new LoadMoreTask().execute();
    }

    //加载更多
    class LoadMoreTask extends AsyncTask<Void, Void, Void> {
        @Override protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayList<String> datas = new ArrayList<String>();
            for (int i = 0; i < 20; i++) {
                datas.add("测试数据 " + (count++));
            }
            repoListView.addMoreData(datas);
            repoListView.hideLoadMore();
        }
    }

    //下拉刷新
    class RefreshTask extends AsyncTask<Void,Void,Void> {
        @Override protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayList<String> datas = new ArrayList<String>();
            for(int i=0; i<20; i++){
                datas.add("测试数据 " + (count++));
            }
            repoListView.stopRefresh();
            repoListView.refreshData(datas);
            repoListView.showContentView();
        }
    }

}
