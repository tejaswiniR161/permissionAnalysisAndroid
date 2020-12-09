package com.google.firebase.crash.internal;

import android.util.Log;
import com.google.firebase.crash.FirebaseCrash;
import java.lang.Thread;

public class zzh implements Thread.UncaughtExceptionHandler {
    private final FirebaseCrash aVf;
    private final Thread.UncaughtExceptionHandler aVg;

    public zzh(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, FirebaseCrash firebaseCrash) {
        this.aVf = firebaseCrash;
        this.aVg = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Log.e("UncaughtException", "", th);
        try {
            this.aVf.zzi(th);
        } catch (zzb e) {
            try {
                Log.v("UncaughtException", e.getMessage());
            } catch (Exception e2) {
                Log.e("UncaughtException", "Ouch!  My own exception handler threw an exception.", e2);
            }
        }
        if (this.aVg != null) {
            this.aVg.uncaughtException(thread, th);
        }
    }
}
