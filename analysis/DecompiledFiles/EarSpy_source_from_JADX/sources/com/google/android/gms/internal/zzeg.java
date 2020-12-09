package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

@zziy
public class zzeg implements NativeCustomTemplateAd {
    private final zzef zzblv;

    public zzeg(zzef zzef) {
        this.zzblv = zzef;
    }

    public List<String> getAvailableAssetNames() {
        try {
            return this.zzblv.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    public String getCustomTemplateId() {
        try {
            return this.zzblv.getCustomTemplateId();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    public NativeAd.Image getImage(String str) {
        try {
            zzdx zzax = this.zzblv.zzax(str);
            if (zzax != null) {
                return new zzdy(zzax);
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get image.", e);
        }
        return null;
    }

    public CharSequence getText(String str) {
        try {
            return this.zzblv.zzaw(str);
        } catch (RemoteException e) {
            zzb.zzb("Failed to get string.", e);
            return null;
        }
    }

    public void performClick(String str) {
        try {
            this.zzblv.performClick(str);
        } catch (RemoteException e) {
            zzb.zzb("Failed to perform click.", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzblv.recordImpression();
        } catch (RemoteException e) {
            zzb.zzb("Failed to record impression.", e);
        }
    }
}
