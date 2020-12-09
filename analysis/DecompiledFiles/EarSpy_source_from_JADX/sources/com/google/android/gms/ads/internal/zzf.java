package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.safebrowsing.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;
import com.google.android.gms.internal.zzly;

@zziy
public class zzf extends zzc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private boolean zzami;

    public class zza {
        public zza() {
        }

        public void onClick() {
            zzf.this.onAdClicked();
        }
    }

    public zzf(Context context, AdSizeParcel adSizeParcel, String str, zzgq zzgq, VersionInfoParcel versionInfoParcel, zzd zzd) {
        super(context, adSizeParcel, str, zzgq, versionInfoParcel, zzd);
    }

    private AdSizeParcel zzb(zzke.zza zza2) {
        AdSize zzjd;
        if (zza2.zzcop.zzaxm) {
            return this.zzall.zzaqz;
        }
        String str = zza2.zzcop.zzchf;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            zzjd = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            zzjd = this.zzall.zzaqz.zzjd();
        }
        return new AdSizeParcel(this.zzall.zzahn, zzjd);
    }

    private boolean zzb(@Nullable zzke zzke, zzke zzke2) {
        if (zzke2.zzchc) {
            View zzg = zzn.zzg(zzke2);
            if (zzg == null) {
                zzkn.zzdf("Could not get mediation view");
                return false;
            }
            View nextView = this.zzall.zzaqw.getNextView();
            if (nextView != null) {
                if (nextView instanceof zzlt) {
                    ((zzlt) nextView).destroy();
                }
                this.zzall.zzaqw.removeView(nextView);
            }
            if (!zzn.zzh(zzke2)) {
                try {
                    zzb(zzg);
                } catch (Throwable th) {
                    zzkn.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (!(zzke2.zzcoh == null || zzke2.zzbyh == null)) {
            zzke2.zzbyh.zza(zzke2.zzcoh);
            this.zzall.zzaqw.removeAllViews();
            this.zzall.zzaqw.setMinimumWidth(zzke2.zzcoh.widthPixels);
            this.zzall.zzaqw.setMinimumHeight(zzke2.zzcoh.heightPixels);
            zzb(zzke2.zzbyh.getView());
        }
        if (this.zzall.zzaqw.getChildCount() > 1) {
            this.zzall.zzaqw.showNext();
        }
        if (zzke != null) {
            View nextView2 = this.zzall.zzaqw.getNextView();
            if (nextView2 instanceof zzlt) {
                ((zzlt) nextView2).zza(this.zzall.zzahn, this.zzall.zzaqz, this.zzalg);
            } else if (nextView2 != null) {
                this.zzall.zzaqw.removeView(nextView2);
            }
            this.zzall.zzhb();
        }
        this.zzall.zzaqw.setVisibility(0);
        return true;
    }

    private void zze(final zzke zzke) {
        if (this.zzall.zzhc()) {
            if (zzke.zzbyh != null) {
                if (zzke.zzcod != null) {
                    this.zzaln.zza(this.zzall.zzaqz, zzke);
                }
                if (zzke.zzib()) {
                    this.zzaln.zza(this.zzall.zzaqz, zzke).zza((zzck) zzke.zzbyh);
                } else {
                    zzke.zzbyh.zzvr().zza((zzlu.zzc) new zzlu.zzc() {
                        public void zzet() {
                            zzf.this.zzaln.zza(zzf.this.zzall.zzaqz, zzke).zza((zzck) zzke.zzbyh);
                        }
                    });
                }
            }
        } else if (this.zzall.zzaru != null && zzke.zzcod != null) {
            this.zzaln.zza(this.zzall.zzaqz, zzke, this.zzall.zzaru);
        }
    }

    public void onGlobalLayout() {
        zzf(this.zzall.zzara);
    }

    public void onScrollChanged() {
        zzf(this.zzall.zzara);
    }

    public void setManualImpressionsEnabled(boolean z) {
        zzac.zzhq("setManualImpressionsEnabled must be called from the main thread.");
        this.zzami = z;
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    /* access modifiers changed from: protected */
    public zzlt zza(zzke.zza zza2, @Nullable zze zze, @Nullable zzc zzc) {
        if (this.zzall.zzaqz.zzaxk == null && this.zzall.zzaqz.zzaxm) {
            this.zzall.zzaqz = zzb(zza2);
        }
        return super.zza(zza2, zze, zzc);
    }

    /* access modifiers changed from: protected */
    public void zza(@Nullable zzke zzke, boolean z) {
        super.zza(zzke, z);
        if (zzn.zzh(zzke)) {
            zzn.zza(zzke, new zza());
        }
    }

    public boolean zza(@Nullable zzke zzke, final zzke zzke2) {
        zzly zzly;
        if (!super.zza(zzke, zzke2)) {
            return false;
        }
        if (!this.zzall.zzhc() || zzb(zzke, zzke2)) {
            if (zzke2.zzchu) {
                zzf(zzke2);
                zzu.zzgx().zza((View) this.zzall.zzaqw, (ViewTreeObserver.OnGlobalLayoutListener) this);
                zzu.zzgx().zza((View) this.zzall.zzaqw, (ViewTreeObserver.OnScrollChangedListener) this);
                if (!zzke2.zzcoe) {
                    final C06821 r2 = new Runnable() {
                        public void run() {
                            zzf.this.zzf(zzf.this.zzall.zzara);
                        }
                    };
                    zzlu zzvr = zzke2.zzbyh != null ? zzke2.zzbyh.zzvr() : null;
                    if (zzvr != null) {
                        zzvr.zza((zzlu.zze) new zzlu.zze() {
                            public void zzes() {
                                if (!zzke2.zzcoe) {
                                    zzu.zzfz();
                                    zzkr.zzb(r2);
                                }
                            }
                        });
                    }
                }
            } else if (!this.zzall.zzhd() || zzdi.zzbfu.get().booleanValue()) {
                zza(zzke2, false);
            }
            if (zzke2.zzbyh != null) {
                zzly = zzke2.zzbyh.zzwb();
                zzlu zzvr2 = zzke2.zzbyh.zzvr();
                if (zzvr2 != null) {
                    zzvr2.zzwo();
                }
            } else {
                zzly = null;
            }
            if (!(this.zzall.zzaro == null || zzly == null)) {
                zzly.zzap(this.zzall.zzaro.zzbac);
            }
            zze(zzke2);
            return true;
        }
        zzh(0);
        return false;
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        return super.zzb(zze(adRequestParcel));
    }

    @Nullable
    public zzab zzdw() {
        zzac.zzhq("getVideoController must be called from the main thread.");
        if (this.zzall.zzara == null || this.zzall.zzara.zzbyh == null) {
            return null;
        }
        return this.zzall.zzara.zzbyh.zzwb();
    }

    /* access modifiers changed from: package-private */
    public AdRequestParcel zze(AdRequestParcel adRequestParcel) {
        if (adRequestParcel.zzawi == this.zzami) {
            return adRequestParcel;
        }
        return new AdRequestParcel(adRequestParcel.versionCode, adRequestParcel.zzawd, adRequestParcel.extras, adRequestParcel.zzawe, adRequestParcel.zzawf, adRequestParcel.zzawg, adRequestParcel.zzawh, adRequestParcel.zzawi || this.zzami, adRequestParcel.zzawj, adRequestParcel.zzawk, adRequestParcel.zzawl, adRequestParcel.zzawm, adRequestParcel.zzawn, adRequestParcel.zzawo, adRequestParcel.zzawp, adRequestParcel.zzawq, adRequestParcel.zzawr, adRequestParcel.zzaws);
    }

    /* access modifiers changed from: protected */
    public boolean zzec() {
        boolean z = true;
        if (!zzu.zzfz().zza(this.zzall.zzahn.getPackageManager(), this.zzall.zzahn.getPackageName(), "android.permission.INTERNET")) {
            zzm.zzjr().zza(this.zzall.zzaqw, this.zzall.zzaqz, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzu.zzfz().zzac(this.zzall.zzahn)) {
            zzm.zzjr().zza(this.zzall.zzaqw, this.zzall.zzaqz, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzall.zzaqw != null) {
            this.zzall.zzaqw.setVisibility(0);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void zzf(@Nullable zzke zzke) {
        if (zzke != null && !zzke.zzcoe && this.zzall.zzaqw != null && zzu.zzfz().zza((View) this.zzall.zzaqw, this.zzall.zzahn) && this.zzall.zzaqw.getGlobalVisibleRect(new Rect(), (Point) null)) {
            if (!(zzke == null || zzke.zzbyh == null || zzke.zzbyh.zzvr() == null)) {
                zzke.zzbyh.zzvr().zza((zzlu.zze) null);
            }
            zza(zzke, false);
            zzke.zzcoe = true;
        }
    }
}
