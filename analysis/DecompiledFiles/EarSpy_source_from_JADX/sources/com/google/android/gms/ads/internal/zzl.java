package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.Window;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel;
import com.google.android.gms.ads.internal.safebrowsing.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zzez;
import com.google.android.gms.internal.zzfe;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzjc;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzl extends zzc implements zzez, zzfe.zza {
    protected transient boolean zzanp = false;
    private int zzanq = -1;
    /* access modifiers changed from: private */
    public boolean zzanr;
    /* access modifiers changed from: private */
    public float zzans;

    @zziy
    private class zza extends zzkm {
        private final int zzant;

        public zza(int i) {
            this.zzant = i;
        }

        public void onStop() {
        }

        public void zzfc() {
            InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(zzl.this.zzall.zzanx, zzl.this.zzez(), zzl.this.zzanr, zzl.this.zzans, zzl.this.zzall.zzanx ? this.zzant : -1);
            int requestedOrientation = zzl.this.zzall.zzara.zzbyh.getRequestedOrientation();
            final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzl.this, zzl.this, zzl.this, zzl.this.zzall.zzara.zzbyh, requestedOrientation == -1 ? zzl.this.zzall.zzara.orientation : requestedOrientation, zzl.this.zzall.zzaqv, zzl.this.zzall.zzara.zzchh, interstitialAdParameterParcel);
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzu.zzfx().zza(zzl.this.zzall.zzahn, adOverlayInfoParcel);
                }
            });
        }
    }

    public zzl(Context context, AdSizeParcel adSizeParcel, String str, zzgq zzgq, VersionInfoParcel versionInfoParcel, zzd zzd) {
        super(context, adSizeParcel, str, zzgq, versionInfoParcel, zzd);
    }

    private void zzb(Bundle bundle) {
        zzu.zzfz().zzb(this.zzall.zzahn, this.zzall.zzaqv.zzcs, "gmob-apps", bundle, false);
    }

    static zzke.zza zzc(zzke.zza zza2) {
        try {
            String jSONObject = zzjc.zzc(zza2.zzcop).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zza2.zzcix.zzaqt);
            zzgg zzgg = new zzgg(jSONObject, (String) null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), (String) null, (String) null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), (String) null, Collections.emptyList(), Collections.emptyList(), (String) null, (String) null, (String) null, (List<String>) null, (String) null, Collections.emptyList());
            AdResponseParcel adResponseParcel = zza2.zzcop;
            zzgh zzgh = new zzgh(Collections.singletonList(zzgg), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), adResponseParcel.zzbsg, adResponseParcel.zzbsh, "", -1, 0, 1, (String) null, 0, -1, -1, false);
            return new zzke.zza(zza2.zzcix, new AdResponseParcel(zza2.zzcix, adResponseParcel.zzbyj, adResponseParcel.body, Collections.emptyList(), Collections.emptyList(), adResponseParcel.zzchb, true, adResponseParcel.zzchd, Collections.emptyList(), adResponseParcel.zzbsj, adResponseParcel.orientation, adResponseParcel.zzchf, adResponseParcel.zzchg, adResponseParcel.zzchh, adResponseParcel.zzchi, adResponseParcel.zzchj, (String) null, adResponseParcel.zzchl, adResponseParcel.zzaxl, adResponseParcel.zzcgc, adResponseParcel.zzchm, adResponseParcel.zzchn, adResponseParcel.zzchq, adResponseParcel.zzaxm, adResponseParcel.zzaxn, (RewardItemParcel) null, Collections.emptyList(), Collections.emptyList(), adResponseParcel.zzchu, adResponseParcel.zzchv, adResponseParcel.zzcgt, adResponseParcel.zzcgu, adResponseParcel.zzbsg, adResponseParcel.zzbsh, adResponseParcel.zzchw, (SafeBrowsingConfigParcel) null, adResponseParcel.zzchy), zzgh, zza2.zzaqz, zza2.errorCode, zza2.zzcoj, zza2.zzcok, (JSONObject) null);
        } catch (JSONException e) {
            zzkn.zzb("Unable to generate ad state for an interstitial ad with pooling.", e);
            return zza2;
        }
    }

    public void showInterstitial() {
        zzac.zzhq("showInterstitial must be called on the main UI thread.");
        if (this.zzall.zzara == null) {
            zzkn.zzdf("The interstitial has not loaded.");
            return;
        }
        if (zzdi.zzbdy.get().booleanValue()) {
            String packageName = this.zzall.zzahn.getApplicationContext() != null ? this.zzall.zzahn.getApplicationContext().getPackageName() : this.zzall.zzahn.getPackageName();
            if (!this.zzanp) {
                zzkn.zzdf("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                zzb(bundle);
            }
            if (!zzu.zzfz().zzai(this.zzall.zzahn)) {
                zzkn.zzdf("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("appid", packageName);
                bundle2.putString("action", "show_interstitial_app_not_in_foreground");
                zzb(bundle2);
            }
        }
        if (this.zzall.zzhd()) {
            return;
        }
        if (this.zzall.zzara.zzchc && this.zzall.zzara.zzbtf != null) {
            try {
                this.zzall.zzara.zzbtf.showInterstitial();
            } catch (RemoteException e) {
                zzkn.zzd("Could not show interstitial.", e);
                zzfa();
            }
        } else if (this.zzall.zzara.zzbyh == null) {
            zzkn.zzdf("The interstitial failed to load.");
        } else if (this.zzall.zzara.zzbyh.zzvv()) {
            zzkn.zzdf("The interstitial is already showing.");
        } else {
            this.zzall.zzara.zzbyh.zzaj(true);
            if (this.zzall.zzara.zzcod != null) {
                this.zzaln.zza(this.zzall.zzaqz, this.zzall.zzara);
            }
            Bitmap zzaj = this.zzall.zzanx ? zzu.zzfz().zzaj(this.zzall.zzahn) : null;
            this.zzanq = zzu.zzgu().zzb(zzaj);
            if (!zzdi.zzbfn.get().booleanValue() || zzaj == null) {
                InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.zzall.zzanx, zzez(), false, 0.0f, -1);
                int requestedOrientation = this.zzall.zzara.zzbyh.getRequestedOrientation();
                if (requestedOrientation == -1) {
                    requestedOrientation = this.zzall.zzara.orientation;
                }
                zzu.zzfx().zza(this.zzall.zzahn, new AdOverlayInfoParcel(this, this, this, this.zzall.zzara.zzbyh, requestedOrientation, this.zzall.zzaqv, this.zzall.zzara.zzchh, interstitialAdParameterParcel));
                return;
            }
            Future future = (Future) new zza(this.zzanq).zzqw();
        }
    }

    /* access modifiers changed from: protected */
    public zzlt zza(zzke.zza zza2, @Nullable zze zze, @Nullable zzc zzc) {
        zzlt zza3 = zzu.zzga().zza(this.zzall.zzahn, this.zzall.zzaqz, false, false, this.zzall.zzaqu, this.zzall.zzaqv, this.zzalg, this, this.zzalo);
        zza3.zzvr().zza(this, (zzg) null, this, this, zzdi.zzbcp.get().booleanValue(), this, this, zze, (zzhn) null, zzc);
        zza((zzfz) zza3);
        zza3.zzdh(zza2.zzcix.zzcgj);
        zzfe.zza(zza3, (zzfe.zza) this);
        return zza3;
    }

    public void zza(zzke.zza zza2, zzdq zzdq) {
        boolean z = true;
        if (!zzdi.zzbdi.get().booleanValue()) {
            super.zza(zza2, zzdq);
        } else if (zza2.errorCode != -2) {
            super.zza(zza2, zzdq);
        } else {
            Bundle bundle = zza2.zzcix.zzcfu.zzawn.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
            boolean z2 = bundle == null || !bundle.containsKey("gw");
            if (zza2.zzcop.zzchc) {
                z = false;
            }
            if (z2 && z) {
                this.zzall.zzarb = zzc(zza2);
            }
            super.zza(this.zzall.zzarb, zzdq);
        }
    }

    public void zza(boolean z, float f) {
        this.zzanr = z;
        this.zzans = f;
    }

    public boolean zza(AdRequestParcel adRequestParcel, zzdq zzdq) {
        if (this.zzall.zzara == null) {
            return super.zza(adRequestParcel, zzdq);
        }
        zzkn.zzdf("An interstitial is already loading. Aborting.");
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zza(AdRequestParcel adRequestParcel, zzke zzke, boolean z) {
        if (this.zzall.zzhc() && zzke.zzbyh != null) {
            zzu.zzgb().zzl(zzke.zzbyh);
        }
        return this.zzalk.zzfl();
    }

    public boolean zza(@Nullable zzke zzke, zzke zzke2) {
        if (!super.zza(zzke, zzke2)) {
            return false;
        }
        if (!(this.zzall.zzhc() || this.zzall.zzaru == null || zzke2.zzcod == null)) {
            this.zzaln.zza(this.zzall.zzaqz, zzke2, this.zzall.zzaru);
        }
        return true;
    }

    public void zzb(RewardItemParcel rewardItemParcel) {
        if (this.zzall.zzara != null) {
            if (this.zzall.zzara.zzcht != null) {
                zzu.zzfz().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, this.zzall.zzara.zzcht);
            }
            if (this.zzall.zzara.zzchr != null) {
                rewardItemParcel = this.zzall.zzara.zzchr;
            }
        }
        zza(rewardItemParcel);
    }

    /* access modifiers changed from: protected */
    public void zzdx() {
        zzfa();
        super.zzdx();
    }

    /* access modifiers changed from: protected */
    public void zzea() {
        super.zzea();
        this.zzanp = true;
    }

    public void zzee() {
        zzlu zzvr;
        recordImpression();
        super.zzee();
        if (this.zzall.zzara != null && this.zzall.zzara.zzbyh != null && (zzvr = this.zzall.zzara.zzbyh.zzvr()) != null) {
            zzvr.zzwo();
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzez() {
        Window window;
        if (!(this.zzall.zzahn instanceof Activity) || (window = ((Activity) this.zzall.zzahn).getWindow()) == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, (Point) null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    public void zzfa() {
        zzu.zzgu().zzb(Integer.valueOf(this.zzanq));
        if (this.zzall.zzhc()) {
            this.zzall.zzgz();
            this.zzall.zzara = null;
            this.zzall.zzanx = false;
            this.zzanp = false;
        }
    }

    public void zzfb() {
        if (!(this.zzall.zzara == null || this.zzall.zzara.zzcoi == null)) {
            zzu.zzfz().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, this.zzall.zzara.zzcoi);
        }
        zzeb();
    }

    public void zzg(boolean z) {
        this.zzall.zzanx = z;
    }
}
