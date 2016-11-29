package com.mz.sanfen.omgplayer.entity;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/11/9.
 */

public class MediaEntity {
    public String name;
    public String time;
    public int length;
    public int id;

    public MediaEntity() {
    }

    public MediaEntity(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public MediaEntity(String name, String time, int length, int id) {
        this.name = name;
        this.time = time;
        this.length = length;
        this.id = id;
    }
}
