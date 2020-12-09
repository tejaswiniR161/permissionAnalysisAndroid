package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzu;

@zziy
class zzfp {
    @Nullable
    zzq zzamy;
    @Nullable
    zzw zzboy;
    @Nullable
    zzhx zzboz;
    @Nullable
    zzdu zzbpa;
    @Nullable
    zzp zzbpb;
    @Nullable
    zzd zzbpc;

    private static class zza extends zzq.zza {
        private final zzq zzbpd;

        zza(zzq zzq) {
            this.zzbpd = zzq;
        }

        public void onAdClosed() throws RemoteException {
            this.zzbpd.onAdClosed();
            zzu.zzgo().zzmm();
        }

        public void onAdFailedToLoad(int i) throws RemoteException {
            this.zzbpd.onAdFailedToLoad(i);
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzbpd.onAdLeftApplication();
        }

        public void onAdLoaded() throws RemoteException {
            this.zzbpd.onAdLoaded();
        }

        public void onAdOpened() throws RemoteException {
            this.zzbpd.onAdOpened();
        }
    }

    zzfp() {
    }

    /* access modifiers changed from: package-private */
    public void zzc(zzl zzl) {
        if (this.zzamy != null) {
            zzl.zza((zzq) new zza(this.zzamy));
        }
        if (this.zzboy != null) {
            zzl.zza(this.zzboy);
        }
        if (this.zzboz != null) {
            zzl.zza(this.zzboz);
        }
        if (this.zzbpa != null) {
            zzl.zza(this.zzbpa);
        }
        if (this.zzbpb != null) {
            zzl.zza(this.zzbpb);
        }
        if (this.zzbpc != null) {
            zzl.zza(this.zzbpc);
        }
    }
}
