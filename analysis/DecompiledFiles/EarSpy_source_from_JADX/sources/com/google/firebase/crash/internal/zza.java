package com.google.firebase.crash.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;

public class zza {
    static AppMeasurement aVb;
    private final Context mContext;

    public zza(Context context) {
        this.mContext = context;
    }

    private void zzar(Bundle bundle) {
        AppMeasurement appMeasurement;
        if (0 == 0) {
            try {
                appMeasurement = AppMeasurement.getInstance(this.mContext);
            } catch (NoClassDefFoundError e) {
                String valueOf = String.valueOf(e);
                Log.w("FirebaseCrashAnalytics", new StringBuilder(String.valueOf(valueOf).length() + 50).append("Unable to log event, missing measurement library: ").append(valueOf).toString());
                return;
            }
        } else {
            appMeasurement = aVb;
        }
        appMeasurement.zze("crash", "_ae", bundle);
    }

    public void zza(boolean z, long j) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("fatal", 1);
        } else {
            bundle.putInt("fatal", 0);
        }
        bundle.putLong("timestamp", j);
        zzar(bundle);
    }
}
