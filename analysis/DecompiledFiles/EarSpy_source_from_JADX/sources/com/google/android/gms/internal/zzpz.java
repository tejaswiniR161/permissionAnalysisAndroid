package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzab;

public final class zzpz<O extends Api.ApiOptions> {

    /* renamed from: tv */
    private final Api<O> f1968tv;

    /* renamed from: vw */
    private final O f1969vw;

    /* renamed from: wo */
    private final boolean f1970wo = false;

    /* renamed from: wp */
    private final int f1971wp;

    private zzpz(Api<O> api, O o) {
        this.f1968tv = api;
        this.f1969vw = o;
        this.f1971wp = zzab.hashCode(this.f1968tv, this.f1969vw);
    }

    public static <O extends Api.ApiOptions> zzpz<O> zza(Api<O> api, O o) {
        return new zzpz<>(api, o);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzpz)) {
            return false;
        }
        zzpz zzpz = (zzpz) obj;
        return zzab.equal(this.f1968tv, zzpz.f1968tv) && zzab.equal(this.f1969vw, zzpz.f1969vw);
    }

    public int hashCode() {
        return this.f1971wp;
    }

    public String zzaqj() {
        return this.f1968tv.getName();
    }
}
