package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.google.android.gms.common.util.zzs;

public final class zzrt extends Drawable implements Drawable.Callback {

    /* renamed from: AD */
    private int f2212AD;

    /* renamed from: AE */
    private int f2213AE;

    /* renamed from: AF */
    private int f2214AF;

    /* renamed from: AG */
    private int f2215AG;

    /* renamed from: AH */
    private int f2216AH;

    /* renamed from: AI */
    private boolean f2217AI;

    /* renamed from: AJ */
    private zzb f2218AJ;

    /* renamed from: AK */
    private Drawable f2219AK;

    /* renamed from: AL */
    private Drawable f2220AL;

    /* renamed from: AM */
    private boolean f2221AM;

    /* renamed from: AN */
    private boolean f2222AN;

    /* renamed from: AO */
    private boolean f2223AO;

    /* renamed from: AP */
    private int f2224AP;

    /* renamed from: Ax */
    private boolean f2225Ax;

    /* renamed from: bZ */
    private long f2226bZ;
    private int mFrom;

    private static final class zza extends Drawable {
        /* access modifiers changed from: private */

        /* renamed from: AQ */
        public static final zza f2227AQ = new zza();

        /* renamed from: AR */
        private static final C1323zza f2228AR = new C1323zza();

        /* renamed from: com.google.android.gms.internal.zzrt$zza$zza  reason: collision with other inner class name */
        private static final class C1323zza extends Drawable.ConstantState {
            private C1323zza() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return zza.f2227AQ;
            }
        }

        private zza() {
        }

        public void draw(Canvas canvas) {
        }

        public Drawable.ConstantState getConstantState() {
            return f2228AR;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    static final class zzb extends Drawable.ConstantState {

        /* renamed from: AS */
        int f2229AS;
        int mChangingConfigurations;

        zzb(zzb zzb) {
            if (zzb != null) {
                this.mChangingConfigurations = zzb.mChangingConfigurations;
                this.f2229AS = zzb.f2229AS;
            }
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Drawable newDrawable() {
            return new zzrt(this);
        }
    }

    public zzrt(Drawable drawable, Drawable drawable2) {
        this((zzb) null);
        drawable = drawable == null ? zza.f2227AQ : drawable;
        this.f2219AK = drawable;
        drawable.setCallback(this);
        this.f2218AJ.f2229AS |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? zza.f2227AQ : drawable2;
        this.f2220AL = drawable2;
        drawable2.setCallback(this);
        this.f2218AJ.f2229AS |= drawable2.getChangingConfigurations();
    }

    zzrt(zzb zzb2) {
        this.f2212AD = 0;
        this.f2214AF = 255;
        this.f2216AH = 0;
        this.f2225Ax = true;
        this.f2218AJ = new zzb(zzb2);
    }

    public boolean canConstantState() {
        if (!this.f2221AM) {
            this.f2222AN = (this.f2219AK.getConstantState() == null || this.f2220AL.getConstantState() == null) ? false : true;
            this.f2221AM = true;
        }
        return this.f2222AN;
    }

    public void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        switch (this.f2212AD) {
            case 1:
                this.f2226bZ = SystemClock.uptimeMillis();
                this.f2212AD = 2;
                break;
            case 2:
                if (this.f2226bZ >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f2226bZ)) / ((float) this.f2215AG);
                    if (uptimeMillis < 1.0f) {
                        z = false;
                    }
                    if (z) {
                        this.f2212AD = 0;
                    }
                    this.f2216AH = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) (this.f2213AE + 0))) + 0.0f);
                    break;
                }
                break;
        }
        z2 = z;
        int i = this.f2216AH;
        boolean z3 = this.f2225Ax;
        Drawable drawable = this.f2219AK;
        Drawable drawable2 = this.f2220AL;
        if (z2) {
            if (!z3 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.f2214AF) {
                drawable2.setAlpha(this.f2214AF);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.f2214AF - i);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.f2214AF);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f2214AF);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f2218AJ.mChangingConfigurations | this.f2218AJ.f2229AS;
    }

    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.f2218AJ.mChangingConfigurations = getChangingConfigurations();
        return this.f2218AJ;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.f2219AK.getIntrinsicHeight(), this.f2220AL.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.f2219AK.getIntrinsicWidth(), this.f2220AL.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.f2223AO) {
            this.f2224AP = Drawable.resolveOpacity(this.f2219AK.getOpacity(), this.f2220AL.getOpacity());
            this.f2223AO = true;
        }
        return this.f2224AP;
    }

    @TargetApi(11)
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (zzs.zzaxk() && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    public Drawable mutate() {
        if (!this.f2217AI && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f2219AK.mutate();
            this.f2220AL.mutate();
            this.f2217AI = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f2219AK.setBounds(rect);
        this.f2220AL.setBounds(rect);
    }

    @TargetApi(11)
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (zzs.zzaxk() && (callback = getCallback()) != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.f2216AH == this.f2214AF) {
            this.f2216AH = i;
        }
        this.f2214AF = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2219AK.setColorFilter(colorFilter);
        this.f2220AL.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.mFrom = 0;
        this.f2213AE = this.f2214AF;
        this.f2216AH = 0;
        this.f2215AG = i;
        this.f2212AD = 1;
        invalidateSelf();
    }

    @TargetApi(11)
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (zzs.zzaxk() && (callback = getCallback()) != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public Drawable zzatn() {
        return this.f2220AL;
    }
}
