package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzu;

@zziy
public class zzki {
    private final Object zzakd = new Object();
    final String zzcpl;
    int zzcqc = -1;
    long zzcqd = -1;
    long zzcqe = -1;
    int zzcqf = -1;
    int zzcqg = 0;
    int zzcqh = 0;

    public zzki(String str) {
        this.zzcpl = str;
    }

    public static boolean zzab(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            zzkn.zzde("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzkn.zzde("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            zzkn.zzdf("Fail to fetch AdActivity theme");
            zzkn.zzde("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public void zzb(AdRequestParcel adRequestParcel, long j) {
        synchronized (this.zzakd) {
            if (this.zzcqe == -1) {
                if (j - zzu.zzgd().zztt() > zzdi.zzbdd.get().longValue()) {
                    zzbd(-1);
                } else {
                    zzbd(zzu.zzgd().zztu());
                }
                this.zzcqe = j;
                this.zzcqd = this.zzcqe;
            } else {
                this.zzcqd = j;
            }
            if (adRequestParcel.extras == null || adRequestParcel.extras.getInt("gw", 2) != 1) {
                this.zzcqf++;
                this.zzcqc++;
            }
        }
    }

    public void zzbd(int i) {
        this.zzcqc = i;
    }

    public Bundle zze(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzakd) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzcpl);
            bundle.putLong("basets", this.zzcqe);
            bundle.putLong("currts", this.zzcqd);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzcqf);
            bundle.putInt("preqs_in_session", this.zzcqc);
            bundle.putInt("pclick", this.zzcqg);
            bundle.putInt("pimp", this.zzcqh);
            bundle.putBoolean("support_transparent_background", zzab(context));
        }
        return bundle;
    }

    public void zzsz() {
        synchronized (this.zzakd) {
            this.zzcqh++;
        }
    }

    public void zzta() {
        synchronized (this.zzakd) {
            this.zzcqg++;
        }
    }

    public int zztu() {
        return this.zzcqc;
    }

    public long zzua() {
        return this.zzcqe;
    }
}
