package com.facebook.ads.internal.action;

import android.content.Context;
import android.net.Uri;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.util.C0550o;
import com.facebook.ads.internal.util.C0553r;

/* renamed from: com.facebook.ads.internal.action.a */
public abstract class C0434a {
    /* renamed from: a */
    public abstract C0528b.C0529a mo5881a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5882a(Context context, Uri uri) {
        String queryParameter = uri.getQueryParameter("native_click_report_url");
        if (!C0553r.m1245a(queryParameter)) {
            new C0550o().execute(new String[]{queryParameter});
            C0537g.m1206a(context, "Click logged");
        }
    }

    /* renamed from: b */
    public abstract void mo5883b();
}
