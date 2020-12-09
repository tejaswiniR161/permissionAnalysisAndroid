package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.impl.adview.C0288v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;

public class AppLovinAdImpl implements C0318ay, AppLovinAd {

    /* renamed from: a */
    private final AppLovinAdSize f226a;

    /* renamed from: b */
    private final AppLovinAdType f227b;

    /* renamed from: c */
    private final long f228c;

    /* renamed from: d */
    private final String f229d;

    /* renamed from: e */
    private final AdTarget f230e;

    /* renamed from: f */
    private final String f231f;

    /* renamed from: g */
    private final String f232g;

    /* renamed from: h */
    private final float f233h;

    /* renamed from: i */
    private final float f234i;

    /* renamed from: j */
    private final int f235j;

    /* renamed from: k */
    private final String f236k;

    /* renamed from: l */
    private final String f237l;

    /* renamed from: m */
    private final String f238m;

    /* renamed from: n */
    private final String f239n;

    /* renamed from: o */
    private final C0288v f240o;

    public enum AdTarget {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    public class Builder {

        /* renamed from: a */
        private String f242a;

        /* renamed from: b */
        private AppLovinAdSize f243b;

        /* renamed from: c */
        private AppLovinAdType f244c;

        /* renamed from: d */
        private String f245d;

        /* renamed from: e */
        private AdTarget f246e;

        /* renamed from: f */
        private C0288v f247f;

        /* renamed from: g */
        private float f248g;

        /* renamed from: h */
        private float f249h;

        /* renamed from: i */
        private int f250i;

        /* renamed from: j */
        private long f251j;

        /* renamed from: k */
        private String f252k;

        /* renamed from: l */
        private String f253l;

        /* renamed from: m */
        private String f254m;

        /* renamed from: n */
        private String f255n;

        /* renamed from: o */
        private String f256o;

        public AppLovinAdImpl build() {
            return new AppLovinAdImpl(this.f242a, this.f243b, this.f244c, this.f245d, this.f246e, this.f247f, this.f248g, this.f249h, this.f250i, this.f251j, this.f252k, this.f253l, this.f254m, this.f255n, this.f256o);
        }

        public Builder setClCode(String str) {
            this.f252k = str;
            return this;
        }

        public Builder setCloseStyle(C0288v vVar) {
            this.f247f = vVar;
            return this;
        }

        public Builder setCompletionUrl(String str) {
            this.f253l = str;
            return this;
        }

        public Builder setCountdownLength(int i) {
            this.f250i = i;
            return this;
        }

        public Builder setCurrentAdIdNumber(long j) {
            this.f251j = j;
            return this;
        }

        public Builder setHtml(String str) {
            this.f242a = str;
            return this;
        }

        public Builder setMuteImageFilename(String str) {
            this.f255n = str;
            return this;
        }

        public Builder setPoststitialCloseDelay(float f) {
            this.f249h = f;
            return this;
        }

        public Builder setSize(AppLovinAdSize appLovinAdSize) {
            this.f243b = appLovinAdSize;
            return this;
        }

        public Builder setSupplementalClickTrackingUrl(String str) {
            this.f254m = str;
            return this;
        }

        public Builder setTarget(AdTarget adTarget) {
            this.f246e = adTarget;
            return this;
        }

        public Builder setType(AppLovinAdType appLovinAdType) {
            this.f244c = appLovinAdType;
            return this;
        }

        public Builder setUnmuteImageFilename(String str) {
            this.f256o = str;
            return this;
        }

        public Builder setVideoCloseDelay(float f) {
            this.f248g = f;
            return this;
        }

        public Builder setVideoFilename(String str) {
            this.f245d = str;
            return this;
        }
    }

