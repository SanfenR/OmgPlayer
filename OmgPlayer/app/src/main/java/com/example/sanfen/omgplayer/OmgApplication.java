package com.example.sanfen.omgplayer;

import android.app.Application;

import com.example.sanfen.omgplayer.dagger.component.ApplicationComponent;
import com.example.sanfen.omgplayer.dagger.component.DaggerApplicationComponent;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/9/5.
 */
public class OmgApplication extends Application {
    private static OmgApplication sOmgApplication;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sOmgApplication = this;
        mApplicationComponent = DaggerApplicationComponent.builder().build();
    }


    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

}
