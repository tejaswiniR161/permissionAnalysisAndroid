package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;

public class zzai extends zzaa {
    private final zzf ass;

    /* renamed from: cc */
    private boolean f2280cc;

    /* renamed from: cd */
    private final AlarmManager f2281cd = ((AlarmManager) getContext().getSystemService("alarm"));

    protected zzai(zzx zzx) {
        super(zzx);
        this.ass = new zzf(zzx) {
            public void run() {
                zzai.this.zzbyl();
            }
        };
    }

    private PendingIntent zzaee() {
        Intent className = new Intent().setClassName(getContext(), (!zzbvi().zzact() || this.anq.zzbxg()) ? "com.google.android.gms.measurement.AppMeasurementReceiver" : "com.google.android.gms.measurement.PackageMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, className, 0);
    }

    /* access modifiers changed from: private */
    public void zzbyl() {
        Intent className = new Intent().setClassName(getContext(), (!zzbvi().zzact() || this.anq.zzbxg()) ? "com.google.android.gms.measurement.AppMeasurementReceiver" : "com.google.android.gms.measurement.PackageMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        getContext().sendBroadcast(className);
    }

    public void cancel() {
        zzaax();
        this.f2280cc = false;
        this.f2281cd.cancel(zzaee());
        this.ass.cancel();
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

    public void zzx(long j) {
        boolean z = false;
        zzaax();
        zzac.zza(zzbvi().zzact() || zzu.zzh(getContext(), false), (Object) "Receiver not registered/enabled");
        if (zzbvi().zzact() || zzae.zzi(getContext(), false)) {
            z = true;
        }
        zzac.zza(z, (Object) "Service not registered/enabled");
        cancel();
        long elapsedRealtime = zzaan().elapsedRealtime() + j;
        this.f2280cc = true;
        if (j < zzbvi().zzbup() && !this.ass.zzfl()) {
            this.ass.zzx(j);
        }
        this.f2281cd.setInexactRepeating(2, elapsedRealtime, Math.max(zzbvi().zzbuq(), j), zzaee());
    }

    public /* bridge */ /* synthetic */ void zzyl() {
        super.zzyl();
    }

    /* access modifiers changed from: protected */
    public void zzym() {
        this.f2281cd.cancel(zzaee());
    }
}
