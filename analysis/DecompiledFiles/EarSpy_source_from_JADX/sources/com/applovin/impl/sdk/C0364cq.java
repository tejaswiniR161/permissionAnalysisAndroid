package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.cq */
class C0364cq {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f608a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinLogger f609b;

    /* renamed from: c */
    private final ScheduledExecutorService f610c = mo5635a("main");

    /* renamed from: d */
    private final ScheduledExecutorService f611d = mo5635a("back");

    /* renamed from: e */
    private final ScheduledExecutorService f612e = mo5635a("postbacks");

    C0364cq(AppLovinSdkImpl appLovinSdkImpl) {
        this.f608a = appLovinSdkImpl;
        this.f609b = appLovinSdkImpl.getLogger();
    }

    /* renamed from: a */
    private static void m522a(Runnable runnable, long j, ScheduledExecutorService scheduledExecutorService) {
        if (j > 0) {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } else {
            scheduledExecutorService.submit(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ScheduledExecutorService mo5635a(String str) {
        return Executors.newScheduledThreadPool(1, new C0366cs(this, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5636a(C0342bv bvVar, C0365cr crVar) {
        mo5637a(bvVar, crVar, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5637a(C0342bv bvVar, C0365cr crVar, long j) {
        if (bvVar == null) {
            throw new IllegalArgumentException("No task specified");
        } else if (j < 0) {
            throw new IllegalArgumentException("Invalid delay specified: " + j);
        } else {
            this.f609b.mo5665d(bvVar.f437e, "Scheduling " + bvVar.f437e + " on " + crVar + " queue in " + j + "ms.");
            C0368cu cuVar = new C0368cu(this, bvVar, crVar);
            if (crVar == C0365cr.MAIN) {
                m522a((Runnable) cuVar, j, this.f610c);
            } else if (crVar == C0365cr.BACKGROUND) {
                m522a((Runnable) cuVar, j, this.f611d);
            } else if (crVar == C0365cr.POSTBACKS) {
                m522a((Runnable) cuVar, j, this.f612e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5638a(C0363cp cpVar, long j) {
        if (cpVar == null) {
            throw new IllegalArgumentException("No task specified");
        }
        m522a((Runnable) cpVar, j, this.f610c);
    }
}
