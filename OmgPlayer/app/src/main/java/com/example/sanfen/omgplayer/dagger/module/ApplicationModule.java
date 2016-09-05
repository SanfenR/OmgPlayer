package com.example.sanfen.omgplayer.dagger.module;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/9/5.
 */
@Module
public class ApplicationModule {


    @Provides
    @Singleton
    public Gson provideGson(){
        return new Gson();
    }

}
