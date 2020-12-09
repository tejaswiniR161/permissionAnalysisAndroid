package com.facebook.ads.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.BannerAdapter;
import com.facebook.ads.internal.adapters.BannerAdapterListener;
import com.facebook.ads.internal.adapters.C0444e;
import com.facebook.ads.internal.adapters.C0460n;
import com.facebook.ads.internal.adapters.C0461o;
import com.facebook.ads.internal.adapters.InterstitialAdapter;
import com.facebook.ads.internal.adapters.InterstitialAdapterListener;
import com.facebook.ads.internal.dto.C0465a;
import com.facebook.ads.internal.dto.C0468c;
import com.facebook.ads.internal.dto.C0469d;
import com.facebook.ads.internal.dto.C0470e;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.server.C0498a;
import com.facebook.ads.internal.server.C0506d;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0531c;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.util.C0553r;
import com.facebook.ads.internal.util.C0555t;
import java.util.HashMap;

/* renamed from: com.facebook.ads.internal.h */
public class C0480h implements C0498a.C0502a {

    /* renamed from: b */
    private static final String f1114b = C0480h.class.getSimpleName();

    /* renamed from: a */
    protected C0433a f1115a;

    /* renamed from: c */
    private final Context f1116c;

    /* renamed from: d */
    private final String f1117d;

    /* renamed from: e */
    private final C0498a f1118e = new C0498a();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Handler f1119f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Runnable f1120g;

    /* renamed from: h */
    private final Runnable f1121h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f1122i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f1123j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile boolean f1124k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public AdAdapter f1125l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View f1126m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C0468c f1127n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public C0470e f1128o;

    /* renamed from: p */
    private C0473e f1129p;

    /* renamed from: q */
    private C0463c f1130q;

    /* renamed from: r */
    private AdSize f1131r;

    /* renamed from: s */
    private int f1132s;

    /* renamed from: t */
    private final C0493c f1133t = new C0493c();

    /* renamed from: u */
    private boolean f1134u;

    /* renamed from: com.facebook.ads.internal.h$a */
    private static final class C0491a extends C0555t<C0480h> {
        public C0491a(C0480h hVar) {
            super(hVar);
        }

