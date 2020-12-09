package com.google.firebase.crash.internal.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.firebase.crash.internal.zze;
import com.google.firebase.crash.internal.zzg;

public final class FirebaseCrashReceiverService extends IntentService {
    private static final String LOG_TAG = FirebaseCrashReceiverService.class.getSimpleName();
    private static final String aVt = FirebaseCrashReceiverService.class.getName();
    public static final String aVu = String.valueOf(aVt).concat(".SAVE");
    public static final String aVv = String.valueOf(aVt).concat(".CRASH_REPORT");
    public static final String aVw = String.valueOf(aVt).concat(".CRASH_TIME");
    public static final String aVx = String.valueOf(aVt).concat(".API_KEY");
    public static final String aVy = String.valueOf(aVt).concat(".IS_FATAL");
    private zze aVz;

    @Keep
    public FirebaseCrashReceiverService() {
        super(FirebaseCrashReceiverService.class.getSimpleName());
    }

    public void onCreate() {
        super.onCreate();
        try {
            zzg.zzcqp().zzbr(getApplicationContext());
            this.aVz = zzg.zzcqp().zzcqr();
            this.aVz.zzap(com.google.android.gms.dynamic.zze.zzac(this));
        } catch (RemoteException | zzg.zza e) {
            Log.e(LOG_TAG, "Unexpected failure remoting onCreate()", e);
            this.aVz = null;
        }
    }

    public void onDestroy() {
        if (this.aVz != null) {
            try {
                this.aVz.onDestroy();
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Unexpected failure remoting onDestroy()", e);
            }
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (this.aVz != null) {
            try {
                this.aVz.zzaq(com.google.android.gms.dynamic.zze.zzac(intent));
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Unexpected failure remoting onHandleIntent()", e);
            }
        }
    }
}
