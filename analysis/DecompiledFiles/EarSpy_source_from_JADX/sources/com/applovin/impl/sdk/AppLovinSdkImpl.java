package com.applovin.impl.sdk;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinTargetingData;
import java.io.PrintWriter;
import java.io.StringWriter;

public class AppLovinSdkImpl extends AppLovinSdk {

    /* renamed from: a */
    private String f261a;

    /* renamed from: b */
    private AppLovinSdkSettings f262b;

    /* renamed from: c */
    private Context f263c;

    /* renamed from: d */
    private AppLovinLogger f264d;

    /* renamed from: e */
    private C0364cq f265e;

    /* renamed from: f */
    private C0346bz f266f;

    /* renamed from: g */
    private C0393o f267g;

    /* renamed from: h */
    private C0349cb f268h;

    /* renamed from: i */
    private C0403y f269i;

    /* renamed from: j */
    private C0320b f270j;

    /* renamed from: k */
    private C0322bb f271k;

    /* renamed from: l */
    private C0396r f272l;

    /* renamed from: m */
    private C0391m f273m;

    /* renamed from: n */
    private AppLovinAdServiceImpl f274n;

    /* renamed from: o */
    private C0324bd f275o;

    /* renamed from: p */
    private PostbackServiceImpl f276p;

    /* renamed from: q */
    private EventServiceImpl f277q;

    /* renamed from: r */
    private C0333bm f278r;

    /* renamed from: s */
    private boolean f279s = true;

    /* renamed from: t */
    private boolean f280t = false;

    /* renamed from: u */
    private boolean f281u = false;

    /* renamed from: v */
    private boolean f282v = false;

    /* renamed from: w */
    private boolean f283w = false;

    /* renamed from: h */
    private static boolean m215h() {
        return !Build.VERSION.RELEASE.startsWith("1.") && !Build.VERSION.RELEASE.startsWith("2.0") && !Build.VERSION.RELEASE.startsWith("2.1");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0364cq mo5362a() {
        return this.f265e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo5363a(C0345by byVar) {
        return this.f266f.mo5545a(byVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5364a(AppLovinSdkSettings appLovinSdkSettings) {
        this.f279s = true;
        this.f265e.mo5638a(new C0363cp(this, appLovinSdkSettings), 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5365a(boolean z) {
        this.f279s = false;
        this.f280t = z;
        this.f281u = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0349cb mo5366b() {
        return this.f268h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0320b mo5367c() {
        return this.f270j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0322bb mo5368d() {
        return this.f271k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo5369e() {
        return this.f279s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo5370f() {
        return this.f281u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5371g() {
        this.f266f.mo5551d();
        this.f266f.mo5549b();
        this.f268h.mo5595a();
    }

    public AppLovinAdService getAdService() {
        return this.f274n;
    }

    public Context getApplicationContext() {
        return this.f263c;
    }

    public C0393o getConnectionManager() {
        return this.f267g;
    }

    public C0396r getDataCollector() {
        return this.f272l;
    }

    public AppLovinEventService getEventService() {
        return this.f277q;
    }

    public C0403y getFileManager() {
        return this.f269i;
    }

    public AppLovinLogger getLogger() {
        return this.f264d;
    }

    public AppLovinNativeAdService getNativeAdService() {
        return this.f275o;
    }

    public C0333bm getPersistentPostbackManager() {
        return this.f278r;
    }

    public PostbackServiceImpl getPostbackService() {
        return this.f276p;
    }

    public String getSdkKey() {
        return this.f261a;
    }

    public AppLovinSdkSettings getSettings() {
        return this.f262b;
    }

    public C0346bz getSettingsManager() {
        return this.f266f;
    }

    public AppLovinTargetingData getTargetingData() {
        return this.f273m;
    }

    public boolean hasCriticalErrors() {
        return this.f282v || this.f283w;
    }

    /* access modifiers changed from: protected */
    public void initialize(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.f261a = str;
        this.f262b = appLovinSdkSettings;
        this.f263c = context;
        try {
            C0389k kVar = new C0389k();
            this.f264d = kVar;
            this.f266f = new C0346bz(this);
            this.f265e = new C0364cq(this);
            this.f267g = new C0393o(this);
            this.f268h = new C0349cb(this);
            this.f269i = new C0403y(this);
            this.f272l = new C0396r(this);
            this.f274n = new AppLovinAdServiceImpl(this);
            this.f275o = new C0324bd(this);
            this.f276p = new PostbackServiceImpl(this);
            this.f277q = new EventServiceImpl(this);
            this.f278r = new C0333bm(this);
            this.f270j = new C0320b(this);
            this.f271k = new C0322bb(this);
            this.f273m = new C0391m(this);
            if (!m215h()) {
                this.f282v = true;
                Log.e(AppLovinLogger.SDK_TAG, "Unable to initalize AppLovin SDK: Android SDK version has to be at least level 8");
            }
            if (str == null || str.length() < 1) {
                this.f283w = true;
                Log.e(AppLovinLogger.SDK_TAG, "Unable to find AppLovin SDK key. Please add     meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
                StringWriter stringWriter = new StringWriter();
                new Throwable("").printStackTrace(new PrintWriter(stringWriter));
                Log.e(AppLovinLogger.SDK_TAG, "Called with an invalid SDK key from: " + stringWriter.toString());
            }
            if (!hasCriticalErrors()) {
                kVar.mo5662a(this.f266f);
                if (appLovinSdkSettings instanceof C0316aw) {
                    kVar.mo5663a(((C0316aw) appLovinSdkSettings).mo5457a());
                }
                mo5364a(appLovinSdkSettings);
                return;
            }
            mo5365a(false);
        } catch (Throwable th) {
            Log.e(AppLovinLogger.SDK_TAG, "Failed to load AppLovin SDK, ad serving will be disabled", th);
            mo5365a(false);
        }
    }

    public void initializeSdk() {
    }

    public boolean isEnabled() {
        return this.f280t;
    }

    public void setPluginVersion(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No version specified");
        }
        this.f266f.mo5546a(C0343bw.f446F, str);
        this.f266f.mo5549b();
    }
}
