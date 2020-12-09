package com.applovin.sdk;

public class AppLovinSdkSettings {

    /* renamed from: a */
    private boolean f722a;

    /* renamed from: b */
    private long f723b = -1;

    /* renamed from: c */
    private String f724c;

    /* renamed from: d */
    private String f725d;

    public String getAutoPreloadSizes() {
        return this.f724c;
    }

    public String getAutoPreloadTypes() {
        return this.f725d;
    }

    public long getBannerAdRefreshSeconds() {
        return this.f723b;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f722a;
    }

    public void setAutoPreloadSizes(String str) {
        this.f724c = str;
    }

    public void setAutoPreloadTypes(String str) {
        this.f725d = str;
    }

    public void setBannerAdRefreshSeconds(long j) {
        this.f723b = j;
    }

    public void setVerboseLogging(boolean z) {
        this.f722a = z;
    }
}
