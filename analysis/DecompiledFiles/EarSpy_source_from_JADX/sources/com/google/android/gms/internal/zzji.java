package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzjh;
import java.util.WeakHashMap;

@zziy
public final class zzji {
    private WeakHashMap<Context, zza> zzcmo = new WeakHashMap<>();

    private class zza {
        public final long zzcmp = zzu.zzgf().currentTimeMillis();
        public final zzjh zzcmq;

        public zza(zzjh zzjh) {
            this.zzcmq = zzjh;
        }

        public boolean hasExpired() {
            return zzdi.zzbdx.get().longValue() + this.zzcmp < zzu.zzgf().currentTimeMillis();
        }
    }

    public zzjh zzy(Context context) {
        zza zza2 = this.zzcmo.get(context);
        zzjh zzsk = (zza2 == null || zza2.hasExpired() || !zzdi.zzbdw.get().booleanValue()) ? new zzjh.zza(context).zzsk() : new zzjh.zza(context, zza2.zzcmq).zzsk();
        this.zzcmo.put(context, new zza(zzsk));
        return zzsk;
    }
}
