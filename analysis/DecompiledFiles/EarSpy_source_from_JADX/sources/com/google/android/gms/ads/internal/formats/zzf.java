package com.google.android.gms.ads.internal.formats;

import android.support.p000v4.util.SimpleArrayMap;
import android.view.View;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdx;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zziy;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@zziy
public class zzf extends zzef.zza implements zzi.zza {
    private final Object zzakd = new Object();
    private final zza zzbjy;
    private zzi zzbkb;
    private final String zzbke;
    private final SimpleArrayMap<String, zzc> zzbkf;
    private final SimpleArrayMap<String, String> zzbkg;

    public zzf(String str, SimpleArrayMap<String, zzc> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zza zza) {
        this.zzbke = str;
        this.zzbkf = simpleArrayMap;
        this.zzbkg = simpleArrayMap2;
        this.zzbjy = zza;
    }

    public List<String> getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[(this.zzbkf.size() + this.zzbkg.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzbkf.size(); i3++) {
            strArr[i2] = this.zzbkf.keyAt(i3);
            i2++;
        }
        while (i < this.zzbkg.size()) {
            strArr[i2] = this.zzbkg.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public String getCustomTemplateId() {
        return this.zzbke;
    }

    public void performClick(String str) {
        synchronized (this.zzakd) {
            if (this.zzbkb == null) {
                zzb.m1352e("Attempt to call performClick before ad initialized.");
            } else {
                this.zzbkb.zza((View) null, str, (JSONObject) null, (JSONObject) null, (JSONObject) null);
            }
        }
    }

    public void recordImpression() {
        synchronized (this.zzakd) {
            if (this.zzbkb == null) {
                zzb.m1352e("Attempt to perform recordImpression before ad initialized.");
            } else {
                this.zzbkb.recordImpression();
            }
        }
    }

    public String zzaw(String str) {
        return this.zzbkg.get(str);
    }

    public zzdx zzax(String str) {
        return this.zzbkf.get(str);
    }

    public void zzb(zzi zzi) {
        synchronized (this.zzakd) {
            this.zzbkb = zzi;
        }
    }

    public String zzlq() {
        return "3";
    }

    public zza zzlr() {
        return this.zzbjy;
    }
}
