package com.microphone.earspy;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class AbsVerticalSeekBar extends VerticalProgressBar {
    private static final int NO_ALPHA = 255;
    private float mDisabledAlpha;
    boolean mIsUserSeekable = true;
    private int mKeyProgressIncrement = 1;
    private Drawable mThumb;
    private int mThumbOffset;
    float mTouchProgressOffset;

    public AbsVerticalSeekBar(Context context) {
        super(context);
    }

    public AbsVerticalSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AbsVerticalSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, C1206R.styleable.SeekBar, defStyle, 0);
        setThumb(a.getDrawable(0));
        setThumbOffset(a.getDimensionPixelOffset(1, getThumbOffset()));
        a.recycle();
        TypedArray a2 = context.obtainStyledAttributes(attrs, C1206R.styleable.Theme, 0, 0);
        this.mDisabledAlpha = a2.getFloat(0, 0.5f);
        a2.recycle();
    }

    public void setThumb(Drawable thumb) {
        if (thumb != null) {
            thumb.setCallback(this);
            this.mThumbOffset = thumb.getIntrinsicHeight() / 2;
        }
        this.mThumb = thumb;
        invalidate();
    }

    public int getThumbOffset() {
        return this.mThumbOffset;
    }

    public void setThumbOffset(int thumbOffset) {
        this.mThumbOffset = thumbOffset;
        invalidate();
    }

    public void setKeyProgressIncrement(int increment) {
        if (increment < 0) {
            increment = -increment;
        }
        this.mKeyProgressIncrement = increment;
    }

    public int getKeyProgressIncrement() {
        return this.mKeyProgressIncrement;
    }

    public synchronized void setMax(int max) {
        super.setMax(max);
        if (this.mKeyProgressIncrement == 0 || getMax() / this.mKeyProgressIncrement > 20) {
            setKeyProgressIncrement(Math.max(1, Math.round(((float) getMax()) / 20.0f)));
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return who == this.mThumb || super.verifyDrawable(who);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setAlpha(isEnabled() ? 255 : (int) (255.0f * this.mDisabledAlpha));
        }
        if (this.mThumb != null && this.mThumb.isStateful()) {
            this.mThumb.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    public void onProgressRefresh(float scale, boolean fromUser) {
        Drawable thumb = this.mThumb;
        if (thumb != null) {
            setThumbPos(getHeight(), thumb, scale, Integer.MIN_VALUE);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        Drawable d = getCurrentDrawable();
        Drawable thumb = this.mThumb;
        int thumbWidth = thumb == null ? 0 : thumb.getIntrinsicWidth();
        int trackWidth = Math.min(this.mMaxWidth, (w - this.mPaddingRight) - this.mPaddingLeft);
        int max = getMax();
        float scale = max > 0 ? ((float) getProgress()) / ((float) max) : 0.0f;
        if (thumbWidth > trackWidth) {
            int gapForCenteringTrack = (thumbWidth - trackWidth) / 28;
            if (thumb != null) {
                setThumbPos(h, thumb, scale, gapForCenteringTrack * -1);
            }
            if (d != null) {
                d.setBounds(gapForCenteringTrack, 0, ((w - this.mPaddingRight) - this.mPaddingLeft) - gapForCenteringTrack, (h - this.mPaddingBottom) - this.mPaddingTop);
                return;
            }
            return;
        }
        if (d != null) {
            d.setBounds(0, 0, (w - this.mPaddingRight) - this.mPaddingLeft, (h - this.mPaddingBottom) - this.mPaddingTop);
        }
        int gap = (trackWidth - thumbWidth) / 2;
        if (thumb != null) {
            setThumbPos(h, thumb, scale, gap);
        }
    }

    private void setThumbPos(int h, Drawable thumb, float scale, int gap) {
        int leftBound;
        int rightBound;
        int thumbWidth = thumb.getIntrinsicWidth();
        int thumbHeight = thumb.getIntrinsicHeight();
        int thumbPos = (int) ((1.0f - scale) * ((float) ((((h - this.mPaddingTop) - this.mPaddingBottom) - thumbHeight) + (this.mThumbOffset * 2))));
        if (gap == Integer.MIN_VALUE) {
            Rect oldBounds = thumb.getBounds();
            leftBound = oldBounds.left;
            rightBound = oldBounds.right;
        } else {
            leftBound = gap;
            rightBound = gap + thumbWidth;
        }
        thumb.setBounds(leftBound, thumbPos, rightBound, thumbPos + thumbHeight);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mThumb != null) {
            canvas.save();
            canvas.translate((float) this.mPaddingLeft, (float) (this.mPaddingTop - this.mThumbOffset));
            this.mThumb.draw(canvas);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = getCurrentDrawable();
        int thumbWidth = this.mThumb == null ? 0 : this.mThumb.getIntrinsicWidth();
        int dw = 0;
        int dh = 0;
        if (d != null) {
            int dw2 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, d.getIntrinsicWidth()));
            dw = Math.max(thumbWidth, 0);
            dh = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, d.getIntrinsicHeight()));
        }
        setMeasuredDimension(resolveSize(dw + this.mPaddingLeft + this.mPaddingRight, widthMeasureSpec), resolveSize(dh + this.mPaddingTop + this.mPaddingBottom, heightMeasureSpec));
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!this.mIsUserSeekable || !isEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case 0:
                setPressed(true);
                onStartTrackingTouch();
                trackTouchEvent(event);
                return true;
            case 1:
                trackTouchEvent(event);
                onStopTrackingTouch();
                setPressed(false);
                invalidate();
                return true;
            case 2:
                trackTouchEvent(event);
                attemptClaimDrag();
                return true;
            case 3:
                onStopTrackingTouch();
                setPressed(false);
                invalidate();
                return true;
            default:
                return true;
        }
    }

    private void trackTouchEvent(MotionEvent event) {
        float scale;
        int height = getHeight();
        int available = (height - this.mPaddingTop) - this.mPaddingBottom;
        int y = height - ((int) event.getY());
        float progress = 0.0f;
        if (y < this.mPaddingBottom) {
            scale = 0.0f;
        } else if (y > height - this.mPaddingTop) {
            scale = 1.0f;
        } else {
            scale = ((float) (y - this.mPaddingBottom)) / ((float) available);
            progress = this.mTouchProgressOffset;
        }
        setProgress((int) (progress + (((float) getMax()) * scale)), true);
    }

    private void attemptClaimDrag() {
        if (this.mParent != null) {
            this.mParent.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void onStartTrackingTouch() {
    }

    /* access modifiers changed from: package-private */
    public void onStopTrackingTouch() {
    }

    /* access modifiers changed from: package-private */
    public void onKeyChange() {
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int progress = getProgress();
        switch (keyCode) {
            case 19:
                if (progress < getMax()) {
                    setProgress(this.mKeyProgressIncrement + progress, true);
                    onKeyChange();
                    return true;
                }
                break;
            case 20:
                if (progress > 0) {
                    setProgress(progress - this.mKeyProgressIncrement, true);
                    onKeyChange();
                    return true;
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
