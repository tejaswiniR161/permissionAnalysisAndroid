package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.RelativeLayout;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.ClickTrackingOverlayView;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C0348ca;
import com.applovin.impl.sdk.C0350cc;
import com.applovin.impl.sdk.C0382dh;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

public class AdViewControllerImpl implements AdViewController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f84a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AppLovinSdk f85b;

    /* renamed from: c */
    private AppLovinAdService f86c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppLovinLogger f87d;

    /* renamed from: e */
    private AppLovinAdSize f88e;

    /* renamed from: f */
    private C0284r f89f;

    /* renamed from: g */
    private C0278l f90g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0281o f91h;

    /* renamed from: i */
    private AppLovinAd f92i;

    /* renamed from: j */
    private Runnable f93j;

    /* renamed from: k */
    private Runnable f94k;

    /* renamed from: l */
    private Runnable f95l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public volatile AppLovinAd f96m = null;

    /* renamed from: n */
    private ClickTrackingOverlayView f97n = null;

    /* renamed from: o */
    private WeakReference f98o = null;

    /* renamed from: p */
    private final AtomicReference f99p = new AtomicReference();

    /* renamed from: q */
    private volatile boolean f100q = false;

    /* renamed from: r */
    private volatile boolean f101r = true;

    /* renamed from: s */
    private volatile boolean f102s = false;

    /* renamed from: t */
    private volatile boolean f103t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public volatile AppLovinAdLoadListener f104u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public volatile AppLovinAdDisplayListener f105v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public volatile AppLovinAdVideoPlaybackListener f106w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public volatile AppLovinAdClickListener f107x;

    /* renamed from: y */
    private volatile boolean f108y;

    /* renamed from: a */
    private void m97a(ViewGroup viewGroup, AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No ad size specified");
        } else if (!(context instanceof Activity)) {
            throw new IllegalArgumentException("Specified context is not an activity");
        } else {
            this.f85b = appLovinSdk;
            this.f86c = appLovinSdk.getAdService();
            this.f87d = appLovinSdk.getLogger();
            this.f88e = appLovinAdSize;
            this.f84a = (Activity) context;
            this.f92i = C0382dh.m581a();
            this.f89f = new C0284r(this, appLovinSdk);
            this.f95l = new C0272f(this, (C0254a) null);
            this.f93j = new C0277k(this, (C0254a) null);
            this.f94k = new C0275i(this, (C0254a) null);
            this.f90g = new C0278l(this, appLovinSdk);
            if (m100a(context)) {
                this.f91h = m101b();
                viewGroup.setBackgroundColor(0);
                viewGroup.addView(this.f91h);
                m103b(this.f91h, appLovinAdSize);
                this.f91h.setVisibility(8);
                m99a((Runnable) new C0276j(this, (C0254a) null));
                this.f100q = true;
                return;
            }
            this.f87d.userError("AppLovinAdView", "Web view database is corrupt, AdView not loaded");
        }
    }

    /* renamed from: a */
    private void m98a(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, Uri uri) {
        if (this.f97n == null) {
            this.f87d.mo5665d("AppLovinAdView", "Creating and rendering click overlay");
            this.f97n = new ClickTrackingOverlayView(appLovinAdView.getContext(), this.f85b);
            this.f97n.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            appLovinAdView.addView(this.f97n);
            appLovinAdView.bringChildToFront(this.f97n);
            ((AppLovinAdServiceImpl) this.f86c).trackForegroundClick(appLovinAd, appLovinAdView, this, uri);
            return;
        }
        this.f87d.mo5665d("AppLovinAdView", "Skipping click overlay rendering because it already exists");
    }

    /* renamed from: a */
    private void m99a(Runnable runnable) {
        this.f84a.runOnUiThread(runnable);
    }

    /* renamed from: a */
    private static boolean m100a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                return true;
            }
            WebViewDatabase instance = WebViewDatabase.getInstance(context);
            Method declaredMethod = WebViewDatabase.class.getDeclaredMethod("getCacheTotalSize", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(instance, new Object[0]);
            return true;
        } catch (NoSuchMethodException e) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e);
            return true;
        } catch (IllegalArgumentException e2) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e2);
            return true;
        } catch (IllegalAccessException e3) {
            Log.e("AppLovinAdView", "Error invoking getCacheTotalSize()", e3);
            return true;
        } catch (InvocationTargetException e4) {
            Log.e("AppLovinAdView", "getCacheTotalSize() reported exception", e4);
            return false;
        } catch (Throwable th) {
            Log.e("AppLovinAdView", "Unexpected error while checking DB state", th);
            return false;
        }
    }

    /* renamed from: b */
    private C0281o m101b() {
        C0281o oVar = new C0281o(this.f89f, this.f85b, this.f84a);
        oVar.setBackgroundColor(0);
        oVar.setWillNotCacheDrawing(false);
        if (new C0348ca(this.f85b).mo5562F() && Build.VERSION.SDK_INT >= 19) {
            oVar.setLayerType(2, (Paint) null);
        }
        return oVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m103b(View view, AppLovinAdSize appLovinAdSize) {
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        int applyDimension = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
        int applyDimension2 = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.width = applyDimension;
        layoutParams.height = applyDimension2;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        }
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5210a() {
        m99a(this.f95l);
        m99a((Runnable) new C0274h(this, this.f96m));
        this.f96m = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5211a(int i) {
        if (!this.f102s) {
            this.f86c.addAdUpdateListener(this.f90g, this.f88e);
            m99a(this.f95l);
        }
        m99a((Runnable) new C0268b(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5212a(AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            this.f103t = true;
            if (!this.f102s) {
                this.f86c.addAdUpdateListener(this.f90g, this.f88e);
                renderAd(appLovinAd);
            } else {
                this.f99p.set(appLovinAd);
                this.f87d.mo5665d("AppLovinAdView", "Ad view has paused when an ad was recieved, ad saved for later");
            }
            m99a((Runnable) new C0254a(this, appLovinAd));
            return;
        }
        this.f87d.mo5666e("AppLovinAdView", "No provided when to the view controller");
        mo5211a(-1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5213a(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri) {
        AppLovinAdServiceImpl appLovinAdServiceImpl = (AppLovinAdServiceImpl) this.f86c;
        if (!new C0348ca(this.f85b).mo5564H() || uri == null) {
            appLovinAdServiceImpl.trackClickOn(appLovinAd, appLovinAdView, this, uri);
        } else {
            m98a(appLovinAd, appLovinAdView, uri);
        }
        m99a((Runnable) new C0273g(this, appLovinAd));
    }

    public void destroy() {
        if (this.f86c != null) {
            this.f86c.removeAdUpdateListener(this.f90g, getSize());
        }
        if (this.f91h != null) {
            try {
                this.f91h.removeAllViews();
                this.f91h.destroy();
            } catch (Throwable th) {
                this.f87d.mo5672w("AppLovinAdView", "Unable to destroy ad view", th);
            }
        }
        this.f102s = true;
    }

    public void dismissInterstitialIfRequired() {
        C0290x xVar;
        if (!new C0348ca(this.f85b).mo5568L()) {
            return;
        }
        if (this.f84a != null && (this.f84a instanceof AppLovinInterstitialActivity)) {
            ((AppLovinInterstitialActivity) this.f84a).dismiss();
        } else if (this.f98o != null && (xVar = (C0290x) this.f98o.get()) != null) {
            xVar.dismiss();
        }
    }

    public AppLovinAdSize getSize() {
        return this.f88e;
    }

    public void initializeAdView(ViewGroup viewGroup, Context context, AppLovinAdSize appLovinAdSize, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context == null) {
            Log.e(AppLovinLogger.SDK_TAG, "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else {
            if (appLovinAdSize == null && (appLovinAdSize = C0279m.m149a(attributeSet)) == null) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            }
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
                m97a(viewGroup, appLovinSdk, appLovinAdSize, context);
                if (C0279m.m150b(attributeSet)) {
                    loadNextAd();
                }
            }
        }
    }

    public boolean isAdReadyToDisplay() {
        return this.f85b.getAdService().hasPreloadedAd(this.f88e);
    }

    public boolean isAutoDestroy() {
        return this.f101r;
    }

    public boolean isForegroundClickInvalidated() {
        return this.f108y;
    }

    public void loadNextAd() {
        if (this.f85b == null || this.f90g == null || this.f84a == null || !this.f100q) {
            Log.i(AppLovinLogger.SDK_TAG, "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.f86c.loadNextAd(this.f88e, this.f90g);
        }
    }

    public void onAdHtmlLoaded(WebView webView) {
        if (this.f96m != null) {
            webView.setVisibility(0);
            try {
                if (this.f105v != null) {
                    this.f105v.adDisplayed(this.f96m);
                }
            } catch (Throwable th) {
                this.f87d.userError("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }

    public void onDetachedFromWindow() {
        if (this.f100q) {
            m99a((Runnable) new C0274h(this, this.f96m));
            if (this.f101r) {
                destroy();
            }
        }
    }

    public void onVisibilityChanged(int i) {
        if (!this.f100q || !this.f101r) {
            return;
        }
        if (i == 8 || i == 4) {
            pause();
        } else if (i == 0) {
            resume();
        }
    }

    public void pause() {
        if (this.f100q) {
            this.f86c.removeAdUpdateListener(this.f90g, getSize());
            AppLovinAd appLovinAd = this.f96m;
            renderAd(this.f92i);
            if (appLovinAd != null) {
                this.f99p.set(appLovinAd);
            }
            this.f102s = true;
        }
    }

    public void removeClickTrackingOverlay() {
        if (this.f97n != null) {
            ViewParent parent = this.f97n.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f97n);
                this.f97n = null;
                return;
            }
            return;
        }
        this.f87d.mo5665d("AppLovinAdView", "Asked to remove an overlay when none existed. Skipping...");
    }

    public void renderAd(AppLovinAd appLovinAd) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (!this.f100q) {
            Log.i(AppLovinLogger.SDK_TAG, "Unable to render ad: AppLovinAdView is not initialized.");
        } else if (appLovinAd != this.f96m) {
            this.f87d.mo5665d("AppLovinAdView", "Rendering ad # " + appLovinAd.getAdIdNumber() + " (" + appLovinAd.getSize() + ")");
            m99a((Runnable) new C0274h(this, this.f96m));
            this.f99p.set((Object) null);
            this.f96m = appLovinAd;
            if (appLovinAd.getSize() == this.f88e) {
                m99a(this.f93j);
            } else if (appLovinAd.getSize() == AppLovinAdSize.INTERSTITIAL) {
                m99a(this.f95l);
                m99a(this.f94k);
            }
            new C0350cc(this.f85b).mo5604a();
        } else {
            this.f87d.mo5671w("AppLovinAdView", "Ad # " + appLovinAd.getAdIdNumber() + " is already showing, ignoring");
        }
    }

    public void resume() {
        if (this.f100q) {
            if (this.f103t) {
                this.f86c.addAdUpdateListener(this.f90g, this.f88e);
            }
            AppLovinAd appLovinAd = (AppLovinAd) this.f99p.getAndSet((Object) null);
            if (appLovinAd != null) {
                renderAd(appLovinAd);
            }
            this.f102s = false;
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f107x = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f105v = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f104u = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f106w = appLovinAdVideoPlaybackListener;
    }

    public void setAutoDestroy(boolean z) {
        this.f101r = z;
    }

    public void setIsForegroundClickInvalidated(boolean z) {
        this.f108y = z;
    }

    public void setParentDialog(WeakReference weakReference) {
        this.f98o = weakReference;
    }
}
