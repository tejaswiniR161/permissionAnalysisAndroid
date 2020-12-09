package com.google.android.gms.internal;

import android.app.Activity;
import android.support.p000v4.app.FragmentActivity;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzs;

public class zzqz {

    /* renamed from: yX */
    private final Object f2164yX;

    public zzqz(Activity activity) {
        zzac.zzb(activity, (Object) "Activity must not be null");
        zzac.zzb(zzs.zzaxk() || (activity instanceof FragmentActivity), (Object) "This Activity is not supported before platform version 11 (3.0 Honeycomb). Please use FragmentActivity instead.");
        this.f2164yX = activity;
    }

    public boolean zzasn() {
        return this.f2164yX instanceof FragmentActivity;
    }

    public Activity zzaso() {
        return (Activity) this.f2164yX;
    }

    public FragmentActivity zzasp() {
        return (FragmentActivity) this.f2164yX;
    }
}
