package com.mz.sanfen.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mz.sanfen.mvvmdemo.databinding.ActivityMainBinding;
import com.mz.sanfen.mvvmdemo.entity.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding bind =  DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("TEST", "USER");
        bind.setUser(user);
    }
}
