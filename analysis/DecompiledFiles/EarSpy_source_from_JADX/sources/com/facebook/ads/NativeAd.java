package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.support.p000v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.internal.C0433a;
import com.facebook.ads.internal.C0462b;
import com.facebook.ads.internal.C0463c;
import com.facebook.ads.internal.C0473e;
import com.facebook.ads.internal.C0480h;
import com.facebook.ads.internal.adapters.C0439b;
import com.facebook.ads.internal.adapters.C0441d;
import com.facebook.ads.internal.adapters.C0459m;
import com.facebook.ads.internal.adapters.C0460n;
import com.facebook.ads.internal.dto.C0469d;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0531c;
import com.facebook.ads.internal.util.C0544k;
import com.facebook.ads.internal.util.C0545l;
import com.facebook.ads.internal.util.C0546m;
import com.facebook.ads.internal.view.C0587n;
import com.facebook.ads.internal.view.C0588o;
import com.facebook.ads.internal.view.video.C0589a;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONObject;

public class NativeAd implements C0405Ad {

    /* renamed from: a */
    private static final C0463c f785a = C0463c.ADS;

    /* renamed from: b */
    private static final String f786b = NativeAd.class.getSimpleName();

    /* renamed from: c */
    private static WeakHashMap<View, WeakReference<NativeAd>> f787c = new WeakHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f788d;

    /* renamed from: e */
    private final String f789e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final String f790f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AdListener f791g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImpressionListener f792h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0480h f793i;

    /* renamed from: j */
    private volatile boolean f794j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C0460n f795k;

    /* renamed from: l */
    private C0469d f796l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View f797m;

    /* renamed from: n */
    private List<View> f798n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public View.OnTouchListener f799o;

    /* renamed from: p */
    private C0441d f800p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public C0459m f801q;

    /* renamed from: r */
    private C0423a f802r;

    /* renamed from: s */
    private C0424b f803s;

    /* renamed from: t */
    private C0588o f804t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public NativeAdView.Type f805u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f806v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f807w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f808x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public long f809y;

    public static class Image {

        /* renamed from: a */
        private final String f819a;

        /* renamed from: b */
        private final int f820b;

        /* renamed from: c */
        private final int f821c;

        private Image(String str, int i, int i2) {
            this.f819a = str;
            this.f820b = i;
            this.f821c = i2;
        }

        public static Image fromJSONObject(JSONObject jSONObject) {
            String optString;
            if (jSONObject == null || (optString = jSONObject.optString("url")) == null) {
                return null;
            }
            return new Image(optString, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
        }

        public int getHeight() {
            return this.f821c;
        }

        public String getUrl() {
            return this.f819a;
        }

        public int getWidth() {
            return this.f820b;
        }
    }

    public enum MediaCacheFlag {
        NONE(0),
        ICON(1),
        IMAGE(2);
        
        public static final EnumSet<MediaCacheFlag> ALL = null;

        /* renamed from: a */
        private final long f823a;

        static {
            ALL = EnumSet.allOf(MediaCacheFlag.class);
        }

        private MediaCacheFlag(long j) {
            this.f823a = j;
        }

        public long getCacheFlagValue() {
            return this.f823a;
        }
    }

    public static class Rating {

        /* renamed from: a */
        private final double f824a;

        /* renamed from: b */
        private final double f825b;

        private Rating(double d, double d2) {
            this.f824a = d;
            this.f825b = d2;
        }

        public static Rating fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            double optDouble = jSONObject.optDouble(FirebaseAnalytics.Param.VALUE, 0.0d);
            double optDouble2 = jSONObject.optDouble("scale", 0.0d);
            if (optDouble == 0.0d || optDouble2 == 0.0d) {
                return null;
            }
            return new Rating(optDouble, optDouble2);
        }

        public double getScale() {
            return this.f825b;
        }

        public double getValue() {
            return this.f824a;
        }
    }

    /* renamed from: com.facebook.ads.NativeAd$a */
    private class C0423a implements View.OnClickListener, View.OnTouchListener {

        /* renamed from: b */
        private int f827b;

        /* renamed from: c */
        private int f828c;

        /* renamed from: d */
        private int f829d;

        /* renamed from: e */
        private int f830e;

        /* renamed from: f */
        private float f831f;

        /* renamed from: g */
        private float f832g;

        /* renamed from: h */
        private int f833h;

        /* renamed from: i */
        private int f834i;

        /* renamed from: j */
        private boolean f835j;

        private C0423a() {
        }

