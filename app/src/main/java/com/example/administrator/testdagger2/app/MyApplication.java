package com.example.administrator.testdagger2.app;

import android.app.Application;

/**
 * Created by Administrator on 2017/12/22 0022.
 */
public class MyApplication extends Application {
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
