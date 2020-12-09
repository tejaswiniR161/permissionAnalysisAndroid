package com.google.android.gms.ads.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Debug;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzkj;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkn;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

@zziy
public abstract class zza extends zzu.zza implements com.google.android.gms.ads.internal.client.zza, zzp, zza.C1258zza, zzer, zzil.zza, zzkj {
    protected zzdq zzalg;
    protected zzdo zzalh;
    protected zzdo zzali;
    protected boolean zzalj = false;
    protected final zzr zzalk;
    protected final zzv zzall;
    @Nullable
    protected transient AdRequestParcel zzalm;
    protected final zzcm zzaln;
    protected final zzd zzalo;

    zza(zzv zzv, @Nullable zzr zzr, zzd zzd) {
        this.zzall = zzv;
        this.zzalk = zzr == null ? new zzr(this) : zzr;
        this.zzalo = zzd;
        zzu.zzfz().zzad(this.zzall.zzahn);
        zzu.zzgd().zzb(this.zzall.zzahn, this.zzall.zzaqv);
        zzu.zzge().initialize(this.zzall.zzahn);
        this.zzaln = zzu.zzgd().zztx();
        zzu.zzgc().initialize(this.zzall.zzahn);
        zzdq();
    }

    private AdRequestParcel zza(AdRequestParcel adRequestParcel) {
        return (!zzi.zzcm(this.zzall.zzahn) || adRequestParcel.zzawl == null) ? adRequestParcel : new zzf(adRequestParcel).zza((Location) null).zzja();
    }

    private TimerTask zza(final Timer timer, final CountDownLatch countDownLatch) {
        return new TimerTask() {
            public void run() {
                if (((long) zzdi.zzbgi.get().intValue()) != countDownLatch.getCount()) {
                    zzkn.zzdd("Stopping method tracing");
                    Debug.stopMethodTracing();
                    if (countDownLatch.getCount() == 0) {
                        timer.cancel();
                        return;
                    }
                }
                String concat = String.valueOf(zza.this.zzall.zzahn.getPackageName()).concat("_adsTrace_");
                try {
                    zzkn.zzdd("Starting method tracing");
                    countDownLatch.countDown();
                    Debug.startMethodTracing(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append(zzu.zzgf().currentTimeMillis()).toString(), zzdi.zzbgj.get().intValue());
                } catch (Exception e) {
                    zzkn.zzd("Exception occurred while starting method tracing.", e);
                }
            }
        };
    }

