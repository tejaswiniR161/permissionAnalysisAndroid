package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzlt;

@zziy
public abstract class zzj {
    @Nullable
    public abstract zzi zza(Context context, zzlt zzlt, int i, boolean z, zzdq zzdq);

    /* access modifiers changed from: protected */
    public boolean zzh(zzlt zzlt) {
        return zzlt.zzdt().zzaxj;
    }

    /* access modifiers changed from: protected */
    public boolean zzq(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return zzs.zzaxn() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11);
    }
}
