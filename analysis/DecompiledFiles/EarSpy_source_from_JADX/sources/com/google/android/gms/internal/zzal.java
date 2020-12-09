package com.google.android.gms.internal;

import java.util.HashMap;

public class zzal extends zzaj<Integer, Object> {
    public String zzdo;
    public String zzdt;
    public String zzee;
    public String zzef;
    public long zzye;

    public zzal() {
        this.zzdo = "E";
        this.zzye = -1;
        this.zzdt = "E";
        this.zzee = "E";
        this.zzef = "E";
    }

    public zzal(String str) {
        this();
        zzk(str);
    }

    /* access modifiers changed from: protected */
    public HashMap<Integer, Object> zzar() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzdo);
        hashMap.put(4, this.zzef);
        hashMap.put(3, this.zzee);
        hashMap.put(2, this.zzdt);
        hashMap.put(1, Long.valueOf(this.zzye));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void zzk(String str) {
        HashMap zzl = zzl(str);
        if (zzl != null) {
            this.zzdo = zzl.get(0) == null ? "E" : (String) zzl.get(0);
            this.zzye = zzl.get(1) == null ? -1 : ((Long) zzl.get(1)).longValue();
            this.zzdt = zzl.get(2) == null ? "E" : (String) zzl.get(2);
            this.zzee = zzl.get(3) == null ? "E" : (String) zzl.get(3);
            this.zzef = zzl.get(4) == null ? "E" : (String) zzl.get(4);
        }
    }
}
