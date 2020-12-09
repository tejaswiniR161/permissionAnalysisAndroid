package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.p000v4.view.ViewCompat;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.am */
public class C0267am extends C0287u {

    /* renamed from: c */
    private float f152c = 30.0f;

    /* renamed from: d */
    private float f153d = 2.0f;

    /* renamed from: e */
    private float f154e = 10.0f;

    /* renamed from: f */
    private float f155f = 3.0f;

    /* renamed from: g */
    private float f156g = 1.0f;

    public C0267am(AppLovinSdk appLovinSdk, Context context) {
        super(appLovinSdk, context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo5251a() {
        return this.f152c * this.f156g;
    }

    /* renamed from: a */
    public void mo5252a(float f) {
        this.f156g = f;
    }

    /* renamed from: a */
    public void mo5246a(int i) {
        mo5252a(((float) i) / this.f152c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public float mo5253b() {
        return this.f154e * this.f156g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public float mo5254c() {
        return this.f155f * this.f156g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public float mo5255d() {
        return mo5251a() / 2.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public float mo5256e() {
        return this.f153d * this.f156g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public float mo5257f() {
        return mo5255d() - mo5256e();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float d = mo5255d();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(d, d, d, paint);
        Paint paint2 = new Paint(1);
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(d, d, mo5257f(), paint2);
        Paint paint3 = new Paint(paint);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(mo5254c());
        float b = mo5253b();
        float a = mo5251a() - b;
        canvas.drawLine(b, b, a, a, paint3);
        canvas.drawLine(b, a, a, b, paint3);
    }
}
