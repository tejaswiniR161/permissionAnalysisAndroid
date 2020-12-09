package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.C0462b;
import com.facebook.ads.internal.C0463c;
import com.facebook.ads.internal.C0473e;
import com.facebook.ads.internal.C0494i;
import com.facebook.ads.internal.adapters.C0460n;
import com.facebook.ads.internal.dto.C0469d;
import com.facebook.ads.internal.util.C0545l;
import com.facebook.ads.internal.util.C0546m;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class NativeAdsManager {

    /* renamed from: a */
    private static final C0463c f860a = C0463c.ADS;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f861b;

    /* renamed from: c */
    private final String f862c;

    /* renamed from: d */
    private final int f863d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<NativeAd> f864e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f865f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Listener f866g;

    /* renamed from: h */
    private C0494i f867h;

    /* renamed from: i */
    private boolean f868i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f869j = false;

    public interface Listener {
        void onAdError(AdError adError);

        void onAdsLoaded();
    }

    public NativeAdsManager(Context context, String str, int i) {
        this.f861b = context;
        this.f862c = str;
        this.f863d = Math.max(i, 0);
        this.f864e = new ArrayList(i);
    }

    public void disableAutoRefresh() {
        this.f868i = true;
        if (this.f867h != null) {
            this.f867h.mo6034c();
        }
    }

    public int getUniqueNativeAdCount() {
        return this.f864e.size();
    }

    public boolean isLoaded() {
        return this.f869j;
    }

    public void loadAds() {
        loadAds(EnumSet.of(NativeAd.MediaCacheFlag.NONE));
    }

    public void loadAds(final EnumSet<NativeAd.MediaCacheFlag> enumSet) {
        C0473e eVar = C0473e.NATIVE_UNKNOWN;
        int i = this.f863d;
        if (this.f867h != null) {
            this.f867h.mo6033b();
        }
        this.f867h = new C0494i(this.f861b, this.f862c, eVar, (AdSize) null, f860a, i, enumSet);
        if (this.f868i) {
            this.f867h.mo6034c();
        }
        this.f867h.mo6032a((C0494i.C0496a) new C0494i.C0496a() {
            /* renamed from: a */
            public void mo5872a(C0462b bVar) {
                if (NativeAdsManager.this.f866g != null) {
                    NativeAdsManager.this.f866g.onAdError(bVar.mo5976b());
                }
            }

            /* renamed from: a */
            public void mo5873a(List<C0460n> list) {
                final NativeAd[] nativeAdArr = new NativeAd[list.size()];
                final int[] iArr = {0};
                for (final int i = 0; i < list.size(); i++) {
                    C0460n nVar = list.get(i);
                    ArrayList arrayList = new ArrayList(2);
                    if (enumSet.contains(NativeAd.MediaCacheFlag.ICON) && nVar.mo5935k() != null) {
                        arrayList.add(nVar.mo5935k().getUrl());
                    }
                    if (enumSet.contains(NativeAd.MediaCacheFlag.IMAGE) && nVar.mo5936l() != null) {
                        arrayList.add(nVar.mo5936l().getUrl());
                    }
                    final List<C0460n> list2 = list;
                    C0546m.m1232a(NativeAdsManager.this.f861b, (List<String>) arrayList, (C0545l) new C0545l() {
                        /* renamed from: a */
                        public void mo5820a() {
                            nativeAdArr[i] = new NativeAd(NativeAdsManager.this.f861b, (C0460n) list2.get(i), (C0469d) null);
                            int[] iArr = iArr;
                            iArr[0] = iArr[0] + 1;
                            if (iArr[0] == list2.size()) {
                                boolean unused = NativeAdsManager.this.f869j = true;
                                NativeAdsManager.this.f864e.clear();
                                int unused2 = NativeAdsManager.this.f865f = 0;
                                for (NativeAd nativeAd : nativeAdArr) {
                                    if (nativeAd != null) {
                                        NativeAdsManager.this.f864e.add(nativeAd);
                                    }
                                }
                                if (NativeAdsManager.this.f866g != null) {
                                    NativeAdsManager.this.f866g.onAdsLoaded();
                                }
                            }
                        }
                    });
                }
            }
        });
        this.f867h.mo6031a();
    }

    public NativeAd nextNativeAd() {
        if (this.f864e.size() == 0) {
            return null;
        }
        int i = this.f865f;
        this.f865f = i + 1;
        NativeAd nativeAd = this.f864e.get(i % this.f864e.size());
        return i >= this.f864e.size() ? new NativeAd(nativeAd) : nativeAd;
    }

    public void setListener(Listener listener) {
        this.f866g = listener;
    }
}
