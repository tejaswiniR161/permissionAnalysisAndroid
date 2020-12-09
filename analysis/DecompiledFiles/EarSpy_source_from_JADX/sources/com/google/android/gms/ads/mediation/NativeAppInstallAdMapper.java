package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

public abstract class NativeAppInstallAdMapper extends NativeAdMapper {
    private VideoController zzayu;
    private String zzbjq;
    private List<NativeAd.Image> zzbjr;
    private String zzbjs;
    private String zzbju;
    private double zzbjv;
    private String zzbjw;
    private String zzbjx;
    private NativeAd.Image zzcxg;

    public final String getBody() {
        return this.zzbjs;
    }

    public final String getCallToAction() {
        return this.zzbju;
    }

    public final String getHeadline() {
        return this.zzbjq;
    }

    public final NativeAd.Image getIcon() {
        return this.zzcxg;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzbjr;
    }

    public final String getPrice() {
        return this.zzbjx;
    }

    public final double getStarRating() {
        return this.zzbjv;
    }

    public final String getStore() {
        return this.zzbjw;
    }

    public final VideoController getVideoController() {
        return this.zzayu;
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

    public final void setIcon(NativeAd.Image image) {
        this.zzcxg = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzbjr = list;
    }

    public final void setPrice(String str) {
        this.zzbjx = str;
    }

    public final void setStarRating(double d) {
        this.zzbjv = d;
    }

    public final void setStore(String str) {
        this.zzbjw = str;
    }

    public final void zza(VideoController videoController) {
        this.zzayu = videoController;
    }
}
