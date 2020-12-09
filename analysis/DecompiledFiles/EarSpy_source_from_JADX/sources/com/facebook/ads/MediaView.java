package com.facebook.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.util.C0544k;
import com.facebook.ads.internal.util.C0553r;
import com.facebook.ads.internal.view.C0573e;
import com.facebook.ads.internal.view.video.C0589a;

public class MediaView extends RelativeLayout {

    /* renamed from: a */
    private final C0573e f781a;

    /* renamed from: b */
    private final C0589a f782b;

    /* renamed from: c */
    private boolean f783c;

    /* renamed from: d */
    private boolean f784d;

    public MediaView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f783c = false;
        this.f784d = true;
        this.f781a = new C0573e(context);
        this.f781a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f781a);
        this.f782b = new C0589a(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f782b.setLayoutParams(layoutParams);
        this.f782b.setAutoplay(this.f784d);
        addView(this.f782b);
    }

    /* renamed from: a */
    private boolean m740a(NativeAd nativeAd) {
        return !C0553r.m1245a(nativeAd.mo5790a());
    }

    public boolean isAutoplay() {
        return this.f784d;
    }

    public void setAutoplay(boolean z) {
        this.f784d = z;
        this.f782b.setAutoplay(z);
    }

    public void setNativeAd(NativeAd nativeAd) {
        nativeAd.mo5794b(true);
        nativeAd.setMediaViewAutoplay(this.f784d);
        if (this.f783c) {
            this.f781a.mo6162a((Bitmap) null, (Bitmap) null);
            this.f782b.mo6194b();
            this.f783c = false;
        }
        if (m740a(nativeAd)) {
            this.f781a.setVisibility(4);
            this.f782b.setVisibility(0);
            bringChildToFront(this.f782b);
            this.f783c = true;
            try {
                this.f782b.setVideoPlayReportURI(nativeAd.mo5793b());
                this.f782b.setVideoTimeReportURI(nativeAd.mo5795c());
                this.f782b.setVideoURI(nativeAd.mo5790a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (nativeAd.getAdCoverImage() != null) {
            this.f782b.mo6193a();
            this.f782b.setVisibility(4);
            this.f781a.setVisibility(0);
            bringChildToFront(this.f781a);
            this.f783c = true;
            new C0544k(this.f781a).execute(new String[]{nativeAd.getAdCoverImage().getUrl()});
        }
    }
}
