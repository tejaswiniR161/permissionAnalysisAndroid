package com.facebook.ads.internal.view;

import android.content.Context;
import android.webkit.WebView;

/* renamed from: com.facebook.ads.internal.view.d */
public class C0572d extends WebView {

    /* renamed from: a */
    private boolean f1327a;

    public C0572d(Context context) {
        super(context);
    }

    /* renamed from: b */
    public boolean mo6161b() {
        return this.f1327a;
    }

    public void destroy() {
        this.f1327a = true;
        super.destroy();
    }
}
