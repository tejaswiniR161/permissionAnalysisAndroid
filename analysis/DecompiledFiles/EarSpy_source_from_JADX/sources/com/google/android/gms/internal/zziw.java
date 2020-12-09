package com.google.android.gms.internal;

import android.support.p000v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.internal.zzis;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zziw implements zzis.zza<zzf> {
    private final boolean zzcfd;

    public zziw(boolean z) {
        this.zzcfd = z;
    }

    private void zza(zzis zzis, JSONObject jSONObject, SimpleArrayMap<String, Future<zzc>> simpleArrayMap) throws JSONException {
        simpleArrayMap.put(jSONObject.getString("name"), zzis.zza(jSONObject, "image_value", this.zzcfd));
    }

    private void zza(JSONObject jSONObject, SimpleArrayMap<String, String> simpleArrayMap) throws JSONException {
        simpleArrayMap.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    private <K, V> SimpleArrayMap<K, V> zzc(SimpleArrayMap<K, Future<V>> simpleArrayMap) throws InterruptedException, ExecutionException {
        SimpleArrayMap<K, V> simpleArrayMap2 = new SimpleArrayMap<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= simpleArrayMap.size()) {
                return simpleArrayMap2;
            }
            simpleArrayMap2.put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2).get());
            i = i2 + 1;
        }
    }

    /* renamed from: zzd */
    public zzf zza(zzis zzis, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        zzlj<zza> zzg = zzis.zzg(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                zza(jSONObject2, (SimpleArrayMap<String, String>) simpleArrayMap2);
            } else if ("image".equals(string)) {
                zza(zzis, jSONObject2, simpleArrayMap);
            } else {
                String valueOf = String.valueOf(string);
                zzkn.zzdf(valueOf.length() != 0 ? "Unknown custom asset type: ".concat(valueOf) : new String("Unknown custom asset type: "));
            }
        }
        return new zzf(jSONObject.getString("custom_template_id"), zzc(simpleArrayMap), simpleArrayMap2, (zza) zzg.get());
    }
}
