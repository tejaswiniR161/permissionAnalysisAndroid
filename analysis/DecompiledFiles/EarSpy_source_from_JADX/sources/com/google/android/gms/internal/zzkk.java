package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzu;

@zziy
public class zzkk {
    private final Object zzakd;
    private final zzkh zzapw;
    private final String zzcos;
    private int zzcqi;
    private int zzcqj;

    zzkk(zzkh zzkh, String str) {
        this.zzakd = new Object();
        this.zzapw = zzkh;
        this.zzcos = str;
    }

    public zzkk(String str) {
        this(zzu.zzgd(), str);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zzakd) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.zzcqi);
            bundle.putInt("pmnll", this.zzcqj);
        }
        return bundle;
    }

    public void zzh(int i, int i2) {
        synchronized (this.zzakd) {
            this.zzcqi = i;
            this.zzcqj = i2;
            this.zzapw.zza(this.zzcos, this);
        }
    }
}
