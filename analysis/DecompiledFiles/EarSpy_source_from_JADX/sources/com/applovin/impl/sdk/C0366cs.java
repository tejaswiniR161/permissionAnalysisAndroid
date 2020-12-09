package com.applovin.impl.sdk;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.applovin.impl.sdk.cs */
class C0366cs implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ C0364cq f617a;

    /* renamed from: b */
    private final String f618b;

    public C0366cs(C0364cq cqVar, String str) {
        this.f617a = cqVar;
        this.f618b = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f618b + ":" + C0382dh.m582a(this.f617a.f608a.getSdkKey()));
        thread.setDaemon(true);
        thread.setPriority(10);
        thread.setUncaughtExceptionHandler(new C0367ct(this));
        return thread;
    }
}
