package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: com.applovin.impl.adview.s */
public class C0285s extends View {

    /* renamed from: A */
    private final int f181A;

    /* renamed from: a */
    protected Paint f182a;

    /* renamed from: b */
    protected Paint f183b;

    /* renamed from: c */
    private Paint f184c;

    /* renamed from: d */
    private Paint f185d;

    /* renamed from: e */
    private RectF f186e;

    /* renamed from: f */
    private float f187f;

    /* renamed from: g */
    private int f188g;

    /* renamed from: h */
    private int f189h;

    /* renamed from: i */
    private int f190i;

    /* renamed from: j */
    private int f191j;

    /* renamed from: k */
    private int f192k;

    /* renamed from: l */
    private float f193l;

    /* renamed from: m */
    private int f194m;

    /* renamed from: n */
    private String f195n;

    /* renamed from: o */
    private String f196o;

    /* renamed from: p */
    private float f197p;

    /* renamed from: q */
    private String f198q;

    /* renamed from: r */
    private float f199r;

    /* renamed from: s */
    private final float f200s;

    /* renamed from: t */
    private final int f201t;

    /* renamed from: u */
    private final int f202u;

    /* renamed from: v */
    private final int f203v;

    /* renamed from: w */
    private final int f204w;

    /* renamed from: x */
    private final int f205x;

    /* renamed from: y */
    private final float f206y;

    /* renamed from: z */
    private final float f207z;

    public C0285s(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0285s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0285s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f186e = new RectF();
        this.f190i = 0;
        this.f195n = "";
        this.f196o = "";
        this.f198q = "";
        this.f201t = Color.rgb(66, 145, 241);
        this.f202u = Color.rgb(66, 145, 241);
        this.f203v = Color.rgb(66, 145, 241);
        this.f204w = 0;
        this.f205x = 100;
        this.f206y = C0286t.m180b(getResources(), 14.0f);
        this.f181A = (int) C0286t.m179a(getResources(), 100.0f);
        this.f200s = C0286t.m179a(getResources(), 4.0f);
        this.f207z = C0286t.m180b(getResources(), 18.0f);
        mo5291b();
        mo5288a();
    }

