package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class zzamz implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final zzamz bhF = new zzamz();

    /* renamed from: aJ */
    private boolean f1928aJ;
    private final AtomicBoolean bhG = new AtomicBoolean();

    private zzamz() {
    }

    /* renamed from: L */
    public static zzamz m1353L() {
        return bhF;
    }

    public static void zza(Application application) {
        application.registerActivityLifecycleCallbacks(bhF);
        application.registerComponentCallbacks(bhF);
        bhF.f1928aJ = true;
    }

    /* renamed from: M */
    public boolean mo8771M() {
        return this.bhG.get();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.bhG.compareAndSet(true, false)) {
            FirebaseApp.zzcp(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.bhG.compareAndSet(true, false)) {
            FirebaseApp.zzcp(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.bhG.compareAndSet(false, true)) {
            FirebaseApp.zzcp(true);
        }
    }
}
