package com.applovin.impl.adview;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.applovin.impl.adview.p */
class C0282p implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C0281o f177a;

    C0282p(C0281o oVar) {
        this.f177a = oVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            return true;
        }
        if (!view.hasFocus()) {
            view.requestFocus();
        }
        return false;
    }
}
