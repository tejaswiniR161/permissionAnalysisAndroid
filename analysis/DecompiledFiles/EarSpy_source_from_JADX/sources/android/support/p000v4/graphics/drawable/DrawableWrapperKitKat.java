package android.support.p000v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.graphics.drawable.DrawableWrapperKitKat */
class DrawableWrapperKitKat extends DrawableWrapperHoneycomb {
    DrawableWrapperKitKat(Drawable drawable) {
        super(drawable);
    }

    public void setAutoMirrored(boolean mirrored) {
        this.mDrawable.setAutoMirrored(mirrored);
    }

    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }
}
