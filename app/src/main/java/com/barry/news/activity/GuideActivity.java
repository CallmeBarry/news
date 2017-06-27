package com.barry.news.activity;

import android.animation.Animator;
import android.widget.Button;
import android.widget.ImageView;

import com.barry.news.R;

import butterknife.BindView;
import butterknife.OnClick;

public class GuideActivity extends BaseActivity {


    @BindView(R.id.iv_guide)
    ImageView mIvGuide;
    @BindView(R.id.btn_enter)
    Button mBtnEnter;
    int index=0;
    int[]imgResource={
            R.drawable.ad_new_version1_img1,
            R.drawable.ad_new_version1_img2,
            R.drawable.ad_new_version1_img3,
            R.drawable.ad_new_version1_img4,
            R.drawable.ad_new_version1_img5,
            R.drawable.ad_new_version1_img6,
            R.drawable.ad_new_version1_img7
    };
    boolean IsEnter=false;

    @Override
    protected void initView() {
        startAnimate();


    }

    private void startAnimate() {
        mIvGuide.setScaleY(1); mIvGuide.setScaleX(1);
        mIvGuide.setImageResource(imgResource[index%7]);
        index++;
        mIvGuide.animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if(!IsEnter)
                        startAnimate();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .setDuration(3000)
                .start();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initDate() {

    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_guide;
    }

    @OnClick(R.id.btn_enter)
    public void onClick() {
        GoTo(MainActivity.class,true);
    }

    @Override
    protected void onDestroy() {
        IsEnter=true;
        super.onDestroy();
    }
}
