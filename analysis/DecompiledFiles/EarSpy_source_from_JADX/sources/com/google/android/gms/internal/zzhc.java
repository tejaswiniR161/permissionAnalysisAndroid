package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zziy
public final class zzhc<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzgr.zza {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzbuf;
    private final NETWORK_EXTRAS zzbug;

    public zzhc(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzbuf = mediationAdapter;
        this.zzbug = network_extras;
    }

    private SERVER_PARAMETERS zzb(String str, int i, String str2) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                zzb.zzd("Could not get MediationServerParameters.", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zzbuf.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    public void destroy() throws RemoteException {
        try {
            this.zzbuf.destroy();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public zzd getView() throws RemoteException {
        if (!(this.zzbuf instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzbuf.getClass().getCanonicalName());
            zzb.zzdf(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return zze.zzac(((MediationBannerAdapter) this.zzbuf).getBannerView());
        } catch (Throwable th) {
            zzb.zzd("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public boolean isInitialized() {
        return true;
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (!(this.zzbuf instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzbuf.getClass().getCanonicalName());
            zzb.zzdf(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzb.zzdd("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzbuf).showInterstitial();
        } catch (Throwable th) {
            zzb.zzd("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    public void showVideo() {
    }

    public void zza(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zza zza, String str2) throws RemoteException {
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzgs zzgs) throws RemoteException {
        zza(zzd, adRequestParcel, str, (String) null, zzgs);
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzgs zzgs) throws RemoteException {
        if (!(this.zzbuf instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.zzbuf.getClass().getCanonicalName());
            zzb.zzdf(valueOf.length() != 0 ? "MediationAdapter is not a MediationInterstitialAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzb.zzdd("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzbuf).requestInterstitialAd(new zzhd(zzgs), (Activity) zze.zzae(zzd), zzb(str, adRequestParcel.zzawh, str2), zzhe.zzs(adRequestParcel), this.zzbug);
        } catch (Throwable th) {
            zzb.zzd("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzgs zzgs, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzgs zzgs) throws RemoteException {
        zza(zzd, adSizeParcel, adRequestParcel, str, (String) null, zzgs);
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzgs zzgs) throws RemoteException {
        if (!(this.zzbuf instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.zzbuf.getClass().getCanonicalName());
            zzb.zzdf(valueOf.length() != 0 ? "MediationAdapter is not a MediationBannerAdapter: ".concat(valueOf) : new String("MediationAdapter is not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzb.zzdd("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.zzbuf).requestBannerAd(new zzhd(zzgs), (Activity) zze.zzae(zzd), zzb(str, adRequestParcel.zzawh, str2), zzhe.zzc(adSizeParcel), zzhe.zzs(adRequestParcel), this.zzbug);
        } catch (Throwable th) {
            zzb.zzd("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zzc(AdRequestParcel adRequestParcel, String str) {
    }

    public void zzj(zzd zzd) throws RemoteException {
    }

    public zzgu zznm() {
        return null;
    }

    public zzgv zznn() {
        return null;
    }

    public Bundle zzno() {
        return new Bundle();
    }

    public Bundle zznp() {
        return new Bundle();
    }
}
