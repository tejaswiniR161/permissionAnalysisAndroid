package com.applovin.impl.sdk;

import android.app.Activity;
import android.widget.Toast;

/* renamed from: com.applovin.impl.sdk.ao */
public class C0308ao {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f346a;

    /* renamed from: b */
    private final String f347b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Activity f348c;

    public C0308ao(AppLovinSdkImpl appLovinSdkImpl, Activity activity, String str) {
        this.f346a = appLovinSdkImpl;
        this.f347b = str;
        this.f348c = activity;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5442a() {
        this.f348c.runOnUiThread(new C0309ap(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5443a(String str, Throwable th) {
        this.f346a.getLogger().userError("IncentivizedConfirmationManager", "Unable to show incentivized ad reward dialog. Have you defined com.applovin.adview.AppLovinConfirmationActivity in your manifest?", th);
        Toast.makeText(this.f348c, str, 1).show();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo5444b() {
        return this.f347b.equals("accepted") ? (String) this.f346a.mo5363a(C0343bw.f496ac) : this.f347b.equals("quota_exceeded") ? (String) this.f346a.mo5363a(C0343bw.f497ad) : this.f347b.equals("rejected") ? (String) this.f346a.mo5363a(C0343bw.f498ae) : (String) this.f346a.mo5363a(C0343bw.f499af);
    }
}