        /* renamed from: a */
        public Map<String, Object> mo5832a() {
            HashMap hashMap = new HashMap();
            hashMap.put("clickX", Integer.valueOf(this.f827b));
            hashMap.put("clickY", Integer.valueOf(this.f828c));
            hashMap.put("width", Integer.valueOf(this.f829d));
            hashMap.put("height", Integer.valueOf(this.f830e));
            hashMap.put("adPositionX", Float.valueOf(this.f831f));
            hashMap.put("adPositionY", Float.valueOf(this.f832g));
            hashMap.put("visibleWidth", Integer.valueOf(this.f834i));
            hashMap.put("visibleHeight", Integer.valueOf(this.f833h));
            return hashMap;
        }

        public void onClick(View view) {
            if (NativeAd.this.f791g != null) {
                NativeAd.this.f791g.onAdClicked(NativeAd.this);
            }
            if (!this.f835j) {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            Map<String, Object> a = mo5832a();
            if (NativeAd.this.f805u != null) {
                a.put("nti", String.valueOf(NativeAd.this.f805u.getValue()));
            }
            if (NativeAd.this.f806v) {
                a.put("nhs", String.valueOf(NativeAd.this.f806v));
            }
            NativeAd.this.f795k.mo5926b(a);
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && NativeAd.this.f797m != null) {
                this.f829d = NativeAd.this.f797m.getWidth();
                this.f830e = NativeAd.this.f797m.getHeight();
                int[] iArr = new int[2];
                NativeAd.this.f797m.getLocationInWindow(iArr);
                this.f831f = (float) iArr[0];
                this.f832g = (float) iArr[1];
                Rect rect = new Rect();
                NativeAd.this.f797m.getGlobalVisibleRect(rect);
                this.f834i = rect.width();
                this.f833h = rect.height();
                int[] iArr2 = new int[2];
                view.getLocationInWindow(iArr2);
                this.f827b = (((int) motionEvent.getX()) + iArr2[0]) - iArr[0];
                this.f828c = (iArr2[1] + ((int) motionEvent.getY())) - iArr[1];
                this.f835j = true;
            }
            return NativeAd.this.f799o != null && NativeAd.this.f799o.onTouch(view, motionEvent);
        }
    }

    /* renamed from: com.facebook.ads.NativeAd$b */
    private class C0424b extends BroadcastReceiver {

        /* renamed from: b */
        private boolean f837b;

        private C0424b() {
        }

        /* renamed from: a */
        public void mo5835a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.facebook.ads.native.impression:" + NativeAd.this.f790f);
            intentFilter.addAction("com.facebook.ads.native.click:" + NativeAd.this.f790f);
            LocalBroadcastManager.getInstance(NativeAd.this.f788d).registerReceiver(this, intentFilter);
            this.f837b = true;
        }

