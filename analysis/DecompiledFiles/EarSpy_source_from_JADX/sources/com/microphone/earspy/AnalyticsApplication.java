package com.microphone.earspy;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class AnalyticsApplication extends Application {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
