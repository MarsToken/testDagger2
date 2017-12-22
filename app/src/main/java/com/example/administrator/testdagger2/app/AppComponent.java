package com.example.administrator.testdagger2.app;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/12/22 0022.
 */
@Singleton
@Component(modules = ApiModule.class)
public interface AppComponent {
    OkHttpClient getClient();

    Retrofit getRetrofit();

    User getUser();
}