        /* renamed from: b */
        public void mo5836b() {
            if (this.f837b) {
                try {
                    LocalBroadcastManager.getInstance(NativeAd.this.f788d).unregisterReceiver(this);
                } catch (Exception e) {
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            String str = intent.getAction().split(":")[0];
            if ("com.facebook.ads.native.impression".equals(str)) {
                NativeAd.this.f801q.mo5905a();
            } else if ("com.facebook.ads.native.click".equals(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("mil", true);
                NativeAd.this.f795k.mo5926b(hashMap);
            }
        }
    }

    /* renamed from: com.facebook.ads.NativeAd$c */
    private class C0425c extends C0439b {
        private C0425c() {
        }

        /* renamed from: a */
        public boolean mo5823a() {
            return false;
        }

        /* renamed from: d */
        public void mo5838d() {
            if (NativeAd.this.f792h != null) {
                NativeAd.this.f792h.onLoggingImpression(NativeAd.this);
            }
            if ((NativeAd.this.f791g instanceof ImpressionListener) && NativeAd.this.f791g != NativeAd.this.f792h) {
                ((ImpressionListener) NativeAd.this.f791g).onLoggingImpression(NativeAd.this);
            }
        }

        /* renamed from: e */
        public void mo5839e() {
        }
    }

    public NativeAd(Context context, C0460n nVar, C0469d dVar) {
        this(context, (String) null);
        this.f796l = dVar;
        this.f794j = true;
        this.f795k = nVar;
    }

    public NativeAd(Context context, String str) {
        this.f790f = UUID.randomUUID().toString();
        this.f798n = new ArrayList();
        this.f788d = context;
        this.f789e = str;
    }

    NativeAd(NativeAd nativeAd) {
        this(nativeAd.f788d, (String) null);
        this.f796l = nativeAd.f796l;
        this.f794j = true;
        this.f795k = nativeAd.f795k;
    }

    /* renamed from: a */
    private void m743a(View view) {
        this.f798n.add(view);
        view.setOnClickListener(this.f802r);
        view.setOnTouchListener(this.f802r);
    }

    /* renamed from: a */
    private void m744a(List<View> list, View view) {
        if (!(view instanceof C0589a) && !(view instanceof AdChoicesView)) {
            list.add(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    m744a(list, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* renamed from: d */
    private int m747d() {
        if (this.f796l != null) {
            return this.f796l.mo5990e();
        }
        if (this.f795k != null) {
            return this.f795k.mo5933i();
        }
        if (this.f793i == null || this.f793i.mo6011a() == null) {
            return 0;
        }
        return this.f793i.mo6011a().mo5991f();
    }

    public static void downloadAndDisplayImage(Image image, ImageView imageView) {
        if (image != null && imageView != null) {
            new C0544k(imageView).execute(new String[]{image.getUrl()});
        }
    }

    /* renamed from: e */
    private int m749e() {
        return this.f796l != null ? this.f796l.mo5992g() : this.f795k != null ? this.f795k.mo5934j() : (this.f793i == null || this.f793i.mo6011a() == null) ? AdError.NETWORK_ERROR_CODE : this.f793i.mo6011a().mo5992g();
    }

    /* renamed from: f */
    private void m752f() {
        for (View next : this.f798n) {
            next.setOnClickListener((View.OnClickListener) null);
            next.setOnTouchListener((View.OnTouchListener) null);
        }
        this.f798n.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m754g() {
        if (this.f795k != null && this.f795k.mo5928d()) {
            this.f803s = new C0424b();
            this.f803s.mo5835a();
            this.f801q = new C0459m(this.f788d, new C0439b() {
                /* renamed from: a */
                public boolean mo5823a() {
                    return true;
                }
            }, this.f795k);
        }
    }

    private int getMinViewabilityPercentage() {
        if (this.f796l != null) {
            return this.f796l.mo5990e();
        }
        if (this.f793i == null || this.f793i.mo6011a() == null) {
            return 1;
        }
        return this.f793i.mo6011a().mo5990e();
    }

    private void logExternalClick(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("eil", true);
        hashMap.put("eil_source", str);
        this.f795k.mo5926b(hashMap);
    }

    private void logExternalImpression() {
        this.f801q.mo5905a();
    }

    private void registerExternalLogReceiver(final String str) {
        this.f801q = new C0459m(this.f788d, new C0439b() {
            /* renamed from: b */
            public boolean mo5824b() {
                return true;
            }

            /* renamed from: c */
            public String mo5825c() {
                return str;
            }
        }, this.f795k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo5790a() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5946v();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5791a(NativeAdView.Type type) {
        this.f805u = type;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5792a(boolean z) {
        this.f806v = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo5793b() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5947w();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5794b(boolean z) {
        this.f807w = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo5795c() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5948x();
    }

    public void destroy() {
        if (this.f803s != null) {
            this.f803s.mo5836b();
            this.f803s = null;
        }
        if (this.f793i != null) {
            this.f793i.mo6017d();
            this.f793i = null;
        }
    }

    public String getAdBody() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5940p();
    }

    public String getAdCallToAction() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5941q();
    }

    public Image getAdChoicesIcon() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5944t();
    }

    public String getAdChoicesLinkUrl() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5945u();
    }

    public Image getAdCoverImage() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5936l();
    }

    public AdExtras getAdExtras() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5949y();
    }

    public Image getAdIcon() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5935k();
    }

    public String getAdSocialContext() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5942r();
    }

    public Rating getAdStarRating() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5943s();
    }

    public String getAdSubtitle() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5939o();
    }

    public String getAdTitle() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5938n();
    }

