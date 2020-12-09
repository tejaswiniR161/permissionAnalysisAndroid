package com.google.android.gms.auth.api.signin.internal;

public class zze {

    /* renamed from: hy */
    static int f1447hy = 31;

    /* renamed from: hz */
    private int f1448hz = 1;

    public int zzahv() {
        return this.f1448hz;
    }

    public zze zzbd(boolean z) {
        this.f1448hz = (z ? 1 : 0) + (this.f1448hz * f1447hy);
        return this;
    }

    public zze zzq(Object obj) {
        this.f1448hz = (obj == null ? 0 : obj.hashCode()) + (this.f1448hz * f1447hy);
        return this;
    }
}
