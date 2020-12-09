package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzhx;

@zziy
public final class zzic extends zzhx.zza {
    private final InAppPurchaseListener zzayy;

    public zzic(InAppPurchaseListener inAppPurchaseListener) {
        this.zzayy = inAppPurchaseListener;
    }

    public void zza(zzhw zzhw) {
        this.zzayy.onInAppPurchaseRequested(new zzif(zzhw));
    }
}
