package com.example.administrator.testdagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.testdagger2.app.AppComponent;
import com.example.administrator.testdagger2.app.MyApplication;
import com.example.administrator.testdagger2.app.User;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @Inject
    DaggerPresenter presenter;
    private TextView tv;

    @Inject
    OkHttpClient client;
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        inject();
        presenter.showUserName();
        Log.e(getClass().getSimpleName(), client == null ? "null" : client.toString());
        Log.e(getClass().getSimpleName(), retrofit == null ? "null" : retrofit.toString());
    }

    private void inject() {
        AppComponent appComponent = ((MyApplication) getApplication()).getAppComponent();
        DaggerActivityComponent.builder()
                .appComponent(appComponent)//app依赖
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    public void showUserName(String name) {
        tv.setText(name);
    }
}


/**
 * presenter
 */
class DaggerPresenter {
    MainActivity activity;
    User user;

    public DaggerPresenter(MainActivity activity, User user) {
        this.user = user;
        this.activity = activity;
    }

    public void showUserName() {
        activity.showUserName(user.name);
    }
}