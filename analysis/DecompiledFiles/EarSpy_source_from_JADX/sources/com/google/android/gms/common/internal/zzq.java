package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzq {

    /* renamed from: CO */
    public static final int f1763CO = (23 - " PII_LOG".length());

    /* renamed from: CP */
    private static final String f1764CP = null;

    /* renamed from: CQ */
    private final String f1765CQ;

    /* renamed from: CR */
    private final String f1766CR;

    public zzq(String str) {
        this(str, (String) null);
    }

    public zzq(String str, String str2) {
        zzac.zzb(str, (Object) "log tag cannot be null");
        zzac.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f1765CQ = str;
        if (str2 == null || str2.length() <= 0) {
            this.f1766CR = null;
        } else {
            this.f1766CR = str2;
        }
    }

    private String zzhx(String str) {
        return this.f1766CR == null ? str : this.f1766CR.concat(str);
    }

    public void zzae(String str, String str2) {
        if (zzgp(3)) {
            Log.d(str, zzhx(str2));
        }
    }

    public void zzaf(String str, String str2) {
        if (zzgp(5)) {
            Log.w(str, zzhx(str2));
        }
    }

    public void zzag(String str, String str2) {
        if (zzgp(6)) {
            Log.e(str, zzhx(str2));
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        if (zzgp(4)) {
            Log.i(str, zzhx(str2), th);
        }
    }

    public void zzc(String str, String str2, Throwable th) {
        if (zzgp(5)) {
            Log.w(str, zzhx(str2), th);
        }
    }

    public void zzd(String str, String str2, Throwable th) {
        if (zzgp(6)) {
            Log.e(str, zzhx(str2), th);
        }
    }

    public void zze(String str, String str2, Throwable th) {
        if (zzgp(7)) {
            Log.e(str, zzhx(str2), th);
            Log.wtf(str, zzhx(str2), th);
        }
    }

    public boolean zzgp(int i) {
        return Log.isLoggable(this.f1765CQ, i);
    }
}
