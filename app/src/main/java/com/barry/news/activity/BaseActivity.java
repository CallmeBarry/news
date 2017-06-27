package com.barry.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private Toast mToast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResource());
        ButterKnife.bind(this);
        initView();
        initListener();
        initDate();
    }

    protected abstract void initView() ;

    protected abstract void initListener() ;

    protected abstract void initDate() ;

    /**
     * 展示吐司
     * @param msg
     */
    public void showToast(String msg){
        if(mToast==null){
            mToast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }


    protected abstract int setLayoutResource() ;

    /**
     * 跳转Activity
     * @param clazz
     * @param isFinish 是否结束Activity
     */
    void GoTo(Class clazz,boolean isFinish ){
        Intent intent=new Intent(this,clazz);
        startActivity(intent);
        if(isFinish)finish();
    }
}
