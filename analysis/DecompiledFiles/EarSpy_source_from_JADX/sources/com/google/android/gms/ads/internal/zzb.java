package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzd;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzlt;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Future;

@zziy
public abstract class zzb extends zza implements zzg, zzj, zzs, zzex, zzgi {
    private final Messenger mMessenger;
    protected final zzgq zzals;
    protected transient boolean zzalt;

    public zzb(Context context, AdSizeParcel adSizeParcel, String str, zzgq zzgq, VersionInfoParcel versionInfoParcel, zzd zzd) {
        this(new zzv(context, adSizeParcel, str, versionInfoParcel), zzgq, (zzr) null, zzd);
    }

    protected zzb(zzv zzv, zzgq zzgq, @Nullable zzr zzr, zzd zzd) {
        super(zzv, zzr, zzd);
        this.zzals = zzgq;
        this.mMessenger = new Messenger(new zzhu(this.zzall.zzahn));
        this.zzalt = false;
    }

    private AdRequestInfoParcel.zza zza(AdRequestParcel adRequestParcel, Bundle bundle, zzkg zzkg) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.zzall.zzahn.getApplicationInfo();
        try {
            packageInfo = this.zzall.zzahn.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzall.zzahn.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.zzall.zzaqw == null || this.zzall.zzaqw.getParent() == null)) {
            int[] iArr = new int[2];
            this.zzall.zzaqw.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.zzall.zzaqw.getWidth();
            int height = this.zzall.zzaqw.getHeight();
            int i3 = 0;
            if (this.zzall.zzaqw.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String zztk = zzu.zzgd().zztk();
        this.zzall.zzarc = new zzkf(zztk, this.zzall.zzaqt);
        this.zzall.zzarc.zzt(adRequestParcel);
        String zza = zzu.zzfz().zza(this.zzall.zzahn, (View) this.zzall.zzaqw, this.zzall.zzaqz);
        long j = 0;
        if (this.zzall.zzarg != null) {
            try {
                j = this.zzall.zzarg.getValue();
            } catch (RemoteException e2) {
                zzkn.zzdf("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzu.zzgd().zza(this.zzall.zzahn, this, zztk);
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.zzall.zzarm.size()) {
                break;
            }
            arrayList.add(this.zzall.zzarm.keyAt(i5));
            i4 = i5 + 1;
        }
        boolean z = this.zzall.zzarh != null;
        boolean z2 = this.zzall.zzari != null && zzu.zzgd().zzty();
        boolean zzr = this.zzalo.zzame.zzr(this.zzall.zzahn);
        String str = "";
        if (zzdi.zzbhh.get().booleanValue()) {
            zzkn.zzdd("Getting webview cookie from CookieManager.");
            CookieManager zzao = zzu.zzgb().zzao(this.zzall.zzahn);
            if (zzao != null) {
                str = zzao.getCookie("googleads.g.doubleclick.net");
            }
        }
        String str2 = null;
        if (zzkg != null) {
            str2 = zzkg.zzth();
        }
        return new AdRequestInfoParcel.zza(bundle2, adRequestParcel, this.zzall.zzaqz, this.zzall.zzaqt, applicationInfo, packageInfo, zztk, zzu.zzgd().getSessionId(), this.zzall.zzaqv, zza2, this.zzall.zzarr, arrayList, bundle, zzu.zzgd().zzto(), this.mMessenger, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, zza, j, uuid, zzdi.zzkr(), this.zzall.zzaqs, this.zzall.zzarn, new CapabilityParcel(z, z2, zzr), this.zzall.zzhg(), zzu.zzfz().zzfe(), zzu.zzfz().zzfg(), zzu.zzfz().zzam(this.zzall.zzahn), zzu.zzfz().zzn(this.zzall.zzaqw), this.zzall.zzahn instanceof Activity, zzu.zzgd().zzts(), str, str2, zzu.zzgd().zztv(), zzu.zzgw().zzmi(), zzu.zzfz().zzul(), zzu.zzgh().zzut());
    }

    public String getMediationAdapterClassName() {
        if (this.zzall.zzara == null) {
            return null;
        }
        return this.zzall.zzara.zzbtg;
    }

    public void onAdClicked() {
        if (this.zzall.zzara == null) {
            zzkn.zzdf("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.zzall.zzara.zzcof == null || this.zzall.zzara.zzcof.zzbsd == null)) {
            zzu.zzgs().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, this.zzall.zzara, this.zzall.zzaqt, false, this.zzall.zzara.zzcof.zzbsd);
        }
        if (!(this.zzall.zzara.zzbte == null || this.zzall.zzara.zzbte.zzbrq == null)) {
            zzu.zzgs().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, this.zzall.zzara, this.zzall.zzaqt, false, this.zzall.zzara.zzbte.zzbrq);
        }
        super.onAdClicked();
    }

    public void onPause() {
        this.zzaln.zzl(this.zzall.zzara);
    }

    public void onResume() {
        this.zzaln.zzm(this.zzall.zzara);
    }

    public void pause() {
        zzac.zzhq("pause must be called on the main UI thread.");
        if (!(this.zzall.zzara == null || this.zzall.zzara.zzbyh == null || !this.zzall.zzhc())) {
            zzu.zzgb().zzl(this.zzall.zzara.zzbyh);
        }
        if (!(this.zzall.zzara == null || this.zzall.zzara.zzbtf == null)) {
            try {
                this.zzall.zzara.zzbtf.pause();
            } catch (RemoteException e) {
                zzkn.zzdf("Could not pause mediation adapter.");
            }
        }
        this.zzaln.zzl(this.zzall.zzara);
        this.zzalk.pause();
    }

    public void recordImpression() {
        zza(this.zzall.zzara, false);
    }

    public void resume() {
        zzac.zzhq("resume must be called on the main UI thread.");
        zzlt zzlt = null;
        if (!(this.zzall.zzara == null || this.zzall.zzara.zzbyh == null)) {
            zzlt = this.zzall.zzara.zzbyh;
        }
        if (zzlt != null && this.zzall.zzhc()) {
            zzu.zzgb().zzm(this.zzall.zzara.zzbyh);
        }
        if (!(this.zzall.zzara == null || this.zzall.zzara.zzbtf == null)) {
            try {
                this.zzall.zzara.zzbtf.resume();
            } catch (RemoteException e) {
                zzkn.zzdf("Could not resume mediation adapter.");
            }
        }
        if (zzlt == null || !zzlt.zzvx()) {
            this.zzalk.resume();
        }
        this.zzaln.zzm(this.zzall.zzara);
    }

    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void zza(zzhx zzhx) {
        zzac.zzhq("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzall.zzarh = zzhx;
    }

    public void zza(zzib zzib, @Nullable String str) {
        zzac.zzhq("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzall.zzars = new zzk(str);
        this.zzall.zzari = zzib;
        if (!zzu.zzgd().zztn() && zzib != null) {
            Future future = (Future) new zzc(this.zzall.zzahn, this.zzall.zzari, this.zzall.zzars).zzqw();
        }
    }

    /* access modifiers changed from: protected */
    public void zza(@Nullable zzke zzke, boolean z) {
        if (zzke == null) {
            zzkn.zzdf("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.zzc(zzke);
        if (!(zzke.zzcof == null || zzke.zzcof.zzbse == null)) {
            zzu.zzgs().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, zzke, this.zzall.zzaqt, z, zzke.zzcof.zzbse);
        }
        if (zzke.zzbte != null && zzke.zzbte.zzbrr != null) {
            zzu.zzgs().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, zzke, this.zzall.zzaqt, z, zzke.zzbte.zzbrr);
        }
    }

    public void zza(String str, ArrayList<String> arrayList) {
        zzd zzd = new zzd(str, arrayList, this.zzall.zzahn, this.zzall.zzaqv.zzcs);
        if (this.zzall.zzarh == null) {
            zzkn.zzdf("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!zzm.zzjr().zzas(this.zzall.zzahn)) {
                zzkn.zzdf("Google Play Service unavailable, cannot launch default purchase flow.");
            } else if (this.zzall.zzari == null) {
                zzkn.zzdf("PlayStorePurchaseListener is not set.");
            } else if (this.zzall.zzars == null) {
                zzkn.zzdf("PlayStorePurchaseVerifier is not initialized.");
            } else if (this.zzall.zzarw) {
                zzkn.zzdf("An in-app purchase request is already in progress, abort");
            } else {
                this.zzall.zzarw = true;
                try {
                    if (!this.zzall.zzari.isValidPurchase(str)) {
                        this.zzall.zzarw = false;
                    } else {
                        zzu.zzgn().zza(this.zzall.zzahn, this.zzall.zzaqv.zzctu, new GInAppPurchaseManagerInfoParcel(this.zzall.zzahn, this.zzall.zzars, zzd, this));
                    }
                } catch (RemoteException e) {
                    zzkn.zzdf("Could not start In-App purchase.");
                    this.zzall.zzarw = false;
                }
            }
        } else {
            try {
                this.zzall.zzarh.zza(zzd);
            } catch (RemoteException e2) {
                zzkn.zzdf("Could not start In-App purchase.");
            }
        }
    }

    public void zza(String str, boolean z, int i, final Intent intent, zzf zzf) {
        try {
            if (this.zzall.zzari != null) {
                this.zzall.zzari.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.zzall.zzahn, str, z, i, intent, zzf));
            }
        } catch (RemoteException e) {
            zzkn.zzdf("Fail to invoke PlayStorePurchaseListener.");
        }
        zzkr.zzcrf.postDelayed(new Runnable() {
            public void run() {
                int zzd = zzu.zzgn().zzd(intent);
                zzu.zzgn();
                if (!(zzd != 0 || zzb.this.zzall.zzara == null || zzb.this.zzall.zzara.zzbyh == null || zzb.this.zzall.zzara.zzbyh.zzvp() == null)) {
                    zzb.this.zzall.zzara.zzbyh.zzvp().close();
                }
                zzb.this.zzall.zzarw = false;
            }
        }, 500);
    }

    public boolean zza(AdRequestParcel adRequestParcel, zzdq zzdq) {
        zzkg zzkg;
        String str = null;
        if (!zzec()) {
            return false;
        }
        Bundle zza = zza(zzu.zzgd().zzaa(this.zzall.zzahn));
        this.zzalk.cancel();
        this.zzall.zzarv = 0;
        if (zzdi.zzbgq.get().booleanValue()) {
            zzkg = zzu.zzgd().zztw();
            zzg zzgv = zzu.zzgv();
            Context context = this.zzall.zzahn;
            VersionInfoParcel versionInfoParcel = this.zzall.zzaqv;
            if (zzkg != null) {
                str = zzkg.zzti();
            }
            zzgv.zza(context, versionInfoParcel, false, zzkg, str, this.zzall.zzaqt);
        } else {
            zzkg = null;
        }
        AdRequestInfoParcel.zza zza2 = zza(adRequestParcel, zza, zzkg);
        zzdq.zzh("seq_num", zza2.zzcfx);
        zzdq.zzh("request_id", zza2.zzcgj);
        zzdq.zzh("session_id", zza2.zzcfy);
        if (zza2.zzcfv != null) {
            zzdq.zzh("app_version", String.valueOf(zza2.zzcfv.versionCode));
        }
        this.zzall.zzaqx = zzu.zzfv().zza(this.zzall.zzahn, zza2, this.zzall.zzaqu, this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zza(AdRequestParcel adRequestParcel, zzke zzke, boolean z) {
        if (!z && this.zzall.zzhc()) {
            if (zzke.zzbsj > 0) {
                this.zzalk.zza(adRequestParcel, zzke.zzbsj);
            } else if (zzke.zzcof != null && zzke.zzcof.zzbsj > 0) {
                this.zzalk.zza(adRequestParcel, zzke.zzcof.zzbsj);
            } else if (!zzke.zzchc && zzke.errorCode == 2) {
                this.zzalk.zzh(adRequestParcel);
            }
        }
        return this.zzalk.zzfl();
    }

    /* access modifiers changed from: package-private */
    public boolean zza(zzke zzke) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.zzalm != null) {
            adRequestParcel = this.zzalm;
            this.zzalm = null;
        } else {
            adRequestParcel = zzke.zzcfu;
            if (adRequestParcel.extras != null) {
                z = adRequestParcel.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(adRequestParcel, zzke, z);
    }

    /* access modifiers changed from: protected */
    public boolean zza(@Nullable zzke zzke, zzke zzke2) {
        int i;
        int i2 = 0;
        if (!(zzke == null || zzke.zzbth == null)) {
            zzke.zzbth.zza((zzgi) null);
        }
        if (zzke2.zzbth != null) {
            zzke2.zzbth.zza((zzgi) this);
        }
        if (zzke2.zzcof != null) {
            i = zzke2.zzcof.zzbsp;
            i2 = zzke2.zzcof.zzbsq;
        } else {
            i = 0;
        }
        this.zzall.zzart.zzh(i, i2);
        return true;
    }

    public void zzb(zzke zzke) {
        super.zzb(zzke);
        if (zzke.zzbte != null) {
            zzkn.zzdd("Pinging network fill URLs.");
            zzu.zzgs().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, zzke, this.zzall.zzaqt, false, zzke.zzbte.zzbrs);
            if (!(zzke.zzcof == null || zzke.zzcof.zzbsg == null || zzke.zzcof.zzbsg.size() <= 0)) {
                zzkn.zzdd("Pinging urls remotely");
                zzu.zzfz().zza(this.zzall.zzahn, zzke.zzcof.zzbsg);
            }
        }
        if (zzke.errorCode == 3 && zzke.zzcof != null && zzke.zzcof.zzbsf != null) {
            zzkn.zzdd("Pinging no fill URLs.");
            zzu.zzgs().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, zzke, this.zzall.zzaqt, false, zzke.zzcof.zzbsf);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzc(AdRequestParcel adRequestParcel) {
        return super.zzc(adRequestParcel) && !this.zzalt;
    }

    /* access modifiers changed from: protected */
    public boolean zzec() {
        return zzu.zzfz().zza(this.zzall.zzahn.getPackageManager(), this.zzall.zzahn.getPackageName(), "android.permission.INTERNET") && zzu.zzfz().zzac(this.zzall.zzahn);
    }

    public void zzed() {
        this.zzaln.zzj(this.zzall.zzara);
        this.zzalt = false;
        zzdx();
        this.zzall.zzarc.zztb();
    }

    public void zzee() {
        this.zzalt = true;
        zzdz();
    }

    public void zzef() {
        onAdClicked();
    }

    public void zzeg() {
        zzed();
    }

    public void zzeh() {
        zzdu();
    }

    public void zzei() {
        zzee();
    }

    public void zzej() {
        if (this.zzall.zzara != null) {
            String str = this.zzall.zzara.zzbtg;
            zzkn.zzdf(new StringBuilder(String.valueOf(str).length() + 74).append("Mediation adapter ").append(str).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        zza(this.zzall.zzara, true);
        zzea();
    }

    public void zzek() {
        recordImpression();
    }

    public void zzel() {
        zzu.zzfz().runOnUiThread(new Runnable() {
            public void run() {
                zzb.this.zzalk.pause();
            }
        });
    }

    public void zzem() {
        zzu.zzfz().runOnUiThread(new Runnable() {
            public void run() {
                zzb.this.zzalk.resume();
            }
        });
    }
}
