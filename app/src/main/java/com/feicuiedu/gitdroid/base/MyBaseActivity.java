package com.feicuiedu.gitdroid.base;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by he.xx on 2016/7/26.
 */
public abstract class MyBaseActivity extends AppCompatActivity implements View.OnClickListener{
//    public int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();       // 屏幕宽（像素，如：480px）
//    public int screenHeight = getWindowManager().getDefaultDisplay().getHeight();      // 屏幕高（像素，如：800p）

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout();
        loadData();
        initView();
        setView();
    }


    protected abstract void setLayout();

    protected abstract void loadData();

    protected abstract void initView();

    protected abstract void setView();

    public void startActivity(Class cla){
        Intent intent = new Intent(this,cla);
        startActivity(intent);
    }

    public void startActivity(Class cla,Bundle bundle){
        Intent intent = new Intent(this,cla);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
