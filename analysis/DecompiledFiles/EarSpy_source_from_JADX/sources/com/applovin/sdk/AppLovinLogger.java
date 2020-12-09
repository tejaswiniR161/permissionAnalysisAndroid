package com.applovin.sdk;

public interface AppLovinLogger {
    public static final String SDK_TAG = "AppLovinSdk";

    /* renamed from: d */
    void mo5665d(String str, String str2);

    /* renamed from: e */
    void mo5666e(String str, String str2);

    /* renamed from: e */
    void mo5667e(String str, String str2, Throwable th);

    /* renamed from: i */
    void mo5668i(String str, String str2);

    void userError(String str, String str2);

    void userError(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo5671w(String str, String str2);

    /* renamed from: w */
    void mo5672w(String str, String str2, Throwable th);
}
