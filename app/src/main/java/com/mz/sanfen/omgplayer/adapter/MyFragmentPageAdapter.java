package com.mz.sanfen.omgplayer.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.mz.sanfen.omgplayer.R;
import com.mz.sanfen.omgplayer.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/11/8.
 */

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private Context mContext;

    List<BaseFragment> mData = new ArrayList<>();

    private int[] mImageResId = {
            R.mipmap.menu_48px,
            R.mipmap.menu_48px,
            R.mipmap.menu_48px,
    };

    public MyFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    public void setData(List<BaseFragment> mData) {
        this.mData = mData;
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable image = mContext.getResources().getDrawable(mImageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }

}
