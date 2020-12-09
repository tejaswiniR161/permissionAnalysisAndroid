package com.microphone.earspy;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewParent;
import android.widget.RemoteViews;

@RemoteViews.RemoteView
public class VerticalProgressBar extends View {
    private static final int MAX_LEVEL = 10000;
    private Drawable mCurrentDrawable;
    private boolean mInDrawing;
    private int mMax;
    int mMaxHeight;
    int mMaxWidth;
    int mMinHeight;
    int mMinWidth;
    private boolean mNoInvalidate;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;
    protected ViewParent mParent;
    private int mProgress;
    private Drawable mProgressDrawable;
    /* access modifiers changed from: private */
    public RefreshProgressRunnable mRefreshProgressRunnable;
    Bitmap mSampleTile;
    protected int mScrollX;
    protected int mScrollY;
    private int mSecondaryProgress;
    private long mUiThreadId;

    public VerticalProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public VerticalProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 16842871);
    }

    public VerticalProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mUiThreadId = Thread.currentThread().getId();
        initProgressBar();
        TypedArray a = context.obtainStyledAttributes(attrs, C1206R.styleable.ProgressBar, defStyle, 0);
        this.mNoInvalidate = true;
        Drawable drawable = a.getDrawable(5);
        if (drawable != null) {
            setProgressDrawable(tileify(drawable, false));
        }
        this.mMinWidth = a.getDimensionPixelSize(6, this.mMinWidth);
        this.mMaxWidth = a.getDimensionPixelSize(0, this.mMaxWidth);
        this.mMinHeight = a.getDimensionPixelSize(7, this.mMinHeight);
        this.mMaxHeight = a.getDimensionPixelSize(1, this.mMaxHeight);
        setMax(a.getInt(2, this.mMax));
        setProgress(a.getInt(3, this.mProgress));
        setSecondaryProgress(a.getInt(4, this.mSecondaryProgress));
        this.mNoInvalidate = false;
        a.recycle();
    }

    private Drawable tileify(Drawable drawable, boolean clip) {
        if (drawable instanceof LayerDrawable) {
            LayerDrawable background = (LayerDrawable) drawable;
            int N = background.getNumberOfLayers();
            Drawable[] outDrawables = new Drawable[N];
            for (int i = 0; i < N; i++) {
                int id = background.getId(i);
                outDrawables[i] = tileify(background.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable newBg = new LayerDrawable(outDrawables);
            for (int i2 = 0; i2 < N; i2++) {
                newBg.setId(i2, background.getId(i2));
            }
            return newBg;
        } else if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            return new StateListDrawable();
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            Bitmap tileBitmap = ((BitmapDrawable) drawable).getBitmap();
            if (this.mSampleTile == null) {
                this.mSampleTile = tileBitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(getDrawableShape());
            if (clip) {
                shapeDrawable = new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
    }

    /* access modifiers changed from: package-private */
    public Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, (RectF) null, (float[]) null);
    }

    private void initProgressBar() {
        this.mMax = 100;
        this.mProgress = 0;
        this.mSecondaryProgress = 0;
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
    }

    public Drawable getProgressDrawable() {
        return this.mProgressDrawable;
    }

    public void setProgressDrawable(Drawable d) {
        if (d != null) {
            d.setCallback(this);
            int drawableHeight = d.getMinimumHeight();
            if (this.mMaxHeight < drawableHeight) {
                this.mMaxHeight = drawableHeight;
                requestLayout();
            }
        }
        this.mProgressDrawable = d;
        this.mCurrentDrawable = d;
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public Drawable getCurrentDrawable() {
        return this.mCurrentDrawable;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return who == this.mProgressDrawable || super.verifyDrawable(who);
    }

    public void postInvalidate() {
        if (!this.mNoInvalidate) {
            super.postInvalidate();
        }
    }

    private class RefreshProgressRunnable implements Runnable {
        private boolean mFromUser;
        private int mId;
        private int mProgress;

        RefreshProgressRunnable(int id, int progress, boolean fromUser) {
            this.mId = id;
            this.mProgress = progress;
            this.mFromUser = fromUser;
        }

        public void run() {
            VerticalProgressBar.this.doRefreshProgress(this.mId, this.mProgress, this.mFromUser);
            RefreshProgressRunnable unused = VerticalProgressBar.this.mRefreshProgressRunnable = this;
        }

        public void setup(int id, int progress, boolean fromUser) {
            this.mId = id;
            this.mProgress = progress;
            this.mFromUser = fromUser;
        }
    }

    /* access modifiers changed from: private */
    public synchronized void doRefreshProgress(int id, int progress, boolean fromUser) {
        float scale = this.mMax > 0 ? ((float) progress) / ((float) this.mMax) : 0.0f;
        Drawable d = this.mCurrentDrawable;
        if (d != null) {
            Drawable progressDrawable = null;
            if (d instanceof LayerDrawable) {
                progressDrawable = ((LayerDrawable) d).findDrawableByLayerId(id);
            }
            int level = (int) (10000.0f * scale);
            if (progressDrawable == null) {
                progressDrawable = d;
            }
            progressDrawable.setLevel(level);
        } else {
            invalidate();
        }
        if (id == 16908301) {
            onProgressRefresh(scale, fromUser);
        }
    }

    /* access modifiers changed from: package-private */
    public void onProgressRefresh(float scale, boolean fromUser) {
    }

    private synchronized void refreshProgress(int id, int progress, boolean fromUser) {
        RefreshProgressRunnable r;
        if (this.mUiThreadId == Thread.currentThread().getId()) {
            doRefreshProgress(id, progress, fromUser);
        } else {
            if (this.mRefreshProgressRunnable != null) {
                r = this.mRefreshProgressRunnable;
                this.mRefreshProgressRunnable = null;
                r.setup(id, progress, fromUser);
            } else {
                r = new RefreshProgressRunnable(id, progress, fromUser);
            }
            post(r);
        }
    }

    public synchronized void setProgress(int progress) {
        setProgress(progress, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized void setProgress(int progress, boolean fromUser) {
        if (progress < 0) {
            progress = 0;
        }
        if (progress > this.mMax) {
            progress = this.mMax;
        }
        if (progress != this.mProgress) {
            this.mProgress = progress;
            refreshProgress(16908301, this.mProgress, fromUser);
        }
    }

    public synchronized void setSecondaryProgress(int secondaryProgress) {
        if (secondaryProgress < 0) {
            secondaryProgress = 0;
        }
        if (secondaryProgress > this.mMax) {
            secondaryProgress = this.mMax;
        }
        if (secondaryProgress != this.mSecondaryProgress) {
            this.mSecondaryProgress = secondaryProgress;
            refreshProgress(16908303, this.mSecondaryProgress, false);
        }
    }

    @ViewDebug.ExportedProperty
    public synchronized int getProgress() {
        return this.mProgress;
    }

    @ViewDebug.ExportedProperty
    public synchronized int getSecondaryProgress() {
        return this.mSecondaryProgress;
    }

    @ViewDebug.ExportedProperty
    public synchronized int getMax() {
        return this.mMax;
    }

    public synchronized void setMax(int max) {
        if (max < 0) {
            max = 0;
        }
        if (max != this.mMax) {
            this.mMax = max;
            postInvalidate();
            if (this.mProgress > max) {
                this.mProgress = max;
                refreshProgress(16908301, this.mProgress, false);
            }
        }
    }

    public final synchronized void incrementProgressBy(int diff) {
        setProgress(this.mProgress + diff);
    }

    public final synchronized void incrementSecondaryProgressBy(int diff) {
        setSecondaryProgress(this.mSecondaryProgress + diff);
    }

    public void setVisibility(int v) {
        if (getVisibility() != v) {
            super.setVisibility(v);
        }
    }

    public void invalidateDrawable(Drawable dr) {
        if (this.mInDrawing) {
            return;
        }
        if (verifyDrawable(dr)) {
            Rect dirty = dr.getBounds();
            int scrollX = this.mScrollX + this.mPaddingLeft;
            int scrollY = this.mScrollY + this.mPaddingTop;
            invalidate(dirty.left + scrollX, dirty.top + scrollY, dirty.right + scrollX, dirty.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(dr);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        int right = (w - this.mPaddingRight) - this.mPaddingLeft;
        int bottom = (h - this.mPaddingBottom) - this.mPaddingTop;
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.setBounds(0, 0, right, bottom);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable d = this.mCurrentDrawable;
        if (d != null) {
            canvas.save();
            canvas.translate((float) this.mPaddingLeft, (float) this.mPaddingTop);
            d.draw(canvas);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = this.mCurrentDrawable;
        int dw = 0;
        int dh = 0;
        if (d != null) {
            dw = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, d.getIntrinsicWidth()));
            dh = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, d.getIntrinsicHeight()));
        }
        setMeasuredDimension(resolveSize(dw + this.mPaddingLeft + this.mPaddingRight, widthMeasureSpec), resolveSize(dh + this.mPaddingTop + this.mPaddingBottom, heightMeasureSpec));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        if (this.mProgressDrawable != null && this.mProgressDrawable.isStateful()) {
            this.mProgressDrawable.setState(state);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int progress;
        int secondaryProgress;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.progress = in.readInt();
            this.secondaryProgress = in.readInt();
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.progress);
            out.writeInt(this.secondaryProgress);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.progress = this.mProgress;
        ss.secondaryProgress = this.mSecondaryProgress;
        return ss;
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setProgress(ss.progress);
        setSecondaryProgress(ss.secondaryProgress);
    }
}
