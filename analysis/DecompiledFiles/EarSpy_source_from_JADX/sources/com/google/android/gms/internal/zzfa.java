package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzfa implements zzev {
    final HashMap<String, zzlg<JSONObject>> zzbnk = new HashMap<>();

    public void zza(zzlt zzlt, Map<String, String> map) {
        zzi(map.get("request_id"), map.get("fetched_ad"));
    }

    public Future<JSONObject> zzaz(String str) {
        zzlg zzlg = new zzlg();
        this.zzbnk.put(str, zzlg);
        return zzlg;
    }

    public void zzba(String str) {
        zzlg zzlg = this.zzbnk.get(str);
        if (zzlg == null) {
            zzkn.m1352e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzlg.isDone()) {
            zzlg.cancel(true);
        }
        this.zzbnk.remove(str);
    }

    public void zzi(String str, String str2) {
        zzkn.zzdd("Received ad from the cache.");
        zzlg zzlg = this.zzbnk.get(str);
        if (zzlg == null) {
            zzkn.m1352e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            zzlg.zzh(new JSONObject(str2));
        } catch (JSONException e) {
            zzkn.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzlg.zzh(null);
        } finally {
            this.zzbnk.remove(str);
        }
    }
}
