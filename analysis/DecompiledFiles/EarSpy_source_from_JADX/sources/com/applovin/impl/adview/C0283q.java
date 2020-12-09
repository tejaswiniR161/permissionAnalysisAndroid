package com.applovin.impl.adview;

import android.util.Log;
import android.view.View;

/* renamed from: com.applovin.impl.adview.q */
class C0283q implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ C0281o f178a;

    C0283q(C0281o oVar) {
        this.f178a = oVar;
    }

    public boolean onLongClick(View view) {
        Log.d("AdWebView", "Received a LongClick event.");
        return true;
    }
}
