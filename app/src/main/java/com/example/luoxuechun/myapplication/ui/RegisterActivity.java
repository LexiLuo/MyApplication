package com.example.luoxuechun.myapplication.ui;

import android.os.Bundle;
import android.os.StrictMode;

/**
 * Created by zcy on 2017/6/22.
 *
 */

public class RegisterActivity extends BaseAppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        //为了在主线程中访问网络，所以加了这两行
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
