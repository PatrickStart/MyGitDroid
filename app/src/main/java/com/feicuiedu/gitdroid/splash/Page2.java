package com.feicuiedu.gitdroid.splash;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.feicuiedu.gitdroid.R;

/**
 * Created by he.xx on 2016/7/26.
 */
public class Page2 extends FrameLayout {

    public Page2(Context context) {
        this(context,null);
    }

    public Page2(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Page2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_2,this,true);
    }
}
