package com.mz.sanfen.omgplayer.main;

import android.widget.TabHost;
import android.widget.TextView;
import com.mz.sanfen.omgplayer.R;
import com.mz.sanfen.omgplayer.fragment.BaseFragment;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


@EFragment(R.layout.fragment_main)
public class MainFragment extends BaseFragment {

    @ViewById(R.id.th_main)
    TabHost th_main;

    @ViewById(R.id.tv_main)
    TextView tv_main;

    public MainFragment() {
    }

    public static MainFragment newInstance(){
        return new MainFragment_();
    }

    @AfterViews
    void initView() {
        tv_main.setText("test");
    }

}