    public NativeAdViewAttributes getAdViewAttributes() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f795k.mo5937m();
    }

    public String getId() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.f790f;
    }

    public boolean isAdLoaded() {
        return this.f795k != null;
    }

    public boolean isNativeConfigEnabled() {
        return isAdLoaded() && this.f795k.mo5930f();
    }

    public void loadAd() {
        loadAd(EnumSet.of(MediaCacheFlag.NONE));
    }

    public void loadAd(final EnumSet<MediaCacheFlag> enumSet) {
        if (this.f794j) {
            throw new IllegalStateException("loadAd cannot be called more than once");
        }
        this.f809y = System.currentTimeMillis();
        this.f794j = true;
        this.f793i = new C0480h(this.f788d, this.f789e, C0473e.NATIVE_UNKNOWN, (AdSize) null, f785a, 1, true);
        this.f793i.mo6012a((C0433a) new C0433a() {
            /* renamed from: a */
            public void mo5765a() {
                if (NativeAd.this.f793i != null) {
                    NativeAd.this.f793i.mo6016c();
                }
            }

            /* renamed from: a */
            public void mo5819a(final C0460n nVar) {
                C0531c.m1182a(C0528b.m1178a(C0528b.C0530b.LOADING_AD, AdPlacementType.NATIVE, System.currentTimeMillis() - NativeAd.this.f809y, (String) null));
                if (nVar != null) {
                    ArrayList arrayList = new ArrayList(2);
                    if (enumSet.contains(MediaCacheFlag.ICON) && nVar.mo5935k() != null) {
                        arrayList.add(nVar.mo5935k().getUrl());
                    }
                    if (enumSet.contains(MediaCacheFlag.IMAGE) && nVar.mo5936l() != null) {
                        arrayList.add(nVar.mo5936l().getUrl());
                    }
                    C0546m.m1232a(NativeAd.this.f788d, (List<String>) arrayList, (C0545l) new C0545l() {
                        /* renamed from: a */
                        public void mo5820a() {
                            C0460n unused = NativeAd.this.f795k = nVar;
                            NativeAd.this.m754g();
                            if (NativeAd.this.f791g != null) {
                                NativeAd.this.f791g.onAdLoaded(NativeAd.this);
                            }
                        }
                    });
                }
            }

            /* renamed from: a */
            public void mo5767a(C0462b bVar) {
                if (NativeAd.this.f791g != null) {
                    NativeAd.this.f791g.onError(NativeAd.this, bVar.mo5976b());
                }
            }

            /* renamed from: b */
            public void mo5768b() {
                if (NativeAd.this.f791g != null) {
                    NativeAd.this.f791g.onAdClicked(NativeAd.this);
                }
            }

            /* renamed from: c */
            public void mo5769c() {
                throw new IllegalStateException("Native ads manager their own impressions.");
            }
        });
        this.f793i.mo6015b();
    }

    public void registerViewForInteraction(View view) {
        ArrayList arrayList = new ArrayList();
        m744a((List<View>) arrayList, view);
        registerViewForInteraction(view, arrayList);
    }

    public void registerViewForInteraction(View view, List<View> list) {
        if (view == null) {
            throw new IllegalArgumentException("Must provide a View");
        } else if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("Invalid set of clickable views");
        } else if (!isAdLoaded()) {
            Log.e(f786b, "Ad not loaded");
        } else {
            if (this.f797m != null) {
                Log.w(f786b, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
                unregisterView();
            }
            if (f787c.containsKey(view)) {
                Log.w(f786b, "View already registered with a NativeAd. Auto unregistering and proceeding.");
                ((NativeAd) f787c.get(view).get()).unregisterView();
            }
            this.f802r = new C0423a();
            this.f797m = view;
            if (view instanceof ViewGroup) {
                this.f804t = new C0588o(view.getContext(), new C0587n() {
                    /* renamed from: a */
                    public void mo5821a(int i) {
                        if (NativeAd.this.f795k != null) {
                            NativeAd.this.f795k.mo5921a(i);
                        }
                    }
                });
                ((ViewGroup) view).addView(this.f804t);
            }
            for (View a : list) {
                m743a(a);
            }
            this.f801q = new C0459m(this.f788d, new C0425c(), this.f795k);
            this.f801q.mo5969a(list);
            this.f800p = new C0441d(this.f788d, this.f797m, getMinViewabilityPercentage(), new C0441d.C0442a() {
                /* renamed from: a */
                public void mo5822a() {
                    NativeAd.this.f801q.mo5967a(NativeAd.this.f797m);
                    NativeAd.this.f801q.mo5968a(NativeAd.this.f805u);
                    NativeAd.this.f801q.mo5970a(NativeAd.this.f806v);
                    NativeAd.this.f801q.mo5971b(NativeAd.this.f807w);
                    NativeAd.this.f801q.mo5972c(NativeAd.this.f808x);
                    NativeAd.this.f801q.mo5905a();
                }
            });
            this.f800p.mo5911a(m747d());
            this.f800p.mo5913b(m749e());
            this.f800p.mo5910a();
            f787c.put(view, new WeakReference(this));
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f791g = adListener;
    }

    @Deprecated
    public void setImpressionListener(ImpressionListener impressionListener) {
        this.f792h = impressionListener;
    }

    public void setMediaViewAutoplay(boolean z) {
        this.f808x = z;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f799o = onTouchListener;
    }

    public void unregisterView() {
        if (this.f797m != null) {
            if (!f787c.containsKey(this.f797m) || f787c.get(this.f797m).get() != this) {
                throw new IllegalStateException("View not registered with this NativeAd");
            }
            if ((this.f797m instanceof ViewGroup) && this.f804t != null) {
                ((ViewGroup) this.f797m).removeView(this.f804t);
                this.f804t = null;
            }
            f787c.remove(this.f797m);
            m752f();
            this.f797m = null;
            if (this.f800p != null) {
                this.f800p.mo5912b();
                this.f800p = null;
            }
            this.f801q = null;
        }
    }
}
