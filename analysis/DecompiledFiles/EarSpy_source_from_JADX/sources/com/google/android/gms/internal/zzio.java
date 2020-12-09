package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzke;

@zziy
@TargetApi(19)
public class zzio extends zzim {
    private Object zzcde = new Object();
    private PopupWindow zzcdf;
    private boolean zzcdg = false;

    zzio(Context context, zzke.zza zza, zzlt zzlt, zzil.zza zza2) {
        super(context, zza, zzlt, zza2);
    }

    private void zzrc() {
        synchronized (this.zzcde) {
            this.zzcdg = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzcdf = null;
            }
            if (this.zzcdf != null) {
                if (this.zzcdf.isShowing()) {
                    this.zzcdf.dismiss();
                }
                this.zzcdf = null;
            }
        }
    }

    public void cancel() {
        zzrc();
        super.cancel();
    }

    /* access modifiers changed from: protected */
    public void zzal(int i) {
        zzrc();
        super.zzal(i);
    }

    /* access modifiers changed from: protected */
    public void zzrb() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.mContext).isDestroyed()) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.addView(this.zzbkr.getView(), -1, -1);
            synchronized (this.zzcde) {
                if (!this.zzcdg) {
                    this.zzcdf = new PopupWindow(frameLayout, 1, 1, false);
                    this.zzcdf.setOutsideTouchable(true);
                    this.zzcdf.setClippingEnabled(false);
                    zzkn.zzdd("Displaying the 1x1 popup off the screen.");
                    try {
                        this.zzcdf.showAtLocation(window.getDecorView(), 0, -1, -1);
                    } catch (Exception e) {
                        this.zzcdf = null;
                    }
                }
            }
        }
    }
}
