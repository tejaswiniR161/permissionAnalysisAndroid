package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzhk {
    private final boolean zzbvo;
    private final boolean zzbvp;
    private final boolean zzbvq;
    private final boolean zzbvr;
    private final boolean zzbvs;

    public static final class zza {
        /* access modifiers changed from: private */
        public boolean zzbvo;
        /* access modifiers changed from: private */
        public boolean zzbvp;
        /* access modifiers changed from: private */
        public boolean zzbvq;
        /* access modifiers changed from: private */
        public boolean zzbvr;
        /* access modifiers changed from: private */
        public boolean zzbvs;

        public zzhk zznw() {
            return new zzhk(this);
        }

        public zza zzu(boolean z) {
            this.zzbvo = z;
            return this;
        }

        public zza zzv(boolean z) {
            this.zzbvp = z;
            return this;
        }

        public zza zzw(boolean z) {
            this.zzbvq = z;
            return this;
        }

        public zza zzx(boolean z) {
            this.zzbvr = z;
            return this;
        }

        public zza zzy(boolean z) {
            this.zzbvs = z;
            return this;
        }
    }

    private zzhk(zza zza2) {
        this.zzbvo = zza2.zzbvo;
        this.zzbvp = zza2.zzbvp;
        this.zzbvq = zza2.zzbvq;
        this.zzbvr = zza2.zzbvr;
        this.zzbvs = zza2.zzbvs;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzbvo).put("tel", this.zzbvp).put("calendar", this.zzbvq).put("storePicture", this.zzbvr).put("inlineVideo", this.zzbvs);
        } catch (JSONException e) {
            zzkn.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
