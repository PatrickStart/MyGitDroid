package com.feicuiedu.gitdroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.feicuiedu.gitdroid.MainActivity;
import com.feicuiedu.gitdroid.R;
import com.feicuiedu.gitdroid.base.MyBaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by he.xx on 2016/7/26.
 */
public class SplashActivity extends MyBaseActivity {

    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.btnEnter)
    Button btnEnter;

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_splash);

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

    }

    @OnClick({R.id.btnLogin, R.id.btnEnter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
            startActivity(LoginActivity.class);
            finish();
                break;
            case R.id.btnEnter:
            startActivity(MainActivity.class);
            finish();
                break;
        }
    }
}
