package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzarc;
import com.google.android.gms.internal.zzard;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;

public class zzv extends zzaa {
    private final Map<String, Map<String, String>> aqu = new ArrayMap();
    private final Map<String, Map<String, Boolean>> aqv = new ArrayMap();
    private final Map<String, Map<String, Boolean>> aqw = new ArrayMap();
    private final Map<String, zzvl.zzb> aqx = new ArrayMap();
    private final Map<String, String> aqy = new ArrayMap();

    zzv(zzx zzx) {
        super(zzx);
    }

    private Map<String, String> zza(zzvl.zzb zzb) {
        ArrayMap arrayMap = new ArrayMap();
        if (!(zzb == null || zzb.atf == null)) {
            for (zzvl.zzc zzc : zzb.atf) {
                if (zzc != null) {
                    arrayMap.put(zzc.zzcb, zzc.value);
                }
            }
        }
        return arrayMap;
    }

    private void zza(String str, zzvl.zzb zzb) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        if (!(zzb == null || zzb.atg == null)) {
            for (zzvl.zza zza : zzb.atg) {
                if (zza != null) {
                    String str2 = AppMeasurement.zza.anr.get(zza.name);
                    if (str2 != null) {
                        zza.name = str2;
                    }
                    arrayMap.put(zza.name, zza.atb);
                    arrayMap2.put(zza.name, zza.atc);
                }
            }
        }
        this.aqv.put(str, arrayMap);
        this.aqw.put(str, arrayMap2);
    }

    @WorkerThread
    private zzvl.zzb zze(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzvl.zzb();
        }
        zzarc zzbd = zzarc.zzbd(bArr);
        zzvl.zzb zzb = new zzvl.zzb();
        try {
            zzvl.zzb zzb2 = (zzvl.zzb) zzb.zzb(zzbd);
            zzbvg().zzbwj().zze("Parsed config. version, gmp_app_id", zzb.atd, zzb.anQ);
            return zzb;
        } catch (IOException e) {
            zzbvg().zzbwe().zze("Unable to merge remote config", str, e);
            return null;
        }
    }

    @WorkerThread
    private void zzmo(String str) {
        zzaax();
        zzyl();
        zzac.zzhz(str);
        if (!this.aqx.containsKey(str)) {
            byte[] zzmb = zzbvb().zzmb(str);
            if (zzmb == null) {
                this.aqu.put(str, (Object) null);
                this.aqv.put(str, (Object) null);
                this.aqw.put(str, (Object) null);
                this.aqx.put(str, (Object) null);
                this.aqy.put(str, (Object) null);
                return;
            }
            zzvl.zzb zze = zze(str, zzmb);
            this.aqu.put(str, zza(zze));
            zza(str, zze);
            this.aqx.put(str, zze);
            this.aqy.put(str, (Object) null);
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzaam() {
        super.zzaam();
    }

    public /* bridge */ /* synthetic */ zze zzaan() {
        return super.zzaan();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public String zzaw(String str, String str2) {
        zzyl();
        zzmo(str);
        Map map = this.aqu.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzax(String str, String str2) {
        zzyl();
        zzmo(str);
        Map map = this.aqv.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzay(String str, String str2) {
        zzyl();
        zzmo(str);
        Map map = this.aqw.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public boolean zzb(String str, byte[] bArr, String str2) {
        zzaax();
        zzyl();
        zzac.zzhz(str);
        zzvl.zzb zze = zze(str, bArr);
        if (zze == null) {
            return false;
        }
        zza(str, zze);
        this.aqx.put(str, zze);
        this.aqy.put(str, str2);
        this.aqu.put(str, zza(zze));
        zzbuw().zza(str, zze.ath);
        try {
            zze.ath = null;
            byte[] bArr2 = new byte[zze.mo9192db()];
            zze.zza(zzard.zzbe(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            zzbvg().zzbwe().zzj("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        zzbvb().zzd(str, bArr);
        return true;
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

    /* access modifiers changed from: protected */
    @WorkerThread
    public zzvl.zzb zzmp(String str) {
        zzaax();
        zzyl();
        zzac.zzhz(str);
        zzmo(str);
        return this.aqx.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public String zzmq(String str) {
        zzyl();
        return this.aqy.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzmr(String str) {
        zzyl();
        this.aqy.put(str, (Object) null);
    }

    public /* bridge */ /* synthetic */ void zzyl() {
        super.zzyl();
    }

    /* access modifiers changed from: protected */
    public void zzym() {
    }
}
