package com.applovin.impl.sdk;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;

public class AppLovinAdServiceImpl implements AppLovinAdService {
    public static String URI_NO_OP = "/adservice/no_op";
    public static String URI_TRACK_CLICK_IMMEDIATELY = "/adservice/track_click_now";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f257a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinLogger f258b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f259c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Map f260d;

    AppLovinAdServiceImpl(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f257a = appLovinSdkImpl;
        this.f258b = appLovinSdkImpl.getLogger();
        this.f259c = new Handler(Looper.getMainLooper());
        this.f260d = new HashMap(2);
        for (AppLovinAdType put : AppLovinAdType.allTypes()) {
            this.f260d.put(put, new HashMap());
        }
        ((Map) this.f260d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.BANNER, new C0387i(AppLovinAdSize.BANNER, (C0383e) null));
        ((Map) this.f260d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.MREC, new C0387i(AppLovinAdSize.MREC, (C0383e) null));
        ((Map) this.f260d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.INTERSTITIAL, new C0387i(AppLovinAdSize.INTERSTITIAL, (C0383e) null));
        ((Map) this.f260d.get(AppLovinAdType.REGULAR)).put(AppLovinAdSize.LEADER, new C0387i(AppLovinAdSize.LEADER, (C0383e) null));
        ((Map) this.f260d.get(AppLovinAdType.INCENTIVIZED)).put(AppLovinAdSize.INTERSTITIAL, new C0387i(AppLovinAdSize.INTERSTITIAL, (C0383e) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m199a(Uri uri, AppLovinAdImpl appLovinAdImpl, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl) {
        adViewControllerImpl.removeClickTrackingOverlay();
        expireAdLoadState(appLovinAdImpl);
        AppLovinSdkUtils.openUri(appLovinAdView.getContext(), uri, this.f257a);
        adViewControllerImpl.dismissInterstitialIfRequired();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m202a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, AppLovinAdLoadListener appLovinAdLoadListener) {
        C0347c cVar = new C0347c(appLovinAdSize, appLovinAdType);
        AppLovinAd appLovinAd = (AppLovinAd) this.f257a.mo5367c().mo5466b(cVar);
        if (appLovinAd != null) {
            this.f258b.mo5665d("AppLovinAdService", "Using pre-loaded ad: " + appLovinAd + " for size " + appLovinAdSize + " and type " + appLovinAdType);
            appLovinAdLoadListener.adReceived(appLovinAd);
        } else {
            this.f257a.mo5362a().mo5636a((C0342bv) new C0360cm(appLovinAdSize, appLovinAdType, appLovinAdLoadListener, this.f257a), C0365cr.MAIN);
        }
        this.f257a.mo5367c().mo5471f(cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m203a() {
        return ((PowerManager) this.f257a.getApplicationContext().getSystemService("power")).isScreenOn();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m205a(AppLovinAdSize appLovinAdSize) {
        if (appLovinAdSize == AppLovinAdSize.BANNER) {
            return ((Boolean) this.f257a.mo5363a(C0343bw.f568z)).booleanValue();
        }
        if (appLovinAdSize == AppLovinAdSize.MREC) {
            return ((Boolean) this.f257a.mo5363a(C0343bw.f442B)).booleanValue();
        }
        if (appLovinAdSize == AppLovinAdSize.LEADER) {
            return ((Boolean) this.f257a.mo5363a(C0343bw.f444D)).booleanValue();
        }
        return false;
    }

    /* renamed from: a */
    private boolean m206a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        boolean z = true;
        if (!((Boolean) this.f257a.mo5363a(C0343bw.f447G)).booleanValue()) {
            return false;
        }
        if (appLovinAdType.equals(AppLovinAdType.INCENTIVIZED)) {
            return ((Boolean) this.f257a.mo5363a(C0343bw.f471aD)).booleanValue() && ((Boolean) this.f257a.mo5363a(C0343bw.f451K)).booleanValue();
        } else if (!appLovinAdSize.equals(AppLovinAdSize.INTERSTITIAL)) {
            return false;
        } else {
            if (!((Boolean) this.f257a.mo5363a(C0343bw.f472aE)).booleanValue() || !((String) this.f257a.mo5363a(C0343bw.f450J)).contains(AppLovinAdSize.INTERSTITIAL.getLabel())) {
                z = false;
            }
            return z;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public long m208b(AppLovinAdSize appLovinAdSize) {
        if (appLovinAdSize == AppLovinAdSize.BANNER) {
            return ((Long) this.f257a.mo5363a(C0343bw.f441A)).longValue();
        }
        if (appLovinAdSize == AppLovinAdSize.MREC) {
            return ((Long) this.f257a.mo5363a(C0343bw.f443C)).longValue();
        }
        if (appLovinAdSize == AppLovinAdSize.LEADER) {
            return ((Long) this.f257a.mo5363a(C0343bw.f445E)).longValue();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m212c(AppLovinAdSize appLovinAdSize) {
        long b = m208b(appLovinAdSize);
        if (b > 0) {
            this.f257a.mo5362a().mo5637a((C0342bv) new C0388j(this, appLovinAdSize), C0365cr.MAIN, (b + 2) * 1000);
        }
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener) {
        addAdUpdateListener(appLovinAdUpdateListener, AppLovinAdSize.BANNER);
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
        boolean z;
        if (appLovinAdUpdateListener == null) {
            throw new IllegalArgumentException("No ad listener specified");
        }
        C0387i iVar = (C0387i) ((Map) this.f260d.get(AppLovinAdType.REGULAR)).get(appLovinAdSize);
        synchronized (iVar.f665b) {
            if (!iVar.f669f.contains(appLovinAdUpdateListener)) {
                iVar.f669f.add(appLovinAdUpdateListener);
                z = true;
                this.f258b.mo5665d("AppLovinAdService", "Added update listener: " + appLovinAdUpdateListener);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f257a.mo5362a().mo5636a((C0342bv) new C0388j(this, appLovinAdSize), C0365cr.MAIN);
        }
    }

    public void expireAdLoadState(AppLovinAd appLovinAd) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        C0387i iVar = (C0387i) ((Map) this.f260d.get(appLovinAdImpl.getType())).get(appLovinAdImpl.getSize());
        synchronized (iVar.f665b) {
            iVar.f666c = null;
            iVar.f667d = 0;
        }
    }

    public boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize) {
        return this.f257a.mo5367c().mo5470e(new C0347c(appLovinAdSize, AppLovinAdType.REGULAR));
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        loadNextAd(appLovinAdSize, AppLovinAdType.REGULAR, appLovinAdLoadListener);
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinAd appLovinAd;
        boolean z = true;
        if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No ad size specified");
        } else if (appLovinAdLoadListener == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (appLovinAdType == null) {
            throw new IllegalArgumentException("No ad type specificed");
        } else {
            if (appLovinAdSize.equals(AppLovinAdSize.BANNER) || appLovinAdSize.equals(AppLovinAdSize.MREC) || appLovinAdSize.equals(AppLovinAdSize.LEADER)) {
                this.f257a.getLogger().userError("AppLovinAdService", "Banners, MRecs and Leaderboards are deprecated and will be removed in a future SDK version!");
            }
            C0387i iVar = (C0387i) ((Map) this.f260d.get(appLovinAdType)).get(appLovinAdSize);
            synchronized (iVar.f665b) {
                if (System.currentTimeMillis() <= iVar.f667d) {
                    z = false;
                }
                if (iVar.f666c == null || z) {
                    this.f258b.mo5665d("AppLovinAdService", "Loading next ad...");
                    iVar.f670g.add(appLovinAdLoadListener);
                    if (!iVar.f668e) {
                        iVar.f668e = true;
                        C0386h hVar = new C0386h(this, (C0387i) ((Map) this.f260d.get(appLovinAdType)).get(appLovinAdSize), (C0383e) null);
                        if (!m206a(appLovinAdSize, appLovinAdType)) {
                            this.f258b.mo5665d("AppLovinAdService", "Task merge not necessary.");
                            m202a(appLovinAdSize, appLovinAdType, hVar);
                        } else if (this.f257a.mo5367c().mo5465a(new C0347c(appLovinAdSize, appLovinAdType), (Object) hVar)) {
                            this.f258b.mo5665d("AppLovinAdService", "Attaching load listener to initial preload task...");
                            appLovinAd = null;
                        } else {
                            this.f258b.mo5665d("AppLovinAdService", "Skipped attach of initial preload callback.");
                            m202a(appLovinAdSize, appLovinAdType, hVar);
                            appLovinAd = null;
                        }
                    }
                    appLovinAd = null;
                } else {
                    appLovinAd = iVar.f666c;
                }
            }
            if (appLovinAd != null) {
                appLovinAdLoadListener.adReceived(appLovinAd);
            }
        }
    }

    public void preloadAd(AppLovinAdSize appLovinAdSize) {
        this.f257a.mo5367c().mo5471f(new C0347c(appLovinAdSize, AppLovinAdType.REGULAR));
    }

    public void removeAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
        if (appLovinAdUpdateListener != null) {
            C0387i iVar = (C0387i) ((Map) this.f260d.get(AppLovinAdType.REGULAR)).get(appLovinAdSize);
            synchronized (iVar.f665b) {
                iVar.f669f.remove(appLovinAdUpdateListener);
            }
            this.f258b.mo5665d("AppLovinAdService", "Removed update listener: " + appLovinAdUpdateListener);
        }
    }

    public void trackClickOn(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        String supplementalClickTrackingUrl = appLovinAdImpl.getSupplementalClickTrackingUrl();
        if (AppLovinSdkUtils.isValidString(supplementalClickTrackingUrl)) {
            this.f257a.getPersistentPostbackManager().mo5506a(supplementalClickTrackingUrl, (Map) null);
        }
        m199a(uri, appLovinAdImpl, appLovinAdView, adViewControllerImpl);
    }

    public void trackForegroundClick(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        this.f258b.mo5665d("AppLovinAdService", "Tracking foreground click on an ad...");
        int intValue = ((Integer) this.f257a.mo5363a(C0343bw.f536bp)).intValue();
        int intValue2 = ((Integer) this.f257a.mo5363a(C0343bw.f537bq)).intValue();
        int intValue3 = ((Integer) this.f257a.mo5363a(C0343bw.f538br)).intValue();
        this.f257a.getPostbackService().dispatchPostbackAsync(((AppLovinAdImpl) appLovinAd).getSupplementalClickTrackingUrl(), (Map) null, intValue, intValue2, intValue3, new C0383e(this, adViewControllerImpl, uri, (AppLovinAdImpl) appLovinAd, appLovinAdView));
    }
}
