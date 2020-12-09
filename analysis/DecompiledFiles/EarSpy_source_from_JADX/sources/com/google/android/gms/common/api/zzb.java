package com.google.android.gms.common.api;

import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzpz;

public class zzb extends zzc {

    /* renamed from: vm */
    private final ConnectionResult f1550vm;

    public zzb(Status status, ArrayMap<zzpz<?>, ConnectionResult> arrayMap) {
        super(status, arrayMap);
        this.f1550vm = arrayMap.get(arrayMap.keyAt(0));
    }
}
