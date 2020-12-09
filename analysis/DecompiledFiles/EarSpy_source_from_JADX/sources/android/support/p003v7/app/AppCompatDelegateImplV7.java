package android.support.p003v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.p000v4.app.NavUtils;
import android.support.p000v4.view.LayoutInflaterCompat;
import android.support.p000v4.view.LayoutInflaterFactory;
import android.support.p000v4.view.OnApplyWindowInsetsListener;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewConfigurationCompat;
import android.support.p000v4.view.WindowInsetsCompat;
import android.support.p003v7.appcompat.C0167R;
import android.support.p003v7.internal.app.AppCompatViewInflater;
import android.support.p003v7.internal.app.ToolbarActionBar;
import android.support.p003v7.internal.app.WindowDecorActionBar;
import android.support.p003v7.internal.view.ContextThemeWrapper;
import android.support.p003v7.internal.view.StandaloneActionMode;
import android.support.p003v7.internal.view.menu.ListMenuPresenter;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.MenuView;
import android.support.p003v7.internal.widget.ActionBarContextView;
import android.support.p003v7.internal.widget.ContentFrameLayout;
import android.support.p003v7.internal.widget.DecorContentParent;
import android.support.p003v7.internal.widget.FitWindowsViewGroup;
import android.support.p003v7.internal.widget.TintManager;
import android.support.p003v7.internal.widget.ViewStubCompat;
import android.support.p003v7.internal.widget.ViewUtils;
import android.support.p003v7.view.ActionMode;
import android.support.p003v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.ads.AdError;

/* renamed from: android.support.v7.app.AppCompatDelegateImplV7 */
class AppCompatDelegateImplV7 extends AppCompatDelegateImplBase implements MenuBuilder.Callback, LayoutInflaterFactory {
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private AppCompatViewInflater mAppCompatViewInflater;
    private boolean mClosingActionMenu;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    /* access modifiers changed from: private */
    public int mInvalidatePanelMenuFeatures;
    /* access modifiers changed from: private */
    public boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable = new Runnable() {
        public void run() {
            if ((AppCompatDelegateImplV7.this.mInvalidatePanelMenuFeatures & 1) != 0) {
                AppCompatDelegateImplV7.this.doInvalidatePanelMenu(0);
            }
            if ((AppCompatDelegateImplV7.this.mInvalidatePanelMenuFeatures & 256) != 0) {
                AppCompatDelegateImplV7.this.doInvalidatePanelMenu(8);
            }
            boolean unused = AppCompatDelegateImplV7.this.mInvalidatePanelMenuPosted = false;
            int unused2 = AppCompatDelegateImplV7.this.mInvalidatePanelMenuFeatures = 0;
        }
    };
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private View mStatusGuard;
    private ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private TextView mTitleView;
    private ViewGroup mWindowDecor;

    AppCompatDelegateImplV7(Context context, Window window, AppCompatCallback callback) {
        super(context, window, callback);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mWindowDecor = (ViewGroup) this.mWindow.getDecorView();
        if ((this.mOriginalWindowCallback instanceof Activity) && NavUtils.getParentActivityName((Activity) this.mOriginalWindowCallback) != null) {
            ActionBar ab = peekSupportActionBar();
            if (ab == null) {
                this.mEnableDefaultActionBarUp = true;
            } else {
                ab.setDefaultDisplayHomeAsUpEnabled(true);
            }
        }
    }

    public void onPostCreate(Bundle savedInstanceState) {
        ensureSubDecor();
    }

    public ActionBar createSupportActionBar() {
        ensureSubDecor();
        ActionBar ab = null;
        if (this.mOriginalWindowCallback instanceof Activity) {
            ab = new WindowDecorActionBar((Activity) this.mOriginalWindowCallback, this.mOverlayActionBar);
        } else if (this.mOriginalWindowCallback instanceof Dialog) {
            ab = new WindowDecorActionBar((Dialog) this.mOriginalWindowCallback);
        }
        if (ab != null) {
            ab.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
        }
        return ab;
    }

    public void setSupportActionBar(Toolbar toolbar) {
        if (this.mOriginalWindowCallback instanceof Activity) {
            if (getSupportActionBar() instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            ToolbarActionBar tbab = new ToolbarActionBar(toolbar, ((Activity) this.mContext).getTitle(), this.mWindow);
            setSupportActionBar(tbab);
            this.mWindow.setCallback(tbab.getWrappedWindowCallback());
            tbab.invalidateOptionsMenu();
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        ActionBar ab;
        if (this.mHasActionBar && this.mSubDecorInstalled && (ab = getSupportActionBar()) != null) {
            ab.onConfigurationChanged(newConfig);
        }
    }

    public void onStop() {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setShowHideAnimationEnabled(false);
        }
    }

    public void onPostResume() {
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setShowHideAnimationEnabled(true);
        }
    }

    public void setContentView(View v) {
        ensureSubDecor();
        ViewGroup contentParent = (ViewGroup) this.mSubDecor.findViewById(16908290);
        contentParent.removeAllViews();
        contentParent.addView(v);
        this.mOriginalWindowCallback.onContentChanged();
    }

    public void setContentView(int resId) {
        ensureSubDecor();
        ViewGroup contentParent = (ViewGroup) this.mSubDecor.findViewById(16908290);
        contentParent.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(resId, contentParent);
        this.mOriginalWindowCallback.onContentChanged();
    }

