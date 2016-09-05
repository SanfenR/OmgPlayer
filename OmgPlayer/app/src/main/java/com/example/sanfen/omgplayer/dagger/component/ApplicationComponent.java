package com.example.sanfen.omgplayer.dagger.component;

import com.example.sanfen.omgplayer.dagger.module.ApplicationModule;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/9/5.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Gson getGson();
}
