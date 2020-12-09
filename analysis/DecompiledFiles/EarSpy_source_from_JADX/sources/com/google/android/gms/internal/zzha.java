package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgv;
import java.util.ArrayList;
import java.util.List;

@zziy
public class zzha extends zzgv.zza {
    private final NativeContentAdMapper zzbue;

    public zzha(NativeContentAdMapper nativeContentAdMapper) {
        this.zzbue = nativeContentAdMapper;
    }

    public String getAdvertiser() {
        return this.zzbue.getAdvertiser();
    }

    public String getBody() {
        return this.zzbue.getBody();
    }

    public String getCallToAction() {
        return this.zzbue.getCallToAction();
    }

    public Bundle getExtras() {
        return this.zzbue.getExtras();
    }

    public String getHeadline() {
        return this.zzbue.getHeadline();
    }

    public List getImages() {
        List<NativeAd.Image> images = this.zzbue.getImages();
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
        return this.zzbue.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.zzbue.getOverrideImpressionRecording();
    }

    public void recordImpression() {
        this.zzbue.recordImpression();
    }

    public void zzk(zzd zzd) {
        this.zzbue.handleClick((View) zze.zzae(zzd));
    }

    public void zzl(zzd zzd) {
        this.zzbue.trackView((View) zze.zzae(zzd));
    }

    public zzdx zzlt() {
        NativeAd.Image logo = this.zzbue.getLogo();
        if (logo != null) {
            return new zzc(logo.getDrawable(), logo.getUri(), logo.getScale());
        }
        return null;
    }

    public void zzm(zzd zzd) {
        this.zzbue.untrackView((View) zze.zzae(zzd));
    }
}
