package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C0609R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzaj;

@Deprecated
public final class zzqw {

    /* renamed from: yP */
    private static zzqw f2156yP;
    private static Object zzaok = new Object();

    /* renamed from: yQ */
    private final String f2157yQ;

    /* renamed from: yR */
    private final Status f2158yR;

    /* renamed from: yS */
    private final String f2159yS;

    /* renamed from: yT */
    private final String f2160yT;

    /* renamed from: yU */
    private final String f2161yU;

    /* renamed from: yV */
    private final boolean f2162yV;

    /* renamed from: yW */
    private final boolean f2163yW;
    private final String zzcpe;

    zzqw(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C0609R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            this.f2163yW = z2 ? false : z;
            z = z2;
        } else {
            this.f2163yW = false;
        }
        this.f2162yV = z;
        zzaj zzaj = new zzaj(context);
        this.f2159yS = zzaj.getString("firebase_database_url");
        this.f2161yU = zzaj.getString("google_storage_bucket");
        this.f2160yT = zzaj.getString("gcm_defaultSenderId");
        this.f2157yQ = zzaj.getString("google_api_key");
        String zzcg = zzaa.zzcg(context);
        zzcg = zzcg == null ? zzaj.getString("google_app_id") : zzcg;
        if (TextUtils.isEmpty(zzcg)) {
            this.f2158yR = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzcpe = null;
            return;
        }
        this.zzcpe = zzcg;
        this.f2158yR = Status.f1540vY;
    }

    zzqw(String str, boolean z) {
        this(str, z, (String) null, (String) null, (String) null);
    }

    zzqw(String str, boolean z, String str2, String str3, String str4) {
        this.zzcpe = str;
        this.f2157yQ = null;
        this.f2158yR = Status.f1540vY;
        this.f2162yV = z;
        this.f2163yW = !z;
        this.f2159yS = str2;
        this.f2160yT = str4;
        this.f2161yU = str3;
    }

    public static String zzasl() {
        return zzhf("getGoogleAppId").zzcpe;
    }

    public static boolean zzasm() {
        return zzhf("isMeasurementExplicitlyDisabled").f2163yW;
    }

    public static Status zzb(Context context, String str, boolean z) {
        Status status;
        zzac.zzb(context, (Object) "Context must not be null.");
        zzac.zzh(str, "App ID must be nonempty.");
        synchronized (zzaok) {
            if (f2156yP != null) {
                status = f2156yP.zzhe(str);
            } else {
                f2156yP = new zzqw(str, z);
                status = f2156yP.f2158yR;
            }
        }
        return status;
    }

    public static Status zzcb(Context context) {
        Status status;
        zzac.zzb(context, (Object) "Context must not be null.");
        synchronized (zzaok) {
            if (f2156yP == null) {
                f2156yP = new zzqw(context);
            }
            status = f2156yP.f2158yR;
        }
        return status;
    }

    private static zzqw zzhf(String str) {
        zzqw zzqw;
        synchronized (zzaok) {
            if (f2156yP == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            zzqw = f2156yP;
        }
        return zzqw;
    }

    /* access modifiers changed from: package-private */
    public Status zzhe(String str) {
        if (this.zzcpe == null || this.zzcpe.equals(str)) {
            return Status.f1540vY;
        }
        String str2 = this.zzcpe;
        return new Status(10, new StringBuilder(String.valueOf(str2).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str2).append("'.").toString());
    }
}
