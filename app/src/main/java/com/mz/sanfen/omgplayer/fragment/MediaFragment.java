package com.mz.sanfen.omgplayer.fragment;


import android.support.v4.app.Fragment;

import com.mz.sanfen.omgplayer.R;

import org.androidannotations.annotations.EFragment;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_media)
public class MediaFragment extends Fragment {
    public MediaFragment() {
    }

    public static MediaFragment newInstance(){
        return new MediaFragment_();
    }

}