    /* renamed from: e */
    private int m157e(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f181A;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    /* renamed from: o */
    private float m158o() {
        return (((float) mo5296d()) / ((float) this.f191j)) * 360.0f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5288a() {
        this.f182a = new TextPaint();
        this.f182a.setColor(this.f188g);
        this.f182a.setTextSize(this.f187f);
        this.f182a.setAntiAlias(true);
        this.f183b = new TextPaint();
        this.f183b.setColor(this.f189h);
        this.f183b.setTextSize(this.f197p);
        this.f183b.setAntiAlias(true);
        this.f184c = new Paint();
        this.f184c.setColor(this.f192k);
        this.f184c.setStyle(Paint.Style.STROKE);
        this.f184c.setAntiAlias(true);
        this.f184c.setStrokeWidth(this.f193l);
        this.f185d = new Paint();
        this.f185d.setColor(this.f194m);
        this.f185d.setAntiAlias(true);
    }

    /* renamed from: a */
    public void mo5289a(float f) {
        this.f193l = f;
        invalidate();
    }

    /* renamed from: a */
    public void mo5290a(int i) {
        this.f190i = i;
        if (this.f190i > mo5298e()) {
            this.f190i %= mo5298e();
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5291b() {
        this.f192k = this.f201t;
        this.f188g = this.f202u;
        this.f187f = this.f206y;
        mo5293b(100);
        mo5290a(0);
        this.f193l = this.f200s;
        this.f194m = 0;
        this.f197p = this.f207z;
        this.f189h = this.f203v;
    }

    /* renamed from: b */
    public void mo5292b(float f) {
        this.f187f = f;
        invalidate();
    }

    /* renamed from: b */
    public void mo5293b(int i) {
        if (i > 0) {
            this.f191j = i;
            invalidate();
        }
    }

    /* renamed from: c */
    public float mo5294c() {
        return this.f193l;
    }

    /* renamed from: c */
    public void mo5295c(int i) {
        this.f188g = i;
        invalidate();
    }

    /* renamed from: d */
    public int mo5296d() {
        return this.f190i;
    }

    /* renamed from: d */
    public void mo5297d(int i) {
        this.f192k = i;
        invalidate();
    }

    /* renamed from: e */
    public int mo5298e() {
        return this.f191j;
    }

    /* renamed from: f */
    public float mo5299f() {
        return this.f187f;
    }

    /* renamed from: g */
    public int mo5300g() {
        return this.f188g;
    }

    /* renamed from: h */
    public int mo5301h() {
        return this.f192k;
    }

    /* renamed from: i */
    public String mo5302i() {
        return this.f196o;
    }

    public void invalidate() {
        mo5288a();
        super.invalidate();
    }

    /* renamed from: j */
    public String mo5304j() {
        return this.f195n;
    }

    /* renamed from: k */
    public int mo5305k() {
        return this.f194m;
    }

    /* renamed from: l */
    public String mo5306l() {
        return this.f198q;
    }

    /* renamed from: m */
    public float mo5307m() {
        return this.f197p;
    }

    /* renamed from: n */
    public int mo5308n() {
        return this.f189h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f193l;
        this.f186e.set(f, f, ((float) getWidth()) - f, ((float) getHeight()) - f);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((((float) getWidth()) - this.f193l) + this.f193l) / 2.0f, this.f185d);
        canvas.drawArc(this.f186e, 270.0f, -m158o(), false, this.f184c);
        String str = this.f195n + this.f190i + this.f196o;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (((float) getWidth()) - this.f182a.measureText(str)) / 2.0f, (((float) getWidth()) - (this.f182a.descent() + this.f182a.ascent())) / 2.0f, this.f182a);
        }
        if (!TextUtils.isEmpty(mo5306l())) {
            this.f183b.setTextSize(this.f197p);
            canvas.drawText(mo5306l(), (((float) getWidth()) - this.f183b.measureText(mo5306l())) / 2.0f, (((float) getHeight()) - this.f199r) - ((this.f182a.descent() + this.f182a.ascent()) / 2.0f), this.f183b);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(m157e(i), m157e(i2));
        this.f199r = (float) (getHeight() - ((getHeight() * 3) / 4));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f188g = bundle.getInt("text_color");
            this.f187f = bundle.getFloat("text_size");
            this.f197p = bundle.getFloat("inner_bottom_text_size");
            this.f198q = bundle.getString("inner_bottom_text");
            this.f189h = bundle.getInt("inner_bottom_text_color");
            this.f192k = bundle.getInt("finished_stroke_color");
            this.f193l = bundle.getFloat("finished_stroke_width");
            this.f194m = bundle.getInt("inner_background_color");
            mo5288a();
            mo5293b(bundle.getInt("max"));
            mo5290a(bundle.getInt("progress"));
            this.f195n = bundle.getString("prefix");
            this.f196o = bundle.getString("suffix");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", mo5300g());
        bundle.putFloat("text_size", mo5299f());
        bundle.putFloat("inner_bottom_text_size", mo5307m());
        bundle.putFloat("inner_bottom_text_color", (float) mo5308n());
        bundle.putString("inner_bottom_text", mo5306l());
        bundle.putInt("inner_bottom_text_color", mo5308n());
        bundle.putInt("finished_stroke_color", mo5301h());
        bundle.putInt("max", mo5298e());
        bundle.putInt("progress", mo5296d());
        bundle.putString("suffix", mo5302i());
        bundle.putString("prefix", mo5304j());
        bundle.putFloat("finished_stroke_width", mo5294c());
        bundle.putInt("inner_background_color", mo5305k());
        return bundle;
    }
}
