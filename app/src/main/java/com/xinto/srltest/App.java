package com.xinto.srltest;

import android.app.Application;
import com.facebook.soloader.SoLoader;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
    }
}