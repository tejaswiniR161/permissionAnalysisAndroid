package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzgu;
import com.google.android.gms.internal.zzgv;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzlt;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zziy
public class zzh extends zzj {
    private Object zzakd;
    @Nullable
    private zzgu zzbkh;
    @Nullable
    private zzgv zzbki;
    private final zzq zzbkj;
    @Nullable
    private zzi zzbkk;
    private boolean zzbkl;

    private zzh(Context context, zzq zzq, zzau zzau, zzi.zza zza) {
        super(context, zzq, (zzir) null, zzau, (JSONObject) null, zza, (VersionInfoParcel) null, (String) null);
        this.zzbkl = false;
        this.zzakd = new Object();
        this.zzbkj = zzq;
    }

    public zzh(Context context, zzq zzq, zzau zzau, zzgu zzgu, zzi.zza zza) {
        this(context, zzq, zzau, zza);
        this.zzbkh = zzgu;
    }

    public zzh(Context context, zzq zzq, zzau zzau, zzgv zzgv, zzi.zza zza) {
        this(context, zzq, zzau, zza);
        this.zzbki = zzgv;
    }

    public void recordImpression() {
        zzac.zzhq("recordImpression must be called on the main UI thread.");
        synchronized (this.zzakd) {
            zzr(true);
            if (this.zzbkk != null) {
                this.zzbkk.recordImpression();
                this.zzbkj.recordImpression();
            } else {
                try {
                    if (this.zzbkh != null && !this.zzbkh.getOverrideImpressionRecording()) {
                        this.zzbkh.recordImpression();
                        this.zzbkj.recordImpression();
                    } else if (this.zzbki != null && !this.zzbki.getOverrideImpressionRecording()) {
                        this.zzbki.recordImpression();
                        this.zzbkj.recordImpression();
                    }
                } catch (RemoteException e) {
                    zzkn.zzd("Failed to call recordImpression", e);
                }
            }
        }
    }

    @Nullable
    public zzb zza(View.OnClickListener onClickListener) {
        return null;
    }

    public void zza(View view, Map<String, WeakReference<View>> map, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        synchronized (this.zzakd) {
            this.zzbkl = true;
            try {
                if (this.zzbkh != null) {
                    this.zzbkh.zzl(zze.zzac(view));
                } else if (this.zzbki != null) {
                    this.zzbki.zzl(zze.zzac(view));
                }
            } catch (RemoteException e) {
                zzkn.zzd("Failed to call prepareAd", e);
            }
            this.zzbkl = false;
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzac.zzhq("performClick must be called on the main UI thread.");
        synchronized (this.zzakd) {
            if (this.zzbkk != null) {
                this.zzbkk.zza(view, map, jSONObject, jSONObject2, jSONObject3);
                this.zzbkj.onAdClicked();
            } else {
                try {
                    if (this.zzbkh != null && !this.zzbkh.getOverrideClickHandling()) {
                        this.zzbkh.zzk(zze.zzac(view));
                        this.zzbkj.onAdClicked();
                    }
                    if (this.zzbki != null && !this.zzbki.getOverrideClickHandling()) {
                        this.zzbki.zzk(zze.zzac(view));
                        this.zzbkj.onAdClicked();
                    }
                } catch (RemoteException e) {
                    zzkn.zzd("Failed to call performClick", e);
                }
            }
        }
    }

    public void zzb(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.zzakd) {
            try {
                if (this.zzbkh != null) {
                    this.zzbkh.zzm(zze.zzac(view));
                } else if (this.zzbki != null) {
                    this.zzbki.zzm(zze.zzac(view));
                }
            } catch (RemoteException e) {
                zzkn.zzd("Failed to call untrackView", e);
            }
        }
    }

    public void zzc(@Nullable zzi zzi) {
        synchronized (this.zzakd) {
            this.zzbkk = zzi;
        }
    }

    public boolean zzlv() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzbkl;
        }
        return z;
    }

    public zzi zzlw() {
        zzi zzi;
        synchronized (this.zzakd) {
            zzi = this.zzbkk;
        }
        return zzi;
    }

    @Nullable
    public zzlt zzlx() {
        return null;
    }
}
