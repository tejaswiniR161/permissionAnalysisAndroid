package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class zzru extends ImageView {

    /* renamed from: AT */
    private Uri f2230AT;

    /* renamed from: AU */
    private int f2231AU;

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public int zzatp() {
        return this.f2231AU;
    }

    public void zzgj(int i) {
        this.f2231AU = i;
    }

    public void zzq(Uri uri) {
        this.f2230AT = uri;
    }
}
