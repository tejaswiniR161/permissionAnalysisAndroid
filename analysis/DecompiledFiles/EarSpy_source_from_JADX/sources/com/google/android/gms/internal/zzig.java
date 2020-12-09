package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzib;

@zziy
public final class zzig extends zzib.zza {
    private final PlayStorePurchaseListener zzaza;

    public zzig(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzaza = playStorePurchaseListener;
    }

    public boolean isValidPurchase(String str) {
        return this.zzaza.isValidPurchase(str);
    }

    public void zza(zzia zzia) {
        this.zzaza.onInAppPurchaseFinished(new zzie(zzia));
    }
}