    private AppLovinAdImpl(String str, AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str2, AdTarget adTarget, C0288v vVar, float f, float f2, int i, long j, String str3, String str4, String str5, String str6, String str7) {
        if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No size specified");
        } else if (appLovinAdType == null) {
            throw new IllegalArgumentException("No type specified");
        } else {
            this.f226a = appLovinAdSize;
            this.f227b = appLovinAdType;
            this.f229d = str2;
            this.f228c = j;
            this.f232g = str;
            this.f230e = adTarget;
            this.f233h = f;
            this.f235j = i;
            this.f231f = str3;
            this.f240o = vVar;
            this.f234i = f2;
            this.f236k = str4;
            this.f237l = str5;
            this.f238m = str6;
            this.f239n = str7;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) obj;
        if (this.f228c != appLovinAdImpl.f228c || Float.compare(appLovinAdImpl.f233h, this.f233h) != 0 || Float.compare(appLovinAdImpl.f234i, this.f234i) != 0 || this.f235j != appLovinAdImpl.f235j) {
            return false;
        }
        if (this.f226a != null) {
            if (!this.f226a.equals(appLovinAdImpl.f226a)) {
                return false;
            }
        } else if (appLovinAdImpl.f226a != null) {
            return false;
        }
        if (this.f227b != null) {
            if (!this.f227b.equals(appLovinAdImpl.f227b)) {
                return false;
            }
        } else if (appLovinAdImpl.f227b != null) {
            return false;
        }
        if (this.f229d != null) {
            if (!this.f229d.equals(appLovinAdImpl.f229d)) {
                return false;
            }
        } else if (appLovinAdImpl.f229d != null) {
            return false;
        }
        if (this.f230e != appLovinAdImpl.f230e) {
            return false;
        }
        if (this.f231f != null) {
            if (!this.f231f.equals(appLovinAdImpl.f231f)) {
                return false;
            }
        } else if (appLovinAdImpl.f231f != null) {
            return false;
        }
        if (this.f232g != null) {
            if (!this.f232g.equals(appLovinAdImpl.f232g)) {
                return false;
            }
        } else if (appLovinAdImpl.f232g != null) {
            return false;
        }
        if (this.f236k != null) {
            if (!this.f236k.equals(appLovinAdImpl.f236k)) {
                return false;
            }
        } else if (appLovinAdImpl.f236k != null) {
            return false;
        }
        if (this.f237l != null) {
            if (!this.f237l.equals(appLovinAdImpl.f237l)) {
                return false;
            }
        } else if (appLovinAdImpl.f237l != null) {
            return false;
        }
        if (this.f238m != null) {
            if (!this.f238m.equals(appLovinAdImpl.f238m)) {
                return false;
            }
        } else if (appLovinAdImpl.f238m != null) {
            return false;
        }
        if (this.f239n != null) {
            if (!this.f239n.equals(appLovinAdImpl.f239n)) {
                return false;
            }
        } else if (appLovinAdImpl.f239n != null) {
            return false;
        }
        if (this.f240o != appLovinAdImpl.f240o) {
            z = false;
        }
        return z;
    }

    public long getAdIdNumber() {
        return this.f228c;
    }

    public String getClCode() {
        return this.f231f;
    }

    public C0288v getCloseStyle() {
        return this.f240o;
    }

    public String getCompletionUrl() {
        return this.f236k;
    }

    public int getCountdownLength() {
        return this.f235j;
    }

    public String getHtmlSource() {
        return this.f232g;
    }

    public String getMuteImageFilename() {
        return this.f238m;
    }

    public String getParametrizedCompletionUrl(int i) {
        String completionUrl = getCompletionUrl();
        return AppLovinSdkUtils.isValidString(completionUrl) ? Uri.parse(completionUrl.replace("{CLCODE}", getClCode())).buildUpon().appendQueryParameter(NativeAdImpl.QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).build().toString() : "";
    }

    public float getPoststitialCloseDelay() {
        return this.f234i;
    }

    public AppLovinAdSize getSize() {
        return this.f226a;
    }

    public String getSupplementalClickTrackingUrl() {
        String str = this.f237l;
        return AppLovinSdkUtils.isValidString(str) ? str.replace("{CLCODE}", getClCode()) : "";
    }

    public AdTarget getTarget() {
        return this.f230e;
    }

    public AppLovinAdType getType() {
        return this.f227b;
    }

    public String getUnmuteImageFilename() {
        return this.f239n;
    }

    public float getVideoCloseDelay() {
        return this.f233h;
    }

    public String getVideoFilename() {
        return this.f229d;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f239n != null ? this.f239n.hashCode() : 0) + (((this.f238m != null ? this.f238m.hashCode() : 0) + (((this.f237l != null ? this.f237l.hashCode() : 0) + (((this.f236k != null ? this.f236k.hashCode() : 0) + (((((this.f234i != 0.0f ? Float.floatToIntBits(this.f234i) : 0) + (((this.f233h != 0.0f ? Float.floatToIntBits(this.f233h) : 0) + (((this.f232g != null ? this.f232g.hashCode() : 0) + (((this.f231f != null ? this.f231f.hashCode() : 0) + (((this.f230e != null ? this.f230e.hashCode() : 0) + (((this.f229d != null ? this.f229d.hashCode() : 0) + (((((this.f227b != null ? this.f227b.hashCode() : 0) + ((this.f226a != null ? this.f226a.hashCode() : 0) * 31)) * 31) + ((int) (this.f228c ^ (this.f228c >>> 32)))) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + this.f235j) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f240o != null) {
            i = this.f240o.hashCode();
        }
        return hashCode + i;
    }

    public boolean isVideoAd() {
        return AppLovinSdkUtils.isValidString(this.f229d);
    }

    public String toString() {
        return "AppLovinAdImpl{size=" + this.f226a + ", type=" + this.f227b + ", adIdNumber=" + this.f228c + ", videoFilename='" + this.f229d + '\'' + ", target=" + this.f230e + ", clCode='" + this.f231f + '\'' + ", htmlSource='" + this.f232g + '\'' + ", videoCloseDelay=" + this.f233h + ", poststitialCloseDelay=" + this.f234i + ", countdownLength=" + this.f235j + ", completionUrl='" + this.f236k + '\'' + ", supplementalClickTrackingUrl='" + this.f237l + '\'' + ", muteImageFilename='" + this.f238m + '\'' + ", unmuteImageFilename='" + this.f239n + '\'' + ", closeStyle=" + this.f240o + '}';
    }
}
