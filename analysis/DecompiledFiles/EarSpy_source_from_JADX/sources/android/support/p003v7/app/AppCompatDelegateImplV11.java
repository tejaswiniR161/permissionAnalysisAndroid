package android.support.p003v7.app;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.p003v7.internal.view.SupportActionModeWrapper;
import android.support.p003v7.internal.widget.NativeActionModeAwareLayout;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

@TargetApi(11)
/* renamed from: android.support.v7.app.AppCompatDelegateImplV11 */
class AppCompatDelegateImplV11 extends AppCompatDelegateImplV7 implements NativeActionModeAwareLayout.OnActionModeForChildListener {
    private NativeActionModeAwareLayout mNativeActionModeAwareLayout;

    AppCompatDelegateImplV11(Context context, Window window, AppCompatCallback callback) {
        super(context, window, callback);
    }

    /* access modifiers changed from: package-private */
    public void onSubDecorInstalled(ViewGroup subDecor) {
        this.mNativeActionModeAwareLayout = (NativeActionModeAwareLayout) subDecor.findViewById(16908290);
        if (this.mNativeActionModeAwareLayout != null) {
            this.mNativeActionModeAwareLayout.setActionModeForChildListener(this);
        }
    }

    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        android.support.p003v7.view.ActionMode supportActionMode = startSupportActionMode(new SupportActionModeWrapper.CallbackWrapper(originalView.getContext(), callback));
        if (supportActionMode != null) {
            return new SupportActionModeWrapper(this.mContext, supportActionMode);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View callActivityOnCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = super.callActivityOnCreateView(parent, name, context, attrs);
        if (view != null) {
            return view;
        }
        if (this.mOriginalWindowCallback instanceof LayoutInflater.Factory2) {
            return ((LayoutInflater.Factory2) this.mOriginalWindowCallback).onCreateView(parent, name, context, attrs);
        }
        return null;
    }
}
