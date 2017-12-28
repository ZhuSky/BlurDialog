package com.zhushuai.stopservice.App;

import android.app.Application;

import com.flurgle.blurkit.BlurKit;


/**
 * 作者 by ZhuShuai on 2017/12/28 9:18.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BlurKit.init(this);
    }
}
