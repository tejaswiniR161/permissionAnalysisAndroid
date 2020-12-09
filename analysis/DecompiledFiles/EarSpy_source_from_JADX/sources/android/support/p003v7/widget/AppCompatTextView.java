package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p003v7.appcompat.C0167R;
import android.support.p003v7.internal.text.AllCapsTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.AppCompatTextView */
public class AppCompatTextView extends TextView {
    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AppCompatTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, C0167R.styleable.AppCompatTextView, defStyle, 0);
        int ap = a.getResourceId(C0167R.styleable.AppCompatTextView_android_textAppearance, -1);
        a.recycle();
        if (ap != -1) {
            TypedArray appearance = context.obtainStyledAttributes(ap, C0167R.styleable.TextAppearance);
            if (appearance.hasValue(C0167R.styleable.TextAppearance_textAllCaps)) {
                setAllCaps(appearance.getBoolean(C0167R.styleable.TextAppearance_textAllCaps, false));
            }
            appearance.recycle();
        }
        TypedArray a2 = context.obtainStyledAttributes(attrs, C0167R.styleable.AppCompatTextView, defStyle, 0);
        if (a2.hasValue(C0167R.styleable.AppCompatTextView_textAllCaps)) {
            setAllCaps(a2.getBoolean(C0167R.styleable.AppCompatTextView_textAllCaps, false));
        }
        a2.recycle();
    }

    public void setAllCaps(boolean allCaps) {
        setTransformationMethod(allCaps ? new AllCapsTransformationMethod(getContext()) : null);
    }

    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        TypedArray appearance = context.obtainStyledAttributes(resId, C0167R.styleable.TextAppearance);
        if (appearance.hasValue(C0167R.styleable.TextAppearance_textAllCaps)) {
            setAllCaps(appearance.getBoolean(C0167R.styleable.TextAppearance_textAllCaps, false));
        }
        appearance.recycle();
    }
}
