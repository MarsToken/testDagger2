package com.example.administrator.testdagger2;

import com.example.administrator.testdagger2.app.User;

import dagger.Module;
import dagger.Provides;

/**
 * Module的作用是用来提供生成依赖对象的比如我要注入DaggerPresenter，
 * 那么这个Module的作用就是需要生成一个DaggerPresenter的对象，来让Dagger2注入到DaggerActivity中
 * <p>
 * 类需要用@Module来标明注解
 * 这里有一点规则，用@Provides注解的函数需要以provide开头，然后后面接什么内容都可以，看自己喜欢，事实上，经过我的测试，我把provideActivity()
 * 改成provideA()同样是可以注入成功的，所以大家可以知道，这里是根据返回值类型来标识的，方法名并不重要，只需要保证以provide开头即可。
 * Created by Administrator on 2017/12/22 0022.
 */
@Module
class ActivityModule {
    private MainActivity activity;

    public ActivityModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    public MainActivity provideActivity() {
        return activity;
    }

//    @Provides
//    public User provideUser() {
//        return new User("user from ActivityModule");
//    }

    @Provides
    public DaggerPresenter provideDaggerPresenter(MainActivity activity, User user) {
        return new DaggerPresenter(activity, user);
    }
}