        public void run() {
            C0480h hVar = (C0480h) mo6141a();
            if (hVar != null) {
                boolean unused = hVar.f1122i = false;
                hVar.m1041m();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.h$b */
    private static final class C0492b extends C0555t<C0480h> {
        public C0492b(C0480h hVar) {
            super(hVar);
        }

        public void run() {
            C0480h hVar = (C0480h) mo6141a();
            if (hVar != null) {
                hVar.m1045p();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.h$c */
    private class C0493c extends BroadcastReceiver {
        private C0493c() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                C0480h.this.m1046q();
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                C0480h.this.m1045p();
            }
        }
    }

    public C0480h(Context context, String str, C0473e eVar, AdSize adSize, C0463c cVar, int i, boolean z) {
        this.f1116c = context;
        this.f1117d = str;
        this.f1129p = eVar;
        this.f1131r = adSize;
        this.f1130q = cVar;
        this.f1132s = i;
        this.f1118e.mo6039a((C0498a.C0502a) this);
        this.f1119f = new Handler();
        this.f1120g = new C0491a(this);
        this.f1121h = new C0492b(this);
        this.f1123j = z;
        m1032i();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1020a(AdAdapter adAdapter) {
        if (adAdapter != null) {
            adAdapter.onDestroy();
        }
    }

    /* renamed from: i */
    private void m1032i() {
        if (!this.f1123j) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f1116c.registerReceiver(this.f1133t, intentFilter);
            this.f1134u = true;
        }
    }

    /* renamed from: j */
    private void m1035j() {
        if (this.f1134u) {
            try {
                this.f1116c.unregisterReceiver(this.f1133t);
                this.f1134u = false;
            } catch (Exception e) {
                C0531c.m1182a(C0528b.m1179a(e, "Error unregistering screen state receiever"));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m1036k() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Adapter listener must be called on the main thread.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public AdPlacementType m1038l() {
        return this.f1131r == null ? AdPlacementType.NATIVE : this.f1131r == AdSize.INTERSTITIAL ? AdPlacementType.INTERSTITIAL : AdPlacementType.BANNER;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m1041m() {
        this.f1128o = new C0470e(this.f1116c, this.f1117d, this.f1131r, this.f1129p, this.f1130q, this.f1132s, AdSettings.isTestMode(this.f1116c));
        this.f1118e.mo6038a(this.f1116c, this.f1128o);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public synchronized void m1043n() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    C0480h.this.m1044o();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m1044o() {
        C0468c cVar = this.f1127n;
        C0465a c = cVar.mo5985c();
        if (c == null) {
            this.f1115a.mo5767a(AdErrorType.NO_FILL.getAdErrorWrapper(""));
            m1045p();
            return;
        }
        String str = c.f1032b;
        AdAdapter a = C0444e.m850a(str, cVar.mo5982a().mo5986a());
        if (a == null) {
            Log.e(f1114b, "Adapter does not exist: " + str);
            m1043n();
        } else if (m1038l() != a.getPlacementType()) {
            this.f1115a.mo5767a(AdErrorType.INTERNAL_ERROR.getAdErrorWrapper(""));
        } else {
            HashMap hashMap = new HashMap();
            C0469d a2 = cVar.mo5982a();
            hashMap.put("data", c.f1033c);
            hashMap.put("definition", a2);
            if (this.f1128o == null) {
                this.f1115a.mo5767a(AdErrorType.UNKNOWN_ERROR.getAdErrorWrapper("environment is empty"));
            }
            switch (a.getPlacementType()) {
                case INTERSTITIAL:
                    final InterstitialAdapter interstitialAdapter = (InterstitialAdapter) a;
                    final C04876 r1 = new Runnable() {
                        public void run() {
                            C0480h.this.m1020a((AdAdapter) interstitialAdapter);
                            C0480h.this.m1043n();
                        }
                    };
                    this.f1119f.postDelayed(r1, 10000);
                    interstitialAdapter.loadInterstitialAd(this.f1116c, new InterstitialAdapterListener() {
                        public void onInterstitialAdClicked(InterstitialAdapter interstitialAdapter, String str, boolean z) {
                            C0480h.this.m1036k();
                            C0480h.this.f1115a.mo5768b();
                            boolean z2 = !C0553r.m1245a(str);
                            if (z && z2) {
                                Intent intent = new Intent("android.intent.action.VIEW");
                                if (!(C0480h.this.f1128o.f1057d instanceof Activity)) {
                                    intent.addFlags(268435456);
                                }
                                intent.setData(Uri.parse(str));
                                C0480h.this.f1128o.f1057d.startActivity(intent);
                            }
                        }

                        public void onInterstitialAdDismissed(InterstitialAdapter interstitialAdapter) {
                            C0480h.this.m1036k();
                            C0480h.this.f1115a.mo5775e();
                        }

                        public void onInterstitialAdDisplayed(InterstitialAdapter interstitialAdapter) {
                            C0480h.this.m1036k();
                            C0480h.this.f1115a.mo5774d();
                        }

                        public void onInterstitialAdLoaded(InterstitialAdapter interstitialAdapter) {
                            C0480h.this.m1036k();
                            C0480h.this.f1119f.removeCallbacks(r1);
                            AdAdapter unused = C0480h.this.f1125l = interstitialAdapter;
                            C0480h.this.f1115a.mo5765a();
                            C0480h.this.m1045p();
                        }

                        public void onInterstitialError(InterstitialAdapter interstitialAdapter, AdError adError) {
                            C0480h.this.m1036k();
                            C0480h.this.f1119f.removeCallbacks(r1);
                            C0480h.this.m1020a((AdAdapter) interstitialAdapter);
                            C0480h.this.m1043n();
                        }

                        public void onInterstitialLoggingImpression(InterstitialAdapter interstitialAdapter) {
                            C0480h.this.m1036k();
                            C0480h.this.f1115a.mo5769c();
                        }
                    }, hashMap);
                    return;
                case BANNER:
                    final BannerAdapter bannerAdapter = (BannerAdapter) a;
                    final C04854 r12 = new Runnable() {
                        public void run() {
                            C0480h.this.m1020a((AdAdapter) bannerAdapter);
                            C0480h.this.m1043n();
                        }
                    };
                    this.f1119f.postDelayed(r12, 10000);
                    bannerAdapter.loadBannerAd(this.f1116c, this.f1131r, new BannerAdapterListener() {
                        public void onBannerAdClicked(BannerAdapter bannerAdapter) {
                            C0480h.this.m1036k();
                            C0480h.this.f1115a.mo5768b();
                        }

                        public void onBannerAdExpanded(BannerAdapter bannerAdapter) {
                            C0480h.this.m1036k();
                            C0480h.this.m1046q();
                        }

                        public void onBannerAdLoaded(BannerAdapter bannerAdapter, View view) {
                            C0480h.this.m1036k();
                            C0480h.this.f1119f.removeCallbacks(r12);
                            AdAdapter g = C0480h.this.f1125l;
                            AdAdapter unused = C0480h.this.f1125l = bannerAdapter;
                            View unused2 = C0480h.this.f1126m = view;
                            if (!C0480h.this.f1124k) {
                                C0480h.this.f1115a.mo5765a();
                                return;
                            }
                            C0480h.this.f1115a.mo5766a(view);
                            C0480h.this.m1020a(g);
                            C0480h.this.m1045p();
                        }

                        public void onBannerAdMinimized(BannerAdapter bannerAdapter) {
                            C0480h.this.m1036k();
                            C0480h.this.m1045p();
                        }

                        public void onBannerError(BannerAdapter bannerAdapter, AdError adError) {
                            C0480h.this.m1036k();
                            C0480h.this.f1119f.removeCallbacks(r12);
                            C0480h.this.m1020a((AdAdapter) bannerAdapter);
                            C0480h.this.m1043n();
                        }

                        public void onBannerLoggingImpression(BannerAdapter bannerAdapter) {
                            C0480h.this.m1036k();
                            C0480h.this.f1115a.mo5769c();
                        }
                    }, hashMap);
                    return;
                case NATIVE:
                    final C0460n nVar = (C0460n) a;
                    final C04898 r13 = new Runnable() {
                        public void run() {
                            C0480h.this.m1020a((AdAdapter) nVar);
                            C0480h.this.m1043n();
                        }
                    };
                    this.f1119f.postDelayed(r13, 10000);
                    nVar.mo5922a(this.f1116c, new C0461o() {
                        /* renamed from: a */
                        public void mo5973a(C0460n nVar) {
                            C0480h.this.m1036k();
                            C0480h.this.f1119f.removeCallbacks(r13);
                            AdAdapter unused = C0480h.this.f1125l = nVar;
                            C0480h.this.f1115a.mo5765a();
                        }

                        /* renamed from: a */
                        public void mo5974a(C0460n nVar, AdError adError) {
                            C0480h.this.m1036k();
                            C0480h.this.f1119f.removeCallbacks(r13);
                            C0480h.this.m1020a((AdAdapter) nVar);
                            C0480h.this.m1043n();
                        }
                    }, hashMap);
                    return;
                default:
                    Log.e(f1114b, "attempt unexpected adapter type");
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m1045p() {
        if (!this.f1123j && !this.f1122i) {
            switch (m1038l()) {
                case INTERSTITIAL:
                    if (!C0537g.m1210a(this.f1116c)) {
                        this.f1119f.postDelayed(this.f1121h, 1000);
                        break;
                    }
                    break;
                case BANNER:
                    int e = this.f1127n == null ? 1 : this.f1127n.mo5982a().mo5990e();
                    if (this.f1126m != null && !C0537g.m1211a(this.f1116c, this.f1126m, e)) {
                        this.f1119f.postDelayed(this.f1121h, 1000);
                        return;
                    }
                default:
                    return;
            }
            long b = this.f1127n == null ? 30000 : this.f1127n.mo5982a().mo5987b();
            if (b > 0) {
                this.f1119f.postDelayed(this.f1120g, b);
                this.f1122i = true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m1046q() {
        if (this.f1122i) {
            this.f1119f.removeCallbacks(this.f1120g);
            this.f1122i = false;
        }
    }

    /* renamed from: a */
    public C0469d mo6011a() {
        if (this.f1127n == null) {
            return null;
        }
        return this.f1127n.mo5982a();
    }

    /* renamed from: a */
    public void mo6012a(C0433a aVar) {
        this.f1115a = aVar;
    }

    /* renamed from: a */
    public synchronized void mo6013a(final C0462b bVar) {
        this.f1119f.post(new Runnable() {
            public void run() {
                C0480h.this.f1115a.mo5767a(bVar);
                if (!C0480h.this.f1123j && !C0480h.this.f1122i) {
                    switch (bVar.mo5975a().getErrorCode()) {
                        case AdError.NETWORK_ERROR_CODE:
                        case AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE:
                            switch (C04832.f1139a[C0480h.this.m1038l().ordinal()]) {
                                case 2:
                                    C0480h.this.f1119f.postDelayed(C0480h.this.f1120g, 30000);
                                    boolean unused = C0480h.this.f1122i = true;
                                    return;
                                default:
                                    return;
                            }
                        default:
                            return;
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public synchronized void mo6014a(final C0506d dVar) {
        this.f1119f.post(new Runnable() {
            public void run() {
                C0468c b = dVar.mo6046b();
                if (b == null || b.mo5982a() == null) {
                    throw new IllegalStateException("invalid placement in response");
                }
                C0468c unused = C0480h.this.f1127n = b;
                C0480h.this.m1043n();
            }
        });
    }

    /* renamed from: b */
    public void mo6015b() {
        m1041m();
    }

    /* renamed from: c */
    public void mo6016c() {
        if (this.f1125l == null) {
            throw new IllegalStateException("no adapter ready to start");
        } else if (this.f1124k) {
            throw new IllegalStateException("ad already started");
        } else {
            this.f1124k = true;
            switch (this.f1125l.getPlacementType()) {
                case INTERSTITIAL:
                    ((InterstitialAdapter) this.f1125l).show();
                    return;
                case BANNER:
                    if (this.f1126m != null) {
                        this.f1115a.mo5766a(this.f1126m);
                        m1045p();
                        return;
                    }
                    return;
                case NATIVE:
                    C0460n nVar = (C0460n) this.f1125l;
                    if (!nVar.mo5950z()) {
                        throw new IllegalStateException("ad is not ready or already displayed");
                    }
                    this.f1115a.mo5819a(nVar);
                    return;
                default:
                    Log.e(f1114b, "start unexpected adapter type");
                    return;
            }
        }
    }

    /* renamed from: d */
    public void mo6017d() {
        m1035j();
        if (this.f1124k) {
            m1046q();
            m1020a(this.f1125l);
            this.f1126m = null;
            this.f1124k = false;
        }
    }

    /* renamed from: e */
    public void mo6018e() {
        if (this.f1124k) {
            m1046q();
        }
    }

    /* renamed from: f */
    public void mo6019f() {
        if (this.f1124k) {
            m1045p();
        }
    }

    /* renamed from: g */
    public void mo6020g() {
        m1046q();
        m1041m();
    }

    /* renamed from: h */
    public void mo6021h() {
        this.f1123j = true;
        m1046q();
    }
}
