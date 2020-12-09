package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public class zzac extends zzaa {
    private zza arA;
    private AppMeasurement.zzb arB;
    private final Set<AppMeasurement.zzc> arC = new CopyOnWriteArraySet();
    private boolean arD;

    @MainThread
    @TargetApi(14)
    private class zza implements Application.ActivityLifecycleCallbacks {
        private zza() {
        }

        private boolean zzmv(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            zzac.this.zzd("auto", "_ldl", str);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            Uri data;
            Bundle zzt;
            try {
                zzac.this.zzbvg().zzbwj().log("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                    if (bundle == null && (zzt = zzac.this.zzbvc().zzt(data)) != null) {
                        zzac.this.zzf("auto", "_cmp", zzt);
                    }
                    String queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (!queryParameter.contains("gclid")) {
                            zzac.this.zzbvg().zzbwi().log("Activity created with data 'referrer' param without gclid");
                            return;
                        }
                        zzac.this.zzbvg().zzbwi().zzj("Activity created with referrer", queryParameter);
                        zzmv(queryParameter);
                    }
                }
            } catch (Throwable th) {
                zzac.this.zzbvg().zzbwc().zzj("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        @MainThread
        public void onActivityPaused(Activity activity) {
            zzac.this.zzbve().zzbyh();
        }

        @MainThread
        public void onActivityResumed(Activity activity) {
            zzac.this.zzbve().zzbyf();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzac(zzx zzx) {
        super(zzx);
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzaan().currentTimeMillis(), bundle, z, z2, z3, str3);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zza(String str, String str2, Object obj, long j) {
        com.google.android.gms.common.internal.zzac.zzhz(str);
        com.google.android.gms.common.internal.zzac.zzhz(str2);
        zzyl();
        zzaam();
        zzaax();
        if (!this.anq.isEnabled()) {
            zzbvg().zzbwi().log("User property not set since app measurement is disabled");
        } else if (this.anq.zzbwv()) {
            zzbvg().zzbwi().zze("Setting user property (FE)", str2, obj);
            zzbva().zza(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        com.google.android.gms.common.internal.zzac.zzhz(str);
        com.google.android.gms.common.internal.zzac.zzhz(str2);
        com.google.android.gms.common.internal.zzac.zzy(bundle);
        zzyl();
        zzaax();
        if (!this.anq.isEnabled()) {
            zzbvg().zzbwi().log("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.arD) {
            this.arD = true;
            zzbxx();
        }
        boolean zznh = zzal.zznh(str2);
        if (z && this.arB != null && !zznh) {
            zzbvg().zzbwi().zze("Passing event to registered event handler (FE)", str2, bundle);
            this.arB.zzb(str, str2, bundle, j);
        } else if (this.anq.zzbwv()) {
            int zzmz = zzbvc().zzmz(str2);
            if (zzmz != 0) {
                this.anq.zzbvc().zza(zzmz, "_ev", zzbvc().zza(str2, zzbvi().zzbtn(), true), str2 != null ? str2.length() : 0);
                return;
            }
            bundle.putString("_o", str);
            Bundle zza2 = zzbvc().zza(str2, bundle, (List<String>) zzf.zzz("_o"), z3);
            Bundle zzam = z2 ? zzam(zza2) : zza2;
            zzbvg().zzbwi().zze("Logging event (FE)", str2, zzam);
            zzbva().zzc(new EventParcel(str2, new EventParams(zzam), str, j), str3);
            for (AppMeasurement.zzc zzc : this.arC) {
                zzc.zzc(str, str2, new Bundle(zzam), j);
            }
        }
    }

    @WorkerThread
    private void zzbxx() {
        try {
            zzg(Class.forName(zzbxy()));
        } catch (ClassNotFoundException e) {
            zzbvg().zzbwh().log("Tag Manager is not found and thus will not be used");
        }
    }

    private String zzbxy() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzch(boolean z) {
        zzyl();
        zzaam();
        zzaax();
        zzbvg().zzbwi().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzbvh().setMeasurementEnabled(z);
        zzbva().zzbxz();
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void setMeasurementEnabled(final boolean z) {
        zzaax();
        zzaam();
        zzbvf().zzm(new Runnable() {
            public void run() {
                zzac.this.zzch(z);
            }
        });
    }

    public void setMinimumSessionDuration(final long j) {
        zzaam();
        zzbvf().zzm(new Runnable() {
            public void run() {
                zzac.this.zzbvh().apZ.set(j);
                zzac.this.zzbvg().zzbwi().zzj("Minimum session duration set", Long.valueOf(j));
            }
        });
    }

    public void setSessionTimeoutDuration(final long j) {
        zzaam();
        zzbvf().zzm(new Runnable() {
            public void run() {
                zzac.this.zzbvh().aqa.set(j);
                zzac.this.zzbvg().zzbwi().zzj("Session timeout duration set", Long.valueOf(j));
            }
        });
    }

    @WorkerThread
    public void zza(AppMeasurement.zzb zzb) {
        zzyl();
        zzaam();
        zzaax();
        if (!(zzb == null || zzb == this.arB)) {
            com.google.android.gms.common.internal.zzac.zza(this.arB == null, (Object) "EventInterceptor already set.");
        }
        this.arB = zzb;
    }

    public void zza(AppMeasurement.zzc zzc) {
        zzaam();
        zzaax();
        com.google.android.gms.common.internal.zzac.zzy(zzc);
        if (!this.arC.add(zzc)) {
            zzbvg().zzbwe().log("OnEventListener already registered");
        }
    }

    /* access modifiers changed from: protected */
    public void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        final Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        final boolean z4 = z;
        final boolean z5 = z2;
        final boolean z6 = z3;
        final String str6 = str3;
        zzbvf().zzm(new Runnable() {
            public void run() {
                zzac.this.zzb(str4, str5, j2, bundle2, z4, z5, z6, str6);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void zza(String str, String str2, long j, Object obj) {
        final String str3 = str;
        final String str4 = str2;
        final Object obj2 = obj;
        final long j2 = j;
        zzbvf().zzm(new Runnable() {
            public void run() {
                zzac.this.zza(str3, str4, obj2, j2);
            }
        });
    }

    public void zza(String str, String str2, Bundle bundle, boolean z) {
        zzaam();
        zza(str, str2, bundle, true, this.arB == null || zzal.zznh(str2), z, (String) null);
    }

    public /* bridge */ /* synthetic */ void zzaam() {
        super.zzaam();
    }

    public /* bridge */ /* synthetic */ zze zzaan() {
        return super.zzaan();
    }

    /* access modifiers changed from: package-private */
    public Bundle zzam(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzl = zzbvc().zzl(str, bundle.get(str));
                if (zzl == null) {
                    zzbvg().zzbwe().zzj("Param value can't be null", str);
                } else {
                    zzbvc().zza(bundle2, str, zzl);
                }
            }
        }
        return bundle2;
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

    @TargetApi(14)
    public void zzbxv() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.arA == null) {
                this.arA = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.arA);
            application.registerActivityLifecycleCallbacks(this.arA);
            zzbvg().zzbwj().log("Registered activity lifecycle callback");
        }
    }

    @WorkerThread
    public void zzbxw() {
        zzyl();
        zzaam();
        zzaax();
        if (this.anq.zzbwv()) {
            zzbva().zzbxw();
            String zzbws = zzbvh().zzbws();
            if (!TextUtils.isEmpty(zzbws) && !zzbws.equals(zzbuz().zzbvv())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", zzbws);
                zzf("auto", "_ou", bundle);
            }
        }
    }

    public List<UserAttributeParcel> zzci(final boolean z) {
        zzaam();
        zzaax();
        zzbvg().zzbwi().log("Fetching user attributes (FE)");
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.anq.zzbvf().zzm(new Runnable() {
                public void run() {
                    zzac.this.zzbva().zza((AtomicReference<List<UserAttributeParcel>>) atomicReference, z);
                }
            });
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzbvg().zzbwe().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<UserAttributeParcel> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzbvg().zzbwe().log("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    public void zzd(String str, String str2, Bundle bundle, long j) {
        zzaam();
        zza(str, str2, j, bundle, false, true, true, (String) null);
    }

    public void zzd(String str, String str2, Object obj) {
        int i = 0;
        com.google.android.gms.common.internal.zzac.zzhz(str);
        long currentTimeMillis = zzaan().currentTimeMillis();
        int zznb = zzbvc().zznb(str2);
        if (zznb != 0) {
            String zza2 = zzbvc().zza(str2, zzbvi().zzbto(), true);
            if (str2 != null) {
                i = str2.length();
            }
            this.anq.zzbvc().zza(zznb, "_ev", zza2, i);
        } else if (obj != null) {
            int zzm = zzbvc().zzm(str2, obj);
            if (zzm != 0) {
                String zza3 = zzbvc().zza(str2, zzbvi().zzbto(), true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.anq.zzbvc().zza(zzm, "_ev", zza3, i);
                return;
            }
            Object zzn = zzbvc().zzn(str2, obj);
            if (zzn != null) {
                zza(str, str2, currentTimeMillis, zzn);
            }
        } else {
            zza(str, str2, currentTimeMillis, (Object) null);
        }
    }

    public void zzf(String str, String str2, Bundle bundle) {
        zzaam();
        zza(str, str2, bundle, true, this.arB == null || zzal.zznh(str2), false, (String) null);
    }

    @WorkerThread
    public void zzg(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{getContext()});
        } catch (Exception e) {
            zzbvg().zzbwe().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    public /* bridge */ /* synthetic */ void zzyl() {
        super.zzyl();
    }

    /* access modifiers changed from: protected */
    public void zzym() {
    }
}
