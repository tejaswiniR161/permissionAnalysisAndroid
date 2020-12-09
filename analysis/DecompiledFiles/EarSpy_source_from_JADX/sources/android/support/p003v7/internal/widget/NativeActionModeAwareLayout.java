package android.support.p003v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;

@TargetApi(11)
/* renamed from: android.support.v7.internal.widget.NativeActionModeAwareLayout */
public class NativeActionModeAwareLayout extends ContentFrameLayout {
    private OnActionModeForChildListener mActionModeForChildListener;

    /* renamed from: android.support.v7.internal.widget.NativeActionModeAwareLayout$OnActionModeForChildListener */
    public interface OnActionModeForChildListener {
        ActionMode startActionModeForChild(View view, ActionMode.Callback callback);
    }

    public NativeActionModeAwareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setActionModeForChildListener(OnActionModeForChildListener listener) {
        this.mActionModeForChildListener = listener;
    }

    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        if (this.mActionModeForChildListener != null) {
            return this.mActionModeForChildListener.startActionModeForChild(originalView, callback);
        }
        return super.startActionModeForChild(originalView, callback);
    }
}
