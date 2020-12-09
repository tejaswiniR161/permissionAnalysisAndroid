package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;

@zziy
public class zzdl {
    @Nullable
    public zzdk zza(@Nullable zzdj zzdj) {
        if (zzdj == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!zzdj.zzkt()) {
            zzkn.m1493v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (zzdj.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzdj.zzhy())) {
            return new zzdk(zzdj.getContext(), zzdj.zzhy(), zzdj.zzku(), zzdj.zzkv());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
