package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.internal.zzis;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zziv implements zzis.zza<zze> {
    private final boolean zzcfd;
    private final boolean zzcfe;

    public zziv(boolean z, boolean z2) {
        this.zzcfd = z;
        this.zzcfe = z2;
    }

    /* renamed from: zzc */
    public zze zza(zzis zzis, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        List<zzlj<zzc>> zza = zzis.zza(jSONObject, "images", true, this.zzcfd, this.zzcfe);
        zzlj<zzc> zza2 = zzis.zza(jSONObject, "secondary_image", false, this.zzcfd);
        zzlj<zza> zzg = zzis.zzg(jSONObject);
        ArrayList arrayList = new ArrayList();
        for (zzlj<zzc> zzlj : zza) {
            arrayList.add((zzc) zzlj.get());
        }
        return new zze(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzdx) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), (zza) zzg.get(), new Bundle());
    }
}
