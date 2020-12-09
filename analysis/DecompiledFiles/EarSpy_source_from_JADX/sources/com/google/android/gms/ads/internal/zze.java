package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkn;

@zziy
public class zze {
    private final Context mContext;
    private final AutoClickProtectionConfigurationParcel zzamg;
    private boolean zzamh;

    public zze(Context context) {
        this(context, false);
    }

    public zze(Context context, @Nullable zzke.zza zza) {
        this.mContext = context;
        if (zza == null || zza.zzcop.zzchv == null) {
            this.zzamg = new AutoClickProtectionConfigurationParcel();
        } else {
            this.zzamg = zza.zzcop.zzchv;
        }
    }

    public zze(Context context, boolean z) {
        this.mContext = context;
        this.zzamg = new AutoClickProtectionConfigurationParcel(z);
    }

    public void recordClick() {
        this.zzamh = true;
    }

    public boolean zzer() {
        return !this.zzamg.zzchz || this.zzamh;
    }

    public void zzv(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        zzkn.zzde("Action was blocked because no touch was detected.");
        if (this.zzamg.zzchz && this.zzamg.zzcia != null) {
            for (String next : this.zzamg.zzcia) {
                if (!TextUtils.isEmpty(next)) {
                    zzu.zzfz().zzc(this.mContext, "", next.replace("{NAVIGATION_URL}", Uri.encode(str)));
                }
            }
        }
    }
}
