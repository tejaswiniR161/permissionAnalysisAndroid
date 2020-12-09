package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.measurement.AppMeasurement;

public class zzp extends zzaa {

    /* renamed from: CQ */
    private final String f2290CQ = zzbvi().zzbtl();
    private final long anE = zzbvi().zzbsy();
    private final char apm;
    private final zza apn;
    private final zza apo;
    private final zza app;
    private final zza apq;
    private final zza apr;
    private final zza aps;
    private final zza apt;
    private final zza apu;
    private final zza apv;

    public class zza {
        private final boolean apy;
        private final boolean apz;
        private final int mPriority;

        zza(int i, boolean z, boolean z2) {
            this.mPriority = i;
            this.apy = z;
            this.apz = z2;
        }

        public void log(String str) {
            zzp.this.zza(this.mPriority, this.apy, this.apz, str, (Object) null, (Object) null, (Object) null);
        }

        public void zzd(String str, Object obj, Object obj2, Object obj3) {
            zzp.this.zza(this.mPriority, this.apy, this.apz, str, obj, obj2, obj3);
        }

        public void zze(String str, Object obj, Object obj2) {
            zzp.this.zza(this.mPriority, this.apy, this.apz, str, obj, obj2, (Object) null);
        }

        public void zzj(String str, Object obj) {
            zzp.this.zza(this.mPriority, this.apy, this.apz, str, obj, (Object) null, (Object) null);
        }
    }

    zzp(zzx zzx) {
        super(zzx);
        if (zzbvi().zzacu()) {
            this.apm = zzbvi().zzact() ? 'P' : 'C';
        } else {
            this.apm = zzbvi().zzact() ? 'p' : 'c';
        }
        this.apn = new zza(6, false, false);
        this.apo = new zza(6, true, false);
        this.app = new zza(6, false, true);
        this.apq = new zza(5, false, false);
        this.apr = new zza(5, true, false);
        this.aps = new zza(5, false, true);
        this.apt = new zza(4, false, false);
        this.apu = new zza(3, false, false);
        this.apv = new zza(2, false, false);
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String zzc = zzc(z, obj);
        String zzc2 = zzc(z, obj2);
        String zzc3 = zzc(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzc)) {
            sb.append(str2);
            sb.append(zzc);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzc2)) {
            sb.append(str2);
            sb.append(zzc2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzc3)) {
            sb.append(str2);
            sb.append(zzc3);
        }
        return sb.toString();
    }

    static String zzc(boolean z, Object obj) {
        StackTraceElement stackTraceElement;
        String className;
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            }
            Throwable th = (Throwable) valueOf;
            StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String zzmj = zzmj(AppMeasurement.class.getCanonicalName());
            String zzmj2 = zzmj(zzx.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                stackTraceElement = stackTrace[i];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                    String zzmj3 = zzmj(className);
                    if (zzmj3.equals(zzmj) || zzmj3.equals(zzmj2)) {
                        sb.append(": ");
                        sb.append(stackTraceElement);
                    }
                }
                i++;
            }
            sb.append(": ");
            sb.append(stackTraceElement);
            return sb.toString();
        }
    }

    private static String zzmj(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    public void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zzbf(i)) {
            zzo(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    public /* bridge */ /* synthetic */ void zzaam() {
        super.zzaam();
    }

    public /* bridge */ /* synthetic */ zze zzaan() {
        return super.zzaan();
    }

    public void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        zzac.zzy(str);
        zzw zzbwx = this.anq.zzbwx();
        if (zzbwx == null) {
            zzo(6, "Scheduler not set. Not logging error/warn.");
        } else if (!zzbwx.isInitialized()) {
            zzo(6, "Scheduler not initialized. Not logging error/warn.");
        } else if (zzbwx.zzbxt()) {
            zzo(6, "Scheduler shutdown. Not logging error/warn.");
        } else {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String valueOf = String.valueOf("1");
            char charAt = "01VDIWEA?".charAt(i);
            char c = this.apm;
            long j = this.anE;
            String valueOf2 = String.valueOf(zza(true, str, obj, obj2, obj3));
            final String sb = new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
            if (sb.length() > 1024) {
                sb = str.substring(0, 1024);
            }
            zzbwx.zzm(new Runnable() {
                public void run() {
                    zzt zzbvh = zzp.this.anq.zzbvh();
                    if (!zzbvh.isInitialized() || zzbvh.zzbxt()) {
                        zzp.this.zzo(6, "Persisted config not initialized . Not logging error/warn.");
                    } else {
                        zzbvh.apP.zzfd(sb);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzbf(int i) {
        return Log.isLoggable(this.f2290CQ, i);
    }

    public /* bridge */ /* synthetic */ void zzbuv() {
        super.zzbuv();
    }

    public /* bridge */ /* synthetic */ zzc zzbuw() {
        return super.zzbuw();
    }

    public /* bridge */ /* synthetic */ zzac zzbux() {
        return super.zzbux();
    }

    public /* bridge */ /* synthetic */ zzn zzbuy() {
        return super.zzbuy();
    }

    public /* bridge */ /* synthetic */ zzg zzbuz() {
        return super.zzbuz();
    }

    public /* bridge */ /* synthetic */ zzad zzbva() {
        return super.zzbva();
    }

    public /* bridge */ /* synthetic */ zze zzbvb() {
        return super.zzbvb();
    }

    public /* bridge */ /* synthetic */ zzal zzbvc() {
        return super.zzbvc();
    }

    public /* bridge */ /* synthetic */ zzv zzbvd() {
        return super.zzbvd();
    }

    public /* bridge */ /* synthetic */ zzaf zzbve() {
        return super.zzbve();
    }

    public /* bridge */ /* synthetic */ zzw zzbvf() {
        return super.zzbvf();
    }

    public /* bridge */ /* synthetic */ zzp zzbvg() {
        return super.zzbvg();
    }

    public /* bridge */ /* synthetic */ zzt zzbvh() {
        return super.zzbvh();
    }

    public /* bridge */ /* synthetic */ zzd zzbvi() {
        return super.zzbvi();
    }

    public zza zzbwc() {
        return this.apn;
    }

    public zza zzbwd() {
        return this.apo;
    }

    public zza zzbwe() {
        return this.apq;
    }

    public zza zzbwf() {
        return this.apr;
    }

    public zza zzbwg() {
        return this.aps;
    }

    public zza zzbwh() {
        return this.apt;
    }

    public zza zzbwi() {
        return this.apu;
    }

    public zza zzbwj() {
        return this.apv;
    }

    public String zzbwk() {
        Pair<String, Long> zzafm = zzbvh().apP.zzafm();
        if (zzafm == null || zzafm == zzt.apO) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(zzafm.second));
        String str = (String) zzafm.first;
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    /* access modifiers changed from: protected */
    public void zzo(int i, String str) {
        Log.println(i, this.f2290CQ, str);
    }

    public /* bridge */ /* synthetic */ void zzyl() {
        super.zzyl();
    }

    /* access modifiers changed from: protected */
    public void zzym() {
    }
}
