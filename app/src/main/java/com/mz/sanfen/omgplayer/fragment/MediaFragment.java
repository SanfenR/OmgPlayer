package com.mz.sanfen.omgplayer.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.mz.sanfen.omgplayer.R;
import com.mz.sanfen.omgplayer.adapter.MediaAdapter;
import com.mz.sanfen.omgplayer.entity.MediaEntity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_media)
public class MediaFragment extends BaseFragment {

    @ViewById(R.id.rv_media)
    RecyclerView rv_media;

    MediaAdapter mAdapter;

    List<MediaEntity> mMediaEntities;

    public MediaFragment() {
    }

    public static MediaFragment newInstance(){
        return new MediaFragment_();
    }

    @AfterViews
    void initView(){
        mAdapter = new MediaAdapter(getContext());
        mMediaEntities.add(new MediaEntity("111.tv", "2:2:2"));
        mMediaEntities.add(new MediaEntity("222.tv", "2:2:2"));
        mMediaEntities.add(new MediaEntity("333.tv", "2:2:2"));
        mMediaEntities.add(new MediaEntity("444.tv", "2:2:2"));
        mAdapter.setDatas(mMediaEntities);
        rv_media.setAdapter(mAdapter);
    }


}
