package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinTargetingData;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.m */
class C0391m implements AppLovinTargetingData {

    /* renamed from: a */
    private final Context f675a;

    C0391m(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f675a = appLovinSdkImpl.getApplicationContext();
    }

    /* renamed from: a */
    private static String m603a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (AppLovinSdkUtils.isValidString(str)) {
                sb.append(C0382dh.m590c(str));
                sb.append(",");
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m604a(String str, String str2) {
        if (AppLovinSdkUtils.isValidString(str)) {
            SharedPreferences.Editor edit = this.f675a.getSharedPreferences("applovin.sdk.targeting", 0).edit();
            edit.putString(str, C0382dh.m590c(str2));
            edit.commit();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map mo5674a() {
        HashMap hashMap = new HashMap();
        Map<String, ?> all = this.f675a.getSharedPreferences("applovin.sdk.targeting", 0).getAll();
        if (all != null && all.size() > 0) {
            for (Map.Entry next : all.entrySet()) {
                hashMap.put(next.getKey(), String.valueOf(next.getValue()));
            }
        }
        return hashMap;
    }

    public void clearData() {
        SharedPreferences.Editor edit = this.f675a.getSharedPreferences("applovin.sdk.targeting", 0).edit();
        edit.clear();
        edit.commit();
    }

    public void putExtra(String str, String str2) {
        if (AppLovinSdkUtils.isValidString(str) && AppLovinSdkUtils.isValidString(str2)) {
            m604a("ex_" + str, str2);
        }
    }

    public void setBirthYear(int i) {
        if (i < 9999 && i > 1900) {
            m604a("yob", Integer.toString(i));
        }
    }

    public void setCarrier(String str) {
        if (AppLovinSdkUtils.isValidString(str)) {
            m604a("carrier", str);
        }
    }

    public void setCountry(String str) {
        if (AppLovinSdkUtils.isValidString(str) && str.length() == 2) {
            m604a("country", str.toUpperCase(Locale.ENGLISH));
        }
    }

    public void setGender(char c) {
        m604a("gender", c == 'm' ? "m" : c == 'f' ? "f" : "u");
    }

    public void setInterests(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            m604a("interests", m603a(strArr));
        }
    }

    public void setKeywords(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            m604a("keywords", m603a(strArr));
        }
    }

    public void setLanguage(String str) {
        if (AppLovinSdkUtils.isValidString(str)) {
            m604a("language", str.toLowerCase(Locale.ENGLISH));
        }
    }

    public void setLocation(Location location) {
        if (location != null) {
            m604a("lat", Double.toString(location.getLatitude()));
            m604a("lon", Double.toString(location.getLongitude()));
        }
    }
}
