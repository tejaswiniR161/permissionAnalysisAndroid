package com.facebook.ads.internal.view;

import android.content.Context;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.internal.view.l */
public class C0585l extends RelativeLayout {

    /* renamed from: a */
    private int f1359a = 0;

    /* renamed from: b */
    private int f1360b = 0;

    public C0585l(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1360b > 0 && getMeasuredWidth() > this.f1360b) {
            setMeasuredDimension(this.f1360b, getMeasuredHeight());
        } else if (getMeasuredWidth() < this.f1359a) {
            setMeasuredDimension(this.f1359a, getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void setMaxWidth(int i) {
        this.f1360b = i;
    }

    public void setMinWidth(int i) {
        this.f1359a = i;
    }
}
