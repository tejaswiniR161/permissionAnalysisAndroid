package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public final class zzgh {
    public final List<zzgg> zzbsb;
    public final long zzbsc;
    public final List<String> zzbsd;
    public final List<String> zzbse;
    public final List<String> zzbsf;
    public final List<String> zzbsg;
    public final boolean zzbsh;
    public final String zzbsi;
    public final long zzbsj;
    public final String zzbsk;
    public final int zzbsl;
    public final int zzbsm;
    public final long zzbsn;
    public final boolean zzbso;
    public int zzbsp;
    public int zzbsq;

    public zzgh(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (zzkn.zzbf(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzkn.m1493v(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzgg zzgg = new zzgg(jSONArray.getJSONObject(i2));
            arrayList.add(zzgg);
            if (i < 0 && zza(zzgg)) {
                i = i2;
            }
        }
        this.zzbsp = i;
        this.zzbsq = jSONArray.length();
        this.zzbsb = Collections.unmodifiableList(arrayList);
        this.zzbsi = jSONObject.getString("qdata");
        this.zzbsm = jSONObject.optInt("fs_model_type", -1);
        this.zzbsn = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzbsc = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.zzbsd = zzu.zzgs().zza(optJSONObject, "click_urls");
            this.zzbse = zzu.zzgs().zza(optJSONObject, "imp_urls");
            this.zzbsf = zzu.zzgs().zza(optJSONObject, "nofill_urls");
            this.zzbsg = zzu.zzgs().zza(optJSONObject, "remote_ping_urls");
            this.zzbsh = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzbsj = optLong > 0 ? optLong * 1000 : -1;
            RewardItemParcel zza = RewardItemParcel.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzbsk = null;
                this.zzbsl = 0;
            } else {
                this.zzbsk = zza.type;
                this.zzbsl = zza.zzcny;
            }
            this.zzbso = optJSONObject.optBoolean("use_displayed_impression", false);
            return;
        }
        this.zzbsc = -1;
        this.zzbsd = null;
        this.zzbse = null;
        this.zzbsf = null;
        this.zzbsg = null;
        this.zzbsj = -1;
        this.zzbsk = null;
        this.zzbsl = 0;
        this.zzbso = false;
        this.zzbsh = false;
    }

    public zzgh(List<zzgg> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.zzbsb = list;
        this.zzbsc = j;
        this.zzbsd = list2;
        this.zzbse = list3;
        this.zzbsf = list4;
        this.zzbsg = list5;
        this.zzbsh = z;
        this.zzbsi = str;
        this.zzbsj = j2;
        this.zzbsp = i;
        this.zzbsq = i2;
        this.zzbsk = str2;
        this.zzbsl = i3;
        this.zzbsm = i4;
        this.zzbsn = j3;
        this.zzbso = z2;
    }

    private boolean zza(zzgg zzgg) {
        for (String equals : zzgg.zzbrn) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
