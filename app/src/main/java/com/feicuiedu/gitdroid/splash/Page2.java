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
 * 第三个页面
 * Created by he.xx on 2016/7/26.
 */
public class Page2 extends FrameLayout {

    @Bind(R.id.ivBubble1) ImageView ivBubble1;
    @Bind(R.id.ivBubble2) ImageView ivBubble2;
    @Bind(R.id.ivBubble3) ImageView ivBubble3;

    public Page2(Context context) {
        this(context, null);
    }

    public Page2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Page2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_2, this, true);
        ButterKnife.bind(this);
        ivBubble1.setVisibility(View.GONE);
        ivBubble2.setVisibility(View.GONE);
        ivBubble3.setVisibility(View.GONE);
    }

    /**
     * 设置三张图片的动画
     */
    public void showAnimation(){
        if (ivBubble1.getVisibility() != View.VISIBLE){
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivBubble1.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.SlideInRight).duration(300).playOn(ivBubble1);
                }
            },100);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivBubble2.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.SlideInRight).duration(300).playOn(ivBubble2);
                }
            },600);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivBubble3.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.SlideInRight).duration(300).playOn(ivBubble2);
                }
            },1200);
        }

    }


    public void hideImG(){
        ivBubble1.setVisibility(View.GONE);
        ivBubble2.setVisibility(View.GONE);
        ivBubble3.setVisibility(View.GONE);
    }
}
