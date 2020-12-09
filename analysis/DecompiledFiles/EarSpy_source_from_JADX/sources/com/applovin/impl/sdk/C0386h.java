package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdUpdateListener;
import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.h */
class C0386h implements AppLovinAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdServiceImpl f662a;

    /* renamed from: b */
    private final C0387i f663b;

    private C0386h(AppLovinAdServiceImpl appLovinAdServiceImpl, C0387i iVar) {
        this.f662a = appLovinAdServiceImpl;
        this.f663b = iVar;
    }

    /* synthetic */ C0386h(AppLovinAdServiceImpl appLovinAdServiceImpl, C0387i iVar, C0383e eVar) {
        this(appLovinAdServiceImpl, iVar);
    }

    public void adReceived(AppLovinAd appLovinAd) {
        HashSet<AppLovinAdLoadListener> hashSet;
        HashSet<AppLovinAdUpdateListener> hashSet2;
        synchronized (this.f663b.f665b) {
            if (this.f662a.m205a(this.f663b.f664a)) {
                long b = this.f662a.m208b(this.f663b.f664a);
                if (b > 0) {
                    this.f663b.f667d = (b * 1000) + System.currentTimeMillis();
                } else if (b == 0) {
                    this.f663b.f667d = Long.MAX_VALUE;
                }
                this.f663b.f666c = appLovinAd;
            } else {
                this.f663b.f666c = null;
                this.f663b.f667d = 0;
            }
            hashSet = new HashSet<>(this.f663b.f670g);
            this.f663b.f670g.clear();
            hashSet2 = new HashSet<>(this.f663b.f669f);
            this.f663b.f668e = false;
        }
        this.f662a.m212c(this.f663b.f664a);
        for (AppLovinAdLoadListener adReceived : hashSet) {
            try {
                adReceived.adReceived(appLovinAd);
            } catch (Throwable th) {
                this.f662a.f258b.mo5667e("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
            }
        }
        for (AppLovinAdUpdateListener adUpdated : hashSet2) {
            try {
                adUpdated.adUpdated(appLovinAd);
            } catch (Throwable th2) {
                this.f662a.f258b.mo5667e("AppLovinAdService", "Unable to notify listener about an updated loaded ad", th2);
            }
        }
    }

    public void failedToReceiveAd(int i) {
        HashSet<AppLovinAdLoadListener> hashSet;
        synchronized (this.f663b.f665b) {
            hashSet = new HashSet<>(this.f663b.f670g);
            this.f663b.f670g.clear();
            this.f663b.f668e = false;
        }
        for (AppLovinAdLoadListener failedToReceiveAd : hashSet) {
            try {
                failedToReceiveAd.failedToReceiveAd(i);
            } catch (Throwable th) {
                this.f662a.f258b.mo5667e("AppLovinAdService", "Unable to notify listener about ad load failure", th);
            }
        }
    }
}
