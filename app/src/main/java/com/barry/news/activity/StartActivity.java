package com.barry.news.activity;

import android.os.Handler;

import com.barry.news.R;

public class StartActivity extends BaseActivity {


    private Handler mHandler;

    @Override
    protected void initView() {
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                GoTo(GuideActivity.class,true);
            }
        },3000);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initDate() {

    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_start;
    }
}
