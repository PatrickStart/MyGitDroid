package com.feicuiedu.gitdroid.splash;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.feicuiedu.gitdroid.R;
import com.feicuiedu.gitdroid.adapter.SplashAdapter;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by he.xx on 2016/7/26.
 */
public class SplashPageFragment extends Fragment {
    SplashAdapter adapter;//适配器
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.indicator)//下面三个小圆点(自定义控件)
    CircleIndicator indicator;
    @Bind(R.id.ivPhoneFont)//手机字体的img
    ImageView ivPhoneFont;
    @Bind(R.id.layoutPhone)//手机的图片
    FrameLayout layoutPhone;
    @Bind(R.id.content)//整个背景
    FrameLayout content;
    //切换页面时候需要显示的背景颜色
    @BindColor(R.color.colorBlue) int colorBlue;
    @BindColor(R.color.colorRed)int colorRed;
    @BindColor(R.color.colorGreen)int colorGreen;
    View[] views ;
    Page2 page2;
    Page0 page0;
    Page1 page1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_pager, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new SplashAdapter(getContext(),views);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        page0 = (Page0) adapter.getView(0);
        page2 = (Page2) adapter.getView(2);
        setAnimation(0);
        viewPager.addOnPageChangeListener(pageColorListener);
        viewPager.addOnPageChangeListener(phoneViewListener);

    }

    private void loadData(){
        views = new View[]{new Page0(getContext()),new Page1(getContext()),new Page2(getContext())};
    }

    // 主要为了做背景颜色渐变处理
    private ViewPager.OnPageChangeListener pageColorListener = new ViewPager.OnPageChangeListener() {
        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();

        //滑动过程中触发
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //第一个页面到第二个页面的颜色变换
            if (position == 0) {
                int corlor = (int) argbEvaluator.evaluate(positionOffset, colorBlue, colorGreen);
                content.setBackgroundColor(corlor);
            }
            //第二个页面到第三个页面的颜色变换
            if (position == 1){
                int corlor = (int) argbEvaluator.evaluate(positionOffset, colorGreen, colorRed);
                content.setBackgroundColor(corlor);
            }

        }

        @Override
        public void onPageSelected(int position) {
           setAnimation(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    // 主要为了做"手机"的动画效果处理(平移、缩放、透明度变化)
    private ViewPager.OnPageChangeListener phoneViewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //第一个页面到第二个页面
            if (position == 0) {
                // 手机的缩放处理
                float scale = 0.2f + 0.8f * positionOffset;
                layoutPhone.setScaleX(scale);
                layoutPhone.setScaleY(scale);
                // 手机的平移处理
                int scroll = (int) ((positionOffset - 1) * 200);
                layoutPhone.setTranslationX(scroll);
                // 手机字体的渐变
                ivPhoneFont.setAlpha(positionOffset);
            }
            // 在第二个页面和第三个页面之间
            if (position == 1) {
                layoutPhone.setTranslationX(-positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void setAnimation(int position){
        if (position == 0){
            page0.showAnimation();
        }else if (position == 2){
            page2.showAnimation();
        }else if (position == 1){
            page2.hideImG();
            page0.hideView();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
