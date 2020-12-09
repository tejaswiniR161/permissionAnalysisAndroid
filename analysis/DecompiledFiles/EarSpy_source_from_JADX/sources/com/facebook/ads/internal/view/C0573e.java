package com.facebook.ads.internal.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* renamed from: com.facebook.ads.internal.view.e */
public class C0573e extends LinearLayout {

    /* renamed from: a */
    private Bitmap f1328a;

    /* renamed from: b */
    private Bitmap f1329b;

    /* renamed from: c */
    private ImageView f1330c;

    /* renamed from: d */
    private ImageView f1331d;

    /* renamed from: e */
    private ImageView f1332e;

    /* renamed from: f */
    private Bitmap f1333f;

    /* renamed from: g */
    private int f1334g;

    /* renamed from: h */
    private int f1335h;

    public C0573e(Context context) {
        super(context);
        m1276b();
    }

    /* renamed from: a */
    private void m1275a() {
        if (getHeight() > 0) {
            this.f1335h = m1277c();
            this.f1334g = (int) Math.ceil((double) (((float) (getHeight() - this.f1335h)) / 2.0f));
            Matrix matrix = new Matrix();
            matrix.preScale(1.0f, -1.0f);
            int floor = (int) Math.floor((double) (((float) (getHeight() - this.f1335h)) / 2.0f));
            float height = ((float) this.f1328a.getHeight()) / ((float) this.f1335h);
            int round = Math.round(((float) this.f1334g) * height);
            if (round > 0) {
                this.f1333f = Bitmap.createBitmap(this.f1329b, 0, 0, this.f1329b.getWidth(), round, matrix, true);
                this.f1330c.setImageBitmap(this.f1333f);
            }
            int round2 = Math.round(((float) floor) * height);
            if (round2 > 0) {
                this.f1332e.setImageBitmap(Bitmap.createBitmap(this.f1329b, 0, this.f1329b.getHeight() - round2, this.f1329b.getWidth(), round2, matrix, true));
            }
        }
    }

    /* renamed from: b */
    private void m1276b() {
        getContext().getResources().getDisplayMetrics();
        setOrientation(1);
        this.f1330c = new ImageView(getContext());
        this.f1330c.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f1330c);
        this.f1331d = new ImageView(getContext());
        this.f1331d.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f1331d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(this.f1331d);
        this.f1332e = new ImageView(getContext());
        this.f1332e.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f1332e);
    }

    /* renamed from: c */
    private int m1277c() {
        return (int) Math.round(((double) getWidth()) / 1.91d);
    }

    /* renamed from: a */
    public void mo6162a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            this.f1331d.setImageDrawable((Drawable) null);
            return;
        }
        this.f1331d.setImageBitmap(Bitmap.createBitmap(bitmap));
        this.f1328a = bitmap;
        this.f1329b = bitmap2;
        float height = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
        m1275a();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1328a == null || this.f1329b == null) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int c = m1277c();
        if (this.f1333f == null || this.f1335h != c) {
            m1275a();
        }
        this.f1330c.layout(i, i2, i3, this.f1334g);
        this.f1331d.layout(i, this.f1334g + i2, i3, this.f1334g + this.f1335h);
        this.f1332e.layout(i, this.f1334g + i2 + this.f1335h, i3, i4);
    }
}
