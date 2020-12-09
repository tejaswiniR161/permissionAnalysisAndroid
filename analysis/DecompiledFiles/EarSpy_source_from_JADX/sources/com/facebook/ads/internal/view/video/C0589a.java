package com.facebook.ads.internal.view.video;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.NativeAdVideoActivity;
import com.facebook.ads.internal.adapters.C0441d;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0531c;
import com.facebook.ads.internal.util.C0550o;
import com.facebook.ads.internal.util.C0555t;
import com.facebook.ads.internal.view.video.support.C0600a;
import com.facebook.ads.internal.view.video.support.C0602b;
import java.util.HashMap;

/* renamed from: com.facebook.ads.internal.view.video.a */
public class C0589a extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0600a f1363a;

    /* renamed from: b */
    private C0441d f1364b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0598c f1365c;

    /* renamed from: d */
    private String f1366d;

    /* renamed from: e */
    private String f1367e;

    /* renamed from: f */
    private String f1368f;

    /* renamed from: g */
    private boolean f1369g;

    /* renamed from: h */
    private boolean f1370h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f1371i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f1372j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f1373k;

    /* renamed from: l */
    private Runnable f1374l;

    /* renamed from: m */
    private Runnable f1375m;

    /* renamed from: n */
    private float f1376n;

    /* renamed from: com.facebook.ads.internal.view.video.a$a */
    private static final class C0596a extends C0555t<C0589a> {
        public C0596a(C0589a aVar) {
            super(aVar);
        }

        public void run() {
            C0589a aVar = (C0589a) mo6141a();
            if (aVar != null) {
                if (aVar.f1363a.getCurrentPosition() > 3000) {
                    new C0550o().execute(new String[]{aVar.getVideoPlayReportURI()});
                    return;
                }
                aVar.f1372j.postDelayed(this, 250);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.video.a$b */
    private static final class C0597b extends C0555t<C0589a> {
        public C0597b(C0589a aVar) {
            super(aVar);
        }

        public void run() {
            C0589a aVar = (C0589a) mo6141a();
            if (aVar != null && aVar != null) {
                int currentPosition = aVar.f1363a.getCurrentPosition();
                if (currentPosition > aVar.f1371i) {
                    int unused = aVar.f1371i = currentPosition;
                }
                aVar.f1373k.postDelayed(this, 250);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.video.a$c */
    class C0598c extends Button {

        /* renamed from: b */
        private Paint f1388b;

        /* renamed from: c */
        private Path f1389c;

        /* renamed from: d */
        private Path f1390d;

        /* renamed from: e */
        private Path f1391e;

        /* renamed from: f */
        private int f1392f;

        /* renamed from: g */
        private boolean f1393g = true;

        public C0598c(Context context) {
            super(context);
            m1338a();
        }

        /* renamed from: a */
        private void m1338a() {
            this.f1392f = 60;
            this.f1389c = new Path();
            this.f1390d = new Path();
            this.f1391e = new Path();
            this.f1388b = new Paint() {
                {
                    setStyle(Paint.Style.FILL_AND_STROKE);
                    setStrokeCap(Paint.Cap.ROUND);
                    setStrokeWidth(3.0f);
                    setAntiAlias(true);
                    setColor(-1);
                }
            };
            m1342b();
            setClickable(true);
            setBackgroundColor(0);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1340a(boolean z) {
            this.f1393g = z;
            refreshDrawableState();
            invalidate();
        }

        /* renamed from: b */
        private void m1342b() {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) this.f1392f) * displayMetrics.density), (int) (displayMetrics.density * ((float) this.f1392f)));
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            setLayoutParams(layoutParams);
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public boolean m1343c() {
            return this.f1393g;
        }

        /* access modifiers changed from: protected */
        public void onDraw(@NonNull Canvas canvas) {
            if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 17) {
                setLayerType(1, (Paint) null);
            }
            float max = ((float) Math.max(canvas.getWidth(), canvas.getHeight())) / 100.0f;
            if (m1343c()) {
                this.f1391e.rewind();
                this.f1391e.moveTo(26.5f * max, 15.5f * max);
                this.f1391e.lineTo(26.5f * max, 84.5f * max);
                this.f1391e.lineTo(82.5f * max, 50.5f * max);
                this.f1391e.lineTo(26.5f * max, max * 15.5f);
                this.f1391e.close();
                canvas.drawPath(this.f1391e, this.f1388b);
            } else {
                this.f1389c.rewind();
                this.f1389c.moveTo(29.0f * max, 21.0f * max);
                this.f1389c.lineTo(29.0f * max, 79.0f * max);
                this.f1389c.lineTo(45.0f * max, 79.0f * max);
                this.f1389c.lineTo(45.0f * max, 21.0f * max);
                this.f1389c.lineTo(29.0f * max, 21.0f * max);
                this.f1389c.close();
                this.f1390d.rewind();
                this.f1390d.moveTo(55.0f * max, 21.0f * max);
                this.f1390d.lineTo(55.0f * max, 79.0f * max);
                this.f1390d.lineTo(71.0f * max, 79.0f * max);
                this.f1390d.lineTo(71.0f * max, 21.0f * max);
                this.f1390d.lineTo(55.0f * max, max * 21.0f);
                this.f1390d.close();
                canvas.drawPath(this.f1389c, this.f1388b);
                canvas.drawPath(this.f1390d, this.f1388b);
            }
            super.onDraw(canvas);
        }
    }

    public C0589a(Context context) {
        super(context);
        m1327e();
    }

    /* renamed from: a */
    private void m1320a(Context context, Intent intent) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        intent.putExtra("useNativeCloseButton", true);
        intent.putExtra(InterstitialAdActivity.VIEW_TYPE, InterstitialAdActivity.Type.VIDEO);
        intent.putExtra(InterstitialAdActivity.VIDEO_URL, getVideoURI());
        intent.putExtra(InterstitialAdActivity.VIDEO_PLAY_REPORT_URL, getVideoPlayReportURI());
        intent.putExtra(InterstitialAdActivity.VIDEO_TIME_REPORT_URL, getVideoTimeReportURI());
        intent.putExtra(InterstitialAdActivity.PREDEFINED_ORIENTATION_KEY, 13);
        intent.addFlags(268435456);
    }

    /* renamed from: a */
    private boolean m1322a(Class<?> cls) {
        try {
            Context context = getContext();
            Intent intent = new Intent(context, cls);
            m1320a(context, intent);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            C0531c.m1182a(C0528b.m1179a(e, "Error occurred while loading fullscreen video activity."));
            return false;
        }
    }

    /* renamed from: e */
    private void m1327e() {
        this.f1376n = 0.0f;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setGravity(17);
        relativeLayout.setLayoutParams(layoutParams);
        setBackgroundColor(0);
        Context context = getContext();
        this.f1363a = new C0600a(context);
        this.f1363a.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(10, -1);
        layoutParams2.addRule(12, -1);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(9, -1);
        this.f1363a.setLayoutParams(layoutParams2);
        this.f1363a.setFrameVideoViewListener(new C0602b() {
            /* renamed from: a */
            public void mo6211a(MediaPlayer mediaPlayer) {
                try {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = new MediaPlayer();
                    }
                    mediaPlayer.setVolume(C0589a.this.getVolume(), C0589a.this.getVolume());
                    mediaPlayer.setLooping(false);
                    if (this.getAutoplay()) {
                        this.mo6195c();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        relativeLayout.addView(this.f1363a);
        addView(relativeLayout);
        this.f1373k = new Handler();
        this.f1374l = new C0597b(this);
        this.f1373k.postDelayed(this.f1374l, 250);
        this.f1372j = new Handler();
        this.f1375m = new C0596a(this);
        this.f1372j.postDelayed(this.f1375m, 250);
        this.f1364b = new C0441d(context, this, 50, true, new C0441d.C0442a() {
            /* renamed from: a */
            public void mo5822a() {
                if (this.getAutoplay()) {
                    C0589a.this.mo6195c();
                }
            }

            /* renamed from: b */
            public void mo5914b() {
                C0589a.this.mo6196d();
            }
        });
        this.f1364b.mo5911a(0);
        this.f1364b.mo5913b(250);
        this.f1364b.mo5910a();
        setOnTouchListenerInternal(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1 || this.getVideoURI() == null) {
                    return false;
                }
                C0589a.this.m1330g();
                return true;
            }
        });
        setOnClickListenerInternal(new View.OnClickListener() {
            public void onClick(View view) {
                if (this.getVideoURI() != null) {
                    C0589a.this.m1330g();
                }
            }
        });
        this.f1365c = new C0598c(context);
        this.f1365c.setLayoutParams(new FrameLayout.LayoutParams(100, 100, 80));
        this.f1365c.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                if (C0589a.this.f1365c.m1343c()) {
                    C0589a.this.mo6195c();
                    return true;
                }
                C0589a.this.mo6196d();
                return true;
            }
        });
        this.f1365c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (C0589a.this.f1365c.m1343c()) {
                    C0589a.this.mo6195c();
                } else {
                    C0589a.this.mo6196d();
                }
            }
        });
        addView(this.f1365c);
    }

    /* renamed from: f */
    private void m1329f() {
        if (!this.f1370h && getVideoTimeReportURI() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("time", Integer.toString(this.f1371i / AdError.NETWORK_ERROR_CODE));
            hashMap.put("inline", "1");
            new C0550o(hashMap).execute(new String[]{getVideoTimeReportURI()});
            this.f1370h = true;
            this.f1371i = 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m1330g() {
        if (!m1322a((Class<?>) NativeAdVideoActivity.class)) {
            m1322a((Class<?>) InterstitialAdActivity.class);
        }
    }

    private void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    private void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    /* renamed from: a */
    public void mo6193a() {
        if (this.f1371i > 0) {
            m1329f();
            this.f1371i = 0;
        }
    }

    /* renamed from: b */
    public void mo6194b() {
        this.f1366d = null;
    }

    /* renamed from: c */
    public void mo6195c() {
        this.f1365c.m1340a(false);
        this.f1363a.mo6219a();
    }

    /* renamed from: d */
    public void mo6196d() {
        this.f1365c.m1340a(true);
        this.f1363a.mo6220b();
    }

    public boolean getAutoplay() {
        return this.f1369g;
    }

    public String getVideoPlayReportURI() {
        return this.f1367e;
    }

    public String getVideoTimeReportURI() {
        return this.f1368f;
    }

    public String getVideoURI() {
        return this.f1366d;
    }

    /* access modifiers changed from: package-private */
    public float getVolume() {
        return this.f1376n;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1364b.mo5910a();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1329f();
        this.f1364b.mo5912b();
    }

    public void setAutoplay(boolean z) {
        this.f1369g = z;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
    }

    public void setVideoPlayReportURI(String str) {
        this.f1367e = str;
    }

    public void setVideoTimeReportURI(String str) {
        mo6193a();
        this.f1368f = str;
    }

    public void setVideoURI(String str) {
        this.f1366d = str;
        if (str != null) {
            this.f1363a.setup(Uri.parse(str));
            if (this.f1369g) {
                this.f1363a.mo6219a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setVolume(float f) {
        this.f1376n = f;
    }
}
