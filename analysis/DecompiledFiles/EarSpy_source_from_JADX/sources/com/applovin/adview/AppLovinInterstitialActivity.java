package com.applovin.adview;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.view.ViewCompat;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.C0260af;
import com.applovin.impl.adview.C0285s;
import com.applovin.impl.adview.C0287u;
import com.applovin.impl.adview.C0289w;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.C0348ca;
import com.applovin.impl.sdk.C0382dh;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.UUID;

public class AppLovinInterstitialActivity extends Activity implements C0289w {
    public static final String KEY_WRAPPER_ID = "com.applovin.interstitial.wrapper_id";
    public static volatile C0260af lastKnownWrapper = null;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public View f17A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public C0285s f18B;

    /* renamed from: C */
    private volatile UUID f19C;

    /* renamed from: D */
    private ImageView f20D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public WeakReference f21E = new WeakReference((Object) null);

    /* renamed from: a */
    private AppLovinAdView f22a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0260af f23b;

    /* renamed from: c */
    private volatile boolean f24c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppLovinLogger f25d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0348ca f26e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AppLovinSdkImpl f27f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile AppLovinAdImpl f28g = C0382dh.m581a();

    /* renamed from: h */
    private volatile boolean f29h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f30i = false;

    /* renamed from: j */
    private volatile boolean f31j = false;

    /* renamed from: k */
    private volatile boolean f32k = false;

    /* renamed from: l */
    private volatile boolean f33l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public volatile boolean f34m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public volatile boolean f35n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public volatile boolean f36o = false;

    /* renamed from: p */
    private volatile boolean f37p = false;

    /* renamed from: q */
    private boolean f38q = false;

    /* renamed from: r */
    private volatile boolean f39r = false;

    /* renamed from: s */
    private boolean f40s = false;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f41t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Handler f42u;

    /* renamed from: v */
    private FrameLayout f43v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public AppLovinVideoView f44w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public C0287u f45x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public View f46y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public C0287u f47z;

    /* renamed from: a */
    private static int m21a(Display display) {
        if (display.getWidth() == display.getHeight()) {
            return 3;
        }
        return display.getWidth() < display.getHeight() ? 1 : 2;
    }

