package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.ads.internal.util.client.zzb;

@zziy
public final class zzkn extends zzb {
    /* renamed from: v */
    public static void m1493v(String str) {
        if (zzue()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzud() {
        return zzdi.zzbdt.get().booleanValue();
    }

    private static boolean zzue() {
        return zzbf(2) && zzud();
    }
}
