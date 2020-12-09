package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.C0348ca;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.x */
class C0290x extends Dialog implements C0289w {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Activity f213a;

    /* renamed from: b */
    private final AppLovinSdk f214b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinLogger f215c;

    /* renamed from: d */
    private RelativeLayout f216d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AppLovinAdView f217e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Runnable f218f;

    /* renamed from: g */
    private C0260af f219g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f220h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f221i = false;

    C0290x(AppLovinSdk appLovinSdk, Activity activity) {
        super(activity, 16973840);
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else {
            this.f214b = appLovinSdk;
            this.f215c = appLovinSdk.getLogger();
            this.f213a = activity;
            this.f218f = new C0259ae(this, (C0291y) null);
            this.f217e = new AppLovinAdView(appLovinSdk, AppLovinAdSize.INTERSTITIAL, activity);
            this.f217e.setAutoDestroy(false);
            ((AdViewControllerImpl) this.f217e.getAdViewController()).setParentDialog(new WeakReference(this));
            requestWindowFeature(1);
            try {
                getWindow().setFlags(activity.getWindow().getAttributes().flags, activity.getWindow().getAttributes().flags);
            } catch (Exception e) {
                this.f215c.mo5667e("InterstitialAdDialog", "Set window flags failed.", e);
            }
        }
    }

    /* renamed from: a */
    private int m183a(int i) {
        return AppLovinSdkUtils.dpToPx(this.f213a, i);
    }

    /* renamed from: a */
    private void m185a() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f217e.setLayoutParams(layoutParams);
        this.f216d = new RelativeLayout(this.f213a);
        this.f216d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f216d.setBackgroundColor(-1157627904);
        this.f216d.addView(this.f217e);
        setContentView(this.f216d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m186a(C0288v vVar) {
        int i = 9;
        C0287u a = C0287u.m181a(this.f214b, getContext(), vVar);
        a.setOnClickListener(new C0257ac(this));
        C0348ca caVar = new C0348ca(this.f214b);
        int a2 = m183a(caVar.mo5580l());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(10);
        layoutParams.addRule(caVar.mo5593y() ? 9 : 11);
        a.mo5246a(a2);
        int a3 = m183a(caVar.mo5582n());
        int a4 = m183a(caVar.mo5584p());
        layoutParams.setMargins(a4, a3, a4, a3);
        this.f217e.addView(a, layoutParams);
        a.bringToFront();
        int a5 = m183a(new C0348ca(this.f214b).mo5586r());
        View view = new View(this.f213a);
        view.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a2 + a5, a2 + a5);
        layoutParams2.addRule(10);
        if (!caVar.mo5592x()) {
            i = 11;
        }
        layoutParams2.addRule(i);
        layoutParams2.setMargins(0, a3 - m183a(5), a4 - m183a(5), 0);
        view.setOnClickListener(new C0258ad(this, a));
        this.f217e.addView(view, layoutParams2);
        view.bringToFront();
    }

    /* renamed from: a */
    public void mo5313a(C0260af afVar) {
        this.f217e.setAdDisplayListener(new C0291y(this, afVar));
        this.f217e.setAdClickListener(new C0292z(this, afVar));
        this.f217e.setAdVideoPlaybackListener(new C0255aa(this, afVar));
        this.f219g = afVar;
        afVar.mo5231a(true);
    }

    /* renamed from: a */
    public void mo5314a(AppLovinAd appLovinAd) {
        this.f213a.runOnUiThread(new C0256ab(this, appLovinAd));
    }

    public void dismiss() {
        if (this.f219g != null) {
            this.f219g.mo5237g();
        }
        if (this.f217e != null) {
            this.f217e.destroy();
        }
        this.f219g = null;
        this.f217e = null;
        super.dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m185a();
    }
}
