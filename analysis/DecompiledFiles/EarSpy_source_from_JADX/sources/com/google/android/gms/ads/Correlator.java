package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.internal.zziy;

@zziy
public final class Correlator {
    private zzn zzaka = new zzn();

    public void reset() {
        this.zzaka.zzjt();
    }

    public zzn zzdh() {
        return this.zzaka;
    }
}
