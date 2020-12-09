package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzn {

    /* renamed from: CA */
    private static zzn f1745CA;

    /* renamed from: Cz */
    private static final Object f1746Cz = new Object();

    public static zzn zzcf(Context context) {
        synchronized (f1746Cz) {
            if (f1745CA == null) {
                f1745CA = new zzo(context.getApplicationContext());
            }
        }
        return f1745CA;
    }

    public abstract boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void zzb(String str, String str2, ServiceConnection serviceConnection, String str3);
}
