package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzu;

@zziy
public final class zzlf {
    private final View mView;
    private Activity zzctd;
    private boolean zzcte;
    private boolean zzctf;
    private boolean zzctg;
    private ViewTreeObserver.OnGlobalLayoutListener zzcth;
    private ViewTreeObserver.OnScrollChangedListener zzcti;

    public zzlf(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzctd = activity;
        this.mView = view;
        this.zzcth = onGlobalLayoutListener;
        this.zzcti = onScrollChangedListener;
    }

    private void zzvc() {
        if (!this.zzcte) {
            if (this.zzcth != null) {
                if (this.zzctd != null) {
                    zzu.zzfz().zza(this.zzctd, this.zzcth);
                }
                zzu.zzgx().zza(this.mView, this.zzcth);
            }
            if (this.zzcti != null) {
                if (this.zzctd != null) {
                    zzu.zzfz().zza(this.zzctd, this.zzcti);
                }
                zzu.zzgx().zza(this.mView, this.zzcti);
            }
            this.zzcte = true;
        }
    }

    private void zzvd() {
        if (this.zzctd != null && this.zzcte) {
            if (!(this.zzcth == null || this.zzctd == null)) {
                zzu.zzgb().zzb(this.zzctd, this.zzcth);
            }
            if (!(this.zzcti == null || this.zzctd == null)) {
                zzu.zzfz().zzb(this.zzctd, this.zzcti);
            }
            this.zzcte = false;
        }
    }

    public void onAttachedToWindow() {
        this.zzctf = true;
        if (this.zzctg) {
            zzvc();
        }
    }

    public void onDetachedFromWindow() {
        this.zzctf = false;
        zzvd();
    }

    public void zzl(Activity activity) {
        this.zzctd = activity;
    }

    public void zzva() {
        this.zzctg = true;
        if (this.zzctf) {
            zzvc();
        }
    }

    public void zzvb() {
        this.zzctg = false;
        zzvd();
    }
}
