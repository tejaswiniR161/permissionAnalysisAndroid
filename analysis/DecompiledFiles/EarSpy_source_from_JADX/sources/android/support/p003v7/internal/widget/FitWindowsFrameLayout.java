package android.support.p003v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p003v7.internal.widget.FitWindowsViewGroup;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.internal.widget.FitWindowsFrameLayout */
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {
    private FitWindowsViewGroup.OnFitSystemWindowsListener mListener;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener listener) {
        this.mListener = listener;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect insets) {
        if (this.mListener != null) {
            this.mListener.onFitSystemWindows(insets);
        }
        return super.fitSystemWindows(insets);
    }
}
