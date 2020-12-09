package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@zziy
public class zzdf {
    private final Collection<zzde> zzbah = new ArrayList();
    private final Collection<zzde<String>> zzbai = new ArrayList();
    private final Collection<zzde<String>> zzbaj = new ArrayList();

    public void zza(zzde zzde) {
        this.zzbah.add(zzde);
    }

    public void zzb(zzde<String> zzde) {
        this.zzbai.add(zzde);
    }

    public void zzc(zzde<String> zzde) {
        this.zzbaj.add(zzde);
    }

    public List<String> zzkr() {
        ArrayList arrayList = new ArrayList();
        for (zzde<String> zzde : this.zzbai) {
            String str = (String) zzde.get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public List<String> zzks() {
        List<String> zzkr = zzkr();
        for (zzde<String> zzde : this.zzbaj) {
            String str = (String) zzde.get();
            if (str != null) {
                zzkr.add(str);
            }
        }
        return zzkr;
    }
}
