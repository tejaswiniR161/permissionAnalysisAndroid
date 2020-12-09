package android.support.p000v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperLollipop */
class DrawableWrapperLollipop extends DrawableWrapperKitKat {
    DrawableWrapperLollipop(Drawable drawable) {
        super(drawable);
    }

    public void setHotspot(float x, float y) {
        this.mDrawable.setHotspot(x, y);
    }

    public void setHotspotBounds(int left, int top, int right, int bottom) {
        this.mDrawable.setHotspotBounds(left, top, right, bottom);
    }

    public void getOutline(Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    public void applyTheme(Resources.Theme t) {
        this.mDrawable.applyTheme(t);
    }

    public boolean canApplyTheme() {
        return this.mDrawable.canApplyTheme();
    }

    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }
}
