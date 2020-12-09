package com.google.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzaj;
import com.google.android.gms.common.util.zzw;

public final class FirebaseOptions {
    /* access modifiers changed from: private */
    public final String aSU;
    /* access modifiers changed from: private */
    public final String aSV;
    /* access modifiers changed from: private */

    /* renamed from: jM */
    public final String f2308jM;
    /* access modifiers changed from: private */

    /* renamed from: yQ */
    public final String f2309yQ;
    /* access modifiers changed from: private */

    /* renamed from: yT */
    public final String f2310yT;
    /* access modifiers changed from: private */

    /* renamed from: yU */
    public final String f2311yU;

    public static final class Builder {
        private String aSU;
        private String aSV;

        /* renamed from: jM */
        private String f2312jM;

        /* renamed from: yQ */
        private String f2313yQ;

        /* renamed from: yT */
        private String f2314yT;

        /* renamed from: yU */
        private String f2315yU;

        public Builder() {
        }

        public Builder(FirebaseOptions firebaseOptions) {
            this.f2312jM = firebaseOptions.f2308jM;
            this.f2313yQ = firebaseOptions.f2309yQ;
            this.aSU = firebaseOptions.aSU;
            this.aSV = firebaseOptions.aSV;
            this.f2314yT = firebaseOptions.f2310yT;
            this.f2315yU = firebaseOptions.f2311yU;
        }

        public FirebaseOptions build() {
            return new FirebaseOptions(this.f2312jM, this.f2313yQ, this.aSU, this.aSV, this.f2314yT, this.f2315yU);
        }

        public Builder setApiKey(@NonNull String str) {
            this.f2313yQ = zzac.zzh(str, "ApiKey must be set.");
            return this;
        }

        public Builder setApplicationId(@NonNull String str) {
            this.f2312jM = zzac.zzh(str, "ApplicationId must be set.");
            return this;
        }

        public Builder setDatabaseUrl(@Nullable String str) {
            this.aSU = str;
            return this;
        }

        public Builder setGcmSenderId(@Nullable String str) {
            this.f2314yT = str;
            return this;
        }

        public Builder setStorageBucket(@Nullable String str) {
            this.f2315yU = str;
            return this;
        }
    }

    private FirebaseOptions(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        zzac.zza(!zzw.zzij(str), (Object) "ApplicationId must be set.");
        this.f2308jM = str;
        this.f2309yQ = str2;
        this.aSU = str3;
        this.aSV = str4;
        this.f2310yT = str5;
        this.f2311yU = str6;
    }

    public static FirebaseOptions fromResource(Context context) {
        zzaj zzaj = new zzaj(context);
        String string = zzaj.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, zzaj.getString("google_api_key"), zzaj.getString("firebase_database_url"), zzaj.getString("ga_trackingId"), zzaj.getString("gcm_defaultSenderId"), zzaj.getString("google_storage_bucket"));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return zzab.equal(this.f2308jM, firebaseOptions.f2308jM) && zzab.equal(this.f2309yQ, firebaseOptions.f2309yQ) && zzab.equal(this.aSU, firebaseOptions.aSU) && zzab.equal(this.aSV, firebaseOptions.aSV) && zzab.equal(this.f2310yT, firebaseOptions.f2310yT) && zzab.equal(this.f2311yU, firebaseOptions.f2311yU);
    }

    public String getApiKey() {
        return this.f2309yQ;
    }

    public String getApplicationId() {
        return this.f2308jM;
    }

    public String getDatabaseUrl() {
        return this.aSU;
    }

    public String getGcmSenderId() {
        return this.f2310yT;
    }

    public String getStorageBucket() {
        return this.f2311yU;
    }

    public int hashCode() {
        return zzab.hashCode(this.f2308jM, this.f2309yQ, this.aSU, this.aSV, this.f2310yT, this.f2311yU);
    }

    public String toString() {
        return zzab.zzx(this).zzg("applicationId", this.f2308jM).zzg("apiKey", this.f2309yQ).zzg("databaseUrl", this.aSU).zzg("gcmSenderId", this.f2310yT).zzg("storageBucket", this.f2311yU).toString();
    }
}