    public void setContentView(View v, ViewGroup.LayoutParams lp) {
        ensureSubDecor();
        ViewGroup contentParent = (ViewGroup) this.mSubDecor.findViewById(16908290);
        contentParent.removeAllViews();
        contentParent.addView(v, lp);
        this.mOriginalWindowCallback.onContentChanged();
    }

    public void addContentView(View v, ViewGroup.LayoutParams lp) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(16908290)).addView(v, lp);
        this.mOriginalWindowCallback.onContentChanged();
    }

    private void ensureSubDecor() {
        Context themedContext;
        if (!this.mSubDecorInstalled) {
            LayoutInflater inflater = LayoutInflater.from(this.mContext);
            if (this.mWindowNoTitle) {
                if (this.mOverlayActionMode) {
                    this.mSubDecor = (ViewGroup) inflater.inflate(C0167R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    this.mSubDecor = (ViewGroup) inflater.inflate(C0167R.layout.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    ViewCompat.setOnApplyWindowInsetsListener(this.mSubDecor, new OnApplyWindowInsetsListener() {
                        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
                            int top = insets.getSystemWindowInsetTop();
                            int newTop = AppCompatDelegateImplV7.this.updateStatusGuard(top);
                            if (top != newTop) {
                                insets = insets.replaceSystemWindowInsets(insets.getSystemWindowInsetLeft(), newTop, insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
                            }
                            return ViewCompat.onApplyWindowInsets(v, insets);
                        }
                    });
                } else {
                    ((FitWindowsViewGroup) this.mSubDecor).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener() {
                        public void onFitSystemWindows(Rect insets) {
                            insets.top = AppCompatDelegateImplV7.this.updateStatusGuard(insets.top);
                        }
                    });
                }
            } else if (this.mIsFloating) {
                this.mSubDecor = (ViewGroup) inflater.inflate(C0167R.layout.abc_dialog_title_material, (ViewGroup) null);
            } else if (this.mHasActionBar) {
                TypedValue outValue = new TypedValue();
                this.mContext.getTheme().resolveAttribute(C0167R.attr.actionBarTheme, outValue, true);
                if (outValue.resourceId != 0) {
                    themedContext = new ContextThemeWrapper(this.mContext, outValue.resourceId);
                } else {
                    themedContext = this.mContext;
                }
                this.mSubDecor = (ViewGroup) LayoutInflater.from(themedContext).inflate(C0167R.layout.abc_screen_toolbar, (ViewGroup) null);
                this.mDecorContentParent = (DecorContentParent) this.mSubDecor.findViewById(C0167R.C0169id.decor_content_parent);
                this.mDecorContentParent.setWindowCallback(getWindowCallback());
                if (this.mOverlayActionBar) {
                    this.mDecorContentParent.initFeature(9);
                }
                if (this.mFeatureProgress) {
                    this.mDecorContentParent.initFeature(2);
                }
                if (this.mFeatureIndeterminateProgress) {
                    this.mDecorContentParent.initFeature(5);
                }
            }
            if (this.mSubDecor == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features");
            }
            if (this.mDecorContentParent == null) {
                this.mTitleView = (TextView) this.mSubDecor.findViewById(C0167R.C0169id.title);
            }
            ViewUtils.makeOptionalFitsSystemWindows(this.mSubDecor);
            ViewGroup decorContent = (ViewGroup) this.mWindow.findViewById(16908290);
            ContentFrameLayout abcContent = (ContentFrameLayout) this.mSubDecor.findViewById(C0167R.C0169id.action_bar_activity_content);
            while (decorContent.getChildCount() > 0) {
                View child = decorContent.getChildAt(0);
                decorContent.removeViewAt(0);
                abcContent.addView(child);
            }
            this.mWindow.setContentView(this.mSubDecor);
            decorContent.setId(-1);
            abcContent.setId(16908290);
            if (decorContent instanceof FrameLayout) {
                ((FrameLayout) decorContent).setForeground((Drawable) null);
            }
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                onTitleChanged(title);
            }
            applyFixedSizeWindow(abcContent);
            onSubDecorInstalled(this.mSubDecor);
            this.mSubDecorInstalled = true;
            PanelFeatureState st = getPanelState(0, false);
            if (isDestroyed()) {
                return;
            }
            if (st == null || st.menu == null) {
                invalidatePanelMenu(8);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onSubDecorInstalled(ViewGroup subDecor) {
    }

    private void applyFixedSizeWindow(ContentFrameLayout contentFrameLayout) {
        contentFrameLayout.setDecorPadding(this.mWindowDecor.getPaddingLeft(), this.mWindowDecor.getPaddingTop(), this.mWindowDecor.getPaddingRight(), this.mWindowDecor.getPaddingBottom());
        TypedArray a = this.mContext.obtainStyledAttributes(C0167R.styleable.Theme);
        a.getValue(C0167R.styleable.Theme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        a.getValue(C0167R.styleable.Theme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (a.hasValue(C0167R.styleable.Theme_windowFixedWidthMajor)) {
            a.getValue(C0167R.styleable.Theme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (a.hasValue(C0167R.styleable.Theme_windowFixedWidthMinor)) {
            a.getValue(C0167R.styleable.Theme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (a.hasValue(C0167R.styleable.Theme_windowFixedHeightMajor)) {
            a.getValue(C0167R.styleable.Theme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (a.hasValue(C0167R.styleable.Theme_windowFixedHeightMinor)) {
            a.getValue(C0167R.styleable.Theme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        a.recycle();
        contentFrameLayout.requestLayout();
    }

    public boolean requestWindowFeature(int featureId) {
        switch (featureId) {
            case 1:
                throwFeatureRequestIfSubDecorInstalled();
                this.mWindowNoTitle = true;
                return true;
            case 2:
                throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureProgress = true;
                return true;
            case 5:
                throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureIndeterminateProgress = true;
                return true;
            case 8:
                throwFeatureRequestIfSubDecorInstalled();
                this.mHasActionBar = true;
                return true;
            case 9:
                throwFeatureRequestIfSubDecorInstalled();
                this.mOverlayActionBar = true;
                return true;
            case 10:
                throwFeatureRequestIfSubDecorInstalled();
                this.mOverlayActionMode = true;
                return true;
            default:
                return this.mWindow.requestFeature(featureId);
        }
    }

    /* access modifiers changed from: package-private */
    public void onTitleChanged(CharSequence title) {
        if (this.mDecorContentParent != null) {
            this.mDecorContentParent.setWindowTitle(title);
        } else if (getSupportActionBar() != null) {
            getSupportActionBar().setWindowTitle(title);
        } else if (this.mTitleView != null) {
            this.mTitleView.setText(title);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onPanelClosed(int featureId, Menu menu) {
        if (featureId == 8) {
            ActionBar ab = getSupportActionBar();
            if (ab == null) {
                return true;
            }
            ab.dispatchMenuVisibilityChanged(false);
            return true;
        }
        if (featureId == 0) {
            PanelFeatureState st = getPanelState(featureId, true);
            if (st.isOpen) {
                closePanel(st, false);
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId != 8) {
            return false;
        }
        ActionBar ab = getSupportActionBar();
        if (ab == null) {
            return true;
        }
        ab.dispatchMenuVisibilityChanged(true);
        return true;
    }

    public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
        PanelFeatureState panel;
        Window.Callback cb = getWindowCallback();
        if (cb == null || isDestroyed() || (panel = findMenuPanel(menu.getRootMenu())) == null) {
            return false;
        }
        return cb.onMenuItemSelected(panel.featureId, item);
    }

    public void onMenuModeChange(MenuBuilder menu) {
        reopenMenu(menu, true);
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        ActionMode.Callback wrappedCallback = new ActionModeCallbackWrapper(callback);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            this.mActionMode = ab.startActionMode(wrappedCallback);
            if (!(this.mActionMode == null || this.mAppCompatCallback == null)) {
                this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
            }
        }
        if (this.mActionMode == null) {
            this.mActionMode = startSupportActionModeFromWindow(wrappedCallback);
        }
        return this.mActionMode;
    }

    public void invalidateOptionsMenu() {
        ActionBar ab = getSupportActionBar();
        if (ab == null || !ab.invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    /* access modifiers changed from: package-private */
    public ActionMode startSupportActionModeFromWindow(ActionMode.Callback callback) {
        boolean z;
        Context actionBarContext;
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        ActionMode.Callback wrappedCallback = new ActionModeCallbackWrapper(callback);
        if (this.mActionModeView == null) {
            if (this.mIsFloating) {
                TypedValue outValue = new TypedValue();
                Resources.Theme baseTheme = this.mContext.getTheme();
                baseTheme.resolveAttribute(C0167R.attr.actionBarTheme, outValue, true);
                if (outValue.resourceId != 0) {
                    Resources.Theme actionBarTheme = this.mContext.getResources().newTheme();
                    actionBarTheme.setTo(baseTheme);
                    actionBarTheme.applyStyle(outValue.resourceId, true);
                    actionBarContext = new ContextThemeWrapper(this.mContext, 0);
                    actionBarContext.getTheme().setTo(actionBarTheme);
                } else {
                    actionBarContext = this.mContext;
                }
                this.mActionModeView = new ActionBarContextView(actionBarContext);
                this.mActionModePopup = new PopupWindow(actionBarContext, (AttributeSet) null, C0167R.attr.actionModePopupWindowStyle);
                this.mActionModePopup.setContentView(this.mActionModeView);
                this.mActionModePopup.setWidth(-1);
                actionBarContext.getTheme().resolveAttribute(C0167R.attr.actionBarSize, outValue, true);
                this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(outValue.data, actionBarContext.getResources().getDisplayMetrics()));
                this.mActionModePopup.setHeight(-2);
                this.mShowActionModePopup = new Runnable() {
                    public void run() {
                        AppCompatDelegateImplV7.this.mActionModePopup.showAtLocation(AppCompatDelegateImplV7.this.mActionModeView, 55, 0, 0);
                    }
                };
            } else {
                ViewStubCompat stub = (ViewStubCompat) this.mSubDecor.findViewById(C0167R.C0169id.action_mode_bar_stub);
                if (stub != null) {
                    stub.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
                    this.mActionModeView = (ActionBarContextView) stub.inflate();
                }
            }
        }
        if (this.mActionModeView != null) {
            this.mActionModeView.killMode();
            Context context = this.mActionModeView.getContext();
            ActionBarContextView actionBarContextView = this.mActionModeView;
            if (this.mActionModePopup == null) {
                z = true;
            } else {
                z = false;
            }
            ActionMode mode = new StandaloneActionMode(context, actionBarContextView, wrappedCallback, z);
            if (callback.onCreateActionMode(mode, mode.getMenu())) {
                mode.invalidate();
                this.mActionModeView.initForMode(mode);
                this.mActionModeView.setVisibility(0);
                this.mActionMode = mode;
                if (this.mActionModePopup != null) {
                    this.mWindow.getDecorView().post(this.mShowActionModePopup);
                }
                this.mActionModeView.sendAccessibilityEvent(32);
                if (this.mActionModeView.getParent() != null) {
                    ViewCompat.requestApplyInsets((View) this.mActionModeView.getParent());
                }
            } else {
                this.mActionMode = null;
            }
        }
        if (!(this.mActionMode == null || this.mAppCompatCallback == null)) {
            this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
    }

    /* access modifiers changed from: package-private */
    public boolean onBackPressed() {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
            return true;
        }
        ActionBar ab = getSupportActionBar();
        if (ab == null || !ab.collapseActionView()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean onKeyShortcut(int keyCode, KeyEvent ev) {
        ActionBar ab = getSupportActionBar();
        if (ab != null && ab.onKeyShortcut(keyCode, ev)) {
            return true;
        }
        if (this.mPreparedPanel == null || !performPanelShortcut(this.mPreparedPanel, ev.getKeyCode(), ev, 1)) {
            if (this.mPreparedPanel == null) {
                PanelFeatureState st = getPanelState(0, true);
                preparePanel(st, ev);
                boolean handled = performPanelShortcut(st, ev.getKeyCode(), ev, 1);
                st.isPrepared = false;
                if (handled) {
                    return true;
                }
            }
            return false;
        } else if (this.mPreparedPanel == null) {
            return true;
        } else {
            this.mPreparedPanel.isHandled = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        return event.getAction() == 0 ? onKeyDown(keyCode, event) : onKeyUp(keyCode, event);
    }

    /* access modifiers changed from: package-private */
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 4:
                PanelFeatureState st = getPanelState(0, false);
                if (st != null && st.isOpen) {
                    closePanel(st, true);
                    return true;
                } else if (onBackPressed()) {
                    return true;
                }
                break;
            case 82:
                onKeyUpPanel(0, event);
                return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 82:
                onKeyDownPanel(0, event);
                return true;
            default:
                if (Build.VERSION.SDK_INT < 11) {
                    return onKeyShortcut(keyCode, event);
                }
                return false;
        }
    }

    public View createView(View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        boolean isPre21;
        boolean inheritContext;
        if (Build.VERSION.SDK_INT < 21) {
            isPre21 = true;
        } else {
            isPre21 = false;
        }
        if (this.mAppCompatViewInflater == null) {
            this.mAppCompatViewInflater = new AppCompatViewInflater(this.mContext);
        }
        if (!isPre21 || !this.mSubDecorInstalled || parent == null || parent.getId() == 16908290) {
            inheritContext = false;
        } else {
            inheritContext = true;
        }
        return this.mAppCompatViewInflater.createView(parent, name, context, attrs, inheritContext, isPre21);
    }

    public void installViewFactory() {
        LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
        if (layoutInflater.getFactory() == null) {
            LayoutInflaterCompat.setFactory(layoutInflater, this);
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = callActivityOnCreateView(parent, name, context, attrs);
        return view != null ? view : createView(parent, name, context, attrs);
    }

    /* access modifiers changed from: package-private */
    public View callActivityOnCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View result;
        if (!(this.mOriginalWindowCallback instanceof LayoutInflater.Factory) || (result = ((LayoutInflater.Factory) this.mOriginalWindowCallback).onCreateView(name, context, attrs)) == null) {
            return null;
        }
        return result;
    }

    private void openPanel(PanelFeatureState st, KeyEvent event) {
        ViewGroup.LayoutParams lp;
        if (!st.isOpen && !isDestroyed()) {
            if (st.featureId == 0) {
                Context context = this.mContext;
                boolean isXLarge = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean isHoneycombApp = context.getApplicationInfo().targetSdkVersion >= 11;
                if (isXLarge && isHoneycombApp) {
                    return;
                }
            }
            Window.Callback cb = getWindowCallback();
            if (cb == null || cb.onMenuOpened(st.featureId, st.menu)) {
                WindowManager wm = (WindowManager) this.mContext.getSystemService("window");
                if (wm != null && preparePanel(st, event)) {
                    int width = -2;
                    if (st.decorView == null || st.refreshDecorView) {
                        if (st.decorView == null) {
                            if (!initializePanelDecor(st) || st.decorView == null) {
                                return;
                            }
                        } else if (st.refreshDecorView && st.decorView.getChildCount() > 0) {
                            st.decorView.removeAllViews();
                        }
                        if (initializePanelContent(st) && st.hasPanelItems()) {
                            ViewGroup.LayoutParams lp2 = st.shownPanelView.getLayoutParams();
                            if (lp2 == null) {
                                lp2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            st.decorView.setBackgroundResource(st.background);
                            ViewParent shownPanelParent = st.shownPanelView.getParent();
                            if (shownPanelParent != null && (shownPanelParent instanceof ViewGroup)) {
                                ((ViewGroup) shownPanelParent).removeView(st.shownPanelView);
                            }
                            st.decorView.addView(st.shownPanelView, lp2);
                            if (!st.shownPanelView.hasFocus()) {
                                st.shownPanelView.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else if (!(st.createdPanelView == null || (lp = st.createdPanelView.getLayoutParams()) == null || lp.width != -1)) {
                        width = -1;
                    }
                    st.isHandled = false;
                    WindowManager.LayoutParams lp3 = new WindowManager.LayoutParams(width, -2, st.f11x, st.f12y, AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE, 8519680, -3);
                    lp3.gravity = st.gravity;
                    lp3.windowAnimations = st.windowAnimations;
                    wm.addView(st.decorView, lp3);
                    st.isOpen = true;
                    return;
                }
                return;
            }
            closePanel(st, true);
        }
    }

    private boolean initializePanelDecor(PanelFeatureState st) {
        st.setStyle(getActionBarThemedContext());
        st.decorView = new ListMenuDecorView(st.listPresenterContext);
        st.gravity = 81;
        return true;
    }

    private void reopenMenu(MenuBuilder menu, boolean toggleMenuMode) {
        if (this.mDecorContentParent == null || !this.mDecorContentParent.canShowOverflowMenu() || (ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext)) && !this.mDecorContentParent.isOverflowMenuShowPending())) {
            PanelFeatureState st = getPanelState(0, true);
            st.refreshDecorView = true;
            closePanel(st, false);
            openPanel(st, (KeyEvent) null);
            return;
        }
        Window.Callback cb = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing() && toggleMenuMode) {
            this.mDecorContentParent.hideOverflowMenu();
            if (!isDestroyed()) {
                cb.onPanelClosed(8, getPanelState(0, true).menu);
            }
        } else if (cb != null && !isDestroyed()) {
            if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
                this.mWindowDecor.removeCallbacks(this.mInvalidatePanelMenuRunnable);
                this.mInvalidatePanelMenuRunnable.run();
            }
            PanelFeatureState st2 = getPanelState(0, true);
            if (st2.menu != null && !st2.refreshMenuContent && cb.onPreparePanel(0, st2.createdPanelView, st2.menu)) {
                cb.onMenuOpened(8, st2.menu);
                this.mDecorContentParent.showOverflowMenu();
            }
        }
    }

    private boolean initializePanelMenu(PanelFeatureState st) {
        Context context = this.mContext;
        if ((st.featureId == 0 || st.featureId == 8) && this.mDecorContentParent != null) {
            TypedValue outValue = new TypedValue();
            Resources.Theme baseTheme = context.getTheme();
            baseTheme.resolveAttribute(C0167R.attr.actionBarTheme, outValue, true);
            Resources.Theme widgetTheme = null;
            if (outValue.resourceId != 0) {
                widgetTheme = context.getResources().newTheme();
                widgetTheme.setTo(baseTheme);
                widgetTheme.applyStyle(outValue.resourceId, true);
                widgetTheme.resolveAttribute(C0167R.attr.actionBarWidgetTheme, outValue, true);
            } else {
                baseTheme.resolveAttribute(C0167R.attr.actionBarWidgetTheme, outValue, true);
            }
            if (outValue.resourceId != 0) {
                if (widgetTheme == null) {
                    widgetTheme = context.getResources().newTheme();
                    widgetTheme.setTo(baseTheme);
                }
                widgetTheme.applyStyle(outValue.resourceId, true);
            }
            if (widgetTheme != null) {
                Context context2 = new ContextThemeWrapper(context, 0);
                context2.getTheme().setTo(widgetTheme);
                context = context2;
            }
        }
        MenuBuilder menu = new MenuBuilder(context);
        menu.setCallback(this);
        st.setMenu(menu);
        return true;
    }

    private boolean initializePanelContent(PanelFeatureState st) {
        if (st.createdPanelView != null) {
            st.shownPanelView = st.createdPanelView;
            return true;
        } else if (st.menu == null) {
            return false;
        } else {
            if (this.mPanelMenuPresenterCallback == null) {
                this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback();
            }
            st.shownPanelView = (View) st.getListMenuView(this.mPanelMenuPresenterCallback);
            if (st.shownPanelView == null) {
                return false;
            }
            return true;
        }
    }

    private boolean preparePanel(PanelFeatureState st, KeyEvent event) {
        boolean isActionBarMenu;
        boolean z;
        if (isDestroyed()) {
            return false;
        }
        if (st.isPrepared) {
            return true;
        }
        if (!(this.mPreparedPanel == null || this.mPreparedPanel == st)) {
            closePanel(this.mPreparedPanel, false);
        }
        Window.Callback cb = getWindowCallback();
        if (cb != null) {
            st.createdPanelView = cb.onCreatePanelView(st.featureId);
        }
        if (st.featureId == 0 || st.featureId == 8) {
            isActionBarMenu = true;
        } else {
            isActionBarMenu = false;
        }
        if (isActionBarMenu && this.mDecorContentParent != null) {
            this.mDecorContentParent.setMenuPrepared();
        }
        if (st.createdPanelView == null) {
            if (st.menu == null || st.refreshMenuContent) {
                if (st.menu == null && (!initializePanelMenu(st) || st.menu == null)) {
                    return false;
                }
                if (isActionBarMenu && this.mDecorContentParent != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
                    }
                    this.mDecorContentParent.setMenu(st.menu, this.mActionMenuPresenterCallback);
                }
                st.menu.stopDispatchingItemsChanged();
                if (!cb.onCreatePanelMenu(st.featureId, st.menu)) {
                    st.setMenu((MenuBuilder) null);
                    if (!isActionBarMenu || this.mDecorContentParent == null) {
                        return false;
                    }
                    this.mDecorContentParent.setMenu((Menu) null, this.mActionMenuPresenterCallback);
                    return false;
                }
                st.refreshMenuContent = false;
            }
            st.menu.stopDispatchingItemsChanged();
            if (st.frozenActionViewState != null) {
                st.menu.restoreActionViewStates(st.frozenActionViewState);
                st.frozenActionViewState = null;
            }
            if (!cb.onPreparePanel(0, st.createdPanelView, st.menu)) {
                if (isActionBarMenu && this.mDecorContentParent != null) {
                    this.mDecorContentParent.setMenu((Menu) null, this.mActionMenuPresenterCallback);
                }
                st.menu.startDispatchingItemsChanged();
                return false;
            }
            if (KeyCharacterMap.load(event != null ? event.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            st.qwertyMode = z;
            st.menu.setQwertyMode(st.qwertyMode);
            st.menu.startDispatchingItemsChanged();
        }
        st.isPrepared = true;
        st.isHandled = false;
        this.mPreparedPanel = st;
        return true;
    }

    /* access modifiers changed from: private */
    public void checkCloseActionMenu(MenuBuilder menu) {
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            this.mDecorContentParent.dismissPopups();
            Window.Callback cb = getWindowCallback();
            if (cb != null && !isDestroyed()) {
                cb.onPanelClosed(8, menu);
            }
            this.mClosingActionMenu = false;
        }
    }

    /* access modifiers changed from: private */
    public void closePanel(int featureId) {
        closePanel(getPanelState(featureId, true), true);
    }

    /* access modifiers changed from: private */
    public void closePanel(PanelFeatureState st, boolean doCallback) {
        if (!doCallback || st.featureId != 0 || this.mDecorContentParent == null || !this.mDecorContentParent.isOverflowMenuShowing()) {
            boolean wasOpen = st.isOpen;
            WindowManager wm = (WindowManager) this.mContext.getSystemService("window");
            if (!(wm == null || !wasOpen || st.decorView == null)) {
                wm.removeView(st.decorView);
            }
            st.isPrepared = false;
            st.isHandled = false;
            st.isOpen = false;
            if (wasOpen && doCallback) {
                callOnPanelClosed(st.featureId, st, (Menu) null);
            }
            st.shownPanelView = null;
            st.refreshDecorView = true;
            if (this.mPreparedPanel == st) {
                this.mPreparedPanel = null;
                return;
            }
            return;
        }
        checkCloseActionMenu(st.menu);
    }

    private boolean onKeyDownPanel(int featureId, KeyEvent event) {
        if (event.getRepeatCount() == 0) {
            PanelFeatureState st = getPanelState(featureId, true);
            if (!st.isOpen) {
                return preparePanel(st, event);
            }
        }
        return false;
    }

    private void onKeyUpPanel(int featureId, KeyEvent event) {
        if (this.mActionMode == null) {
            boolean playSoundEffect = false;
            PanelFeatureState st = getPanelState(featureId, true);
            if (featureId != 0 || this.mDecorContentParent == null || !this.mDecorContentParent.canShowOverflowMenu() || ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext))) {
                if (st.isOpen || st.isHandled) {
                    playSoundEffect = st.isOpen;
                    closePanel(st, true);
                } else if (st.isPrepared) {
                    boolean show = true;
                    if (st.refreshMenuContent) {
                        st.isPrepared = false;
                        show = preparePanel(st, event);
                    }
                    if (show) {
                        openPanel(st, event);
                        playSoundEffect = true;
                    }
                }
            } else if (this.mDecorContentParent.isOverflowMenuShowing()) {
                playSoundEffect = this.mDecorContentParent.hideOverflowMenu();
            } else if (!isDestroyed() && preparePanel(st, event)) {
                playSoundEffect = this.mDecorContentParent.showOverflowMenu();
            }
            if (playSoundEffect) {
                AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                } else {
                    Log.w("AppCompatDelegate", "Couldn't get audio manager");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void callOnPanelClosed(int featureId, PanelFeatureState panel, Menu menu) {
        Window.Callback cb;
        if (menu == null) {
            if (panel == null && featureId >= 0 && featureId < this.mPanels.length) {
                panel = this.mPanels[featureId];
            }
            if (panel != null) {
                menu = panel.menu;
            }
        }
        if ((panel == null || panel.isOpen) && (cb = getWindowCallback()) != null) {
            cb.onPanelClosed(featureId, menu);
        }
    }

    /* access modifiers changed from: private */
    public PanelFeatureState findMenuPanel(Menu menu) {
        PanelFeatureState[] panels = this.mPanels;
        int N = panels != null ? panels.length : 0;
        for (int i = 0; i < N; i++) {
            PanelFeatureState panel = panels[i];
            if (panel != null && panel.menu == menu) {
                return panel;
            }
        }
        return null;
    }

    private PanelFeatureState getPanelState(int featureId, boolean required) {
        PanelFeatureState[] ar = this.mPanels;
        if (ar == null || ar.length <= featureId) {
            PanelFeatureState[] nar = new PanelFeatureState[(featureId + 1)];
            if (ar != null) {
                System.arraycopy(ar, 0, nar, 0, ar.length);
            }
            ar = nar;
            this.mPanels = nar;
        }
        PanelFeatureState st = ar[featureId];
        if (st != null) {
            return st;
        }
        PanelFeatureState st2 = new PanelFeatureState(featureId);
        ar[featureId] = st2;
        return st2;
    }

    private boolean performPanelShortcut(PanelFeatureState st, int keyCode, KeyEvent event, int flags) {
        if (event.isSystem()) {
            return false;
        }
        boolean handled = false;
        if ((st.isPrepared || preparePanel(st, event)) && st.menu != null) {
            handled = st.menu.performShortcut(keyCode, event, flags);
        }
        if (!handled || (flags & 1) != 0 || this.mDecorContentParent != null) {
            return handled;
        }
        closePanel(st, true);
        return handled;
    }

    private void invalidatePanelMenu(int featureId) {
        this.mInvalidatePanelMenuFeatures |= 1 << featureId;
        if (!this.mInvalidatePanelMenuPosted && this.mWindowDecor != null) {
            ViewCompat.postOnAnimation(this.mWindowDecor, this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = true;
        }
    }

    /* access modifiers changed from: private */
    public void doInvalidatePanelMenu(int featureId) {
        PanelFeatureState st;
        PanelFeatureState st2 = getPanelState(featureId, true);
        if (st2.menu != null) {
            Bundle savedActionViewStates = new Bundle();
            st2.menu.saveActionViewStates(savedActionViewStates);
            if (savedActionViewStates.size() > 0) {
                st2.frozenActionViewState = savedActionViewStates;
            }
            st2.menu.stopDispatchingItemsChanged();
            st2.menu.clear();
        }
        st2.refreshMenuContent = true;
        st2.refreshDecorView = true;
        if ((featureId == 8 || featureId == 0) && this.mDecorContentParent != null && (st = getPanelState(0, false)) != null) {
            st.isPrepared = false;
            preparePanel(st, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: private */
    public int updateStatusGuard(int insetTop) {
        int newMargin;
        int i = 0;
        boolean showStatusGuard = false;
        if (this.mActionModeView != null && (this.mActionModeView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) this.mActionModeView.getLayoutParams();
            boolean mlpChanged = false;
            if (this.mActionModeView.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect insets = this.mTempRect1;
                Rect localInsets = this.mTempRect2;
                insets.set(0, insetTop, 0, 0);
                ViewUtils.computeFitSystemWindows(this.mSubDecor, insets, localInsets);
                if (localInsets.top == 0) {
                    newMargin = insetTop;
                } else {
                    newMargin = 0;
                }
                if (mlp.topMargin != newMargin) {
                    mlpChanged = true;
                    mlp.topMargin = insetTop;
                    if (this.mStatusGuard == null) {
                        this.mStatusGuard = new View(this.mContext);
                        this.mStatusGuard.setBackgroundColor(this.mContext.getResources().getColor(C0167R.color.abc_input_method_navigation_guard));
                        this.mSubDecor.addView(this.mStatusGuard, -1, new ViewGroup.LayoutParams(-1, insetTop));
                    } else {
                        ViewGroup.LayoutParams lp = this.mStatusGuard.getLayoutParams();
                        if (lp.height != insetTop) {
                            lp.height = insetTop;
                            this.mStatusGuard.setLayoutParams(lp);
                        }
                    }
                }
                if (this.mStatusGuard != null) {
                    showStatusGuard = true;
                } else {
                    showStatusGuard = false;
                }
                if (!this.mOverlayActionMode && showStatusGuard) {
                    insetTop = 0;
                }
            } else if (mlp.topMargin != 0) {
                mlpChanged = true;
                mlp.topMargin = 0;
            }
            if (mlpChanged) {
                this.mActionModeView.setLayoutParams(mlp);
            }
        }
        if (this.mStatusGuard != null) {
            View view = this.mStatusGuard;
            if (!showStatusGuard) {
                i = 8;
            }
            view.setVisibility(i);
        }
        return insetTop;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* access modifiers changed from: package-private */
    public ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$ActionModeCallbackWrapper */
    class ActionModeCallbackWrapper implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapper(ActionMode.Callback wrapped) {
            this.mWrapped = wrapped;
        }

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return this.mWrapped.onCreateActionMode(mode, menu);
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return this.mWrapped.onPrepareActionMode(mode, menu);
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return this.mWrapped.onActionItemClicked(mode, item);
        }

        public void onDestroyActionMode(ActionMode mode) {
            this.mWrapped.onDestroyActionMode(mode);
            if (AppCompatDelegateImplV7.this.mActionModePopup != null) {
                AppCompatDelegateImplV7.this.mWindow.getDecorView().removeCallbacks(AppCompatDelegateImplV7.this.mShowActionModePopup);
                AppCompatDelegateImplV7.this.mActionModePopup.dismiss();
            } else if (AppCompatDelegateImplV7.this.mActionModeView != null) {
                AppCompatDelegateImplV7.this.mActionModeView.setVisibility(8);
                if (AppCompatDelegateImplV7.this.mActionModeView.getParent() != null) {
                    ViewCompat.requestApplyInsets((View) AppCompatDelegateImplV7.this.mActionModeView.getParent());
                }
            }
            if (AppCompatDelegateImplV7.this.mActionModeView != null) {
                AppCompatDelegateImplV7.this.mActionModeView.removeAllViews();
            }
            if (AppCompatDelegateImplV7.this.mAppCompatCallback != null) {
                AppCompatDelegateImplV7.this.mAppCompatCallback.onSupportActionModeFinished(AppCompatDelegateImplV7.this.mActionMode);
            }
            AppCompatDelegateImplV7.this.mActionMode = null;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelMenuPresenterCallback */
    private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        private PanelMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            MenuBuilder rootMenu = menu.getRootMenu();
            boolean isSubMenu = rootMenu != menu;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (isSubMenu) {
                menu = rootMenu;
            }
            PanelFeatureState panel = appCompatDelegateImplV7.findMenuPanel(menu);
            if (panel == null) {
                return;
            }
            if (isSubMenu) {
                AppCompatDelegateImplV7.this.callOnPanelClosed(panel.featureId, panel, rootMenu);
                AppCompatDelegateImplV7.this.closePanel(panel, true);
                return;
            }
            AppCompatDelegateImplV7.this.closePanel(panel, allMenusAreClosing);
        }

        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            Window.Callback cb;
            if (subMenu != null || !AppCompatDelegateImplV7.this.mHasActionBar || (cb = AppCompatDelegateImplV7.this.getWindowCallback()) == null || AppCompatDelegateImplV7.this.isDestroyed()) {
                return true;
            }
            cb.onMenuOpened(8, subMenu);
            return true;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$ActionMenuPresenterCallback */
    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private ActionMenuPresenterCallback() {
        }

        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            Window.Callback cb = AppCompatDelegateImplV7.this.getWindowCallback();
            if (cb == null) {
                return true;
            }
            cb.onMenuOpened(8, subMenu);
            return true;
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            AppCompatDelegateImplV7.this.checkCloseActionMenu(menu);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState */
    private static final class PanelFeatureState {
        int background;
        View createdPanelView;
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        ListMenuPresenter listMenuPresenter;
        Context listPresenterContext;
        MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView = false;
        boolean refreshMenuContent;
        View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;

        /* renamed from: x */
        int f11x;

        /* renamed from: y */
        int f12y;

        PanelFeatureState(int featureId2) {
            this.featureId = featureId2;
        }

        public boolean hasPanelItems() {
            if (this.shownPanelView == null) {
                return false;
            }
            if (this.createdPanelView != null || this.listMenuPresenter.getAdapter().getCount() > 0) {
                return true;
            }
            return false;
        }

        public void clearMenuPresenters() {
            if (this.menu != null) {
                this.menu.removeMenuPresenter(this.listMenuPresenter);
            }
            this.listMenuPresenter = null;
        }

        /* access modifiers changed from: package-private */
        public void setStyle(Context context) {
            TypedValue outValue = new TypedValue();
            Resources.Theme widgetTheme = context.getResources().newTheme();
            widgetTheme.setTo(context.getTheme());
            widgetTheme.resolveAttribute(C0167R.attr.actionBarPopupTheme, outValue, true);
            if (outValue.resourceId != 0) {
                widgetTheme.applyStyle(outValue.resourceId, true);
            }
            widgetTheme.resolveAttribute(C0167R.attr.panelMenuListTheme, outValue, true);
            if (outValue.resourceId != 0) {
                widgetTheme.applyStyle(outValue.resourceId, true);
            } else {
                widgetTheme.applyStyle(C0167R.style.Theme_AppCompat_CompactMenu, true);
            }
            Context context2 = new ContextThemeWrapper(context, 0);
            context2.getTheme().setTo(widgetTheme);
            this.listPresenterContext = context2;
            TypedArray a = context2.obtainStyledAttributes(C0167R.styleable.Theme);
            this.background = a.getResourceId(C0167R.styleable.Theme_panelBackground, 0);
            this.windowAnimations = a.getResourceId(C0167R.styleable.Theme_android_windowAnimationStyle, 0);
            a.recycle();
        }

        /* access modifiers changed from: package-private */
        public void setMenu(MenuBuilder menu2) {
            if (menu2 != this.menu) {
                if (this.menu != null) {
                    this.menu.removeMenuPresenter(this.listMenuPresenter);
                }
                this.menu = menu2;
                if (menu2 != null && this.listMenuPresenter != null) {
                    menu2.addMenuPresenter(this.listMenuPresenter);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public MenuView getListMenuView(MenuPresenter.Callback cb) {
            if (this.menu == null) {
                return null;
            }
            if (this.listMenuPresenter == null) {
                this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, C0167R.layout.abc_list_menu_item_layout);
                this.listMenuPresenter.setCallback(cb);
                this.menu.addMenuPresenter(this.listMenuPresenter);
            }
            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        /* access modifiers changed from: package-private */
        public Parcelable onSaveInstanceState() {
            SavedState savedState = new SavedState();
            savedState.featureId = this.featureId;
            savedState.isOpen = this.isOpen;
            if (this.menu != null) {
                savedState.menuState = new Bundle();
                this.menu.savePresenterStates(savedState.menuState);
            }
            return savedState;
        }

        /* access modifiers changed from: package-private */
        public void onRestoreInstanceState(Parcelable state) {
            SavedState savedState = (SavedState) state;
            this.featureId = savedState.featureId;
            this.wasLastOpen = savedState.isOpen;
            this.frozenMenuState = savedState.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        /* access modifiers changed from: package-private */
        public void applyFrozenState() {
            if (this.menu != null && this.frozenMenuState != null) {
                this.menu.restorePresenterStates(this.frozenMenuState);
                this.frozenMenuState = null;
            }
        }

        /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState$SavedState */
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
                public SavedState createFromParcel(Parcel in) {
                    return SavedState.readFromParcel(in);
                }

                public SavedState[] newArray(int size) {
                    return new SavedState[size];
                }
            };
            int featureId;
            boolean isOpen;
            Bundle menuState;

            private SavedState() {
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.featureId);
                dest.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    dest.writeBundle(this.menuState);
                }
            }

            /* access modifiers changed from: private */
            public static SavedState readFromParcel(Parcel source) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.featureId = source.readInt();
                if (source.readInt() != 1) {
                    z = false;
                }
                savedState.isOpen = z;
                if (savedState.isOpen) {
                    savedState.menuState = source.readBundle();
                }
                return savedState;
            }
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7$ListMenuDecorView */
    private class ListMenuDecorView extends FrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent event) {
            return AppCompatDelegateImplV7.this.dispatchKeyEvent(event);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            if (event.getAction() != 0 || !isOutOfBounds((int) event.getX(), (int) event.getY())) {
                return super.onInterceptTouchEvent(event);
            }
            AppCompatDelegateImplV7.this.closePanel(0);
            return true;
        }

        public void setBackgroundResource(int resid) {
            setBackgroundDrawable(TintManager.getDrawable(getContext(), resid));
        }

        private boolean isOutOfBounds(int x, int y) {
            return x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5;
        }
    }
}
