package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzek;

public class zzaj extends zzs.zza {
    /* access modifiers changed from: private */
    public zzq zzamy;

    private class zza extends zzr.zza {
        private zza() {
        }

        public String getMediationAdapterClassName() throws RemoteException {
            return null;
        }

        public boolean isLoading() throws RemoteException {
            return false;
        }

        public void zzf(AdRequestParcel adRequestParcel) throws RemoteException {
            zzb.m1352e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            com.google.android.gms.ads.internal.util.client.zza.zzctj.post(new Runnable() {
                public void run() {
                    if (zzaj.this.zzamy != null) {
                        try {
                            zzaj.this.zzamy.onAdFailedToLoad(1);
                        } catch (RemoteException e) {
                            zzb.zzd("Could not notify onAdFailedToLoad event.", e);
                        }
                    }
                }
            });
        }
    }

    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException {
    }

    public void zza(zzeh zzeh) throws RemoteException {
    }

    public void zza(zzei zzei) throws RemoteException {
    }

    public void zza(String str, zzek zzek, zzej zzej) throws RemoteException {
    }

    public void zzb(zzq zzq) throws RemoteException {
        this.zzamy = zzq;
    }

    public void zzb(zzy zzy) throws RemoteException {
    }

    public zzr zzey() throws RemoteException {
        return new zza();
    }
}
