package com.facebook.ads.internal.action;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0537g;

/* renamed from: com.facebook.ads.internal.action.d */
public class C0437d extends C0434a {

    /* renamed from: a */
    private static final String f884a = C0437d.class.getSimpleName();

    /* renamed from: b */
    private final Context f885b;

    /* renamed from: c */
    private final Uri f886c;

    public C0437d(Context context, Uri uri) {
        this.f885b = context;
        this.f886c = uri;
    }

    /* renamed from: a */
    public C0528b.C0529a mo5881a() {
        return C0528b.C0529a.OPEN_LINK;
    }

    /* renamed from: b */
    public void mo5883b() {
        mo5882a(this.f885b, this.f886c);
        try {
            C0537g.m1205a(this.f885b, Uri.parse(this.f886c.getQueryParameter("link")));
        } catch (Exception e) {
            Log.d(f884a, "Failed to open link url: " + this.f886c.toString(), e);
        }
    }
}
