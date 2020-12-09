package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;

@zziy
public class zza {
    public boolean zza(Context context, Intent intent, zzp zzp) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzkn.m1493v(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzu.zzfz().zzb(context, intent);
            if (zzp != null) {
                zzp.zzdu();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzkn.zzdf(e.getMessage());
            return false;
        }
    }

    public boolean zza(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, zzp zzp) {
        int i;
        if (adLauncherIntentInfoParcel == null) {
            zzkn.zzdf("No intent data for launcher overlay.");
            return false;
        } else if (adLauncherIntentInfoParcel.intent != null) {
            return zza(context, adLauncherIntentInfoParcel.intent, zzp);
        } else {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.url)) {
                zzkn.zzdf("Open GMSG did not contain a URL.");
                return false;
            }
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.mimeType)) {
                intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.url), adLauncherIntentInfoParcel.mimeType);
            } else {
                intent.setData(Uri.parse(adLauncherIntentInfoParcel.url));
            }
            intent.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.packageName)) {
                intent.setPackage(adLauncherIntentInfoParcel.packageName);
            }
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.zzbwf)) {
                String[] split = adLauncherIntentInfoParcel.zzbwf.split("/", 2);
                if (split.length < 2) {
                    String valueOf = String.valueOf(adLauncherIntentInfoParcel.zzbwf);
                    zzkn.zzdf(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                    return false;
                }
                intent.setClassName(split[0], split[1]);
            }
            String str = adLauncherIntentInfoParcel.zzbwg;
            if (!TextUtils.isEmpty(str)) {
                try {
                    i = Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    zzkn.zzdf("Could not parse intent flags.");
                    i = 0;
                }
                intent.addFlags(i);
            }
            return zza(context, intent, zzp);
        }
    }
}
