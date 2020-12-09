package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class NativeAdImpl implements C0318ay, C0402x {
    public static final String QUERY_PARAM_IS_FIRST_PLAY = "fp";
    public static final String QUERY_PARAM_VIDEO_PERCENT_VIEWED = "pv";
    public static final AppLovinAdSize SIZE_NATIVE = new AppLovinAdSize("NATIVE");
    public static final C0347c SPEC_NATIVE = new C0347c(SIZE_NATIVE, TYPE_NATIVE);
    public static final AppLovinAdType TYPE_NATIVE = new AppLovinAdType("NATIVE");

    /* renamed from: a */
    private final AppLovinSdkImpl f286a;

    /* renamed from: b */
    private String f287b;

    /* renamed from: c */
    private String f288c;

    /* renamed from: d */
    private String f289d;

    /* renamed from: e */
    private String f290e;

    /* renamed from: f */
    private String f291f;

    /* renamed from: g */
    private String f292g;

    /* renamed from: h */
    private String f293h;

    /* renamed from: i */
    private String f294i;

    /* renamed from: j */
    private String f295j;

    /* renamed from: k */
    private String f296k;

    /* renamed from: l */
    private float f297l;

    /* renamed from: m */
    private String f298m;

    /* renamed from: n */
    private String f299n;

    /* renamed from: o */
    private String f300o;

    /* renamed from: p */
    private String f301p;

    /* renamed from: q */
    private String f302q;

    /* renamed from: r */
    private String f303r;

    /* renamed from: s */
    private long f304s;

    private NativeAdImpl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, float f, String str10, String str11, String str12, String str13, String str14, String str15, String str16, long j, AppLovinSdkImpl appLovinSdkImpl) {
        this.f287b = str;
        this.f288c = str2;
        this.f289d = str3;
        this.f290e = str4;
        this.f291f = str5;
        this.f292g = str6;
        this.f293h = str7;
        this.f295j = str8;
        this.f296k = str9;
        this.f297l = f;
        this.f298m = str10;
        this.f299n = str11;
        this.f300o = str12;
        this.f301p = str13;
        this.f302q = str14;
        this.f303r = str15;
        this.f294i = str16;
        this.f304s = j;
        this.f286a = appLovinSdkImpl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NativeAdImpl nativeAdImpl = (NativeAdImpl) obj;
        if (this.f293h == null ? nativeAdImpl.f293h != null : !this.f293h.equals(nativeAdImpl.f293h)) {
            return false;
        }
        if (this.f303r == null ? nativeAdImpl.f303r != null : !this.f303r.equals(nativeAdImpl.f303r)) {
            return false;
        }
        if (this.f300o == null ? nativeAdImpl.f300o != null : !this.f300o.equals(nativeAdImpl.f300o)) {
            return false;
        }
        if (this.f294i == null ? nativeAdImpl.f294i != null : !this.f294i.equals(nativeAdImpl.f294i)) {
            return false;
        }
        if (this.f292g == null ? nativeAdImpl.f292g != null : !this.f292g.equals(nativeAdImpl.f292g)) {
            return false;
        }
        if (this.f299n == null ? nativeAdImpl.f299n != null : !this.f299n.equals(nativeAdImpl.f299n)) {
            return false;
        }
        if (this.f287b == null ? nativeAdImpl.f287b != null : !this.f287b.equals(nativeAdImpl.f287b)) {
            return false;
        }
        if (this.f288c == null ? nativeAdImpl.f288c != null : !this.f288c.equals(nativeAdImpl.f288c)) {
            return false;
        }
        if (this.f289d == null ? nativeAdImpl.f289d != null : !this.f289d.equals(nativeAdImpl.f289d)) {
            return false;
        }
        if (this.f290e == null ? nativeAdImpl.f290e != null : !this.f290e.equals(nativeAdImpl.f290e)) {
            return false;
        }
        if (this.f291f == null ? nativeAdImpl.f291f != null : !this.f291f.equals(nativeAdImpl.f291f)) {
            return false;
        }
        if (this.f302q == null ? nativeAdImpl.f302q != null : !this.f302q.equals(nativeAdImpl.f302q)) {
            return false;
        }
        if (this.f301p != null) {
            if (this.f301p.equals(nativeAdImpl.f301p)) {
                return true;
            }
        } else if (nativeAdImpl.f301p == null) {
            return true;
        }
        return false;
    }

    public long getAdId() {
        return this.f304s;
    }

    public String getCaptionText() {
        return this.f293h;
    }

    public String getClCode() {
        return this.f303r;
    }

    public String getClickUrl() {
        return this.f300o;
    }

    public String getCtaText() {
        return this.f294i;
    }

    public String getDescriptionText() {
        return this.f292g;
    }

    public String getIconUrl() {
        return this.f295j;
    }

    public String getImageUrl() {
        return this.f296k;
    }

    public String getImpressionTrackingUrl() {
        return this.f299n;
    }

    public String getSourceIconUrl() {
        return this.f287b;
    }

    public String getSourceImageUrl() {
        return this.f288c;
    }

    public String getSourceStarRatingImageUrl() {
        return this.f289d;
    }

    public String getSourceVideoUrl() {
        return this.f290e;
    }

    public float getStarRating() {
        return this.f297l;
    }

    public String getTitle() {
        return this.f291f;
    }

    public String getVideoEndTrackingUrl(int i, boolean z) {
        if (this.f302q == null) {
            return Uri.EMPTY.toString();
        }
        if (i < 0 || i > 100) {
            Log.e("AppLovinNativeAd", "Invalid percent viewed supplied.", new IllegalArgumentException("Percent viewed must be an integer between 0 and 100."));
        }
        return Uri.parse(this.f302q).buildUpon().appendQueryParameter(QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).appendQueryParameter(QUERY_PARAM_IS_FIRST_PLAY, Boolean.toString(z)).build().toString();
    }

    public String getVideoStartTrackingUrl() {
        return this.f301p;
    }

    public String getVideoUrl() {
        return this.f298m;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f302q != null ? this.f302q.hashCode() : 0) + (((this.f301p != null ? this.f301p.hashCode() : 0) + (((this.f300o != null ? this.f300o.hashCode() : 0) + (((this.f299n != null ? this.f299n.hashCode() : 0) + (((this.f294i != null ? this.f294i.hashCode() : 0) + (((this.f293h != null ? this.f293h.hashCode() : 0) + (((this.f292g != null ? this.f292g.hashCode() : 0) + (((this.f291f != null ? this.f291f.hashCode() : 0) + (((this.f290e != null ? this.f290e.hashCode() : 0) + (((this.f289d != null ? this.f289d.hashCode() : 0) + (((this.f288c != null ? this.f288c.hashCode() : 0) + ((this.f287b != null ? this.f287b.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f303r != null) {
            i = this.f303r.hashCode();
        }
        return hashCode + i;
    }

    public boolean isImagePrecached() {
        return (this.f295j != null && !this.f295j.equals(this.f287b)) && (this.f296k != null && !this.f296k.equals(this.f288c));
    }

    public boolean isVideoPrecached() {
        return this.f298m != null && !this.f298m.equals(this.f290e);
    }

    public void launchClickTarget(Context context) {
        this.f286a.getPersistentPostbackManager().mo5506a(this.f300o, (Map) null);
        AppLovinSdkUtils.openUrl(context, this.f300o, this.f286a);
    }

    public void setIconUrl(String str) {
        this.f295j = str;
    }

    public void setImageUrl(String str) {
        this.f296k = str;
    }

    public void setStarRating(float f) {
        this.f297l = f;
    }

    public void setVideoUrl(String str) {
        this.f298m = str;
    }

    public String toString() {
        return "WidgetSlot{clCode='" + this.f303r + '\'' + ", sourceIconUrl='" + this.f287b + '\'' + ", sourceImageUrl='" + this.f288c + '\'' + ", sourceStarRatingImageUrl='" + this.f289d + '\'' + ", sourceVideoUrl='" + this.f290e + '\'' + ", title='" + this.f291f + '\'' + ", descriptionText='" + this.f292g + '\'' + ", captionText='" + this.f293h + '\'' + ", ctaText='" + this.f294i + '\'' + ", iconUrl='" + this.f295j + '\'' + ", imageUrl='" + this.f296k + '\'' + ", starRating='" + this.f297l + '\'' + ", videoUrl='" + this.f298m + '\'' + ", impressionTrackingUrl='" + this.f299n + '\'' + ", clickUrl='" + this.f300o + '\'' + ", videoStartTrackingUrl='" + this.f301p + '\'' + ", videoEndTrackingUrl='" + this.f302q + '\'' + '}';
    }
}
