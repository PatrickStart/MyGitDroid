package com.feicuiedu.gitdroid;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.feicuiedu.gitdroid.base.MyBaseActivity;
import com.feicuiedu.gitdroid.hotrepository.frgment.HotRepoFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends MyBaseActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.navigationView)
    NavigationView navigationView;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    HotRepoFragment hotRepoFragment;

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void setView() {
        navigationView.setNavigationItemSelectedListener(listener);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);// 设置抽屉监听

        // 默认显示的是热门仓库fragment
        hotRepoFragment = new HotRepoFragment();
        replaceFragment(hotRepoFragment);
    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }


    private NavigationView.OnNavigationItemSelectedListener listener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.github_hot_repo:
                    Toast.makeText(MainActivity.this, "最热门！", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.github_hot_coder:
                    Toast.makeText(MainActivity.this, "开发者！", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.github_trend:
                    Toast.makeText(MainActivity.this, "流行趋势！", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.arsenal_my_repo:
                    Toast.makeText(MainActivity.this, "我的收藏！", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.arsenal_recommend:
                    Toast.makeText(MainActivity.this, "推荐！", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tips_daily:
                    Toast.makeText(MainActivity.this, "每日干货！", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.tips_share:
                    Toast.makeText(MainActivity.this, "分享！", Toast.LENGTH_SHORT).show();
                    break;
            }
            // 是否要将当前选中听变为checked状态
            return true;
        }
    };

//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }else {
//            drawerLayout.openDrawer(GravityCompat.START);
//        }
//    }

    @Override
    public void onClick(View v) {

    }


}
