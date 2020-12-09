package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.ae */
class C0298ae implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {

    /* renamed from: a */
    final /* synthetic */ C0404z f315a;

    /* renamed from: b */
    private final Activity f316b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinAdDisplayListener f317c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AppLovinAdClickListener f318d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AppLovinAdVideoPlaybackListener f319e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final AppLovinAdRewardListener f320f;

    private C0298ae(C0404z zVar, Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.f315a = zVar;
        this.f317c = appLovinAdDisplayListener;
        this.f318d = appLovinAdClickListener;
        this.f319e = appLovinAdVideoPlaybackListener;
        this.f320f = appLovinAdRewardListener;
        this.f316b = activity;
    }

    /* synthetic */ C0298ae(C0404z zVar, Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener, C0294aa aaVar) {
        this(zVar, activity, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void adClicked(AppLovinAd appLovinAd) {
        if (this.f318d != null) {
            this.f315a.f710e.post(new C0301ah(this, appLovinAd));
        }
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        if (this.f317c != null) {
            this.f317c.adDisplayed(appLovinAd);
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        String str;
        int i;
        String c = this.f315a.mo5721c();
        if (c == null || !this.f315a.f714i) {
            this.f315a.f713h.mo5656a(true);
            if (this.f315a.f714i) {
                str = "network_timeout";
                i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
            } else {
                str = "user_closed_video";
                i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
            }
            C0332bl.m330a().mo5502a(appLovinAd, str);
            if (this.f315a.f714i) {
                this.f315a.mo5717a(c, this.f316b);
            }
            this.f315a.f710e.post(new C0299af(this, appLovinAd, i));
        } else {
            this.f315a.mo5717a(c, this.f316b);
        }
        if (this.f317c != null) {
            this.f315a.f710e.post(new C0300ag(this, appLovinAd));
        }
        this.f315a.f706a.mo5362a().mo5636a((C0342bv) new C0373cz(this.f315a.f706a, appLovinAd), C0365cr.BACKGROUND);
        AppLovinAdImpl unused = this.f315a.f708c = null;
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map map) {
        this.f315a.mo5720b("quota_exceeded");
        if (this.f320f != null) {
            this.f315a.f710e.post(new C0305al(this, appLovinAd, map));
        }
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
        this.f315a.mo5720b("rejected");
        if (this.f320f != null) {
            this.f315a.f710e.post(new C0306am(this, appLovinAd, map));
        }
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
        this.f315a.mo5720b("accepted");
        if (this.f320f != null) {
            this.f315a.f710e.post(new C0304ak(this, appLovinAd, map));
        }
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        this.f315a.mo5720b("network_timeout");
        if (this.f320f != null) {
            this.f315a.f710e.post(new C0307an(this, appLovinAd, i));
        }
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        if (this.f319e != null) {
            this.f315a.f710e.post(new C0302ai(this, appLovinAd));
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        if (this.f319e != null) {
            this.f315a.f710e.post(new C0303aj(this, appLovinAd, d, z));
        }
        boolean unused = this.f315a.f714i = z;
    }
}
