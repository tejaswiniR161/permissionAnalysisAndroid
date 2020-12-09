package com.google.android.gms.ads.internal.safebrowsing;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class SafeBrowsingConfigParcel extends AbstractSafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final int versionCode;
    public final String zzcnz;
    public final String zzcoa;
    public final boolean zzcob;
    public final boolean zzcoc;

    public SafeBrowsingConfigParcel(int i, String str, String str2, boolean z, boolean z2) {
        this.versionCode = i;
        this.zzcnz = str;
        this.zzcoa = str2;
        this.zzcob = z;
        this.zzcoc = z2;
    }

    @Nullable
    public static SafeBrowsingConfigParcel zzk(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new SafeBrowsingConfigParcel(1, jSONObject.getString("click_string"), jSONObject.getString("report_url"), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
