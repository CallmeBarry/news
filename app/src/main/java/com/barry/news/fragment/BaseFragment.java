package com.barry.news.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/27.
 */

public abstract class BaseFragment extends Fragment {

    private View mView;
    private Activity mActivity;
    private Toast mToast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(mView==null){
            mView = LayoutInflater.from(getContext()).inflate(setLayoutResource(), container, false);
            ButterKnife.bind(this, mView);
            initView();
            initListener();
            initDate();
        }

       return mView;

    }

    protected abstract void initDate();

    protected abstract void initListener();

    protected abstract void initView();

    /**
     * 展示吐司
     * @param msg
     */
    void showToast(String msg){
        if(mToast==null){
            mToast = Toast.makeText(mActivity, "", Toast.LENGTH_SHORT);
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
        Intent intent=new Intent(getActivity(),clazz);
        startActivity(intent);
        if(isFinish)mActivity.finish();
    }

}
