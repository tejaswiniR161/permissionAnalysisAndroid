package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.zziy;

@zziy
public class zzb {
    /* renamed from: e */
    public static void m1352e(String str) {
        if (zzbf(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void zza(String str, Throwable th) {
        if (zzbf(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zzbf(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean zzbf(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }

    public static void zzc(String str, Throwable th) {
        if (zzbf(4)) {
            Log.i(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzd(String str, Throwable th) {
        if (zzbf(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzdd(String str) {
        if (zzbf(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void zzde(String str) {
        if (zzbf(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void zzdf(String str) {
        if (zzbf(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
