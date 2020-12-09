package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdz;

public abstract class NativeAdView extends FrameLayout {
    private final FrameLayout zzaks;
    private final zzdz zzakt = zzdm();

    public NativeAdView(Context context) {
        super(context);
        this.zzaks = zze(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzaks = zze(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzaks = zze(context);
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzaks = zze(context);
    }

    private zzdz zzdm() {
        zzac.zzb(this.zzaks, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return zzm.zzjs().zza(this.zzaks.getContext(), (FrameLayout) this, this.zzaks);
    }

    private FrameLayout zze(Context context) {
        FrameLayout zzf = zzf(context);
        zzf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(zzf);
        return zzf;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzaks);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.zzaks != view) {
            super.bringChildToFront(this.zzaks);
        }
    }

    public void destroy() {
        try {
            this.zzakt.destroy();
        } catch (RemoteException e) {
            zzb.zzb("Unable to destroy native ad view", e);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzaks);
    }

    public void removeView(View view) {
        if (this.zzaks != view) {
            super.removeView(view);
        }
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzakt.zze((zzd) nativeAd.zzdl());
        } catch (RemoteException e) {
            zzb.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(String str, View view) {
        try {
            this.zzakt.zzc(str, zze.zzac(view));
        } catch (RemoteException e) {
            zzb.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    /* access modifiers changed from: package-private */
    public FrameLayout zzf(Context context) {
        return new FrameLayout(context);
    }

    /* access modifiers changed from: protected */
    public View zzs(String str) {
        try {
            zzd zzas = this.zzakt.zzas(str);
            if (zzas != null) {
                return (View) zze.zzae(zzas);
            }
        } catch (RemoteException e) {
            zzb.zzb("Unable to call getAssetView on delegate", e);
        }
        return null;
    }
}
