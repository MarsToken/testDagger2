package com.example.administrator.testdagger2;

import com.example.administrator.testdagger2.app.ActivityScope;
import com.example.administrator.testdagger2.app.AppComponent;

import dagger.Component;

/**
 * Created by Administrator on 2017/12/22 0022.
 */
@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
