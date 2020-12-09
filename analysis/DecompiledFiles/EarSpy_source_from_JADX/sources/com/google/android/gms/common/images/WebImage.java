package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zzb();

    /* renamed from: AC */
    private final Uri f1613AC;
    private final int mVersionCode;
    private final int zzajw;
    private final int zzajx;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.mVersionCode = i;
        this.f1613AC = uri;
        this.zzajw = i2;
        this.zzajx = i3;
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) throws IllegalArgumentException {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(zzq(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri zzq(JSONObject jSONObject) {
        if (!jSONObject.has("url")) {
            return null;
        }
        try {
            return Uri.parse(jSONObject.getString("url"));
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzab.equal(this.f1613AC, webImage.f1613AC) && this.zzajw == webImage.zzajw && this.zzajx == webImage.zzajx;
    }

    public int getHeight() {
        return this.zzajx;
    }

    public Uri getUrl() {
        return this.f1613AC;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int getWidth() {
        return this.zzajw;
    }

    public int hashCode() {
        return zzab.hashCode(this.f1613AC, Integer.valueOf(this.zzajw), Integer.valueOf(this.zzajx));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f1613AC.toString());
            jSONObject.put("width", this.zzajw);
            jSONObject.put("height", this.zzajx);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.zzajw), Integer.valueOf(this.zzajx), this.f1613AC.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
