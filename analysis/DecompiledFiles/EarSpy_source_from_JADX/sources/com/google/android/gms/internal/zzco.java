package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@zziy
public class zzco extends zzcj {
    private final zzfz zzato;

    public zzco(Context context, AdSizeParcel adSizeParcel, zzke zzke, VersionInfoParcel versionInfoParcel, zzcq zzcq, zzfz zzfz) {
        super(context, adSizeParcel, zzke, versionInfoParcel, zzcq);
        this.zzato = zzfz;
        zzc(this.zzato);
        zzhj();
        zzk(3);
        String valueOf = String.valueOf(this.zzasj.zzia());
        zzkn.zzdd(valueOf.length() != 0 ? "Tracking ad unit: ".concat(valueOf) : new String("Tracking ad unit: "));
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        synchronized (this.zzakd) {
            super.destroy();
            zzd(this.zzato);
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(JSONObject jSONObject) {
        this.zzato.zza("AFMA_updateActiveView", jSONObject);
    }

    public void zzhl() {
        destroy();
    }

    /* access modifiers changed from: protected */
    public boolean zzhr() {
        return true;
    }
}
