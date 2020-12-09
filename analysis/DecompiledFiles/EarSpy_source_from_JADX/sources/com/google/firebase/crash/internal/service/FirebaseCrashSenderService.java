package com.google.firebase.crash.internal.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.firebase.crash.internal.zzf;
import com.google.firebase.crash.internal.zzg;

public final class FirebaseCrashSenderService extends IntentService {
    public static final String ACTION_SEND = String.valueOf(aVt).concat(".SEND");
    private static final String LOG_TAG = FirebaseCrashSenderService.class.getSimpleName();
    private static final String aVt = FirebaseCrashSenderService.class.getName();
    public static final String aVx = String.valueOf(aVt).concat(".API_KEY");
    private zzf aVA;

    @Keep
    public FirebaseCrashSenderService() {
        super(FirebaseCrashSenderService.class.getSimpleName());
    }

    public void onCreate() {
        super.onCreate();
        try {
            zzg.zzcqp().zzbr(getApplicationContext());
            this.aVA = zzg.zzcqp().zzcqs();
            this.aVA.zzap(zze.zzac(this));
        } catch (RemoteException | zzg.zza e) {
            Log.e(LOG_TAG, "Unexpected failure remoting onCreate()", e);
            this.aVA = null;
        }
    }

    public void onDestroy() {
        if (this.aVA != null) {
            try {
                this.aVA.onDestroy();
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Unexpected failure remoting onDestroy()", e);
            }
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (this.aVA != null) {
            try {
                this.aVA.zzaq(zze.zzac(intent));
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Unexpected failure remoting onRunTask()", e);
            }
        }
    }
}
