package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0609R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.dynamic.zzg;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements View.OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;

    /* renamed from: vg */
    private View f1500vg;

    /* renamed from: vh */
    private View.OnClickListener f1501vh;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1501vh = null;
        zzb(context, attributeSet);
        setStyle(this.mSize, this.mColor);
    }

    private static Button zza(Context context, int i, int i2) {
        zzah zzah = new zzah(context);
        zzah.zza(context.getResources(), i, i2);
        return zzah;
    }

    private void zzb(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C0609R.styleable.SignInButton, 0, 0);
        try {
            this.mSize = obtainStyledAttributes.getInt(C0609R.styleable.SignInButton_buttonSize, 0);
            this.mColor = obtainStyledAttributes.getInt(C0609R.styleable.SignInButton_colorScheme, 2);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void zzca(Context context) {
        if (this.f1500vg != null) {
            removeView(this.f1500vg);
        }
        try {
            this.f1500vg = zzag.zzb(context, this.mSize, this.mColor);
        } catch (zzg.zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.f1500vg = zza(context, this.mSize, this.mColor);
        }
        addView(this.f1500vg);
        this.f1500vg.setEnabled(isEnabled());
        this.f1500vg.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.f1501vh != null && view == this.f1500vg) {
            this.f1501vh.onClick(this);
        }
    }

    public void setColorScheme(int i) {
        setStyle(this.mSize, i);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f1500vg.setEnabled(z);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1501vh = onClickListener;
        if (this.f1500vg != null) {
            this.f1500vg.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(Scope[] scopeArr) {
        setStyle(this.mSize, this.mColor);
    }

    public void setSize(int i) {
        setStyle(i, this.mColor);
    }

    public void setStyle(int i, int i2) {
        this.mSize = i;
        this.mColor = i2;
        zzca(getContext());
    }

    @Deprecated
    public void setStyle(int i, int i2, Scope[] scopeArr) {
        setStyle(i, i2);
    }
}
