package com.microphone.earspy.inappbilling;

import android.app.Activity;
import android.os.Bundle;

public abstract class BlundellActivity extends Activity {
    private Navigator navigator;
    private Toaster toaster;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.navigator = new Navigator(this);
        this.toaster = new Toaster(this);
    }

    /* access modifiers changed from: protected */
    public Navigator navigate() {
        return this.navigator;
    }

    /* access modifiers changed from: protected */
    public void popBurntToast(String msg) {
        this.toaster.popBurntToast(msg);
    }

    /* access modifiers changed from: protected */
    public void popToast(String msg) {
        this.toaster.popToast(msg);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.navigator = null;
        this.toaster = null;
    }
}
