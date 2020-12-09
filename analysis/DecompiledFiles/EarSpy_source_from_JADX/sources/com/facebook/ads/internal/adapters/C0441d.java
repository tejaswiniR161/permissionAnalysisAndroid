package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.util.C0555t;

/* renamed from: com.facebook.ads.internal.adapters.d */
public class C0441d {

    /* renamed from: a */
    private int f894a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f895b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f896c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final View f897d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f898e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C0442a f899f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Handler f900g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Runnable f901h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final boolean f902i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public volatile boolean f903j;

    /* renamed from: com.facebook.ads.internal.adapters.d$a */
    public static abstract class C0442a {
        /* renamed from: a */
        public abstract void mo5822a();

        /* renamed from: b */
        public void mo5914b() {
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.d$b */
    private static final class C0443b extends C0555t<C0441d> {
        public C0443b(C0441d dVar) {
            super(dVar);
        }

        public void run() {
            C0441d dVar = (C0441d) mo6141a();
            if (dVar != null) {
                if (dVar.f902i || !dVar.f903j) {
                    View c = dVar.f897d;
                    C0442a d = dVar.f899f;
                    if (c != null && d != null) {
                        if (C0537g.m1211a(dVar.f896c, c, dVar.f898e)) {
                            d.mo5822a();
                            boolean unused = dVar.f903j = true;
                            return;
                        }
                        d.mo5914b();
                        dVar.f900g.postDelayed(dVar.f901h, (long) dVar.f895b);
                    }
                }
            }
        }
    }

    public C0441d(Context context, View view, int i, C0442a aVar) {
        this(context, view, i, false, aVar);
    }

    public C0441d(Context context, View view, int i, boolean z, C0442a aVar) {
        this.f894a = 0;
        this.f895b = AdError.NETWORK_ERROR_CODE;
        this.f900g = new Handler();
        this.f901h = new C0443b(this);
        this.f896c = context;
        this.f897d = view;
        this.f898e = i;
        this.f899f = aVar;
        this.f902i = z;
    }

    /* renamed from: a */
    public void mo5910a() {
        if (!this.f902i && !this.f903j) {
            this.f900g.postDelayed(this.f901h, (long) this.f894a);
        }
    }

    /* renamed from: a */
    public void mo5911a(int i) {
        this.f894a = i;
    }

    /* renamed from: b */
    public void mo5912b() {
        this.f900g.removeCallbacks(this.f901h);
    }

    /* renamed from: b */
    public void mo5913b(int i) {
        this.f895b = i;
    }
}
