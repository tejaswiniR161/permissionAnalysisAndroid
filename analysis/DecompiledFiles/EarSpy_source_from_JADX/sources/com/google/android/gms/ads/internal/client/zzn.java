package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.internal.zziy;
import java.util.Random;

@zziy
public class zzn extends zzy.zza {
    private Object zzakd = new Object();
    private final Random zzayg = new Random();
    private long zzayh;

    public zzn() {
        zzjt();
    }

    public long getValue() {
        return this.zzayh;
    }

    public void zzjt() {
        synchronized (this.zzakd) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = ((long) this.zzayg.nextInt()) + 2147483648L;
                if (j != this.zzayh && j != 0) {
                    break;
                }
            }
            this.zzayh = j;
        }
    }
}
