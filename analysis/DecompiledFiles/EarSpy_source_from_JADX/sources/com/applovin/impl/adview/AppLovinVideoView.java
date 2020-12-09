package com.applovin.impl.adview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class AppLovinVideoView extends VideoView {

    /* renamed from: a */
    private int f109a;

    /* renamed from: b */
    private int f110b;

    public AppLovinVideoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppLovinVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f109a = 0;
        this.f110b = 0;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int ceil;
        int ceil2;
        if (this.f109a <= 0 || this.f110b <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        float height = ((float) this.f110b) / ((float) getHeight());
        float width = ((float) this.f109a) / ((float) getWidth());
        if (height > width) {
            ceil = (int) Math.ceil((double) (((float) this.f110b) / height));
            ceil2 = (int) Math.ceil((double) (((float) this.f109a) / height));
        } else {
            ceil = (int) Math.ceil((double) (((float) this.f110b) / width));
            ceil2 = (int) Math.ceil((double) (((float) this.f109a) / width));
        }
        setMeasuredDimension(ceil2, ceil);
    }

    public void setVideoSize(int i, int i2) {
        this.f109a = i;
        this.f110b = i2;
        try {
            getHolder().setFixedSize(i, i2);
            requestLayout();
            invalidate();
        } catch (Exception e) {
        }
    }
}
