package com.mz.sanfen.omgplayer.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.mz.sanfen.omgplayer.R;
import com.mz.sanfen.omgplayer.adapter.MyFragmentPageAdapter;
import com.mz.sanfen.omgplayer.fragment.BaseFragment;
import com.mz.sanfen.omgplayer.fragment.MediaFragment;
import com.mz.sanfen.omgplayer.fragment.SettingFragment;
import com.mz.sanfen.omgplayer.main.MainFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.tl_main)
    TabLayout tl_main;

    @ViewById(R.id.vp_main)
    ViewPager vg_main;

    MyFragmentPageAdapter mAdapter;

    List<BaseFragment> mList;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void initView(){

        mAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(), this);
        mList = new ArrayList<>();


        mList.add(MainFragment.newInstance());
        mList.add(MediaFragment.newInstance());
        mList.add(SettingFragment.newInstance());

        mAdapter.setData(mList);
        vg_main.setAdapter(mAdapter);
        tl_main.setupWithViewPager(vg_main);
        tl_main.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void onBackPressed() {
        int position = tl_main.getSelectedTabPosition();

        Log.e(TAG, "onBackPressed: " + position);

        BaseFragment baseFragment = mList.get(position);

        if (!baseFragment.back()){
            super.onBackPressed();
        }
    }
}
