package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

public abstract class NativeContentAdMapper extends NativeAdMapper {
    private String zzbjq;
    private List<NativeAd.Image> zzbjr;
    private String zzbjs;
    private String zzbju;
    private String zzbkd;
    private NativeAd.Image zzcxh;

    public final String getAdvertiser() {
        return this.zzbkd;
    }

    public final String getBody() {
        return this.zzbjs;
    }

    public final String getCallToAction() {
        return this.zzbju;
    }

    public final String getHeadline() {
        return this.zzbjq;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbjr;
    }

    public final NativeAd.Image getLogo() {
        return this.zzcxh;
    }

    public final void setAdvertiser(String str) {
        this.zzbkd = str;
    }

    public final void setBody(String str) {
        this.zzbjs = str;
    }

    public final void setCallToAction(String str) {
        this.zzbju = str;
    }

    public final void setHeadline(String str) {
        this.zzbjq = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzbjr = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzcxh = image;
    }
}
