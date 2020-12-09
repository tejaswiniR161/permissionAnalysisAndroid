package com.google.android.gms.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzkg {
    private final long zzcpb;
    private final List<String> zzcpc = new ArrayList();
    private final Map<String, zzb> zzcpd = new HashMap();
    private String zzcpe;
    private String zzcpf;
    private boolean zzcpg = false;

    class zza {
        private final List<String> zzcph;
        private final Bundle zzcpi;

        public zza(List<String> list, Bundle bundle) {
            this.zzcph = list;
            this.zzcpi = bundle;
        }
    }

    class zzb {
        final List<zza> zzcpk = new ArrayList();

        zzb() {
        }

        public void zza(zza zza) {
            this.zzcpk.add(zza);
        }
    }

    public zzkg(String str, long j) {
        this.zzcpf = str;
        this.zzcpb = j;
        zzcs(str);
    }

    private void zzcs(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("status", -1) != 1) {
                    this.zzcpg = false;
                    zzkn.zzdf("App settings could not be fetched successfully.");
                    return;
                }
                this.zzcpg = true;
                this.zzcpe = jSONObject.optString("app_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        zzl(optJSONArray.getJSONObject(i));
                    }
                }
            } catch (JSONException e) {
                zzkn.zzd("Exception occurred while processing app setting json", e);
                zzu.zzgd().zza((Throwable) e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    private void zzl(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        String optString = jSONObject.optString("format");
        String optString2 = jSONObject.optString("ad_unit_id");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            if ("interstitial".equalsIgnoreCase(optString)) {
                this.zzcpc.add(optString2);
            } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject.optJSONObject("mediation_config")) != null && (optJSONArray = optJSONObject.optJSONArray("ad_networks")) != null) {
                int i = 0;
                while (i < optJSONArray.length() && (optJSONArray2 = r5.optJSONArray("adapters")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        arrayList.add(optJSONArray2.getString(i2));
                    }
                    JSONObject optJSONObject2 = (r5 = optJSONArray.getJSONObject(i)).optJSONObject("data");
                    if (optJSONObject2 != null) {
                        Bundle bundle = new Bundle();
                        Iterator<String> keys = optJSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            bundle.putString(next, optJSONObject2.getString(next));
                        }
                        zza zza2 = new zza(arrayList, bundle);
                        zzb zzb2 = this.zzcpd.containsKey(optString2) ? this.zzcpd.get(optString2) : new zzb();
                        zzb2.zza(zza2);
                        this.zzcpd.put(optString2, zzb2);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public long zztf() {
        return this.zzcpb;
    }

    public boolean zztg() {
        return this.zzcpg;
    }

    public String zzth() {
        return this.zzcpf;
    }

    public String zzti() {
        return this.zzcpe;
    }
}
