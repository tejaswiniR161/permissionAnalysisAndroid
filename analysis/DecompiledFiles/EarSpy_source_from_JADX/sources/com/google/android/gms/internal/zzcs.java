package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zziy
public class zzcs {
    private final Object zzakd = new Object();
    private int zzaug;
    private List<zzcr> zzauh = new LinkedList();

    public boolean zza(zzcr zzcr) {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzauh.contains(zzcr);
        }
        return z;
    }

    public boolean zzb(zzcr zzcr) {
        boolean z;
        synchronized (this.zzakd) {
            Iterator<zzcr> it = this.zzauh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                zzcr next = it.next();
                if (zzcr != next && next.zzie().equals(zzcr.zzie())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public void zzc(zzcr zzcr) {
        synchronized (this.zzakd) {
            if (this.zzauh.size() >= 10) {
                zzkn.zzdd(new StringBuilder(41).append("Queue is full, current size = ").append(this.zzauh.size()).toString());
                this.zzauh.remove(0);
            }
            int i = this.zzaug;
            this.zzaug = i + 1;
            zzcr.zzl(i);
            this.zzauh.add(zzcr);
        }
    }

    @Nullable
    public zzcr zzil() {
        int i;
        zzcr zzcr;
        zzcr zzcr2 = null;
        synchronized (this.zzakd) {
            if (this.zzauh.size() == 0) {
                zzkn.zzdd("Queue empty");
                return null;
            } else if (this.zzauh.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                for (zzcr next : this.zzauh) {
                    int score = next.getScore();
                    if (score > i2) {
                        int i3 = score;
                        zzcr = next;
                        i = i3;
                    } else {
                        i = i2;
                        zzcr = zzcr2;
                    }
                    i2 = i;
                    zzcr2 = zzcr;
                }
                this.zzauh.remove(zzcr2);
                return zzcr2;
            } else {
                zzcr zzcr3 = this.zzauh.get(0);
                zzcr3.zzig();
                return zzcr3;
            }
        }
    }
}
