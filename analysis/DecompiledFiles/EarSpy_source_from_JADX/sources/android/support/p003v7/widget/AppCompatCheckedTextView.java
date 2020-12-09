package android.support.p003v7.widget;

import android.content.Context;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

/* renamed from: android.support.v7.widget.AppCompatCheckedTextView */
public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] TINT_ATTRS = {16843016};
    private TintManager mTintManager;

    public AppCompatCheckedTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (TintManager.SHOULD_BE_USED) {
            TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, TINT_ATTRS, defStyleAttr, 0);
            setCheckMarkDrawable(a.getDrawable(0));
            a.recycle();
            this.mTintManager = a.getTintManager();
        }
    }

    public void setCheckMarkDrawable(int resId) {
        if (this.mTintManager != null) {
            setCheckMarkDrawable(this.mTintManager.getDrawable(resId));
        } else {
            super.setCheckMarkDrawable(resId);
        }
    }
}
