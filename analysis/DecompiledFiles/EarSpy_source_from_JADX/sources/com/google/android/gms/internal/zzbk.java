package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.zzae;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class zzbk extends zzbv {
    public zzbk(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    private void zzcz() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzair) {
            this.zzair.zzes = (String) this.zzaiz.invoke((Object) null, new Object[]{this.zzafz.getApplicationContext()});
        }
    }

    private void zzda() {
        AdvertisingIdClient zzcv = this.zzafz.zzcv();
        if (zzcv == null) {
            zzr("E1");
            return;
        }
        try {
            AdvertisingIdClient.Info info = zzcv.getInfo();
            String zzq = zzbd.zzq(info.getId());
            if (zzq != null) {
                synchronized (this.zzair) {
                    this.zzair.zzes = zzq;
                    this.zzair.zzeu = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                    this.zzair.zzet = 5;
                }
                return;
            }
            zzr("E");
        } catch (IOException e) {
            zzr("E");
        }
    }

    private void zzr(String str) {
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        if (this.zzafz.zzcm()) {
            zzda();
        } else {
            zzcz();
        }
    }
}
