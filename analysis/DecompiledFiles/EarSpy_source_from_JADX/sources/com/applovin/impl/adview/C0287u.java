package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.u */
public abstract class C0287u extends View {

    /* renamed from: a */
    protected final AppLovinSdk f208a;

    /* renamed from: b */
    protected final Context f209b;

    C0287u(AppLovinSdk appLovinSdk, Context context) {
        super(context);
        this.f209b = context;
        this.f208a = appLovinSdk;
    }

    /* renamed from: a */
    public static C0287u m181a(AppLovinSdk appLovinSdk, Context context, C0288v vVar) {
        return vVar.equals(C0288v.WhiteXOnTransparentGrey) ? new C0266al(appLovinSdk, context) : new C0267am(appLovinSdk, context);
    }

    /* renamed from: a */
    public abstract void mo5246a(int i);
}
