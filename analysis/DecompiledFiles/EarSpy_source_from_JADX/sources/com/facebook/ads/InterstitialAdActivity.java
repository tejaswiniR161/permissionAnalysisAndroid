package com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p000v4.content.LocalBroadcastManager;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.C0479g;
import com.facebook.ads.internal.view.C0574f;
import com.facebook.ads.internal.view.C0580h;
import com.facebook.ads.internal.view.C0586m;

public class InterstitialAdActivity extends Activity {
    public static final String PREDEFINED_ORIENTATION_KEY = "predefinedOrientationKey";
    public static final String VIDEO_PLAY_REPORT_URL = "videoPlayReportURL";
    public static final String VIDEO_TIME_REPORT_URL = "videoTimeReportURL";
    public static final String VIDEO_URL = "videoURL";
    public static final String VIEW_TYPE = "viewType";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RelativeLayout f771a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0479g f772b;

    /* renamed from: c */
    private int f773c = -1;

    /* renamed from: d */
    private String f774d;

    /* renamed from: e */
    private C0580h f775e;

    public enum Type {
        DISPLAY,
        VIDEO
    }

    /* renamed from: a */
    private void m732a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.f773c = bundle.getInt(PREDEFINED_ORIENTATION_KEY, -1);
            this.f774d = bundle.getString("adInterstitialUniqueId");
            this.f775e.mo6165a(intent, bundle);
            return;
        }
        this.f773c = intent.getIntExtra(PREDEFINED_ORIENTATION_KEY, -1);
        this.f774d = intent.getStringExtra("adInterstitialUniqueId");
        this.f775e.mo6165a(intent, bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m734a(String str) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(str + ":" + this.f774d));
    }

    public void finish() {
        this.f771a.removeAllViews();
        this.f775e.mo6168c();
        m734a("com.facebook.ads.interstitial.dismissed");
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.f771a = new RelativeLayout(this);
        this.f771a.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        setContentView(this.f771a, new RelativeLayout.LayoutParams(-1, -1));
        Intent intent = getIntent();
        if (intent.getBooleanExtra("useNativeCloseButton", false)) {
            this.f772b = new C0479g(this);
            this.f772b.setId(100002);
            this.f772b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    InterstitialAdActivity.this.finish();
                }
            });
        }
        switch ((Type) intent.getSerializableExtra(VIEW_TYPE)) {
            case VIDEO:
                this.f775e = new C0586m(this, new C0580h.C0581a() {
                    /* renamed from: a */
                    public void mo5785a(View view) {
                        InterstitialAdActivity.this.f771a.addView(view);
                        if (InterstitialAdActivity.this.f772b != null) {
                            InterstitialAdActivity.this.f771a.addView(InterstitialAdActivity.this.f772b);
                        }
                    }

                    /* renamed from: a */
                    public void mo5786a(String str) {
                        InterstitialAdActivity.this.m734a(str);
                    }
                });
                break;
            default:
                this.f775e = new C0574f(this, new C0580h.C0581a() {
                    /* renamed from: a */
                    public void mo5785a(View view) {
                        InterstitialAdActivity.this.f771a.addView(view);
                        if (InterstitialAdActivity.this.f772b != null) {
                            InterstitialAdActivity.this.f771a.addView(InterstitialAdActivity.this.f772b);
                        }
                    }

                    /* renamed from: a */
                    public void mo5786a(String str) {
                        InterstitialAdActivity.this.m734a(str);
                    }
                });
                break;
        }
        m732a(intent, bundle);
        m734a("com.facebook.ads.interstitial.displayed");
    }

    public void onPause() {
        super.onPause();
        this.f775e.mo6164a();
    }

    public void onRestart() {
        super.onRestart();
    }

    public void onResume() {
        super.onResume();
        this.f775e.mo6167b();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f775e.mo6166a(bundle);
        bundle.putInt(PREDEFINED_ORIENTATION_KEY, this.f773c);
        bundle.putString("adInterstitialUniqueId", this.f774d);
    }

    public void onStart() {
        super.onStart();
        if (this.f773c != -1) {
            setRequestedOrientation(this.f773c);
        }
    }

    public void setRequestedOrientation(int i) {
        super.setRequestedOrientation(i);
    }
}
