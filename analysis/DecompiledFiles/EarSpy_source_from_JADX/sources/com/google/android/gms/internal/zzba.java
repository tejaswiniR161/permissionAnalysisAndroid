package com.google.android.gms.internal;

import java.util.HashMap;

public class zzba extends zzaj<Integer, Long> {
    public Long zzahl;
    public Long zzahm;

    public zzba() {
    }

    public zzba(String str) {
        zzk(str);
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, Long> zzar() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzahl);
        hashMap.put(1, this.zzahm);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void zzk(String str) {
        HashMap zzl = zzl(str);
        if (zzl != null) {
            this.zzahl = (Long) zzl.get(0);
            this.zzahm = (Long) zzl.get(1);
        }
    }
}
