package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.ck */
public class C0358ck extends C0342bv {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f590a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map f591b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinPostbackListener f592c;

    /* renamed from: d */
    private int f593d;

    /* renamed from: i */
    private int f594i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f595j = -1;

    public C0358ck(AppLovinSdkImpl appLovinSdkImpl, String str, Map map, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", appLovinSdkImpl);
        this.f590a = str;
        this.f592c = appLovinPostbackListener;
        this.f591b = map;
    }

    /* renamed from: a */
    public void mo5617a(int i) {
        this.f593d = i;
    }

    /* renamed from: b */
    public void mo5618b(int i) {
        this.f594i = i;
    }

    /* renamed from: c */
    public void mo5619c(int i) {
        this.f595j = i;
    }

    public void run() {
        if (!AppLovinSdkUtils.isValidString(this.f590a)) {
            this.f438f.getLogger().mo5668i("TaskDispatchPostback", "Requested URL is not valid; nothing to do...");
            this.f592c.onPostbackFailure(this.f590a, AppLovinErrorCodes.INVALID_URL);
            return;
        }
        C0359cl clVar = new C0359cl(this, "RepeatTaskDispatchPostback", this.f593d < 0 ? ((Integer) this.f438f.mo5363a(C0343bw.f474aG)).intValue() : this.f593d, this.f438f);
        clVar.mo5647a((long) this.f594i);
        clVar.run();
    }
}
