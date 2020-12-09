package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzlu;

@zziy
public class zzij extends zzih {
    private zzii zzccz;

    zzij(Context context, zzke.zza zza, zzlt zzlt, zzil.zza zza2) {
        super(context, zza, zzlt, zza2);
    }

    /* access modifiers changed from: protected */
    public void zzqu() {
        int i;
        int i2;
        AdSizeParcel zzdt = this.zzbkr.zzdt();
        if (zzdt.zzaxj) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        } else {
            i = zzdt.widthPixels;
            i2 = zzdt.heightPixels;
        }
        this.zzccz = new zzii(this, this.zzbkr, i, i2);
        this.zzbkr.zzvr().zza((zzlu.zza) this);
        this.zzccz.zza(this.zzccl);
    }

    /* access modifiers changed from: protected */
    public int zzqv() {
        if (!this.zzccz.zzqz()) {
            return !this.zzccz.zzra() ? 2 : -2;
        }
        zzkn.zzdd("Ad-Network indicated no fill with passback URL.");
        return 3;
    }
}
