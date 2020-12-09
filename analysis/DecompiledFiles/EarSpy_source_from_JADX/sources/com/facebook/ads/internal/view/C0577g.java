package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.C0550o;
import com.facebook.ads.internal.util.C0555t;
import java.util.HashMap;

/* renamed from: com.facebook.ads.internal.view.g */
public class C0577g extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public VideoView f1347a;

    /* renamed from: b */
    private String f1348b;

    /* renamed from: c */
    private String f1349c;

    /* renamed from: d */
    private boolean f1350d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f1351e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f1352f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f1353g;

    /* renamed from: com.facebook.ads.internal.view.g$a */
    private static final class C0578a extends C0555t<C0577g> {
        public C0578a(C0577g gVar) {
            super(gVar);
        }

        public void run() {
            C0577g gVar = (C0577g) mo6141a();
            if (gVar == null) {
                return;
            }
            if (gVar.f1347a.getCurrentPosition() > 3000) {
                new C0550o().execute(new String[]{gVar.getVideoPlayReportURI()});
                return;
            }
            gVar.f1352f.postDelayed(this, 250);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.g$b */
    private static final class C0579b extends C0555t<C0577g> {
        public C0579b(C0577g gVar) {
            super(gVar);
        }

        public void run() {
            C0577g gVar = (C0577g) mo6141a();
            if (gVar != null) {
                int currentPosition = gVar.f1347a.getCurrentPosition();
                if (currentPosition > gVar.f1351e) {
                    int unused = gVar.f1351e = currentPosition;
                }
                gVar.f1353g.postDelayed(this, 250);
            }
        }
    }

    public C0577g(Context context) {
        super(context);
        m1298c();
    }

    /* renamed from: c */
    private void m1298c() {
        MediaController mediaController = new MediaController(getContext());
        this.f1347a = new VideoView(getContext());
        mediaController.setAnchorView(this);
        this.f1347a.setMediaController(mediaController);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(10, -1);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(13);
        this.f1347a.setLayoutParams(layoutParams);
        addView(this.f1347a);
        this.f1353g = new Handler();
        this.f1353g.postDelayed(new C0579b(this), 250);
        this.f1352f = new Handler();
        this.f1352f.postDelayed(new C0578a(this), 250);
    }

    /* renamed from: d */
    private void m1300d() {
        if (!this.f1350d && getVideoTimeReportURI() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("time", Integer.toString(this.f1351e / AdError.NETWORK_ERROR_CODE));
            hashMap.put("inline", "0");
            new C0550o(hashMap).execute(new String[]{getVideoTimeReportURI()});
            this.f1350d = true;
            this.f1351e = 0;
        }
    }

    /* renamed from: a */
    public void mo6169a() {
        this.f1347a.start();
    }

    /* renamed from: b */
    public void mo6170b() {
        if (this.f1347a != null) {
            this.f1347a.stopPlayback();
        }
    }

    public String getVideoPlayReportURI() {
        return this.f1348b;
    }

    public String getVideoTimeReportURI() {
        return this.f1349c;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1300d();
    }

    public void setVideoPlayReportURI(String str) {
        this.f1348b = str;
    }

    public void setVideoTimeReportURI(String str) {
        this.f1349c = str;
    }

    public void setVideoURI(Uri uri) {
        if (uri != null) {
            this.f1347a.setVideoURI(uri);
        }
    }

    public void setVideoURI(String str) {
        if (str != null) {
            setVideoURI(Uri.parse(str));
        }
    }
}
