package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.p000v4.util.SimpleArrayMap;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgu;
import com.google.android.gms.internal.zzgv;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzlt;
import java.util.List;

@zziy
public class zzq extends zzb {
    private zzlt zzaoq;

    public zzq(Context context, zzd zzd, AdSizeParcel adSizeParcel, String str, zzgq zzgq, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzgq, versionInfoParcel, zzd);
    }

    private static zzd zza(zzgu zzgu) throws RemoteException {
        return new zzd(zzgu.getHeadline(), zzgu.getImages(), zzgu.getBody(), zzgu.zzlo() != null ? zzgu.zzlo() : null, zzgu.getCallToAction(), zzgu.getStarRating(), zzgu.getStore(), zzgu.getPrice(), (zza) null, zzgu.getExtras(), zzgu.zzdw(), (View) null);
    }

    private static zze zza(zzgv zzgv) throws RemoteException {
        return new zze(zzgv.getHeadline(), zzgv.getImages(), zzgv.getBody(), zzgv.zzlt() != null ? zzgv.zzlt() : null, zzgv.getCallToAction(), zzgv.getAdvertiser(), (zza) null, zzgv.getExtras());
    }

    private void zza(final zzd zzd) {
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                try {
                    if (zzq.this.zzall.zzarj != null) {
                        zzq.this.zzall.zzarj.zza(zzd);
                    }
                } catch (RemoteException e) {
                    zzkn.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
                }
            }
        });
    }

    private void zza(final zze zze) {
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                try {
                    if (zzq.this.zzall.zzark != null) {
                        zzq.this.zzall.zzark.zza(zze);
                    }
                } catch (RemoteException e) {
                    zzkn.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
                }
            }
        });
    }

    private void zza(final zzke zzke, final String str) {
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                try {
                    zzq.this.zzall.zzarm.get(str).zza((zzf) zzke.zzcol);
                } catch (RemoteException e) {
                    zzkn.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
                }
            }
        });
    }

    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(SimpleArrayMap<String, zzek> simpleArrayMap) {
        zzac.zzhq("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.zzall.zzarm = simpleArrayMap;
    }

    public void zza(zzg zzg) {
        if (this.zzaoq != null) {
            this.zzaoq.zzb(zzg);
        }
    }

    public void zza(zzi zzi) {
        if (this.zzall.zzara.zzcod != null) {
            zzu.zzgd().zztx().zza(this.zzall.zzaqz, this.zzall.zzara, zzi);
        }
    }

    public void zza(zzdu zzdu) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void zza(zzhx zzhx) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void zza(final zzke.zza zza, zzdq zzdq) {
        if (zza.zzaqz != null) {
            this.zzall.zzaqz = zza.zzaqz;
        }
        if (zza.errorCode != -2) {
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzq.this.zzb(new zzke(zza, (zzlt) null, (zzgg) null, (zzgr) null, (String) null, (zzgj) null, (zzi.zza) null, (String) null));
                }
            });
            return;
        }
        this.zzall.zzarv = 0;
        this.zzall.zzaqy = zzu.zzfy().zza(this.zzall.zzahn, this, zza, this.zzall.zzaqu, (zzlt) null, this.zzals, this, zzdq);
        String valueOf = String.valueOf(this.zzall.zzaqy.getClass().getName());
        zzkn.zzdd(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
    }

    /* access modifiers changed from: protected */
    public boolean zza(AdRequestParcel adRequestParcel, zzke zzke, boolean z) {
        return this.zzalk.zzfl();
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzke zzke, zzke zzke2) {
        zzb((List<String>) null);
        if (!this.zzall.zzhc()) {
            throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
        }
        if (zzke2.zzchc) {
            try {
                zzgu zznm = zzke2.zzbtf != null ? zzke2.zzbtf.zznm() : null;
                zzgv zznn = zzke2.zzbtf != null ? zzke2.zzbtf.zznn() : null;
                if (zznm == null || this.zzall.zzarj == null) {
                    if (zznn != null) {
                        if (this.zzall.zzark != null) {
                            zze zza = zza(zznn);
                            zza.zzb(new zzh(this.zzall.zzahn, this, this.zzall.zzaqu, zznn, (zzi.zza) zza));
                            zza(zza);
                        }
                    }
                    zzkn.zzdf("No matching mapper/listener for retrieved native ad template.");
                    zzh(0);
                    return false;
                }
                zzd zza2 = zza(zznm);
                zza2.zzb(new zzh(this.zzall.zzahn, this, this.zzall.zzaqu, zznm, (zzi.zza) zza2));
                zza(zza2);
            } catch (RemoteException e) {
                zzkn.zzd("Failed to get native ad mapper", e);
            }
        } else {
            zzi.zza zza3 = zzke2.zzcol;
            if ((zza3 instanceof zze) && this.zzall.zzark != null) {
                zza((zze) zzke2.zzcol);
            } else if ((zza3 instanceof zzd) && this.zzall.zzarj != null) {
                zza((zzd) zzke2.zzcol);
            } else if (!(zza3 instanceof zzf) || this.zzall.zzarm == null || this.zzall.zzarm.get(((zzf) zza3).getCustomTemplateId()) == null) {
                zzkn.zzdf("No matching listener for retrieved native ad template.");
                zzh(0);
                return false;
            } else {
                zza(zzke2, ((zzf) zza3).getCustomTemplateId());
            }
        }
        return super.zza(zzke, zzke2);
    }

    public void zzb(SimpleArrayMap<String, zzej> simpleArrayMap) {
        zzac.zzhq("setOnCustomClickListener must be called on the main UI thread.");
        this.zzall.zzarl = simpleArrayMap;
    }

    public void zzb(NativeAdOptionsParcel nativeAdOptionsParcel) {
        zzac.zzhq("setNativeAdOptions must be called on the main UI thread.");
        this.zzall.zzarn = nativeAdOptionsParcel;
    }

    public void zzb(zzeh zzeh) {
        zzac.zzhq("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.zzall.zzarj = zzeh;
    }

    public void zzb(zzei zzei) {
        zzac.zzhq("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.zzall.zzark = zzei;
    }

    public void zzb(@Nullable List<String> list) {
        zzac.zzhq("setNativeTemplates must be called on the main UI thread.");
        this.zzall.zzarr = list;
    }

    public void zzc(zzlt zzlt) {
        this.zzaoq = zzlt;
    }

    public void zzfh() {
        if (this.zzall.zzara == null || this.zzaoq == null) {
            zzkn.zzdf("Request to enable ActiveView before adState is available.");
        } else {
            zzu.zzgd().zztx().zza(this.zzall.zzaqz, this.zzall.zzara, this.zzaoq.getView(), (zzfz) this.zzaoq);
        }
    }

    public SimpleArrayMap<String, zzek> zzfi() {
        zzac.zzhq("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzall.zzarm;
    }

    public void zzfj() {
        if (this.zzaoq != null) {
            this.zzaoq.destroy();
            this.zzaoq = null;
        }
    }

    public void zzfk() {
        if (this.zzaoq != null && this.zzaoq.zzwb() != null && this.zzall.zzarn != null && this.zzall.zzarn.zzblf != null) {
            this.zzaoq.zzwb().zzap(this.zzall.zzarn.zzblf.zzbac);
        }
    }

    @Nullable
    public zzej zzx(String str) {
        zzac.zzhq("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzall.zzarl.get(str);
    }
}
