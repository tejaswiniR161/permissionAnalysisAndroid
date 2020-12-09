package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zzdr;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzez;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzlt;
import java.util.Map;

@zziy
public abstract class zzc extends zzb implements zzh, zzhn {
    public zzc(Context context, AdSizeParcel adSizeParcel, String str, zzgq zzgq, VersionInfoParcel versionInfoParcel, zzd zzd) {
        super(context, adSizeParcel, str, zzgq, versionInfoParcel, zzd);
    }

    /* access modifiers changed from: protected */
    public zzlt zza(zzke.zza zza, @Nullable zze zze, @Nullable com.google.android.gms.ads.internal.safebrowsing.zzc zzc) {
        zzlt zzlt = null;
        View nextView = this.zzall.zzaqw.getNextView();
        if (nextView instanceof zzlt) {
            zzlt = (zzlt) nextView;
            if (zzdi.zzbcv.get().booleanValue()) {
                zzkn.zzdd("Reusing webview...");
                zzlt.zza(this.zzall.zzahn, this.zzall.zzaqz, this.zzalg);
            } else {
                zzlt.destroy();
                zzlt = null;
            }
        }
        if (zzlt == null) {
            if (nextView != null) {
                this.zzall.zzaqw.removeView(nextView);
            }
            zzlt = zzu.zzga().zza(this.zzall.zzahn, this.zzall.zzaqz, false, false, this.zzall.zzaqu, this.zzall.zzaqv, this.zzalg, this, this.zzalo);
            if (this.zzall.zzaqz.zzaxk == null) {
                zzb(zzlt.getView());
            }
        }
        zzlt zzlt2 = zzlt;
        zzlt2.zzvr().zza(this, this, this, this, false, this, (zzez) null, zze, this, zzc);
        zza((zzfz) zzlt2);
        zzlt2.zzdh(zza.zzcix.zzcgj);
        return zzlt2;
    }

    public void zza(int i, int i2, int i3, int i4) {
        zzdz();
    }

    public void zza(zzdu zzdu) {
        zzac.zzhq("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzall.zzarp = zzdu;
    }

    /* access modifiers changed from: protected */
    public void zza(zzfz zzfz) {
        zzfz.zza("/trackActiveViewUnit", (zzev) new zzev() {
            public void zza(zzlt zzlt, Map<String, String> map) {
                if (zzc.this.zzall.zzara != null) {
                    zzc.this.zzaln.zza(zzc.this.zzall.zzaqz, zzc.this.zzall.zzara, zzlt.getView(), (zzfz) zzlt);
                } else {
                    zzkn.zzdf("Request to enable ActiveView before adState is available.");
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void zza(final zzke.zza zza, final zzdq zzdq) {
        if (zza.errorCode != -2) {
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzc.this.zzb(new zzke(zza, (zzlt) null, (zzgg) null, (zzgr) null, (String) null, (zzgj) null, (zzi.zza) null, (String) null));
                }
            });
            return;
        }
        if (zza.zzaqz != null) {
            this.zzall.zzaqz = zza.zzaqz;
        }
        if (!zza.zzcop.zzchc || zza.zzcop.zzaxn) {
            final com.google.android.gms.ads.internal.safebrowsing.zzc zza2 = this.zzalo.zzamf.zza(this.zzall.zzahn, zza.zzcop);
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    if (zza.zzcop.zzchl && zzc.this.zzall.zzarp != null) {
                        String str = null;
                        if (zza.zzcop.zzbyj != null) {
                            str = zzu.zzfz().zzcv(zza.zzcop.zzbyj);
                        }
                        zzdr zzdr = new zzdr(zzc.this, str, zza.zzcop.body);
                        zzc.this.zzall.zzarv = 1;
                        try {
                            zzc.this.zzalj = false;
                            zzc.this.zzall.zzarp.zza(zzdr);
                            return;
                        } catch (RemoteException e) {
                            zzkn.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
                            zzc.this.zzalj = true;
                        }
                    }
                    final zze zze = new zze(zzc.this.zzall.zzahn, zza);
                    zzlt zza = zzc.this.zza(zza, zze, zza2);
                    zza.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            zze.recordClick();
                            return false;
                        }
                    });
                    zza.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            zze.recordClick();
                        }
                    });
                    zzc.this.zzall.zzarv = 0;
                    zzc.this.zzall.zzaqy = zzu.zzfy().zza(zzc.this.zzall.zzahn, zzc.this, zza, zzc.this.zzall.zzaqu, zza, zzc.this.zzals, zzc.this, zzdq);
                }
            });
            return;
        }
        this.zzall.zzarv = 0;
        this.zzall.zzaqy = zzu.zzfy().zza(this.zzall.zzahn, this, zza, this.zzall.zzaqu, (zzlt) null, this.zzals, this, zzdq);
    }

    /* access modifiers changed from: protected */
    public boolean zza(@Nullable zzke zzke, zzke zzke2) {
        if (this.zzall.zzhc() && this.zzall.zzaqw != null) {
            this.zzall.zzaqw.zzhi().zzcz(zzke2.zzchh);
        }
        return super.zza(zzke, zzke2);
    }

    public void zzc(View view) {
        this.zzall.zzaru = view;
        zzb(new zzke(this.zzall.zzarb, (zzlt) null, (zzgg) null, (zzgr) null, (String) null, (zzgj) null, (zzi.zza) null, (String) null));
    }

    public void zzen() {
        onAdClicked();
    }

    public void zzeo() {
        recordImpression();
        zzdv();
    }

    public void zzep() {
        zzdx();
    }
}
