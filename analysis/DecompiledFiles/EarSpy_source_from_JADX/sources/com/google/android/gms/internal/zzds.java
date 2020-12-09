package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zziy
public class zzds implements CustomRenderedAd {
    private final zzdt zzbix;

    public zzds(zzdt zzdt) {
        this.zzbix = zzdt;
    }

    public String getBaseUrl() {
        try {
            return this.zzbix.zzle();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.zzbix.getContent();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.zzbix.zzi(view != null ? zze.zzac(view) : null);
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.zzbix.recordClick();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzbix.recordImpression();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
