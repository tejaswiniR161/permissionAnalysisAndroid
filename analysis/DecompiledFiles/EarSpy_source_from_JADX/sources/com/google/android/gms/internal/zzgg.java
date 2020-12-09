package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public final class zzgg {
    public final String zzbrl;
    public final String zzbrm;
    public final List<String> zzbrn;
    public final String zzbro;
    public final String zzbrp;
    public final List<String> zzbrq;
    public final List<String> zzbrr;
    public final List<String> zzbrs;
    public final String zzbrt;
    public final List<String> zzbru;
    public final List<String> zzbrv;
    @Nullable
    public final String zzbrw;
    @Nullable
    public final String zzbrx;
    public final String zzbry;
    @Nullable
    public final List<String> zzbrz;
    public final String zzbsa;

    public zzgg(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, String str5, String str6, List<String> list4, List<String> list5, String str7, String str8, String str9, List<String> list6, String str10, List<String> list7) {
        this.zzbrl = str;
        this.zzbrm = str2;
        this.zzbrn = list;
        this.zzbro = str3;
        this.zzbrp = str4;
        this.zzbrq = list2;
        this.zzbrr = list3;
        this.zzbrt = str5;
        this.zzbru = list4;
        this.zzbrv = list5;
        this.zzbrw = str7;
        this.zzbrx = str8;
        this.zzbry = str9;
        this.zzbrz = list6;
        this.zzbsa = str10;
        this.zzbrs = list7;
    }

    public zzgg(JSONObject jSONObject) throws JSONException {
        String str = null;
        this.zzbrm = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzbrn = Collections.unmodifiableList(arrayList);
        this.zzbro = jSONObject.optString("allocation_id", (String) null);
        this.zzbrq = zzu.zzgs().zza(jSONObject, "clickurl");
        this.zzbrr = zzu.zzgs().zza(jSONObject, "imp_urls");
        this.zzbrs = zzu.zzgs().zza(jSONObject, "fill_urls");
        this.zzbru = zzu.zzgs().zza(jSONObject, "video_start_urls");
        this.zzbrv = zzu.zzgs().zza(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.zzbrl = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzbrt = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzbrp = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzbrw = jSONObject.optString("html_template", (String) null);
        this.zzbrx = jSONObject.optString("ad_base_url", (String) null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzbry = optJSONObject3 != null ? optJSONObject3.toString() : null;
        this.zzbrz = zzu.zzgs().zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzbsa = optJSONObject4 != null ? optJSONObject4.toString() : str;
    }
}
