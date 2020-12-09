package com.google.android.gms.common.api;

import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzpz;

public class zzc implements Result {

    /* renamed from: fp */
    private final Status f1551fp;

    /* renamed from: vn */
    private final ArrayMap<zzpz<?>, ConnectionResult> f1552vn;

    public zzc(Status status, ArrayMap<zzpz<?>, ConnectionResult> arrayMap) {
        this.f1551fp = status;
        this.f1552vn = arrayMap;
    }

    public Status getStatus() {
        return this.f1551fp;
    }
}
