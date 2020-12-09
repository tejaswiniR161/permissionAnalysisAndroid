package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.zze;
import com.google.android.gms.measurement.internal.zzm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class zzy extends zzm.zza {
    /* access modifiers changed from: private */
    public final zzx anq;
    private Boolean art;
    @Nullable
    private String aru;

    public zzy(zzx zzx) {
        this(zzx, (String) null);
    }

    public zzy(zzx zzx, @Nullable String str) {
        zzac.zzy(zzx);
        this.anq = zzx;
        this.aru = str;
    }

    @BinderThread
    private void zzf(AppMetadata appMetadata) {
        zzac.zzy(appMetadata);
        zzmt(appMetadata.packageName);
        this.anq.zzbvc().zzne(appMetadata.anQ);
    }

    @BinderThread
    private void zzmt(String str) throws SecurityException {
        if (TextUtils.isEmpty(str)) {
            this.anq.zzbvg().zzbwc().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            zzmu(str);
        } catch (SecurityException e) {
            this.anq.zzbvg().zzbwc().zzj("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    @BinderThread
    public List<UserAttributeParcel> zza(final AppMetadata appMetadata, boolean z) {
        zzf(appMetadata);
        try {
            List<zzak> list = (List) this.anq.zzbvf().zzd(new Callable<List<zzak>>() {
                /* renamed from: zzbxs */
                public List<zzak> call() throws Exception {
                    zzy.this.anq.zzbxp();
                    return zzy.this.anq.zzbvb().zzly(appMetadata.packageName);
                }
            }).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzak zzak : list) {
                if (z || !zzal.zznh(zzak.mName)) {
                    arrayList.add(new UserAttributeParcel(zzak));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.anq.zzbvg().zzbwc().zzj("Failed to get user attributes", e);
            return null;
        }
    }

    @BinderThread
    public void zza(final AppMetadata appMetadata) {
        zzf(appMetadata);
        this.anq.zzbvf().zzm(new Runnable() {
            public void run() {
                zzy.this.anq.zzbxp();
                zzy.this.zzms(appMetadata.anU);
                zzy.this.anq.zzd(appMetadata);
            }
        });
    }

    @BinderThread
    public void zza(final EventParcel eventParcel, final AppMetadata appMetadata) {
        zzac.zzy(eventParcel);
        zzf(appMetadata);
        this.anq.zzbvf().zzm(new Runnable() {
            public void run() {
                zzy.this.anq.zzbxp();
                zzy.this.zzms(appMetadata.anU);
                zzy.this.anq.zzb(eventParcel, appMetadata);
            }
        });
    }

    @BinderThread
    public void zza(final EventParcel eventParcel, final String str, final String str2) {
        zzac.zzy(eventParcel);
        zzac.zzhz(str);
        zzmt(str);
        this.anq.zzbvf().zzm(new Runnable() {
            public void run() {
                zzy.this.anq.zzbxp();
                zzy.this.zzms(str2);
                zzy.this.anq.zzb(eventParcel, str);
            }
        });
    }

    @BinderThread
    public void zza(final UserAttributeParcel userAttributeParcel, final AppMetadata appMetadata) {
        zzac.zzy(userAttributeParcel);
        zzf(appMetadata);
        if (userAttributeParcel.getValue() == null) {
            this.anq.zzbvf().zzm(new Runnable() {
                public void run() {
                    zzy.this.anq.zzbxp();
                    zzy.this.zzms(appMetadata.anU);
                    zzy.this.anq.zzc(userAttributeParcel, appMetadata);
                }
            });
        } else {
            this.anq.zzbvf().zzm(new Runnable() {
                public void run() {
                    zzy.this.anq.zzbxp();
                    zzy.this.zzms(appMetadata.anU);
                    zzy.this.anq.zzb(userAttributeParcel, appMetadata);
                }
            });
        }
    }

    @BinderThread
    public byte[] zza(final EventParcel eventParcel, final String str) {
        zzac.zzhz(str);
        zzac.zzy(eventParcel);
        zzmt(str);
        this.anq.zzbvg().zzbwi().zzj("Log and bundle. event", eventParcel.name);
        long nanoTime = this.anq.zzaan().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.anq.zzbvf().zze(new Callable<byte[]>() {
                /* renamed from: zzbxr */
                public byte[] call() throws Exception {
                    zzy.this.anq.zzbxp();
                    return zzy.this.anq.zza(eventParcel, str);
                }
            }).get();
            if (bArr == null) {
                this.anq.zzbvg().zzbwc().log("Log and bundle returned null");
                bArr = new byte[0];
            }
            this.anq.zzbvg().zzbwi().zzd("Log and bundle processed. event, size, time_ms", eventParcel.name, Integer.valueOf(bArr.length), Long.valueOf((this.anq.zzaan().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.anq.zzbvg().zzbwc().zze("Failed to log and bundle. event, error", eventParcel.name, e);
            return null;
        }
    }

    @BinderThread
    public void zzb(final AppMetadata appMetadata) {
        zzf(appMetadata);
        this.anq.zzbvf().zzm(new Runnable() {
            public void run() {
                zzy.this.anq.zzbxp();
                zzy.this.zzms(appMetadata.anU);
                zzy.this.anq.zzc(appMetadata);
            }
        });
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzms(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.anq.zzbvh().apP.zzi(split[1], longValue);
                    } else {
                        this.anq.zzbvg().zzbwe().zzj("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.anq.zzbvg().zzbwe().zzj("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzmu(String str) throws SecurityException {
        if (this.aru == null && zze.zzb(this.anq.getContext(), Binder.getCallingUid(), str)) {
            this.aru = str;
        }
        if (!str.equals(this.aru)) {
            if (this.art == null) {
                this.art = Boolean.valueOf(("com.google.android.gms".equals(this.aru) || com.google.android.gms.common.util.zzy.zzf(this.anq.getContext(), Binder.getCallingUid())) && !this.anq.zzbxg());
            }
            if (!this.art.booleanValue()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }
}
