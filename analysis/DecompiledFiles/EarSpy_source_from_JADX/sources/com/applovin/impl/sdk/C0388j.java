package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.j */
class C0388j extends C0342bv {

    /* renamed from: a */
    final /* synthetic */ AppLovinAdServiceImpl f671a;

    /* renamed from: b */
    private final AppLovinAdSize f672b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0388j(AppLovinAdServiceImpl appLovinAdServiceImpl, AppLovinAdSize appLovinAdSize) {
        super("UpdateAdTask", appLovinAdServiceImpl.f257a);
        this.f671a = appLovinAdServiceImpl;
        this.f672b = appLovinAdSize;
    }

    public void run() {
        boolean z = true;
        C0387i iVar = (C0387i) ((Map) this.f671a.f260d.get(AppLovinAdType.REGULAR)).get(this.f672b);
        synchronized (iVar.f665b) {
            boolean a = this.f671a.m205a(this.f672b);
            boolean e = this.f671a.m203a();
            boolean z2 = !iVar.f669f.isEmpty();
            if (System.currentTimeMillis() <= iVar.f667d) {
                z = false;
            }
            if (a && z2 && z && e && !iVar.f668e) {
                iVar.f668e = true;
                this.f671a.m202a(this.f672b, AppLovinAdType.REGULAR, new C0386h(this.f671a, iVar, (C0383e) null));
            }
        }
    }
}
