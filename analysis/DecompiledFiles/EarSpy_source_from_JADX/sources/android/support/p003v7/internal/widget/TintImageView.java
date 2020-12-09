package android.support.p003v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.internal.widget.TintImageView */
public class TintImageView extends ImageView {
    private static final int[] TINT_ATTRS = {16842964, 16843033};
    private final TintManager mTintManager;

    public TintImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TintImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TintImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, TINT_ATTRS, defStyleAttr, 0);
        if (a.length() > 0) {
            if (a.hasValue(0)) {
                setBackgroundDrawable(a.getDrawable(0));
            }
            if (a.hasValue(1)) {
                setImageDrawable(a.getDrawable(1));
            }
        }
        a.recycle();
        this.mTintManager = a.getTintManager();
    }

    public void setImageResource(int resId) {
        setImageDrawable(this.mTintManager.getDrawable(resId));
    }
}
