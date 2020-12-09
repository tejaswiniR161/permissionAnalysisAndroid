package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.internal.zzfs;

@zziy
public class zzft extends zzu.zza {
    private final String zzang;
    private final zzfn zzbpg;
    @Nullable
    private zzl zzbpl;
    private final zzfp zzbps;
    @Nullable
    private zzib zzbpt;
    private String zzbpu;

    public zzft(Context context, String str, zzgq zzgq, VersionInfoParcel versionInfoParcel, zzd zzd) {
        this(str, new zzfn(context, zzgq, versionInfoParcel, zzd));
    }

    zzft(String str, zzfn zzfn) {
        this.zzang = str;
        this.zzbpg = zzfn;
        this.zzbps = new zzfp();
        com.google.android.gms.ads.internal.zzu.zzgo().zza(zzfn);
    }

    private void zzmu() {
        if (this.zzbpl != null && this.zzbpt != null) {
            this.zzbpl.zza(this.zzbpt, this.zzbpu);
        }
    }

    static boolean zzq(AdRequestParcel adRequestParcel) {
        Bundle zzk = zzfq.zzk(adRequestParcel);
        return zzk != null && zzk.containsKey("gw");
    }

    static boolean zzr(AdRequestParcel adRequestParcel) {
        Bundle zzk = zzfq.zzk(adRequestParcel);
        return zzk != null && zzk.containsKey("_ad");
    }

    /* access modifiers changed from: package-private */
    public void abort() {
        if (this.zzbpl == null) {
            this.zzbpl = this.zzbpg.zzbf(this.zzang);
            this.zzbps.zzc(this.zzbpl);
            zzmu();
        }
    }

    public void destroy() throws RemoteException {
        if (this.zzbpl != null) {
            this.zzbpl.destroy();
        }
    }

    @Nullable
    public String getMediationAdapterClassName() throws RemoteException {
        if (this.zzbpl != null) {
            return this.zzbpl.getMediationAdapterClassName();
        }
        return null;
    }

    public boolean isLoading() throws RemoteException {
        return this.zzbpl != null && this.zzbpl.isLoading();
    }

    public boolean isReady() throws RemoteException {
        return this.zzbpl != null && this.zzbpl.isReady();
    }

    public void pause() throws RemoteException {
        if (this.zzbpl != null) {
            this.zzbpl.pause();
        }
    }

    public void resume() throws RemoteException {
        if (this.zzbpl != null) {
            this.zzbpl.resume();
        }
    }

    public void setManualImpressionsEnabled(boolean z) throws RemoteException {
        abort();
        if (this.zzbpl != null) {
            this.zzbpl.setManualImpressionsEnabled(z);
        }
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() throws RemoteException {
        if (this.zzbpl != null) {
            this.zzbpl.showInterstitial();
        } else {
            zzkn.zzdf("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    public void stopLoading() throws RemoteException {
        if (this.zzbpl != null) {
            this.zzbpl.stopLoading();
        }
    }

    public void zza(AdSizeParcel adSizeParcel) throws RemoteException {
        if (this.zzbpl != null) {
            this.zzbpl.zza(adSizeParcel);
        }
    }

    public void zza(VideoOptionsParcel videoOptionsParcel) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public void zza(zzp zzp) throws RemoteException {
        this.zzbps.zzbpb = zzp;
        if (this.zzbpl != null) {
            this.zzbps.zzc(this.zzbpl);
        }
    }

    public void zza(zzq zzq) throws RemoteException {
        this.zzbps.zzamy = zzq;
        if (this.zzbpl != null) {
            this.zzbps.zzc(this.zzbpl);
        }
    }

    public void zza(zzw zzw) throws RemoteException {
        this.zzbps.zzboy = zzw;
        if (this.zzbpl != null) {
            this.zzbps.zzc(this.zzbpl);
        }
    }

    public void zza(zzy zzy) throws RemoteException {
        abort();
        if (this.zzbpl != null) {
            this.zzbpl.zza(zzy);
        }
    }

    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzd) {
        this.zzbps.zzbpc = zzd;
        if (this.zzbpl != null) {
            this.zzbps.zzc(this.zzbpl);
        }
    }

    public void zza(zzdu zzdu) throws RemoteException {
        this.zzbps.zzbpa = zzdu;
        if (this.zzbpl != null) {
            this.zzbps.zzc(this.zzbpl);
        }
    }

    public void zza(zzhx zzhx) throws RemoteException {
        this.zzbps.zzboz = zzhx;
        if (this.zzbpl != null) {
            this.zzbps.zzc(this.zzbpl);
        }
    }

    public void zza(zzib zzib, String str) throws RemoteException {
        this.zzbpt = zzib;
        this.zzbpu = str;
        zzmu();
    }

    public boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException {
        if (zzdi.zzbdg.get().booleanValue()) {
            AdRequestParcel.zzj(adRequestParcel);
        }
        if (!zzq(adRequestParcel)) {
            abort();
        }
        if (zzfq.zzm(adRequestParcel)) {
            abort();
        }
        if (adRequestParcel.zzawk != null) {
            abort();
        }
        if (this.zzbpl != null) {
            return this.zzbpl.zzb(adRequestParcel);
        }
        zzfq zzgo = com.google.android.gms.ads.internal.zzu.zzgo();
        if (zzr(adRequestParcel)) {
            zzgo.zzb(adRequestParcel, this.zzang);
        }
        zzfs.zza zza = zzgo.zza(adRequestParcel, this.zzang);
        if (zza != null) {
            if (!zza.zzbpp) {
                zza.zzmt();
            }
            this.zzbpl = zza.zzbpl;
            zza.zzbpn.zza(this.zzbps);
            this.zzbps.zzc(this.zzbpl);
            zzmu();
            return zza.zzbpq;
        }
        abort();
        return this.zzbpl.zzb(adRequestParcel);
    }

    @Nullable
    public com.google.android.gms.dynamic.zzd zzds() throws RemoteException {
        if (this.zzbpl != null) {
            return this.zzbpl.zzds();
        }
        return null;
    }

    @Nullable
    public AdSizeParcel zzdt() throws RemoteException {
        if (this.zzbpl != null) {
            return this.zzbpl.zzdt();
        }
        return null;
    }

    public void zzdv() throws RemoteException {
        if (this.zzbpl != null) {
            this.zzbpl.zzdv();
        } else {
            zzkn.zzdf("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public zzab zzdw() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }
}
