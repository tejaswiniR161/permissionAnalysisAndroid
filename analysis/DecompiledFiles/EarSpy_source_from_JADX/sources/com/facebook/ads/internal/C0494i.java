package com.facebook.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.C0444e;
import com.facebook.ads.internal.adapters.C0460n;
import com.facebook.ads.internal.adapters.C0461o;
import com.facebook.ads.internal.dto.C0465a;
import com.facebook.ads.internal.dto.C0468c;
import com.facebook.ads.internal.dto.C0470e;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.server.C0498a;
import com.facebook.ads.internal.server.C0506d;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.util.C0555t;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.facebook.ads.internal.i */
public class C0494i implements C0498a.C0502a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f1154a;

    /* renamed from: b */
    private final String f1155b;

    /* renamed from: c */
    private final C0498a f1156c = new C0498a();

    /* renamed from: d */
    private final C0473e f1157d;

    /* renamed from: e */
    private final C0463c f1158e;

    /* renamed from: f */
    private final AdSize f1159f;

    /* renamed from: g */
    private final int f1160g;

    /* renamed from: h */
    private boolean f1161h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Handler f1162i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final Runnable f1163j;

    /* renamed from: k */
    private C0496a f1164k;

    /* renamed from: l */
    private C0468c f1165l;

    /* renamed from: com.facebook.ads.internal.i$a */
    public interface C0496a {
        /* renamed from: a */
        void mo5872a(C0462b bVar);

        /* renamed from: a */
        void mo5873a(List<C0460n> list);
    }

    /* renamed from: com.facebook.ads.internal.i$b */
    private static final class C0497b extends C0555t<C0494i> {
        public C0497b(C0494i iVar) {
            super(iVar);
        }

        public void run() {
            C0494i iVar = (C0494i) mo6141a();
            if (iVar != null) {
                if (C0537g.m1210a(iVar.f1154a)) {
                    iVar.mo6031a();
                } else {
                    iVar.f1162i.postDelayed(iVar.f1163j, 5000);
                }
            }
        }
    }

    public C0494i(Context context, String str, C0473e eVar, AdSize adSize, C0463c cVar, int i, EnumSet<NativeAd.MediaCacheFlag> enumSet) {
        this.f1154a = context;
        this.f1155b = str;
        this.f1157d = eVar;
        this.f1159f = adSize;
        this.f1158e = cVar;
        this.f1160g = i;
        this.f1156c.mo6039a((C0498a.C0502a) this);
        this.f1161h = true;
        this.f1162i = new Handler();
        this.f1163j = new C0497b(this);
    }

    /* renamed from: d */
    private List<C0460n> m1063d() {
        C0468c cVar = this.f1165l;
        C0465a c = cVar.mo5985c();
        final ArrayList arrayList = new ArrayList(cVar.mo5984b());
        for (C0465a aVar = c; aVar != null; aVar = cVar.mo5985c()) {
            AdAdapter a = C0444e.m850a(aVar.f1032b, AdPlacementType.NATIVE);
            if (a != null && a.getPlacementType() == AdPlacementType.NATIVE) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", aVar.f1033c);
                hashMap.put("definition", cVar.mo5982a());
                ((C0460n) a).mo5922a(this.f1154a, new C0461o() {
                    /* renamed from: a */
                    public void mo5973a(C0460n nVar) {
                        arrayList.add(nVar);
                    }

                    /* renamed from: a */
                    public void mo5974a(C0460n nVar, AdError adError) {
                    }
                }, hashMap);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo6031a() {
        this.f1156c.mo6038a(this.f1154a, new C0470e(this.f1154a, this.f1155b, this.f1159f, this.f1157d, this.f1158e, this.f1160g, AdSettings.isTestMode(this.f1154a)));
    }

    /* renamed from: a */
    public void mo6013a(C0462b bVar) {
        if (this.f1161h) {
            this.f1162i.postDelayed(this.f1163j, 1800000);
        }
        if (this.f1164k != null) {
            this.f1164k.mo5872a(bVar);
        }
    }

    /* renamed from: a */
    public void mo6032a(C0496a aVar) {
        this.f1164k = aVar;
    }

    /* renamed from: a */
    public void mo6014a(C0506d dVar) {
        C0468c b = dVar.mo6046b();
        if (b == null) {
            throw new IllegalStateException("no placement in response");
        }
        if (this.f1161h) {
            long b2 = b.mo5982a().mo5987b();
            if (b2 == 0) {
                b2 = 1800000;
            }
            this.f1162i.postDelayed(this.f1163j, b2);
        }
        this.f1165l = b;
        List<C0460n> d = m1063d();
        if (this.f1164k == null) {
            return;
        }
        if (d.isEmpty()) {
            this.f1164k.mo5872a(AdErrorType.NO_FILL.getAdErrorWrapper(""));
        } else {
            this.f1164k.mo5873a(d);
        }
    }

    /* renamed from: b */
    public void mo6033b() {
    }

    /* renamed from: c */
    public void mo6034c() {
        this.f1161h = false;
        this.f1162i.removeCallbacks(this.f1163j);
    }
}
