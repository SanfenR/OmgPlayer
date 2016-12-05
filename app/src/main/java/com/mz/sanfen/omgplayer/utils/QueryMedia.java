package com.mz.sanfen.omgplayer.utils;

import com.mz.sanfen.omgplayer.adapter.MediaAdapter;
import com.mz.sanfen.omgplayer.entity.MediaEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/11/29.
 */

public class QueryMedia {

    public static final String ROOT_PATH = "/";

    public static List<MediaEntity> showFileDir(){
        return showFileDir(ROOT_PATH);
    }

    public static List<MediaEntity> showFileDir(String path){
        List<MediaEntity> medias = new ArrayList<MediaEntity>();

        File file = new File(path);


        if (!file.isDirectory()){
            return null;
        }


        File[] files = file.listFiles();

        if (files == null){
            return null;
        }

        //添加所有文件
        for (File f : files){
            MediaEntity entity = new MediaEntity();
            entity.name = f.getName();
            entity.path = f.getPath();
            medias.add(entity);
        }

        return medias;
    }

}
