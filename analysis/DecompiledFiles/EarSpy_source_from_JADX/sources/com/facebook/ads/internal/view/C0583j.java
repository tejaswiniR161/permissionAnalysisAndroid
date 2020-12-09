package com.facebook.ads.internal.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/* renamed from: com.facebook.ads.internal.view.j */
public class C0583j extends TextView {

    /* renamed from: a */
    private int f1354a;

    /* renamed from: b */
    private float f1355b;

    /* renamed from: c */
    private float f1356c = 8.0f;

    public C0583j(Context context, int i) {
        super(context);
        setMaxLines(i);
        setEllipsize(TextUtils.TruncateAt.END);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.setMaxLines(this.f1354a + 1);
        super.setTextSize(this.f1355b);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 0));
        if (getMeasuredHeight() > i6) {
            float f = this.f1355b;
            while (f > this.f1356c) {
                f -= 0.5f;
                super.setTextSize(f);
                measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), 0);
                if (getMeasuredHeight() <= i6 && getLineCount() <= this.f1354a) {
                    break;
                }
            }
        }
        super.setMaxLines(this.f1354a);
        setMeasuredDimension(i5, i6);
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setMaxLines(int i) {
        this.f1354a = i;
        super.setMaxLines(i);
    }

    public void setMinTextSize(float f) {
        this.f1356c = f;
    }

    public void setTextSize(float f) {
        this.f1355b = f;
        super.setTextSize(f);
    }
}