    /* renamed from: a */
    private void m25a(int i) {
        m38b((int) (((float) i) - C0382dh.m578a(1.0f)));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26a(int i, UUID uuid) {
        if (this.f18B != null && uuid.equals(this.f19C)) {
            if (i <= 0) {
                this.f18B.setVisibility(8);
                this.f40s = true;
            } else if (!this.f40s) {
                int i2 = i - 1;
                this.f18B.mo5290a(i2);
                this.f42u.postDelayed(new C0240h(this, i2, uuid), 1000);
            }
        }
    }

    /* renamed from: a */
    private void m27a(long j, C0287u uVar) {
        this.f42u.postDelayed(new C0239g(this, uVar), j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30a(AppLovinAd appLovinAd) {
        AppLovinAdDisplayListener d = this.f23b.mo5234d();
        if (d != null) {
            d.adDisplayed(appLovinAd);
        }
        this.f30i = true;
    }

    /* renamed from: a */
    private void m31a(AppLovinAd appLovinAd, double d, boolean z) {
        this.f33l = true;
        AppLovinAdVideoPlaybackListener c = this.f23b.mo5233c();
        if (c != null) {
            c.videoPlaybackEnded(appLovinAd, d, z);
        }
    }

    /* renamed from: a */
    private void m32a(boolean z) {
        this.f39r = z;
        MediaPlayer mediaPlayer = (MediaPlayer) this.f21E.get();
        if (mediaPlayer != null) {
            int i = z ? 0 : 1;
            mediaPlayer.setVolume((float) i, (float) i);
        }
    }

    /* renamed from: a */
    private boolean m33a() {
        if (this.f23b == null || this.f26e == null || this.f26e.mo5569a()) {
            return true;
        }
        if (!this.f26e.mo5571c() || !this.f35n) {
            return this.f26e.mo5570b() && this.f37p;
        }
        return true;
    }

    /* renamed from: b */
    private void m37b() {
        SharedPreferences.Editor edit = m88x().edit();
        edit.putBoolean("com.applovin.interstitial.should_resume_video", false);
        edit.putInt("com.applovin.interstitial.last_video_position", 0);
        edit.commit();
    }

    /* renamed from: b */
    private void m38b(int i) {
        m26a(i, this.f19C);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40b(AppLovinAd appLovinAd) {
        m45c(appLovinAd);
        dismiss();
    }

    /* renamed from: c */
    private int m42c(int i) {
        return AppLovinSdkUtils.dpToPx(this, i);
    }

    /* renamed from: c */
    private void m44c() {
        Uri fromFile = Uri.fromFile(this.f27f.getFileManager().mo5695a(this.f28g.getVideoFilename(), (Context) this, false));
        this.f44w = new AppLovinVideoView(this);
        this.f44w.setOnPreparedListener(new C0234b(this));
        this.f44w.setOnCompletionListener(new C0243k(this));
        this.f44w.setOnErrorListener(new C0244l(this));
        this.f44w.setVideoURI(fromFile);
        this.f44w.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.f44w.setOnTouchListener(new AppLovinTouchToClickListener(this, new C0246n(this)));
        this.f43v.addView(this.f44w);
        setContentView(this.f43v);
        m67m();
    }

    /* renamed from: c */
    private void m45c(AppLovinAd appLovinAd) {
        AppLovinAdDisplayListener d;
        if (!this.f31j) {
            this.f31j = true;
            if (this.f23b != null && (d = this.f23b.mo5234d()) != null) {
                d.adHidden(appLovinAd);
            }
        }
    }

    /* renamed from: d */
    private void m48d(AppLovinAd appLovinAd) {
        if (!this.f32k) {
            this.f32k = true;
            AppLovinAdVideoPlaybackListener c = this.f23b.mo5233c();
            if (c != null) {
                c.videoPlaybackBegan(appLovinAd);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m49d() {
        return this.f26e.mo5563G();
    }

    /* renamed from: e */
    private void m51e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f43v = new FrameLayout(this);
        this.f43v.setLayoutParams(layoutParams);
        this.f43v.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f42u = new Handler();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m52f() {
        if (this.f26e.mo5579k()) {
            finish();
        } else {
            m60j();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m54g() {
        m48d((AppLovinAd) this.f28g);
        this.f44w.start();
        m38b(m70o());
    }

    /* renamed from: h */
    private void m56h() {
        int i = 3;
        this.f45x = C0287u.m181a(this.f27f, this, this.f28g.getCloseStyle());
        this.f45x.setVisibility(8);
        this.f45x.setOnClickListener(new C0248p(this));
        int c = m42c(this.f26e.mo5581m());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c, c, (this.f26e.mo5592x() ? 3 : 5) | 48);
        this.f45x.mo5246a(c);
        int c2 = m42c(this.f26e.mo5583o());
        int c3 = m42c(this.f26e.mo5585q());
        layoutParams.setMargins(c3, c2, c3, c2);
        this.f43v.addView(this.f45x, layoutParams);
        this.f47z = C0287u.m181a(this.f27f, this, this.f28g.getCloseStyle());
        this.f47z.setVisibility(8);
        this.f47z.setOnClickListener(new C0249q(this));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(c, c, (this.f26e.mo5591w() ? 3 : 5) | 48);
        layoutParams2.setMargins(c3, c2, c3, c2);
        this.f47z.mo5246a(c);
        this.f43v.addView(this.f47z, layoutParams2);
        this.f47z.bringToFront();
        if (m63k()) {
            int c4 = m42c(new C0348ca(this.f27f).mo5586r());
            this.f46y = new View(this);
            this.f46y.setBackgroundColor(0);
            this.f46y.setVisibility(8);
            this.f17A = new View(this);
            this.f17A.setBackgroundColor(0);
            this.f17A.setVisibility(8);
            int i2 = c + c4;
            int c5 = c2 - m42c(5);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i2, i2, (this.f26e.mo5592x() ? 3 : 5) | 48);
            layoutParams3.setMargins(c5, c5, c5, c5);
            if (!this.f26e.mo5591w()) {
                i = 5;
            }
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i2, i2, i | 48);
            layoutParams4.setMargins(c5, c5, c5, c5);
            this.f46y.setOnClickListener(new C0250r(this));
            this.f17A.setOnClickListener(new C0251s(this));
            this.f43v.addView(this.f46y, layoutParams3);
            this.f46y.bringToFront();
            this.f43v.addView(this.f17A, layoutParams4);
            this.f17A.bringToFront();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m58i() {
        this.f20D = new ImageView(this);
        if (!this.f26e.mo5557A()) {
            return;
        }
        if (m49d() || this.f26e.mo5558B()) {
            int c = m42c(this.f26e.mo5559C());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c, c, this.f26e.mo5560D());
            this.f20D.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int c2 = m42c(this.f26e.mo5561E());
            layoutParams.setMargins(c2, c2, c2, c2);
            this.f27f.getLogger().mo5665d("AppLovinInterstitialActivity", "Added mute button with params: " + layoutParams);
            AppLovinSdkUtils.safePopulateImageView(this.f20D, Uri.fromFile(this.f27f.getFileManager().mo5695a(m49d() ? this.f28g.getMuteImageFilename() : this.f28g.getUnmuteImageFilename(), (Context) this, true)), c);
            this.f20D.setClickable(true);
            this.f20D.setOnClickListener(new C0252t(this));
            this.f43v.addView(this.f20D, layoutParams);
            this.f20D.bringToFront();
            this.f39r = m49d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m60j() {
        runOnUiThread(new C0237e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean m63k() {
        return this.f26e.mo5586r() > 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m65l() {
        runOnUiThread(new C0238f(this));
    }

    /* renamed from: m */
    private void m67m() {
        if (this.f28g.getVideoCloseDelay() >= 0.0f) {
            m27a(C0382dh.m589c(this.f28g.getVideoCloseDelay()), (!this.f38q || this.f47z == null) ? this.f45x : this.f47z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m68n() {
        if (this.f18B == null) {
            this.f18B = new C0285s(this);
            int q = m74q();
            this.f18B.mo5295c(q);
            this.f18B.mo5292b((float) this.f26e.mo5576h());
            this.f18B.mo5297d(q);
            this.f18B.mo5289a((float) this.f26e.mo5575g());
            this.f18B.mo5293b(m70o());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m42c(this.f26e.mo5574f()), m42c(this.f26e.mo5574f()), this.f26e.mo5590v());
            int c = m42c(this.f26e.mo5589u());
            layoutParams.setMargins(c, c, c, c);
            this.f43v.addView(this.f18B, layoutParams);
            this.f18B.bringToFront();
            this.f18B.setVisibility((!this.f26e.mo5577i() || m70o() <= 0) ? 4 : 0);
        }
    }

    /* renamed from: o */
    private int m70o() {
        int countdownLength = this.f28g.getCountdownLength();
        return (countdownLength <= 0 && this.f26e.mo5588t()) ? this.f41t + 1 : countdownLength;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m73p() {
        this.f19C = UUID.randomUUID();
    }

    /* renamed from: q */
    private int m74q() {
        return Color.parseColor(this.f26e.mo5572d());
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m76r() {
        m81t();
    }

    /* renamed from: s */
    private void m78s() {
        if (this.f24c) {
            return;
        }
        if (this.f22a != null) {
            this.f22a.setAdDisplayListener(new C0241i(this));
            this.f22a.setAdClickListener(new C0242j(this));
            this.f28g = (AppLovinAdImpl) this.f23b.mo5232b();
            m51e();
            m56h();
            if (this.f28g.getVideoFilename() != null) {
                m44c();
            } else {
                this.f29h = true;
                this.f27f.getLogger().mo5666e("AppLovinInterstitialActivity", "Video file was missing or null - please make sure your app has the WRITE_EXTERNAL_STORAGE permission!");
                m81t();
            }
            this.f45x.bringToFront();
            if (m63k() && this.f46y != null) {
                this.f46y.bringToFront();
            }
            if (this.f47z != null) {
                this.f47z.bringToFront();
            }
            this.f22a.renderAd(this.f28g);
            this.f23b.mo5231a(true);
            return;
        }
        exitWithError("AdView was null");
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m81t() {
        m86w();
        this.f44w.stopPlayback();
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(-1157627904);
        frameLayout.addView(this.f22a);
        if (this.f47z != null) {
            this.f43v.removeView(this.f47z);
            if (this.f17A != null) {
                this.f43v.removeView(this.f17A);
            }
        }
        if (m63k() && this.f46y != null) {
            this.f43v.removeView(this.f46y);
            frameLayout.addView(this.f46y);
            this.f46y.bringToFront();
        }
        this.f43v.removeView(this.f45x);
        frameLayout.addView(this.f45x);
        setContentView(frameLayout);
        this.f45x.bringToFront();
        if (this.f28g.getPoststitialCloseDelay() > 0.0f) {
            m27a(C0382dh.m589c(this.f28g.getPoststitialCloseDelay()), this.f45x);
        } else {
            this.f45x.setVisibility(0);
        }
        this.f37p = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m82u() {
        boolean z = !m85v();
        m32a(z);
        AppLovinSdkUtils.safePopulateImageView(this.f20D, Uri.fromFile(this.f27f.getFileManager().mo5695a(z ? this.f28g.getMuteImageFilename() : this.f28g.getUnmuteImageFilename(), (Context) this, true)), m42c(this.f26e.mo5559C()));
    }

    /* renamed from: v */
    private boolean m85v() {
        return this.f39r;
    }

    /* renamed from: w */
    private void m86w() {
        double d = 100.0d;
        if (!this.f33l) {
            if (!this.f34m) {
                if (this.f44w != null) {
                    d = 100.0d * (((double) this.f44w.getCurrentPosition()) / ((double) this.f44w.getDuration()));
                } else {
                    Log.e("AppLovinInterstitialActivity", "No video view detected on video end");
                    d = 0.0d;
                }
            }
            this.f27f.getPostbackService().dispatchPostbackAsync(this.f28g.getParametrizedCompletionUrl((int) d), (AppLovinPostbackListener) null);
            m31a((AppLovinAd) this.f28g, d, d > 95.0d);
        }
    }

    /* renamed from: x */
    private SharedPreferences m88x() {
        return getSharedPreferences("com.applovin.interstitial.sharedpreferences", 0);
    }

    public void dismiss() {
        ((AdViewControllerImpl) this.f22a.getAdViewController()).setIsForegroundClickInvalidated(true);
        m37b();
        m86w();
        if (this.f23b != null) {
            if (this.f28g != null) {
                m45c((AppLovinAd) this.f28g);
            }
            this.f23b.mo5231a(false);
            this.f23b.mo5237g();
        }
        finish();
    }

    public void exitWithError(String str) {
        try {
            Log.e("AppLovinInterstitialActivity", "Failed to properly render an Interstitial Activity, due to error: " + str, new Throwable("Initialized = " + C0260af.f124a + "; CleanedUp = " + C0260af.f125b));
            m45c((AppLovinAd) C0382dh.m581a());
        } catch (Exception e) {
            Log.e("AppLovinInterstitialActivity", "Failed to show a video ad due to error:", e);
        }
        finish();
    }

    public void onBackPressed() {
        if (m33a()) {
            this.f25d.mo5665d("AppLovinInterstitialActivity", "Back button was pressed; forwarding to Android for handling...");
            super.onBackPressed();
            return;
        }
        try {
            if (this.f38q && this.f47z != null && this.f47z.getVisibility() == 0 && this.f47z.getAlpha() > 0.0f && !this.f35n) {
                this.f25d.mo5665d("AppLovinInterstitialActivity", "Back button was pressed; forwarding as a click to skip button.");
                this.f47z.performClick();
            } else if (this.f45x == null || this.f45x.getVisibility() != 0 || this.f45x.getAlpha() <= 0.0f) {
                this.f25d.mo5665d("AppLovinInterstitialActivity", "Back button was pressed, but was not eligible for dismissal.");
            } else {
                this.f25d.mo5665d("AppLovinInterstitialActivity", "Back button was pressed; forwarding as a click to close button.");
                this.f45x.performClick();
            }
        } catch (Exception e) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        try {
            getWindow().setFlags(1024, 1024);
        } catch (Throwable th) {
        }
        requestWindowFeature(1);
        String stringExtra = getIntent().getStringExtra(KEY_WRAPPER_ID);
        if (stringExtra == null || stringExtra.isEmpty()) {
            exitWithError("Wrapper ID is null");
        } else {
            this.f23b = C0260af.m115a(stringExtra);
            if (this.f23b == null && lastKnownWrapper != null) {
                this.f23b = lastKnownWrapper;
            }
            if (this.f23b != null) {
                AppLovinAd b = this.f23b.mo5232b();
                this.f27f = (AppLovinSdkImpl) this.f23b.mo5229a();
                this.f25d = this.f23b.mo5229a().getLogger();
                this.f26e = new C0348ca(this.f23b.mo5229a());
                if (b != null) {
                    Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
                    int a = m21a(defaultDisplay);
                    int rotation = defaultDisplay.getRotation();
                    boolean z = (a == 2 && rotation == 0) || (a == 2 && rotation == 2) || ((a == 1 && rotation == 1) || (a == 1 && rotation == 3));
                    if (this.f23b.mo5236f() == AppLovinAdImpl.AdTarget.ACTIVITY_PORTRAIT) {
                        if (z) {
                            if (!(rotation == 1 || rotation == 3)) {
                                this.f24c = true;
                                setRequestedOrientation(1);
                            }
                        } else if (!(rotation == 0 || rotation == 2)) {
                            this.f24c = true;
                            setRequestedOrientation(1);
                        }
                    } else if (z) {
                        if (!(rotation == 0 || rotation == 2)) {
                            this.f24c = true;
                            setRequestedOrientation(0);
                        }
                    } else if (!(rotation == 1 || rotation == 3)) {
                        this.f24c = true;
                        setRequestedOrientation(0);
                    }
                    this.f22a = new AppLovinAdView((AppLovinSdk) this.f27f, AppLovinAdSize.INTERSTITIAL, (Activity) this);
                    this.f22a.setAutoDestroy(false);
                    this.f23b.mo5230a((C0289w) this);
                    this.f38q = this.f26e.mo5587s();
                } else {
                    exitWithError("No current ad found.");
                }
            } else {
                exitWithError("Wrapper is null; initialized state: " + Boolean.toString(C0260af.f124a));
            }
        }
        SharedPreferences.Editor edit = m88x().edit();
        edit.putBoolean("com.applovin.interstitial.should_resume_video", false);
        edit.commit();
        m37b();
        m78s();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f22a != null) {
                this.f22a.destroy();
            }
            if (this.f44w != null) {
                this.f44w.pause();
                this.f44w.stopPlayback();
            }
        } catch (Throwable th) {
            this.f25d.mo5672w("AppLovinInterstitialActivity", "Unable to destroy video view", th);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (!this.f24c && !this.f29h) {
            SharedPreferences.Editor edit = m88x().edit();
            edit.putInt("com.applovin.interstitial.last_video_position", this.f44w.getCurrentPosition());
            edit.putBoolean("com.applovin.interstitial.should_resume_video", true);
            edit.commit();
            this.f44w.pause();
        }
        this.f23b.mo5231a(false);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f23b.mo5231a(true);
        SharedPreferences x = m88x();
        if (x.getBoolean("com.applovin.interstitial.should_resume_video", false)) {
            if (this.f44w != null) {
                int duration = this.f44w.getDuration();
                int i = x.getInt("com.applovin.interstitial.last_video_position", duration);
                m73p();
                this.f44w.seekTo(i);
                this.f44w.start();
                m25a(duration - i);
            }
            if (this.f45x == null || !this.f26e.mo5578j()) {
                dismiss();
                return;
            }
            this.f25d.mo5665d("AppLovinInterstitialActivity", "Fading in close button due to app resume.");
            m27a(0, (!this.f38q || this.f47z == null) ? this.f45x : this.f47z);
        }
    }
}
