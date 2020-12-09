package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.al */
public class C0266al extends C0287u {

    /* renamed from: c */
    private float f147c = 30.0f;

    /* renamed from: d */
    private float f148d = 2.0f;

    /* renamed from: e */
    private float f149e = 8.0f;

    /* renamed from: f */
    private float f150f = 2.0f;

    /* renamed from: g */
    private float f151g = 1.0f;

    public C0266al(AppLovinSdk appLovinSdk, Context context) {
        super(appLovinSdk, context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo5244a() {
        return this.f147c * this.f151g;
    }

    /* renamed from: a */
    public void mo5245a(float f) {
        this.f151g = f;
    }

    /* renamed from: a */
    public void mo5246a(int i) {
        mo5245a(((float) i) / this.f147c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public float mo5247b() {
        return this.f149e * this.f151g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public float mo5248c() {
        return this.f150f * this.f151g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public float mo5249d() {
        return mo5244a() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = mo5249d();
        Paint paint = new Paint(1);
        paint.setARGB(80, 0, 0, 0);
        canvas.drawCircle(d, d, d, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(mo5248c());
        float b = mo5247b();
        float a = mo5244a() - b;
        canvas.drawLine(b, b, a, a, paint2);
        canvas.drawLine(b, a, a, b, paint2);
    }
}
