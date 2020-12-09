package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zziy
public class zzgb implements zzga {
    private final zzfz zzbrj;
    private final HashSet<AbstractMap.SimpleEntry<String, zzev>> zzbrk = new HashSet<>();

    public zzgb(zzfz zzfz) {
        this.zzbrj = zzfz;
    }

    public void zza(String str, zzev zzev) {
        this.zzbrj.zza(str, zzev);
        this.zzbrk.add(new AbstractMap.SimpleEntry(str, zzev));
    }

    public void zza(String str, JSONObject jSONObject) {
        this.zzbrj.zza(str, jSONObject);
    }

    public void zzb(String str, zzev zzev) {
        this.zzbrj.zzb(str, zzev);
        this.zzbrk.remove(new AbstractMap.SimpleEntry(str, zzev));
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzbrj.zzb(str, jSONObject);
    }

    public void zzj(String str, String str2) {
        this.zzbrj.zzj(str, str2);
    }

    public void zznd() {
        Iterator<AbstractMap.SimpleEntry<String, zzev>> it = this.zzbrk.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            String valueOf = String.valueOf(((zzev) next.getValue()).toString());
            zzkn.m1493v(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzbrj.zzb((String) next.getKey(), (zzev) next.getValue());
        }
        this.zzbrk.clear();
    }
}
