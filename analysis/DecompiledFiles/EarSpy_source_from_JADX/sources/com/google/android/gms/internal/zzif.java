package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zziy
public class zzif implements InAppPurchase {
    private final zzhw zzcbu;

    public zzif(zzhw zzhw) {
        this.zzcbu = zzhw;
    }

    public String getProductId() {
        try {
            return this.zzcbu.getProductId();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int i) {
        try {
            this.zzcbu.recordPlayBillingResolution(i);
        } catch (RemoteException e) {
            zzb.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int i) {
        try {
            this.zzcbu.recordResolution(i);
        } catch (RemoteException e) {
            zzb.zzd("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
