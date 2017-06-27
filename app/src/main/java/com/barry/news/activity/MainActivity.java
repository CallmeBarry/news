package com.barry.news.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.barry.news.R;
import com.barry.news.fragment.MainFragment01;
import com.barry.news.fragment.MainFragment02;
import com.barry.news.fragment.MainFragment03;
import com.barry.news.fragment.MainFragment04;
import com.barry.news.fragment.MainFragment05;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.vp_main)
    ViewPager mVpMain;
    @BindView(R.id.radio_01)
    RadioButton mRadio01;
    @BindView(R.id.radio_02)
    RadioButton mRadio02;
    @BindView(R.id.radio_03)
    RadioButton mRadio03;
    @BindView(R.id.radio_04)
    RadioButton mRadio04;
    @BindView(R.id.radio_05)
    RadioButton mRadio05;
    @BindView(R.id.rg)
    RadioGroup mRg;
    @BindView(R.id.DrawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;

    private List<Fragment> mFragments;

    @Override
    protected void initView() {
        initActionBarDrawToggle();

        mFragments = new ArrayList<>();
        mFragments.add(new MainFragment01());
        mFragments.add(new MainFragment02());
        mFragments.add(new MainFragment03());
        mFragments.add(new MainFragment04());
        mFragments.add(new MainFragment05());

        mVpMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
    }

    private void initActionBarDrawToggle() {
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, 0, 0);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    protected void initListener() {
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRg.check(R.id.radio_01);
                        break;
                    case 1:
                        mRg.check(R.id.radio_02);
                        break;
                    case 2:
                        mRg.check(R.id.radio_03);
                        break;
                    case 3:
                        mRg.check(R.id.radio_04);
                        break;
                    case 4:
                        mRg.check(R.id.radio_05);
                        break;


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mNavView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.radio_01, R.id.radio_02, R.id.radio_03, R.id.radio_04, R.id.radio_05})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radio_01:
                mVpMain.setCurrentItem(0);
                break;
            case R.id.radio_02:
                mVpMain.setCurrentItem(1);
                break;
            case R.id.radio_03:
                mVpMain.setCurrentItem(2);
                break;
            case R.id.radio_04:
                mVpMain.setCurrentItem(3);
                break;
            case R.id.radio_05:
                mVpMain.setCurrentItem(4);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                showToast("item1");
                break;
            case R.id.item2:
                showToast("item2");
                break;
            case R.id.item3:
                showToast("item3");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_item1:
                showToast("item1");
                mDrawerLayout.closeDrawers();
                break;
            case R.id.nav_item2:
                showToast("item2");
                mDrawerLayout.closeDrawers();
                break;
            case R.id.nav_item3:
                showToast("item3");
                mDrawerLayout.closeDrawers();
                break;
        }
        return false;
    }
}
