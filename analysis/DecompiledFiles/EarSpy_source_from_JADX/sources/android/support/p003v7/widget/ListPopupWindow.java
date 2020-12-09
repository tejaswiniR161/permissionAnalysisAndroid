package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p000v4.text.TextUtilsCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p000v4.widget.ListViewAutoScrollHelper;
import android.support.p000v4.widget.PopupWindowCompat;
import android.support.p003v7.appcompat.C0167R;
import android.support.p003v7.internal.widget.ActivityChooserView;
import android.support.p003v7.internal.widget.AppCompatPopupWindow;
import android.support.p003v7.internal.widget.ListViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.ListPopupWindow */
public class ListPopupWindow {
    private static final boolean DEBUG = false;
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sClipToWindowEnabledMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    /* access modifiers changed from: private */
    public DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private boolean mForceIgnoreOutsideTouch;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private int mLayoutDirection;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    /* access modifiers changed from: private */
    public PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    /* access modifiers changed from: private */
    public final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        try {
            sClipToWindowEnabledMethod = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, C0167R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, C0167R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs, C0167R.styleable.ListPopupWindow, defStyleAttr, defStyleRes);
        this.mDropDownHorizontalOffset = a.getDimensionPixelOffset(C0167R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.mDropDownVerticalOffset = a.getDimensionPixelOffset(C0167R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.mDropDownVerticalOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        a.recycle();
        this.mPopup = new AppCompatPopupWindow(context, attrs, defStyleAttr);
        this.mPopup.setInputMethodMode(1);
        this.mLayoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
    }

    public void setAdapter(ListAdapter adapter) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = adapter;
        if (this.mAdapter != null) {
            adapter.registerDataSetObserver(this.mObserver);
        }
        if (this.mDropDownList != null) {
            this.mDropDownList.setAdapter(this.mAdapter);
        }
    }

