package com.facebook.ads.internal.view.video.support;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: com.facebook.ads.internal.view.video.support.a */
public class C0600a extends FrameLayout {

    /* renamed from: a */
    private C0605e f1395a;

    /* renamed from: b */
    private C0606f f1396b;

    /* renamed from: c */
    private View f1397c;

    /* renamed from: d */
    private Uri f1398d;

    /* renamed from: e */
    private Context f1399e;

    public C0600a(Context context) {
        super(context);
        this.f1399e = context;
        this.f1397c = m1345b(context);
        this.f1395a = m1344a(context);
        addView(this.f1397c);
    }

    /* renamed from: a */
    private C0605e m1344a(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.f1396b = C0606f.TEXTURE_VIEW;
            C0604d dVar = new C0604d(context);
            dVar.mo6228a(this.f1397c, this.f1398d);
            addView(dVar);
            return dVar;
        }
        this.f1396b = C0606f.VIDEO_VIEW;
        C0607g gVar = new C0607g(context);
        addView(gVar);
        return gVar;
    }

    /* renamed from: b */
    private View m1345b(Context context) {
        View view = new View(context);
        view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return view;
    }

    /* renamed from: a */
    public void mo6219a() {
        this.f1395a.start();
    }

    /* renamed from: b */
    public void mo6220b() {
        this.f1395a.pause();
    }

    public int getCurrentPosition() {
        return this.f1395a.getCurrentPosition();
    }

    public View getPlaceholderView() {
        return this.f1397c;
    }

    public C0606f getVideoImplType() {
        return this.f1396b;
    }

    public void setFrameVideoViewListener(C0602b bVar) {
        this.f1395a.setFrameVideoViewListener(bVar);
    }

    public void setVideoImpl(C0606f fVar) {
        removeAllViews();
        if (fVar == C0606f.TEXTURE_VIEW && Build.VERSION.SDK_INT < 14) {
            fVar = C0606f.VIDEO_VIEW;
        }
        this.f1396b = fVar;
        switch (fVar) {
            case TEXTURE_VIEW:
                C0604d dVar = new C0604d(this.f1399e);
                dVar.mo6228a(this.f1397c, this.f1398d);
                addView(dVar);
                this.f1395a = dVar;
                break;
            case VIDEO_VIEW:
                C0607g gVar = new C0607g(this.f1399e);
                gVar.mo6228a(this.f1397c, this.f1398d);
                addView(gVar);
                this.f1395a = gVar;
                break;
        }
        addView(this.f1397c);
        mo6219a();
    }

    public void setup(Uri uri) {
        this.f1398d = uri;
        this.f1395a.mo6228a(this.f1397c, uri);
    }
}
