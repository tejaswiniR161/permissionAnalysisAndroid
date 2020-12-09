package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.bq */
abstract class C0337bq implements C0401w, AppLovinNativeAdLoadListener {

    /* renamed from: a */
    protected final AppLovinSdkImpl f420a;

    /* renamed from: b */
    protected final AppLovinLogger f421b;

    /* renamed from: c */
    protected final Object f422c = new Object();

    /* renamed from: d */
    protected final Map f423d = mo5461a();

    /* renamed from: e */
    protected final Map f424e = new HashMap();

    /* renamed from: f */
    protected final Set f425f = new HashSet();

    C0337bq(AppLovinSdkImpl appLovinSdkImpl) {
        this.f420a = appLovinSdkImpl;
        this.f421b = appLovinSdkImpl.getLogger();
    }

    /* renamed from: h */
    private C0338br m354h(C0347c cVar) {
        return (C0338br) this.f423d.get(cVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C0342bv mo5459a(C0347c cVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C0347c mo5460a(C0318ay ayVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract Map mo5461a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo5463a(Object obj, C0318ay ayVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo5464a(Object obj, C0347c cVar, int i);

    /* renamed from: a */
    public boolean mo5465a(C0347c cVar, Object obj) {
        boolean z;
        synchronized (this.f422c) {
            if (!mo5520g(cVar)) {
                mo5467b(cVar, obj);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public C0318ay mo5466b(C0347c cVar) {
        C0318ay e;
        synchronized (this.f422c) {
            e = m354h(cVar).mo5526e();
        }
        return e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5517b(C0318ay ayVar) {
        mo5471f(mo5460a(ayVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5518b(C0347c cVar, int i) {
        Object remove;
        this.f421b.mo5665d("PreloadManager", "Failed to pre-load an ad of spec " + cVar + ", error code " + i);
        synchronized (this.f422c) {
            remove = this.f424e.remove(cVar);
            this.f425f.add(cVar);
        }
        if (remove != null) {
            try {
                mo5464a(remove, cVar, i);
            } catch (Throwable th) {
                this.f420a.getLogger().userError("PreloadManager", "Encountered exception while invoking user callback", th);
            }
        }
    }

    /* renamed from: b */
    public void mo5467b(C0347c cVar, Object obj) {
        synchronized (this.f422c) {
            if (this.f424e.containsKey(cVar)) {
                this.f421b.mo5671w("PreloadManager", "Possibly missing prior registered preload callback.");
            }
            this.f424e.put(cVar, obj);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5519c(C0318ay ayVar) {
        Object obj;
        synchronized (this.f422c) {
            C0347c a = mo5460a(ayVar);
            obj = this.f424e.get(a);
            this.f424e.remove(a);
            this.f425f.add(a);
            if (obj == null) {
                m354h(a).mo5522a(ayVar);
                this.f421b.mo5665d("PreloadManager", "Ad enqueued: " + ayVar);
            } else {
                this.f421b.mo5665d("PreloadManager", "Additional callback found, skipping enqueue.");
            }
        }
        if (obj != null) {
            this.f421b.mo5665d("PreloadManager", "Called additional callback regarding " + ayVar);
            try {
                mo5463a(obj, ayVar);
            } catch (Throwable th) {
                this.f420a.getLogger().userError("PreloadManager", "Encountered throwable while notifying user callback", th);
            }
            mo5517b(ayVar);
        }
        this.f421b.mo5665d("PreloadManager", "Pulled ad from network and saved to preload cache: " + ayVar);
    }

    /* renamed from: c */
    public boolean mo5468c(C0347c cVar) {
        boolean c;
        synchronized (this.f422c) {
            c = m354h(cVar).mo5524c();
        }
        return c;
    }

    /* renamed from: d */
    public void mo5469d(C0347c cVar) {
        int b;
        synchronized (this.f422c) {
            C0338br h = m354h(cVar);
            b = h.mo5523b() - h.mo5521a();
        }
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                mo5471f(cVar);
            }
        }
    }

    /* renamed from: e */
    public boolean mo5470e(C0347c cVar) {
        boolean z;
        synchronized (this.f422c) {
            z = !m354h(cVar).mo5525d();
        }
        return z;
    }

    /* renamed from: f */
    public void mo5471f(C0347c cVar) {
        if (((Boolean) this.f420a.mo5363a(C0343bw.f447G)).booleanValue() && !mo5468c(cVar)) {
            this.f421b.mo5665d("PreloadManager", "Preloading ad for spec " + cVar + "...");
            this.f420a.mo5362a().mo5637a(mo5459a(cVar), C0365cr.MAIN, 500);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo5520g(C0347c cVar) {
        boolean contains;
        synchronized (this.f422c) {
            contains = this.f425f.contains(cVar);
        }
        return contains;
    }
}
