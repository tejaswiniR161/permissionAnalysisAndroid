package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

public class PostbackServiceImpl implements AppLovinPostbackService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f305a;

    PostbackServiceImpl(AppLovinSdkImpl appLovinSdkImpl) {
        this.f305a = appLovinSdkImpl;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackAsync(str, (Map) null, appLovinPostbackListener);
    }

    public void dispatchPostbackAsync(String str, Map map, int i, int i2, int i3, AppLovinPostbackListener appLovinPostbackListener) {
        if (AppLovinSdkUtils.isValidString(str)) {
            C0358ck ckVar = new C0358ck(this.f305a, str, map, appLovinPostbackListener);
            ckVar.mo5618b(i2);
            ckVar.mo5617a(i);
            ckVar.mo5619c(i3);
            this.f305a.mo5362a().mo5636a((C0342bv) ckVar, C0365cr.POSTBACKS);
            return;
        }
        this.f305a.getLogger().mo5666e("PostbackService", "Requested a postback dispatch for an empty URL; nothing to do...");
        if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(str, AppLovinErrorCodes.INVALID_URL);
        }
    }

    public void dispatchPostbackAsync(String str, Map map, AppLovinPostbackListener appLovinPostbackListener) {
        if (!AppLovinSdkUtils.isValidString(str)) {
            this.f305a.getLogger().mo5665d("PostbackService", "Ignoring enqueued postback request to invalid URL");
            return;
        }
        this.f305a.mo5362a().mo5636a((C0342bv) new C0358ck(this.f305a, str, map, new C0336bp(this, appLovinPostbackListener)), C0365cr.POSTBACKS);
    }
}
