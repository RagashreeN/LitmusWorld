package com.litmus.interview.common.utils;

import android.app.Application;

import androidx.multidex.MultiDexApplication;

import com.litmus.interview.common.rest.NetworkService;

public class LitmusApplication extends Application {

    public static NetworkService networkService;

    @Override
    public void onCreate() {
        super.onCreate();
        networkService = new NetworkService();
    }
}