    public void setPromptPosition(int position) {
        this.mPromptPosition = position;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public void setModal(boolean modal) {
        this.mModal = modal;
        this.mPopup.setFocusable(modal);
    }

    public boolean isModal() {
        return this.mModal;
    }

    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        this.mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
    }

    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        this.mDropDownAlwaysVisible = dropDownAlwaysVisible;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public void setSoftInputMode(int mode) {
        this.mPopup.setSoftInputMode(mode);
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public void setListSelector(Drawable selector) {
        this.mDropDownListHighlight = selector;
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public void setBackgroundDrawable(Drawable d) {
        this.mPopup.setBackgroundDrawable(d);
    }

    public void setAnimationStyle(int animationStyle) {
        this.mPopup.setAnimationStyle(animationStyle);
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public void setAnchorView(View anchor) {
        this.mDropDownAnchorView = anchor;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public void setHorizontalOffset(int offset) {
        this.mDropDownHorizontalOffset = offset;
    }

    public int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    public void setVerticalOffset(int offset) {
        this.mDropDownVerticalOffset = offset;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setDropDownGravity(int gravity) {
        this.mDropDownGravity = gravity;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public void setWidth(int width) {
        this.mDropDownWidth = width;
    }

    public void setContentWidth(int width) {
        Drawable popupBackground = this.mPopup.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(this.mTempRect);
            this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + width;
            return;
        }
        setWidth(width);
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public void setHeight(int height) {
        this.mDropDownHeight = height;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        this.mItemClickListener = clickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener selectedListener) {
        this.mItemSelectedListener = selectedListener;
    }

    public void setPromptView(View prompt) {
        boolean showing = isShowing();
        if (showing) {
            removePromptView();
        }
        this.mPromptView = prompt;
        if (showing) {
            show();
        }
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void show() {
        int widthSpec;
        int heightSpec;
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int height = buildDropDown();
        int widthSpec2 = 0;
        int heightSpec2 = 0;
        boolean noInputMethod = isInputMethodNotNeeded();
        if (this.mPopup.isShowing()) {
            if (this.mDropDownWidth == -1) {
                widthSpec = -1;
            } else if (this.mDropDownWidth == -2) {
                widthSpec = getAnchorView().getWidth();
            } else {
                widthSpec = this.mDropDownWidth;
            }
            if (this.mDropDownHeight == -1) {
                if (noInputMethod) {
                    heightSpec = height;
                } else {
                    heightSpec = -1;
                }
                if (noInputMethod) {
                    PopupWindow popupWindow = this.mPopup;
                    if (this.mDropDownWidth != -1) {
                        i = 0;
                    }
                    popupWindow.setWindowLayoutMode(i, 0);
                } else {
                    this.mPopup.setWindowLayoutMode(this.mDropDownWidth == -1 ? -1 : 0, -1);
                }
            } else if (this.mDropDownHeight == -2) {
                heightSpec = height;
            } else {
                heightSpec = this.mDropDownHeight;
            }
            PopupWindow popupWindow2 = this.mPopup;
            if (!this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            this.mPopup.update(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, widthSpec, heightSpec);
            return;
        }
        if (this.mDropDownWidth == -1) {
            widthSpec2 = -1;
        } else if (this.mDropDownWidth == -2) {
            this.mPopup.setWidth(getAnchorView().getWidth());
        } else {
            this.mPopup.setWidth(this.mDropDownWidth);
        }
        if (this.mDropDownHeight == -1) {
            heightSpec2 = -1;
        } else if (this.mDropDownHeight == -2) {
            this.mPopup.setHeight(height);
        } else {
            this.mPopup.setHeight(this.mDropDownHeight);
        }
        this.mPopup.setWindowLayoutMode(widthSpec2, heightSpec2);
        setPopupClipToScreenEnabled(true);
        PopupWindow popupWindow3 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            z = false;
        }
        popupWindow3.setOutsideTouchable(z);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if (!this.mModal || this.mDropDownList.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.mModal) {
            this.mHandler.post(this.mHideSelector);
        }
    }

    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView((View) null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        this.mPopup.setOnDismissListener(listener);
    }

    private void removePromptView() {
        if (this.mPromptView != null) {
            ViewParent parent = this.mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    public void setInputMethodMode(int mode) {
        this.mPopup.setInputMethodMode(mode);
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public void setSelection(int position) {
        DropDownListView list = this.mDropDownList;
        if (isShowing() && list != null) {
            boolean unused = list.mListSelectionHidden = false;
            list.setSelection(position);
            if (Build.VERSION.SDK_INT >= 11 && list.getChoiceMode() != 0) {
                list.setItemChecked(position, true);
            }
        }
    }

    public void clearListSelection() {
        DropDownListView list = this.mDropDownList;
        if (list != null) {
            boolean unused = list.mListSelectionHidden = true;
            list.requestLayout();
        }
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    public boolean performItemClick(int position) {
        if (!isShowing()) {
            return false;
        }
        if (this.mItemClickListener != null) {
            DropDownListView list = this.mDropDownList;
            int i = position;
            this.mItemClickListener.onItemClick(list, list.getChildAt(position - list.getFirstVisiblePosition()), i, list.getAdapter().getItemId(position));
        }
        return true;
    }

    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedItem();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.mDropDownList.getSelectedItemPosition();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.mDropDownList.getSelectedItemId();
    }

    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedView();
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    /* access modifiers changed from: package-private */
    public void setListItemExpandMax(int max) {
        this.mListItemExpandMaximum = max;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean below;
        if (isShowing() && keyCode != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(keyCode))) {
            int curIndex = this.mDropDownList.getSelectedItemPosition();
            if (!this.mPopup.isAboveAnchor()) {
                below = true;
            } else {
                below = false;
            }
            ListAdapter adapter = this.mAdapter;
            int firstItem = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int lastItem = Integer.MIN_VALUE;
            if (adapter != null) {
                boolean allEnabled = adapter.areAllItemsEnabled();
                firstItem = allEnabled ? 0 : this.mDropDownList.lookForSelectablePosition(0, true);
                if (allEnabled) {
                    lastItem = adapter.getCount() - 1;
                } else {
                    lastItem = this.mDropDownList.lookForSelectablePosition(adapter.getCount() - 1, false);
                }
            }
            if ((!below || keyCode != 19 || curIndex > firstItem) && (below || keyCode != 20 || curIndex < lastItem)) {
                boolean unused = this.mDropDownList.mListSelectionHidden = false;
                if (this.mDropDownList.onKeyDown(keyCode, event)) {
                    this.mPopup.setInputMethodMode(2);
                    this.mDropDownList.requestFocusFromTouch();
                    show();
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 23:
                        case 66:
                            return true;
                    }
                } else if (!below || keyCode != 20) {
                    if (!below && keyCode == 19 && curIndex == firstItem) {
                        return true;
                    }
                } else if (curIndex == lastItem) {
                    return true;
                }
            } else {
                clearListSelection();
                this.mPopup.setInputMethodMode(1);
                show();
                return true;
            }
        }
        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (!isShowing() || this.mDropDownList.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean consumed = this.mDropDownList.onKeyUp(keyCode, event);
        if (!consumed || !isConfirmKey(keyCode)) {
            return consumed;
        }
        dismiss();
        return consumed;
    }

    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == 4 && isShowing()) {
            View anchorView = this.mDropDownAnchorView;
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                KeyEvent.DispatcherState state = anchorView.getKeyDispatcherState();
                if (state == null) {
                    return true;
                }
                state.startTracking(event, this);
                return true;
            } else if (event.getAction() == 1) {
                KeyEvent.DispatcherState state2 = anchorView.getKeyDispatcherState();
                if (state2 != null) {
                    state2.handleUpEvent(event);
                }
                if (event.isTracking() && !event.isCanceled()) {
                    dismiss();
                    return true;
                }
            }
        }
        return false;
    }

    public View.OnTouchListener createDragToOpenListener(View src) {
        return new ForwardingListener(src) {
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: android.support.v7.widget.ListPopupWindow$DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: android.support.v7.widget.ListPopupWindow$DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: android.support.v7.widget.ListPopupWindow$DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int buildDropDown() {
        /*
            r21 = this;
            r17 = 0
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            if (r1 != 0) goto L_0x0161
            r0 = r21
            android.content.Context r8 = r0.mContext
            android.support.v7.widget.ListPopupWindow$2 r1 = new android.support.v7.widget.ListPopupWindow$2
            r0 = r21
            r1.<init>()
            r0 = r21
            r0.mShowDropDownRunnable = r1
            android.support.v7.widget.ListPopupWindow$DropDownListView r3 = new android.support.v7.widget.ListPopupWindow$DropDownListView
            r0 = r21
            boolean r1 = r0.mModal
            if (r1 != 0) goto L_0x014e
            r1 = 1
        L_0x0020:
            r3.<init>(r8, r1)
            r0 = r21
            r0.mDropDownList = r3
            r0 = r21
            android.graphics.drawable.Drawable r1 = r0.mDropDownListHighlight
            if (r1 == 0) goto L_0x0038
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.graphics.drawable.Drawable r3 = r0.mDropDownListHighlight
            r1.setSelector(r3)
        L_0x0038:
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.widget.ListAdapter r3 = r0.mAdapter
            r1.setAdapter(r3)
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.widget.AdapterView$OnItemClickListener r3 = r0.mItemClickListener
            r1.setOnItemClickListener(r3)
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r3 = 1
            r1.setFocusable(r3)
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r3 = 1
            r1.setFocusableInTouchMode(r3)
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            android.support.v7.widget.ListPopupWindow$3 r3 = new android.support.v7.widget.ListPopupWindow$3
            r0 = r21
            r3.<init>()
            r1.setOnItemSelectedListener(r3)
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.support.v7.widget.ListPopupWindow$PopupScrollListener r3 = r0.mScrollListener
            r1.setOnScrollListener(r3)
            r0 = r21
            android.widget.AdapterView$OnItemSelectedListener r1 = r0.mItemSelectedListener
            if (r1 == 0) goto L_0x0088
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.widget.AdapterView$OnItemSelectedListener r3 = r0.mItemSelectedListener
            r1.setOnItemSelectedListener(r3)
        L_0x0088:
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r9 = r0.mDropDownList
            r0 = r21
            android.view.View r13 = r0.mPromptView
            if (r13 == 0) goto L_0x00e9
            android.widget.LinearLayout r11 = new android.widget.LinearLayout
            r11.<init>(r8)
            r1 = 1
            r11.setOrientation(r1)
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            r1 = -1
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r12.<init>(r1, r3, r4)
            r0 = r21
            int r1 = r0.mPromptPosition
            switch(r1) {
                case 0: goto L_0x0159;
                case 1: goto L_0x0151;
                default: goto L_0x00ab;
            }
        L_0x00ab:
            java.lang.String r1 = "ListPopupWindow"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Invalid hint position "
            java.lang.StringBuilder r3 = r3.append(r4)
            r0 = r21
            int r4 = r0.mPromptPosition
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r1, r3)
        L_0x00c7:
            r0 = r21
            int r1 = r0.mDropDownWidth
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            int r20 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r3)
            r10 = 0
            r0 = r20
            r13.measure(r0, r10)
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r12 = (android.widget.LinearLayout.LayoutParams) r12
            int r1 = r13.getMeasuredHeight()
            int r3 = r12.topMargin
            int r1 = r1 + r3
            int r3 = r12.bottomMargin
            int r17 = r1 + r3
            r9 = r11
        L_0x00e9:
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            r1.setContentView(r9)
        L_0x00f0:
            r18 = 0
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            android.graphics.drawable.Drawable r7 = r1.getBackground()
            if (r7 == 0) goto L_0x0186
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            r7.getPadding(r1)
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            int r1 = r1.top
            r0 = r21
            android.graphics.Rect r3 = r0.mTempRect
            int r3 = r3.bottom
            int r18 = r1 + r3
            r0 = r21
            boolean r1 = r0.mDropDownVerticalOffsetSet
            if (r1 != 0) goto L_0x0122
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            int r1 = r1.top
            int r1 = -r1
            r0 = r21
            r0.mDropDownVerticalOffset = r1
        L_0x0122:
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            int r1 = r1.getInputMethodMode()
            r3 = 2
            if (r1 != r3) goto L_0x018e
            r14 = 1
        L_0x012e:
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            android.view.View r3 = r21.getAnchorView()
            r0 = r21
            int r4 = r0.mDropDownVerticalOffset
            int r16 = r1.getMaxAvailableHeight(r3, r4)
            r0 = r21
            boolean r1 = r0.mDropDownAlwaysVisible
            if (r1 != 0) goto L_0x014b
            r0 = r21
            int r1 = r0.mDropDownHeight
            r3 = -1
            if (r1 != r3) goto L_0x0190
        L_0x014b:
            int r1 = r16 + r18
        L_0x014d:
            return r1
        L_0x014e:
            r1 = 0
            goto L_0x0020
        L_0x0151:
            r11.addView(r9, r12)
            r11.addView(r13)
            goto L_0x00c7
        L_0x0159:
            r11.addView(r13)
            r11.addView(r9, r12)
            goto L_0x00c7
        L_0x0161:
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            android.view.View r9 = r1.getContentView()
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            r0 = r21
            android.view.View r0 = r0.mPromptView
            r19 = r0
            if (r19 == 0) goto L_0x00f0
            android.view.ViewGroup$LayoutParams r12 = r19.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r12 = (android.widget.LinearLayout.LayoutParams) r12
            int r1 = r19.getMeasuredHeight()
            int r3 = r12.topMargin
            int r1 = r1 + r3
            int r3 = r12.bottomMargin
            int r17 = r1 + r3
            goto L_0x00f0
        L_0x0186:
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            r1.setEmpty()
            goto L_0x0122
        L_0x018e:
            r14 = 0
            goto L_0x012e
        L_0x0190:
            r0 = r21
            int r1 = r0.mDropDownWidth
            switch(r1) {
                case -2: goto L_0x01b5;
                case -1: goto L_0x01d8;
                default: goto L_0x0197;
            }
        L_0x0197:
            r0 = r21
            int r1 = r0.mDropDownWidth
            r3 = 1073741824(0x40000000, float:2.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r3)
        L_0x01a1:
            r0 = r21
            android.support.v7.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r3 = 0
            r4 = -1
            int r5 = r16 - r17
            r6 = -1
            int r15 = r1.measureHeightOfChildrenCompat(r2, r3, r4, r5, r6)
            if (r15 <= 0) goto L_0x01b2
            int r17 = r17 + r18
        L_0x01b2:
            int r1 = r15 + r17
            goto L_0x014d
        L_0x01b5:
            r0 = r21
            android.content.Context r1 = r0.mContext
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r1 = r1.widthPixels
            r0 = r21
            android.graphics.Rect r3 = r0.mTempRect
            int r3 = r3.left
            r0 = r21
            android.graphics.Rect r4 = r0.mTempRect
            int r4 = r4.right
            int r3 = r3 + r4
            int r1 = r1 - r3
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r3)
            goto L_0x01a1
        L_0x01d8:
            r0 = r21
            android.content.Context r1 = r0.mContext
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r1 = r1.widthPixels
            r0 = r21
            android.graphics.Rect r3 = r0.mTempRect
            int r3 = r3.left
            r0 = r21
            android.graphics.Rect r4 = r0.mTempRect
            int r4 = r4.right
            int r3 = r3 + r4
            int r1 = r1 - r3
            r3 = 1073741824(0x40000000, float:2.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r3)
            goto L_0x01a1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.widget.ListPopupWindow.buildDropDown():int");
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$ForwardingListener */
    public static abstract class ForwardingListener implements View.OnTouchListener {
        private int mActivePointerId;
        private Runnable mDisallowIntercept;
        private boolean mForwarding;
        private final int mLongPressTimeout;
        private final float mScaledTouchSlop;
        /* access modifiers changed from: private */
        public final View mSrc;
        private final int mTapTimeout;
        private final int[] mTmpLocation = new int[2];
        private Runnable mTriggerLongPress;
        private boolean mWasLongPress;

        public abstract ListPopupWindow getPopup();

        public ForwardingListener(View src) {
            this.mSrc = src;
            this.mScaledTouchSlop = (float) ViewConfiguration.get(src.getContext()).getScaledTouchSlop();
            this.mTapTimeout = ViewConfiguration.getTapTimeout();
            this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        public boolean onTouch(View v, MotionEvent event) {
            boolean forwarding;
            boolean wasForwarding = this.mForwarding;
            if (!wasForwarding) {
                if (!onTouchObserved(event) || !onForwardingStarted()) {
                    forwarding = false;
                } else {
                    forwarding = true;
                }
                if (forwarding) {
                    long now = SystemClock.uptimeMillis();
                    MotionEvent e = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
                    this.mSrc.onTouchEvent(e);
                    e.recycle();
                }
            } else if (this.mWasLongPress) {
                forwarding = onTouchForwarded(event);
            } else {
                forwarding = onTouchForwarded(event) || !onForwardingStopped();
            }
            this.mForwarding = forwarding;
            if (forwarding || wasForwarding) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStarted() {
            ListPopupWindow popup = getPopup();
            if (popup == null || popup.isShowing()) {
                return true;
            }
            popup.show();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStopped() {
            ListPopupWindow popup = getPopup();
            if (popup == null || !popup.isShowing()) {
                return true;
            }
            popup.dismiss();
            return true;
        }

        private boolean onTouchObserved(MotionEvent srcEvent) {
            View src = this.mSrc;
            if (!src.isEnabled()) {
                return false;
            }
            switch (MotionEventCompat.getActionMasked(srcEvent)) {
                case 0:
                    this.mActivePointerId = srcEvent.getPointerId(0);
                    this.mWasLongPress = false;
                    if (this.mDisallowIntercept == null) {
                        this.mDisallowIntercept = new DisallowIntercept();
                    }
                    src.postDelayed(this.mDisallowIntercept, (long) this.mTapTimeout);
                    if (this.mTriggerLongPress == null) {
                        this.mTriggerLongPress = new TriggerLongPress();
                    }
                    src.postDelayed(this.mTriggerLongPress, (long) this.mLongPressTimeout);
                    return false;
                case 1:
                case 3:
                    clearCallbacks();
                    return false;
                case 2:
                    int activePointerIndex = srcEvent.findPointerIndex(this.mActivePointerId);
                    if (activePointerIndex < 0 || pointInView(src, srcEvent.getX(activePointerIndex), srcEvent.getY(activePointerIndex), this.mScaledTouchSlop)) {
                        return false;
                    }
                    clearCallbacks();
                    src.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        private void clearCallbacks() {
            if (this.mTriggerLongPress != null) {
                this.mSrc.removeCallbacks(this.mTriggerLongPress);
            }
            if (this.mDisallowIntercept != null) {
                this.mSrc.removeCallbacks(this.mDisallowIntercept);
            }
        }

        /* access modifiers changed from: private */
        public void onLongPress() {
            clearCallbacks();
            View src = this.mSrc;
            if (src.isEnabled() && !src.isLongClickable() && onForwardingStarted()) {
                src.getParent().requestDisallowInterceptTouchEvent(true);
                long now = SystemClock.uptimeMillis();
                MotionEvent e = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
                src.onTouchEvent(e);
                e.recycle();
                this.mForwarding = true;
                this.mWasLongPress = true;
            }
        }

        private boolean onTouchForwarded(MotionEvent srcEvent) {
            DropDownListView dst;
            boolean keepForwarding;
            boolean z = true;
            View src = this.mSrc;
            ListPopupWindow popup = getPopup();
            if (popup == null || !popup.isShowing() || (dst = popup.mDropDownList) == null || !dst.isShown()) {
                return false;
            }
            MotionEvent dstEvent = MotionEvent.obtainNoHistory(srcEvent);
            toGlobalMotionEvent(src, dstEvent);
            toLocalMotionEvent(dst, dstEvent);
            boolean handled = dst.onForwardedEvent(dstEvent, this.mActivePointerId);
            dstEvent.recycle();
            int action = MotionEventCompat.getActionMasked(srcEvent);
            if (action == 1 || action == 3) {
                keepForwarding = false;
            } else {
                keepForwarding = true;
            }
            if (!handled || !keepForwarding) {
                z = false;
            }
            return z;
        }

        private static boolean pointInView(View view, float localX, float localY, float slop) {
            return localX >= (-slop) && localY >= (-slop) && localX < ((float) (view.getRight() - view.getLeft())) + slop && localY < ((float) (view.getBottom() - view.getTop())) + slop;
        }

        private boolean toLocalMotionEvent(View view, MotionEvent event) {
            int[] loc = this.mTmpLocation;
            view.getLocationOnScreen(loc);
            event.offsetLocation((float) (-loc[0]), (float) (-loc[1]));
            return true;
        }

        private boolean toGlobalMotionEvent(View view, MotionEvent event) {
            int[] loc = this.mTmpLocation;
            view.getLocationOnScreen(loc);
            event.offsetLocation((float) loc[0], (float) loc[1]);
            return true;
        }

        /* renamed from: android.support.v7.widget.ListPopupWindow$ForwardingListener$DisallowIntercept */
        private class DisallowIntercept implements Runnable {
            private DisallowIntercept() {
            }

            public void run() {
                ForwardingListener.this.mSrc.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* renamed from: android.support.v7.widget.ListPopupWindow$ForwardingListener$TriggerLongPress */
        private class TriggerLongPress implements Runnable {
            private TriggerLongPress() {
            }

            public void run() {
                ForwardingListener.this.onLongPress();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$DropDownListView */
    private static class DropDownListView extends ListViewCompat {
        private ViewPropertyAnimatorCompat mClickAnimation;
        private boolean mDrawsInPressedState;
        private boolean mHijackFocus;
        /* access modifiers changed from: private */
        public boolean mListSelectionHidden;
        private ListViewAutoScrollHelper mScrollHelper;

        public DropDownListView(Context context, boolean hijackFocus) {
            super(context, (AttributeSet) null, C0167R.attr.dropDownListViewStyle);
            this.mHijackFocus = hijackFocus;
            setCacheColorHint(0);
        }

        public boolean onForwardedEvent(MotionEvent event, int activePointerId) {
            boolean handledEvent = true;
            boolean clearPressedItem = false;
            int actionMasked = MotionEventCompat.getActionMasked(event);
            switch (actionMasked) {
                case 1:
                    handledEvent = false;
                    break;
                case 2:
                    break;
                case 3:
                    handledEvent = false;
                    break;
            }
            int activeIndex = event.findPointerIndex(activePointerId);
            if (activeIndex < 0) {
                handledEvent = false;
            } else {
                int x = (int) event.getX(activeIndex);
                int y = (int) event.getY(activeIndex);
                int position = pointToPosition(x, y);
                if (position == -1) {
                    clearPressedItem = true;
                } else {
                    View child = getChildAt(position - getFirstVisiblePosition());
                    setPressedItem(child, position, (float) x, (float) y);
                    handledEvent = true;
                    if (actionMasked == 1) {
                        clickPressedItem(child, position);
                    }
                }
            }
            if (!handledEvent || clearPressedItem) {
                clearPressedItem();
            }
            if (handledEvent) {
                if (this.mScrollHelper == null) {
                    this.mScrollHelper = new ListViewAutoScrollHelper(this);
                }
                this.mScrollHelper.setEnabled(true);
                this.mScrollHelper.onTouch(this, event);
            } else if (this.mScrollHelper != null) {
                this.mScrollHelper.setEnabled(false);
            }
            return handledEvent;
        }

        private void clickPressedItem(View child, int position) {
            performItemClick(child, position, getItemIdAtPosition(position));
        }

        private void clearPressedItem() {
            this.mDrawsInPressedState = false;
            setPressed(false);
            drawableStateChanged();
            if (this.mClickAnimation != null) {
                this.mClickAnimation.cancel();
                this.mClickAnimation = null;
            }
        }

        private void setPressedItem(View child, int position, float x, float y) {
            this.mDrawsInPressedState = true;
            setPressed(true);
            layoutChildren();
            setSelection(position);
            positionSelectorLikeTouchCompat(position, child, x, y);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        /* access modifiers changed from: protected */
        public boolean touchModeDrawsInPressedStateCompat() {
            return this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat();
        }

        public boolean isInTouchMode() {
            return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
        }

        public boolean hasWindowFocus() {
            return this.mHijackFocus || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.mHijackFocus || super.isFocused();
        }

        public boolean hasFocus() {
            return this.mHijackFocus || super.hasFocus();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$PopupDataSetObserver */
    private class PopupDataSetObserver extends DataSetObserver {
        private PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$ListSelectorHider */
    private class ListSelectorHider implements Runnable {
        private ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$ResizePopupRunnable */
    private class ResizePopupRunnable implements Runnable {
        private ResizePopupRunnable() {
        }

        public void run() {
            if (ListPopupWindow.this.mDropDownList != null && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
                ListPopupWindow.this.mPopup.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$PopupTouchInterceptor */
    private class PopupTouchInterceptor implements View.OnTouchListener {
        private PopupTouchInterceptor() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (action == 0 && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && x >= 0 && x < ListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < ListPopupWindow.this.mPopup.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                return false;
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow$PopupScrollListener */
    private class PopupScrollListener implements AbsListView.OnScrollListener {
        private PopupScrollListener() {
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }

    private static boolean isConfirmKey(int keyCode) {
        return keyCode == 66 || keyCode == 23;
    }

    private void setPopupClipToScreenEnabled(boolean clip) {
        if (sClipToWindowEnabledMethod != null) {
            try {
                sClipToWindowEnabledMethod.invoke(this.mPopup, new Object[]{Boolean.valueOf(clip)});
            } catch (Exception e) {
                Log.i(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }
}
