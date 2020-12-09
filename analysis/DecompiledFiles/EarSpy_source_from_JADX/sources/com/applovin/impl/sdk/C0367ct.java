package com.applovin.impl.sdk;

import java.lang.Thread;

/* renamed from: com.applovin.impl.sdk.ct */
class C0367ct implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ C0366cs f619a;

    C0367ct(C0366cs csVar) {
        this.f619a = csVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f619a.f617a.f609b.mo5667e("TaskManager", "Caught unhandled exception", th);
    }
}
