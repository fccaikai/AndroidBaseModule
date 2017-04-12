package com.kcode.baselib.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by caik on 2017/4/12.
 */

public class BaseApp extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }
}
