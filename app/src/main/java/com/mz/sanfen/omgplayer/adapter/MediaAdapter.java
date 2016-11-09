package com.mz.sanfen.omgplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mz.sanfen.omgplayer.R;
import com.mz.sanfen.omgplayer.entity.MediaEntity;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/11/8.
 */

public class MediaAdapter  extends BaseRecyclerAdapter<MediaEntity> {

    public MediaAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_media, parent, false);
        return new MediaAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, MediaEntity data) {
        if (viewHolder instanceof MediaAdapter.ViewHolder){
            MediaAdapter.ViewHolder vh = (ViewHolder) viewHolder;

            vh.tv_title.setText(data.name);
            vh.tv_time.setText(data.time);

        }
    }


    private class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title;
        TextView tv_time;
        ImageView iv_play;
        ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            iv_play = (ImageView) itemView.findViewById(R.id.iv_play);
        }
    }

}
