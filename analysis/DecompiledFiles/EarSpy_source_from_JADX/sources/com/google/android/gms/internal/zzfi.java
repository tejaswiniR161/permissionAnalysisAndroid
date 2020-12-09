package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zziy
public class zzfi implements Iterable<zzfh> {
    private final List<zzfh> zzbnv = new LinkedList();

    private zzfh zzg(zzlt zzlt) {
        Iterator<zzfh> it = zzu.zzgw().iterator();
        while (it.hasNext()) {
            zzfh next = it.next();
            if (next.zzbkr == zzlt) {
                return next;
            }
        }
        return null;
    }

    public Iterator<zzfh> iterator() {
        return this.zzbnv.iterator();
    }

    public void zza(zzfh zzfh) {
        this.zzbnv.add(zzfh);
    }

    public void zzb(zzfh zzfh) {
        this.zzbnv.remove(zzfh);
    }

    public boolean zze(zzlt zzlt) {
        zzfh zzg = zzg(zzlt);
        if (zzg == null) {
            return false;
        }
        zzg.zzbns.abort();
        return true;
    }

    public boolean zzf(zzlt zzlt) {
        return zzg(zzlt) != null;
    }

    public int zzmi() {
        return this.zzbnv.size();
    }
}
