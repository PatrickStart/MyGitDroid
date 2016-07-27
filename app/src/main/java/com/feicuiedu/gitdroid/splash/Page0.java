package com.feicuiedu.gitdroid.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.feicuiedu.gitdroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by he.xx on 2016/7/26.
 */
public class Page0 extends FrameLayout {

    @Bind(R.id.ivTablet)
    ImageView ivTablet;
    @Bind(R.id.ivDesktop)
    ImageView ivDesktop;

    public Page0(Context context) {
        this(context, null);
    }

    public Page0(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Page0(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_0, this, true);
        ButterKnife.bind(this);
        if (ivTablet.getVisibility() == View.VISIBLE){
            ivTablet.setVisibility(View.GONE);
            ivDesktop.setVisibility(View.GONE);
        }

    }

    public void showAnimation(){
        if (ivTablet.getVisibility() != View.VISIBLE || ivDesktop.getVisibility() != View.VISIBLE){
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivTablet.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.RubberBand).duration(500).playOn(ivTablet);
                }
            },0);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivDesktop.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.RubberBand).duration(500).playOn(ivDesktop);
                }
            },500);
        }

    }

    public void hideView(){
        ivTablet.setVisibility(View.GONE);
        ivDesktop.setVisibility(View.GONE);
    }
}
