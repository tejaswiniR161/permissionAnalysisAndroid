package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.facebook.ads.internal.view.o */
public class C0588o extends View {

    /* renamed from: a */
    private C0587n f1362a;

    public C0588o(Context context, C0587n nVar) {
        super(context);
        this.f1362a = nVar;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    public void onWindowVisibilityChanged(int i) {
        if (this.f1362a != null) {
            this.f1362a.mo5821a(i);
        }
    }
}
