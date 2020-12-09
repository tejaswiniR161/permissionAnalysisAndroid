package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zziy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public final class RewardItemParcel extends AbstractSafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String type;
    public final int versionCode;
    public final int zzcny;

    public RewardItemParcel(int i, String str, int i2) {
        this.versionCode = i;
        this.type = str;
        this.zzcny = i2;
    }

    public RewardItemParcel(RewardItem rewardItem) {
        this(1, rewardItem.getType(), rewardItem.getAmount());
    }

    public RewardItemParcel(String str, int i) {
        this(1, str, i);
    }

    @Nullable
    public static RewardItemParcel zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new RewardItemParcel(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    @Nullable
    public static RewardItemParcel zzcp(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return zza(new JSONArray(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RewardItemParcel)) {
            return false;
        }
        RewardItemParcel rewardItemParcel = (RewardItemParcel) obj;
        return zzab.equal(this.type, rewardItemParcel.type) && zzab.equal(Integer.valueOf(this.zzcny), Integer.valueOf(rewardItemParcel.zzcny));
    }

    public int hashCode() {
        return zzab.hashCode(this.type, Integer.valueOf(this.zzcny));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public JSONArray zzsx() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rb_type", this.type);
        jSONObject.put("rb_amount", this.zzcny);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray;
    }
}
