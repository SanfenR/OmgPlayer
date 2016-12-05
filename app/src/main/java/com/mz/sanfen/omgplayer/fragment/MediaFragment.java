package com.mz.sanfen.omgplayer.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.mz.sanfen.omgplayer.R;
import com.mz.sanfen.omgplayer.adapter.MediaAdapter;
import com.mz.sanfen.omgplayer.entity.MediaEntity;
import com.mz.sanfen.omgplayer.utils.QueryMedia;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.util.ArrayList;
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
        mMediaEntities = new ArrayList<>();

        mAdapter.setDatas(QueryMedia.showFileDir());

        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.header_file, null);



        mAdapter.setHeaderView(headerView);

        rv_media.setAdapter(mAdapter);
        rv_media.setLayoutManager(new LinearLayoutManager(getContext()));
    }



}
