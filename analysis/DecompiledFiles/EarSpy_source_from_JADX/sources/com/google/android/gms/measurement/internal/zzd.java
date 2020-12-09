package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.measurement.internal.zzl;
import java.lang.reflect.InvocationTargetException;

public class zzd extends zzz {
    static final String anZ = String.valueOf(zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / AdError.NETWORK_ERROR_CODE).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");

    /* renamed from: bU */
    private Boolean f2282bU;

    zzd(zzx zzx) {
        super(zzx);
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public long zza(String str, zzl.zza<Long> zza) {
        if (str == null) {
            return zza.get().longValue();
        }
        String zzaw = zzbvd().zzaw(str, zza.getKey());
        if (TextUtils.isEmpty(zzaw)) {
            return zza.get().longValue();
        }
        try {
            return zza.get(Long.valueOf(Long.valueOf(zzaw).longValue())).longValue();
        } catch (NumberFormatException e) {
            return zza.get().longValue();
        }
    }

    public /* bridge */ /* synthetic */ void zzaam() {
        super.zzaam();
    }

    public /* bridge */ /* synthetic */ zze zzaan() {
        return super.zzaan();
    }

    public boolean zzact() {
        return false;
    }

    public boolean zzacu() {
        if (this.f2282bU == null) {
            synchronized (this) {
                if (this.f2282bU == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String zzaxy = zzt.zzaxy();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f2282bU = Boolean.valueOf(str != null && str.equals(zzaxy));
                    }
                    if (this.f2282bU == null) {
                        this.f2282bU = Boolean.TRUE;
                        zzbvg().zzbwc().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f2282bU.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public long zzado() {
        return zzl.api.get().longValue();
    }

    public String zzadt() {
        return "google_app_measurement.db";
    }

    public String zzadu() {
        return "google_app_measurement2.db";
    }

    public long zzadz() {
        return Math.max(0, zzl.aoG.get().longValue());
    }

    public String zzap(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedAuthority = builder.scheme(zzl.aoI.get()).encodedAuthority(zzl.aoJ.get());
        String valueOf = String.valueOf(str);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzbsy()));
        return builder.build().toString();
    }

    public boolean zzasm() {
        return zzqw.zzasm();
    }

    public int zzb(String str, zzl.zza<Integer> zza) {
        if (str == null) {
            return zza.get().intValue();
        }
        String zzaw = zzbvd().zzaw(str, zza.getKey());
        if (TextUtils.isEmpty(zzaw)) {
            return zza.get().intValue();
        }
        try {
            return zza.get(Integer.valueOf(Integer.valueOf(zzaw).intValue())).intValue();
        } catch (NumberFormatException e) {
            return zza.get().intValue();
        }
    }

    public long zzbsy() {
        return 9683;
    }

    /* access modifiers changed from: package-private */
    public String zzbtl() {
        return zzl.aoE.get();
    }

    public int zzbtm() {
        return 25;
    }

    public int zzbtn() {
        return 32;
    }

    public int zzbto() {
        return 24;
    }

    /* access modifiers changed from: package-private */
    public int zzbtp() {
        return 24;
    }

    /* access modifiers changed from: package-private */
    public int zzbtq() {
        return 36;
    }

    /* access modifiers changed from: package-private */
    public int zzbtr() {
        return 256;
    }

    public int zzbts() {
        return 36;
    }

    public int zzbtt() {
        return 2048;
    }

    /* access modifiers changed from: package-private */
    public int zzbtu() {
        return 500;
    }

    public long zzbtv() {
        return (long) zzl.aoO.get().intValue();
    }

    public long zzbtw() {
        return (long) zzl.aoQ.get().intValue();
    }

    /* access modifiers changed from: package-private */
    public int zzbtx() {
        return 25;
    }

    /* access modifiers changed from: package-private */
    public int zzbty() {
        return 50;
    }

    /* access modifiers changed from: package-private */
    public long zzbtz() {
        return 3600000;
    }

    /* access modifiers changed from: package-private */
    public long zzbua() {
        return 60000;
    }

    /* access modifiers changed from: package-private */
    public long zzbub() {
        return 61000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = zzlu("firebase_analytics_collection_deactivated");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzbuc() {
        /*
            r2 = this;
            r0 = 0
            boolean r1 = r2.zzact()
            if (r1 == 0) goto L_0x0008
        L_0x0007:
            return r0
        L_0x0008:
            java.lang.String r1 = "firebase_analytics_collection_deactivated"
            java.lang.Boolean r1 = r2.zzlu(r1)
            if (r1 == 0) goto L_0x0007
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0007
            r0 = 1
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzd.zzbuc():boolean");
    }

    public Boolean zzbud() {
        if (zzact()) {
            return null;
        }
        return zzlu("firebase_analytics_collection_enabled");
    }

    public long zzbue() {
        return zzl.apf.get().longValue();
    }

    public long zzbuf() {
        return zzl.apb.get().longValue();
    }

    public long zzbug() {
        return 1000;
    }

    public int zzbuh() {
        return Math.max(0, zzl.aoM.get().intValue());
    }

    public int zzbui() {
        return Math.max(1, zzl.aoN.get().intValue());
    }

    public String zzbuj() {
        return zzl.aoU.get();
    }

    public long zzbuk() {
        return zzl.aoH.get().longValue();
    }

    public long zzbul() {
        return Math.max(0, zzl.aoV.get().longValue());
    }

    public long zzbum() {
        return Math.max(0, zzl.aoX.get().longValue());
    }

    public long zzbun() {
        return Math.max(0, zzl.aoY.get().longValue());
    }

    public long zzbuo() {
        return Math.max(0, zzl.aoZ.get().longValue());
    }

    public long zzbup() {
        return Math.max(0, zzl.apa.get().longValue());
    }

    public long zzbuq() {
        return zzl.aoW.get().longValue();
    }

    public long zzbur() {
        return Math.max(0, zzl.apc.get().longValue());
    }

    public long zzbus() {
        return Math.max(0, zzl.apd.get().longValue());
    }

    public int zzbut() {
        return Math.min(20, Math.max(0, zzl.ape.get().intValue()));
    }

    public String zzbuu() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{"firebase.analytics.debug-mode", ""});
        } catch (ClassNotFoundException e) {
            zzbvg().zzbwc().zzj("Could not find SystemProperties class", e);
        } catch (NoSuchMethodException e2) {
            zzbvg().zzbwc().zzj("Could not find SystemProperties.get() method", e2);
        } catch (IllegalAccessException e3) {
            zzbvg().zzbwc().zzj("Could not access SystemProperties.get()", e3);
        } catch (InvocationTargetException e4) {
            zzbvg().zzbwc().zzj("SystemProperties.get() threw an exception", e4);
        }
        return "";
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

    public int zzlo(@Size(min = 1) String str) {
        return Math.max(0, Math.min(1000000, zzb(str, zzl.aoP)));
    }

    public int zzlp(@Size(min = 1) String str) {
        return zzb(str, zzl.aoR);
    }

    public int zzlq(@Size(min = 1) String str) {
        return zzb(str, zzl.aoS);
    }

    /* access modifiers changed from: package-private */
    public long zzlr(String str) {
        return zza(str, zzl.aoF);
    }

    /* access modifiers changed from: package-private */
    public int zzls(String str) {
        return zzb(str, zzl.apg);
    }

    /* access modifiers changed from: package-private */
    public int zzlt(String str) {
        return Math.max(0, Math.min(AdError.SERVER_ERROR_CODE, zzb(str, zzl.aph)));
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Boolean zzlu(@Size(min = 1) String str) {
        zzac.zzhz(str);
        try {
            PackageManager packageManager = getContext().getPackageManager();
            if (packageManager == null) {
                zzbvg().zzbwc().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzbvg().zzbwc().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzbvg().zzbwc().log("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (applicationInfo.metaData.containsKey(str)) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            } else {
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzbvg().zzbwc().zzj("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public int zzlv(String str) {
        return zzb(str, zzl.aoK);
    }

    public int zzlw(String str) {
        return Math.max(0, zzb(str, zzl.aoL));
    }

    public int zzlx(String str) {
        return Math.max(0, Math.min(1000000, zzb(str, zzl.aoT)));
    }

    public /* bridge */ /* synthetic */ void zzyl() {
        super.zzyl();
    }
}