    private void zzd(zzke zzke) {
        if (zzu.zzgh().zzuu() && !zzke.zzcoo && !TextUtils.isEmpty(zzke.zzchy)) {
            zzkn.zzdd("Sending troubleshooting signals to the server.");
            zzu.zzgh().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, zzke.zzchy, this.zzall.zzaqt);
            zzke.zzcoo = true;
        }
    }

    private void zzdq() {
        if (zzdi.zzbgg.get().booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(zza(timer, new CountDownLatch(zzdi.zzbgi.get().intValue())), 0, zzdi.zzbgh.get().longValue());
        }
    }

    public void destroy() {
        zzac.zzhq("destroy must be called on the main UI thread.");
        this.zzalk.cancel();
        this.zzaln.zzk(this.zzall.zzara);
        this.zzall.destroy();
    }

    public boolean isLoading() {
        return this.zzalj;
    }

    public boolean isReady() {
        zzac.zzhq("isLoaded must be called on the main UI thread.");
        return this.zzall.zzaqx == null && this.zzall.zzaqy == null && this.zzall.zzara != null;
    }

    public void onAdClicked() {
        if (this.zzall.zzara == null) {
            zzkn.zzdf("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzkn.zzdd("Pinging click URLs.");
        if (this.zzall.zzarc != null) {
            this.zzall.zzarc.zzta();
        }
        if (this.zzall.zzara.zzbsd != null) {
            zzu.zzfz().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, this.zzall.zzara.zzbsd);
        }
        if (this.zzall.zzard != null) {
            try {
                this.zzall.zzard.onAdClicked();
            } catch (RemoteException e) {
                zzkn.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void onAppEvent(String str, @Nullable String str2) {
        if (this.zzall.zzarf != null) {
            try {
                this.zzall.zzarf.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzkn.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzac.zzhq("pause must be called on the main UI thread.");
    }

    public void resume() {
        zzac.zzhq("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void setUserId(String str) {
        zzkn.zzdf("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void stopLoading() {
        zzac.zzhq("stopLoading must be called on the main UI thread.");
        this.zzalj = false;
        this.zzall.zzi(true);
    }

    /* access modifiers changed from: package-private */
    public Bundle zza(@Nullable zzcu zzcu) {
        String str;
        String zztq;
        if (zzcu == null) {
            return null;
        }
        if (zzcu.zziq()) {
            zzcu.wakeup();
        }
        zzcr zzio = zzcu.zzio();
        if (zzio != null) {
            zztq = zzio.zzie();
            str = zzio.zzif();
            String valueOf = String.valueOf(zzio.toString());
            zzkn.zzdd(valueOf.length() != 0 ? "In AdManager: loadAd, ".concat(valueOf) : new String("In AdManager: loadAd, "));
            if (zztq != null) {
                zzu.zzgd().zzct(zztq);
            }
        } else {
            str = null;
            zztq = zzu.zzgd().zztq();
        }
        if (zztq == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", zztq);
        if (zztq.equals(str)) {
            return bundle;
        }
        bundle.putString("v_fp", str);
        return bundle;
    }

    public void zza(AdSizeParcel adSizeParcel) {
        zzac.zzhq("setAdSize must be called on the main UI thread.");
        this.zzall.zzaqz = adSizeParcel;
        if (!(this.zzall.zzara == null || this.zzall.zzara.zzbyh == null || this.zzall.zzarv != 0)) {
            this.zzall.zzara.zzbyh.zza(adSizeParcel);
        }
        if (this.zzall.zzaqw != null) {
            if (this.zzall.zzaqw.getChildCount() > 1) {
                this.zzall.zzaqw.removeView(this.zzall.zzaqw.getNextView());
            }
            this.zzall.zzaqw.setMinimumWidth(adSizeParcel.widthPixels);
            this.zzall.zzaqw.setMinimumHeight(adSizeParcel.heightPixels);
            this.zzall.zzaqw.requestLayout();
        }
    }

    public void zza(@Nullable VideoOptionsParcel videoOptionsParcel) {
        zzac.zzhq("setVideoOptions must be called on the main UI thread.");
        this.zzall.zzaro = videoOptionsParcel;
    }

    public void zza(com.google.android.gms.ads.internal.client.zzp zzp) {
        zzac.zzhq("setAdListener must be called on the main UI thread.");
        this.zzall.zzard = zzp;
    }

    public void zza(zzq zzq) {
        zzac.zzhq("setAdListener must be called on the main UI thread.");
        this.zzall.zzare = zzq;
    }

    public void zza(zzw zzw) {
        zzac.zzhq("setAppEventListener must be called on the main UI thread.");
        this.zzall.zzarf = zzw;
    }

    public void zza(zzy zzy) {
        zzac.zzhq("setCorrelationIdProvider must be called on the main UI thread");
        this.zzall.zzarg = zzy;
    }

    public void zza(zzd zzd) {
        zzac.zzhq("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzall.zzarq = zzd;
    }

    /* access modifiers changed from: protected */
    public void zza(@Nullable RewardItemParcel rewardItemParcel) {
        if (this.zzall.zzarq != null) {
            String str = "";
            int i = 0;
            if (rewardItemParcel != null) {
                try {
                    str = rewardItemParcel.type;
                    i = rewardItemParcel.zzcny;
                } catch (RemoteException e) {
                    zzkn.zzd("Could not call RewardedVideoAdListener.onRewarded().", e);
                    return;
                }
            }
            this.zzall.zzarq.zza(new zzjp(str, i));
        }
    }

    public void zza(zzdu zzdu) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(zzhx zzhx) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(zzib zzib, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(zzke.zza zza) {
        if (zza.zzcop.zzchg != -1 && !TextUtils.isEmpty(zza.zzcop.zzchp)) {
            long zzu = zzu(zza.zzcop.zzchp);
            if (zzu != -1) {
                zzdo zzc = this.zzalg.zzc(zzu + zza.zzcop.zzchg);
                this.zzalg.zza(zzc, "stc");
            }
        }
        this.zzalg.zzav(zza.zzcop.zzchp);
        this.zzalg.zza(this.zzalh, "arf");
        this.zzali = this.zzalg.zzla();
        this.zzalg.zzh("gqi", zza.zzcop.zzchq);
        this.zzall.zzaqx = null;
        this.zzall.zzarb = zza;
        zza(zza, this.zzalg);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzke.zza zza, zzdq zzdq);

    public void zza(HashSet<zzkf> hashSet) {
        this.zzall.zza(hashSet);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(AdRequestParcel adRequestParcel, zzdq zzdq);

    /* access modifiers changed from: package-private */
    public boolean zza(zzke zzke) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(@Nullable zzke zzke, zzke zzke2);

    /* access modifiers changed from: protected */
    public void zzb(View view) {
        zzv.zza zza = this.zzall.zzaqw;
        if (zza != null) {
            zza.addView(view, zzu.zzgb().zzup());
        }
    }

    public void zzb(zzke zzke) {
        this.zzalg.zza(this.zzali, "awr");
        this.zzall.zzaqy = null;
        if (!(zzke.errorCode == -2 || zzke.errorCode == 3)) {
            zzu.zzgd().zzb(this.zzall.zzgy());
        }
        if (zzke.errorCode == -1) {
            this.zzalj = false;
            return;
        }
        if (zza(zzke)) {
            zzkn.zzdd("Ad refresh scheduled.");
        }
        if (zzke.errorCode != -2) {
            zzh(zzke.errorCode);
            return;
        }
        if (this.zzall.zzart == null) {
            this.zzall.zzart = new zzkk(this.zzall.zzaqt);
        }
        this.zzaln.zzj(this.zzall.zzara);
        if (zza(this.zzall.zzara, zzke)) {
            this.zzall.zzara = zzke;
            this.zzall.zzhh();
            this.zzalg.zzh("is_mraid", this.zzall.zzara.zzib() ? "1" : "0");
            this.zzalg.zzh("is_mediation", this.zzall.zzara.zzchc ? "1" : "0");
            if (!(this.zzall.zzara.zzbyh == null || this.zzall.zzara.zzbyh.zzvr() == null)) {
                this.zzalg.zzh("is_delay_pl", this.zzall.zzara.zzbyh.zzvr().zzwm() ? "1" : "0");
            }
            this.zzalg.zza(this.zzalh, "ttc");
            if (zzu.zzgd().zztm() != null) {
                zzu.zzgd().zztm().zza(this.zzalg);
            }
            if (this.zzall.zzhc()) {
                zzea();
            }
        }
        if (zzke.zzbsg != null) {
            zzu.zzfz().zza(this.zzall.zzahn, zzke.zzbsg);
        }
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        zzac.zzhq("loadAd must be called on the main UI thread.");
        zzu.zzge().zzit();
        if (zzdi.zzbdg.get().booleanValue()) {
            AdRequestParcel.zzj(adRequestParcel);
        }
        AdRequestParcel zza = zza(adRequestParcel);
        if (this.zzall.zzaqx == null && this.zzall.zzaqy == null) {
            zzkn.zzde("Starting ad request.");
            zzdr();
            this.zzalh = this.zzalg.zzla();
            if (!zza.zzawg) {
                String valueOf = String.valueOf(zzm.zzjr().zzar(this.zzall.zzahn));
                zzkn.zzde(new StringBuilder(String.valueOf(valueOf).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(valueOf).append("\") to get test ads on this device.").toString());
            }
            this.zzalk.zzg(zza);
            this.zzalj = zza(zza, this.zzalg);
            return this.zzalj;
        }
        if (this.zzalm != null) {
            zzkn.zzdf("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            zzkn.zzdf("Loading already in progress, saving this object for future refreshes.");
        }
        this.zzalm = zza;
        return false;
    }

    /* access modifiers changed from: protected */
    public void zzc(@Nullable zzke zzke) {
        if (zzke == null) {
            zzkn.zzdf("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzkn.zzdd("Pinging Impression URLs.");
        if (this.zzall.zzarc != null) {
            this.zzall.zzarc.zzsz();
        }
        if (zzke.zzbse != null && !zzke.zzcom) {
            zzu.zzfz().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, zzke.zzbse);
            zzke.zzcom = true;
            zzd(zzke);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzc(AdRequestParcel adRequestParcel) {
        if (this.zzall.zzaqw == null) {
            return false;
        }
        ViewParent parent = this.zzall.zzaqw.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return zzu.zzfz().zza(view, view.getContext());
    }

    public void zzd(AdRequestParcel adRequestParcel) {
        if (zzc(adRequestParcel)) {
            zzb(adRequestParcel);
            return;
        }
        zzkn.zzde("Ad is not visible. Not refreshing ad.");
        this.zzalk.zzh(adRequestParcel);
    }

    public zzd zzdp() {
        return this.zzalo;
    }

    public void zzdr() {
        this.zzalg = new zzdq(zzdi.zzbca.get().booleanValue(), "load_ad", this.zzall.zzaqz.zzaxi);
        this.zzalh = new zzdo(-1, (String) null, (zzdo) null);
        this.zzali = new zzdo(-1, (String) null, (zzdo) null);
    }

    public com.google.android.gms.dynamic.zzd zzds() {
        zzac.zzhq("getAdFrame must be called on the main UI thread.");
        return zze.zzac(this.zzall.zzaqw);
    }

    @Nullable
    public AdSizeParcel zzdt() {
        zzac.zzhq("getAdSize must be called on the main UI thread.");
        if (this.zzall.zzaqz == null) {
            return null;
        }
        return new ThinAdSizeParcel(this.zzall.zzaqz);
    }

    public void zzdu() {
        zzdy();
    }

    public void zzdv() {
        zzac.zzhq("recordManualImpression must be called on the main UI thread.");
        if (this.zzall.zzara == null) {
            zzkn.zzdf("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzkn.zzdd("Pinging manual tracking URLs.");
        if (this.zzall.zzara.zzche != null && !this.zzall.zzara.zzcon) {
            zzu.zzfz().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, this.zzall.zzara.zzche);
            this.zzall.zzara.zzcon = true;
            zzd(this.zzall.zzara);
        }
    }

    public zzab zzdw() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void zzdx() {
        zzkn.zzde("Ad closing.");
        if (this.zzall.zzare != null) {
            try {
                this.zzall.zzare.onAdClosed();
            } catch (RemoteException e) {
                zzkn.zzd("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.zzall.zzarq != null) {
            try {
                this.zzall.zzarq.onRewardedVideoAdClosed();
            } catch (RemoteException e2) {
                zzkn.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzdy() {
        zzkn.zzde("Ad leaving application.");
        if (this.zzall.zzare != null) {
            try {
                this.zzall.zzare.onAdLeftApplication();
            } catch (RemoteException e) {
                zzkn.zzd("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.zzall.zzarq != null) {
            try {
                this.zzall.zzarq.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e2) {
                zzkn.zzd("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzdz() {
        zzkn.zzde("Ad opening.");
        if (this.zzall.zzare != null) {
            try {
                this.zzall.zzare.onAdOpened();
            } catch (RemoteException e) {
                zzkn.zzd("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.zzall.zzarq != null) {
            try {
                this.zzall.zzarq.onRewardedVideoAdOpened();
            } catch (RemoteException e2) {
                zzkn.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzea() {
        zzkn.zzde("Ad finished loading.");
        this.zzalj = false;
        if (this.zzall.zzare != null) {
            try {
                this.zzall.zzare.onAdLoaded();
            } catch (RemoteException e) {
                zzkn.zzd("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.zzall.zzarq != null) {
            try {
                this.zzall.zzarq.onRewardedVideoAdLoaded();
            } catch (RemoteException e2) {
                zzkn.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzeb() {
        if (this.zzall.zzarq != null) {
            try {
                this.zzall.zzarq.onRewardedVideoStarted();
            } catch (RemoteException e) {
                zzkn.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzh(int i) {
        zzkn.zzdf(new StringBuilder(30).append("Failed to load ad: ").append(i).toString());
        this.zzalj = false;
        if (this.zzall.zzare != null) {
            try {
                this.zzall.zzare.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzkn.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.zzall.zzarq != null) {
            try {
                this.zzall.zzarq.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e2) {
                zzkn.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public long zzu(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            zzkn.zzdf("Invalid index for Url fetch time in CSI latency info.");
        } catch (NumberFormatException e2) {
            zzkn.zzdf("Cannot find valid format of Url fetch time in CSI latency info.");
        }
        return -1;
    }
}
