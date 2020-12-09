package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public final class AutoClickProtectionConfigurationParcel extends AbstractSafeParcelable {
    public static final zzi CREATOR = new zzi();
    public final int versionCode;
    public final boolean zzchz;
    @Nullable
    public final List<String> zzcia;

    public AutoClickProtectionConfigurationParcel() {
        this(1, false, Collections.emptyList());
    }

    public AutoClickProtectionConfigurationParcel(int i, boolean z, List<String> list) {
        this.versionCode = i;
        this.zzchz = z;
        this.zzcia = list;
    }

    public AutoClickProtectionConfigurationParcel(boolean z) {
        this(1, z, Collections.emptyList());
    }

    public AutoClickProtectionConfigurationParcel(boolean z, List<String> list) {
        this(1, z, list);
    }

    @Nullable
    public static AutoClickProtectionConfigurationParcel zzi(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new AutoClickProtectionConfigurationParcel();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("reporting_urls");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (JSONException e) {
                    zzkn.zzd("Error grabbing url from json.", e);
                }
            }
        }
        return new AutoClickProtectionConfigurationParcel(jSONObject.optBoolean("enable_protection"), arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
