package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzhm {
    private final zzlt zzbkr;
    private final String zzbwd;

    public zzhm(zzlt zzlt) {
        this(zzlt, "");
    }

    public zzhm(zzlt zzlt, String str) {
        this.zzbkr = zzlt;
        this.zzbwd = str;
    }

    public void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzbkr.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzkn.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzbkr.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzkn.zzb("Error occured while dispatching size change.", e);
        }
    }

    public void zzbx(String str) {
        try {
            this.zzbkr.zzb("onError", new JSONObject().put("message", str).put("action", this.zzbwd));
        } catch (JSONException e) {
            zzkn.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public void zzby(String str) {
        try {
            this.zzbkr.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzkn.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public void zzbz(String str) {
        try {
            this.zzbkr.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzkn.zzb("Error occured while dispatching state change.", e);
        }
    }

    public void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzbkr.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzkn.zzb("Error occured while dispatching default position.", e);
        }
    }
}
