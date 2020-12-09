package com.google.android.gms.internal;

import java.util.HashMap;

public class zzaz extends zzaj<Integer, Object> {
    public Long zzahi;
    public Boolean zzahj;
    public Boolean zzahk;

    public zzaz() {
    }

    public zzaz(String str) {
        zzk(str);
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, Object> zzar() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzahi);
        hashMap.put(1, this.zzahj);
        hashMap.put(2, this.zzahk);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void zzk(String str) {
        HashMap zzl = zzl(str);
        if (zzl != null) {
            this.zzahi = (Long) zzl.get(0);
            this.zzahj = (Boolean) zzl.get(1);
            this.zzahk = (Boolean) zzl.get(2);
        }
    }
}
