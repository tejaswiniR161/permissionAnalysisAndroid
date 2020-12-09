package com.applovin.adview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

public class AppLovinTouchToClickListener implements View.OnTouchListener {

    /* renamed from: a */
    private long f49a;

    /* renamed from: b */
    private float f50b;

    /* renamed from: c */
    private float f51c;

    /* renamed from: d */
    private Context f52d;

    /* renamed from: e */
    private View.OnClickListener f53e;

    public AppLovinTouchToClickListener(Context context, View.OnClickListener onClickListener) {
        this.f52d = context;
        this.f53e = onClickListener;
    }

    /* renamed from: a */
    private float m92a(float f) {
        return f / this.f52d.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    private float m93a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return m92a((float) Math.sqrt((double) ((f5 * f5) + (f6 * f6))));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f49a = System.currentTimeMillis();
                this.f50b = motionEvent.getX();
                this.f51c = motionEvent.getY();
                return true;
            case 1:
                if (System.currentTimeMillis() - this.f49a >= 1000 || m93a(this.f50b, this.f51c, motionEvent.getX(), motionEvent.getY()) >= 10.0f) {
                    return true;
                }
                this.f53e.onClick(view);
                return true;
            default:
                return true;
        }
    }
}
