package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.internal.zzis;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zziu implements zzis.zza<zzd> {
    private final boolean zzcfd;
    private final boolean zzcfe;

    public zziu(boolean z, boolean z2) {
        this.zzcfd = z;
        this.zzcfe = z2;
    }

    private zzlt zzb(zzlj<zzlt> zzlj) {
        try {
            return (zzlt) zzlj.get((long) zzdi.zzbgb.get().intValue(), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            zzkn.zzd("InterruptedException occurred while waiting for video to load", e);
            Thread.currentThread().interrupt();
        } catch (CancellationException | ExecutionException | TimeoutException e2) {
            zzkn.zzd("Exception occurred while waiting for video to load", e2);
        }
        return null;
    }

    /* renamed from: zzb */
    public zzd zza(zzis zzis, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        List<zzlj<zzc>> zza = zzis.zza(jSONObject, "images", true, this.zzcfd, this.zzcfe);
        zzlj<zzc> zza2 = zzis.zza(jSONObject, "app_icon", true, this.zzcfd);
        zzlj<zzlt> zzc = zzis.zzc(jSONObject, "video");
        zzlj<zza> zzg = zzis.zzg(jSONObject);
        ArrayList arrayList = new ArrayList();
        for (zzlj<zzc> zzlj : zza) {
            arrayList.add((zzc) zzlj.get());
        }
        zzlt zzb = zzb(zzc);
        return new zzd(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzdx) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString(FirebaseAnalytics.Param.PRICE), (zza) zzg.get(), new Bundle(), zzb != null ? zzb.zzwb() : null, zzb != null ? zzb.getView() : null);
    }
}
