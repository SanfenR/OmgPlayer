package com.mz.sanfen.omgplayer.fragment;


import android.support.v4.app.Fragment;

import com.mz.sanfen.omgplayer.R;

import org.androidannotations.annotations.EFragment;

/**
 * A simple {@link Fragment} subclass.
 */

@EFragment(R.layout.fragment_setting)
public class SettingFragment extends BaseFragment {


    public SettingFragment() {
        // Required empty public constructor
    }

    public static SettingFragment newInstance(){
        return new SettingFragment_();
    }
}
