package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.p000v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzu;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzu.zza {
    private zzu anu;

    private zzu zzbso() {
        if (this.anu == null) {
            this.anu = new zzu(this);
        }
        return this.anu;
    }

    @MainThread
    public void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        zzbso().onReceive(context, intent);
    }
}
