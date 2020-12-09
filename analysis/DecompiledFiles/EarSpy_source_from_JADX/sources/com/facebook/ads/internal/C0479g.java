package com.facebook.ads.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.internal.g */
public class C0479g extends View {

    /* renamed from: a */
    private Paint f1109a;

    /* renamed from: b */
    private Paint f1110b;

    /* renamed from: c */
    private Paint f1111c;

    /* renamed from: d */
    private int f1112d;

    /* renamed from: e */
    private boolean f1113e;

    public C0479g(Context context) {
        this(context, 60, true);
    }

    public C0479g(Context context, int i, boolean z) {
        super(context);
        this.f1112d = i;
        this.f1113e = z;
        if (z) {
            this.f1109a = new Paint();
            this.f1109a.setColor(-3355444);
            this.f1109a.setStyle(Paint.Style.STROKE);
            this.f1109a.setStrokeWidth(3.0f);
            this.f1109a.setAntiAlias(true);
            this.f1110b = new Paint();
            this.f1110b.setColor(-1287371708);
            this.f1110b.setStyle(Paint.Style.FILL);
            this.f1110b.setAntiAlias(true);
            this.f1111c = new Paint();
            this.f1111c.setColor(-1);
            this.f1111c.setStyle(Paint.Style.STROKE);
            this.f1111c.setStrokeWidth(6.0f);
            this.f1111c.setAntiAlias(true);
        }
        m1017a();
    }

    /* renamed from: a */
    private void m1017a() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) this.f1112d) * displayMetrics.density), (int) (displayMetrics.density * ((float) this.f1112d)));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f1113e) {
            if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 17) {
                setLayerType(1, (Paint) null);
            }
            int min = Math.min(canvas.getWidth(), canvas.getHeight());
            int i = min / 2;
            int i2 = min / 2;
            int i3 = (i * 2) / 3;
            canvas.drawCircle((float) i, (float) i2, (float) i3, this.f1109a);
            canvas.drawCircle((float) i, (float) i2, (float) (i3 - 2), this.f1110b);
            int i4 = min / 3;
            int i5 = min / 3;
            canvas.drawLine((float) i4, (float) i5, (float) (i4 * 2), (float) (i5 * 2), this.f1111c);
            canvas.drawLine((float) (i4 * 2), (float) i5, (float) i4, (float) (i5 * 2), this.f1111c);
        }
        super.onDraw(canvas);
    }
}
