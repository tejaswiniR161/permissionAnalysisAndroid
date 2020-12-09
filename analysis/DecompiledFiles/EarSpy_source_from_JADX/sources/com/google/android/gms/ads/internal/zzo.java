package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzku;

@zziy
public class zzo extends zzz.zza {
    private static final Object zzaok = new Object();
    @Nullable
    private static zzo zzaol;
    private final Context mContext;
    private final Object zzakd = new Object();
    private boolean zzaom;
    private boolean zzaon;
    private float zzaoo = -1.0f;
    private VersionInfoParcel zzaop;

    zzo(Context context, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzaop = versionInfoParcel;
        this.zzaom = false;
    }

    public static zzo zza(Context context, VersionInfoParcel versionInfoParcel) {
        zzo zzo;
        synchronized (zzaok) {
            if (zzaol == null) {
                zzaol = new zzo(context.getApplicationContext(), versionInfoParcel);
            }
            zzo = zzaol;
        }
        return zzo;
    }

    @Nullable
    public static zzo zzfd() {
        zzo zzo;
        synchronized (zzaok) {
            zzo = zzaol;
        }
        return zzo;
    }

    public void initialize() {
        synchronized (zzaok) {
            if (this.zzaom) {
                zzkn.zzdf("Mobile ads is initialized already.");
                return;
            }
            this.zzaom = true;
            zzu.zzgd().zzb(this.mContext, this.zzaop);
            zzu.zzge().initialize(this.mContext);
        }
    }

    public void setAppMuted(boolean z) {
        synchronized (this.zzakd) {
            this.zzaon = z;
        }
    }

    public void setAppVolume(float f) {
        synchronized (this.zzakd) {
            this.zzaoo = f;
        }
    }

    public void zzb(zzd zzd, String str) {
        zzku zzc = zzc(zzd, str);
        if (zzc == null) {
            zzkn.m1352e("Context is null. Failed to open debug menu.");
        } else {
            zzc.showDialog();
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public zzku zzc(zzd zzd, String str) {
        if (zzd == null) {
            return null;
        }
        Context context = (Context) zze.zzae(zzd);
        if (context == null) {
            return null;
        }
        zzku zzku = new zzku(context);
        zzku.setAdUnitId(str);
        return zzku;
    }

    public float zzfe() {
        float f;
        synchronized (this.zzakd) {
            f = this.zzaoo;
        }
        return f;
    }

    public boolean zzff() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzaoo >= 0.0f;
        }
        return z;
    }

    public boolean zzfg() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzaon;
        }
        return z;
    }

    public void zzw(String str) {
        zzdi.initialize(this.mContext);
        if (!TextUtils.isEmpty(str) && zzdi.zzbgq.get().booleanValue()) {
            zzu.zzgv().zza(this.mContext, this.zzaop, true, (zzkg) null, str, (String) null);
        }
    }
}
