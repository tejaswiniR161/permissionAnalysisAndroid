package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.common.internal.zzac;

@zziy
public class zzls {
    private final Context mContext;
    private final zzlt zzbkr;
    private zzk zzcay;
    private final ViewGroup zzcur;

    public zzls(Context context, ViewGroup viewGroup, zzlt zzlt) {
        this(context, viewGroup, zzlt, (zzk) null);
    }

    zzls(Context context, ViewGroup viewGroup, zzlt zzlt, zzk zzk) {
        this.mContext = context;
        this.zzcur = viewGroup;
        this.zzbkr = zzlt;
        this.zzcay = zzk;
    }

    public void onDestroy() {
        zzac.zzhq("onDestroy must be called from the UI thread.");
        if (this.zzcay != null) {
            this.zzcay.destroy();
            this.zzcur.removeView(this.zzcay);
            this.zzcay = null;
        }
    }

    public void onPause() {
        zzac.zzhq("onPause must be called from the UI thread.");
        if (this.zzcay != null) {
            this.zzcay.pause();
        }
    }

    public void zza(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (this.zzcay == null) {
            zzdm.zza(this.zzbkr.zzwa().zzkz(), this.zzbkr.zzvz(), "vpr2");
            this.zzcay = new zzk(this.mContext, this.zzbkr, i5, z, this.zzbkr.zzwa().zzkz());
            this.zzcur.addView(this.zzcay, 0, new ViewGroup.LayoutParams(-1, -1));
            this.zzcay.zzd(i, i2, i3, i4);
            this.zzbkr.zzvr().zzan(false);
        }
    }

    public void zze(int i, int i2, int i3, int i4) {
        zzac.zzhq("The underlay may only be modified from the UI thread.");
        if (this.zzcay != null) {
            this.zzcay.zzd(i, i2, i3, i4);
        }
    }

    public zzk zzvk() {
        zzac.zzhq("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzcay;
    }
}
