package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@zziy
public final class zzcl {
    private final String zzatf;
    private final JSONObject zzatg;
    private final String zzath;
    private final String zzati;
    private final boolean zzatj;
    private final boolean zzatk;

    public zzcl(String str, VersionInfoParcel versionInfoParcel, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzati = versionInfoParcel.zzcs;
        this.zzatg = jSONObject;
        this.zzath = str;
        this.zzatf = str2;
        this.zzatj = z;
        this.zzatk = z2;
    }

    public String zzhx() {
        return this.zzatf;
    }

    public String zzhy() {
        return this.zzati;
    }

    public JSONObject zzhz() {
        return this.zzatg;
    }

    public String zzia() {
        return this.zzath;
    }

    public boolean zzib() {
        return this.zzatj;
    }

    public boolean zzic() {
        return this.zzatk;
    }
}
