package com.applovin.sdk;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AppLovinAdType {
    public static final AppLovinAdType INCENTIVIZED = new AppLovinAdType("VIDEOA");
    public static final AppLovinAdType REGULAR = new AppLovinAdType("REGULAR");

    /* renamed from: a */
    private final String f719a;

    public AppLovinAdType(String str) {
        this.f719a = str;
    }

    public static Set allTypes() {
        HashSet hashSet = new HashSet(2);
        hashSet.add(REGULAR);
        hashSet.add(INCENTIVIZED);
        return hashSet;
    }

    public static AppLovinAdType fromString(String str) {
        return str.toUpperCase(Locale.ENGLISH).equals(INCENTIVIZED.getLabel()) ? INCENTIVIZED : REGULAR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdType appLovinAdType = (AppLovinAdType) obj;
        if (this.f719a != null) {
            if (this.f719a.equals(appLovinAdType.f719a)) {
                return true;
            }
        } else if (appLovinAdType.f719a == null) {
            return true;
        }
        return false;
    }

    public String getLabel() {
        return this.f719a.toUpperCase(Locale.ENGLISH);
    }

    public int hashCode() {
        if (this.f719a != null) {
            return this.f719a.hashCode();
        }
        return 0;
    }

    public String toString() {
        return getLabel();
    }
}
