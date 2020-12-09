package com.google.android.gms.internal;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@zziy
public class zzla {
    Map<Integer, Bitmap> zzcsx = new ConcurrentHashMap();
    private AtomicInteger zzcsy = new AtomicInteger(0);

    public Bitmap zza(Integer num) {
        return this.zzcsx.get(num);
    }

    public int zzb(Bitmap bitmap) {
        if (bitmap == null) {
            zzkn.zzdd("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        this.zzcsx.put(Integer.valueOf(this.zzcsy.get()), bitmap);
        return this.zzcsy.getAndIncrement();
    }

    public void zzb(Integer num) {
        this.zzcsx.remove(num);
    }
}
