package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzqv extends BroadcastReceiver {
    protected Context mContext;

    /* renamed from: yO */
    private final zza f2155yO;

    public static abstract class zza {
        public abstract void zzaqp();
    }

    public zzqv(zza zza2) {
        this.f2155yO = zza2;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        String str = null;
        if (data != null) {
            str = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(str)) {
            this.f2155yO.zzaqp();
            unregister();
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public synchronized void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
    }
}
