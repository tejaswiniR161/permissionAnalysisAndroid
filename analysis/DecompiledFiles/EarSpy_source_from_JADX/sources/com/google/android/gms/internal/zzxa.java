package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;

public final class zzxa implements Api.ApiOptions.Optional {
    public static final zzxa aAa = new zza().zzcdf();
    private final boolean aAb;
    private final boolean aAc;
    private final Long aAd;
    private final Long aAe;

    /* renamed from: hh */
    private final boolean f2268hh;

    /* renamed from: hj */
    private final boolean f2269hj;

    /* renamed from: hk */
    private final String f2270hk;

    /* renamed from: hl */
    private final String f2271hl;

    public static final class zza {
        public zzxa zzcdf() {
            return new zzxa(false, false, (String) null, false, (String) null, false, (Long) null, (Long) null);
        }
    }

    private zzxa(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
        this.aAb = z;
        this.f2268hh = z2;
        this.f2270hk = str;
        this.f2269hj = z3;
        this.aAc = z4;
        this.f2271hl = str2;
        this.aAd = l;
        this.aAe = l2;
    }

    public boolean zzahk() {
        return this.f2268hh;
    }

    public boolean zzahm() {
        return this.f2269hj;
    }

    public String zzahn() {
        return this.f2270hk;
    }

    @Nullable
    public String zzaho() {
        return this.f2271hl;
    }

    public boolean zzcdb() {
        return this.aAb;
    }

    public boolean zzcdc() {
        return this.aAc;
    }

    @Nullable
    public Long zzcdd() {
        return this.aAd;
    }

    @Nullable
    public Long zzcde() {
        return this.aAe;
    }
}
