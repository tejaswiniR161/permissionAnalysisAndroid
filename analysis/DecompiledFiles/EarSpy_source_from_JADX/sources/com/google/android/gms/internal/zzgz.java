package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgu;
import java.util.ArrayList;
import java.util.List;

@zziy
public class zzgz extends zzgu.zza {
    private final NativeAppInstallAdMapper zzbud;

    public zzgz(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzbud = nativeAppInstallAdMapper;
    }

    public String getBody() {
        return this.zzbud.getBody();
    }

    public String getCallToAction() {
        return this.zzbud.getCallToAction();
    }

    public Bundle getExtras() {
        return this.zzbud.getExtras();
    }

    public String getHeadline() {
        return this.zzbud.getHeadline();
    }

    public List getImages() {
        List<NativeAd.Image> images = this.zzbud.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image next : images) {
            arrayList.add(new zzc(next.getDrawable(), next.getUri(), next.getScale()));
        }
        return arrayList;
    }

    public boolean getOverrideClickHandling() {
        return this.zzbud.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.zzbud.getOverrideImpressionRecording();
    }

    public String getPrice() {
        return this.zzbud.getPrice();
    }

    public double getStarRating() {
        return this.zzbud.getStarRating();
    }

    public String getStore() {
        return this.zzbud.getStore();
    }

    public void recordImpression() {
        this.zzbud.recordImpression();
    }

    public zzab zzdw() {
        if (this.zzbud.getVideoController() != null) {
            return this.zzbud.getVideoController().zzdj();
        }
        return null;
    }

    public void zzk(zzd zzd) {
        this.zzbud.handleClick((View) zze.zzae(zzd));
    }

    public void zzl(zzd zzd) {
        this.zzbud.trackView((View) zze.zzae(zzd));
    }

    public zzdx zzlo() {
        NativeAd.Image icon = this.zzbud.getIcon();
        if (icon != null) {
            return new zzc(icon.getDrawable(), icon.getUri(), icon.getScale());
        }
        return null;
    }

    public void zzm(zzd zzd) {
        this.zzbud.untrackView((View) zze.zzae(zzd));
    }
}
