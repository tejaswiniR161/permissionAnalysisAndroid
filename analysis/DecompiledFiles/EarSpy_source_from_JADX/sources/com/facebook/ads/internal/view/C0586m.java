package com.facebook.ads.internal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.internal.view.C0580h;

/* renamed from: com.facebook.ads.internal.view.m */
public class C0586m implements C0580h {

    /* renamed from: a */
    private C0577g f1361a;

    public C0586m(InterstitialAdActivity interstitialAdActivity, C0580h.C0581a aVar) {
        this.f1361a = new C0577g(interstitialAdActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        this.f1361a.setLayoutParams(layoutParams);
        aVar.mo5785a((View) this.f1361a);
    }

    /* renamed from: a */
    public void mo6164a() {
    }

    /* renamed from: a */
    public void mo6165a(Intent intent, Bundle bundle) {
        String stringExtra = intent.getStringExtra(InterstitialAdActivity.VIDEO_URL);
        String stringExtra2 = intent.getStringExtra(InterstitialAdActivity.VIDEO_PLAY_REPORT_URL);
        String stringExtra3 = intent.getStringExtra(InterstitialAdActivity.VIDEO_TIME_REPORT_URL);
        this.f1361a.setVideoPlayReportURI(stringExtra2);
        this.f1361a.setVideoTimeReportURI(stringExtra3);
        this.f1361a.setVideoURI(stringExtra);
        this.f1361a.mo6169a();
    }

    /* renamed from: a */
    public void mo6166a(Bundle bundle) {
    }

    /* renamed from: b */
    public void mo6167b() {
    }

    /* renamed from: c */
    public void mo6168c() {
        this.f1361a.mo6170b();
    }
}
