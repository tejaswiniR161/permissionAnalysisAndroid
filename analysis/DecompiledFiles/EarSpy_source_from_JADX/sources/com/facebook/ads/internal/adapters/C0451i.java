package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.WindowManager;
import android.webkit.WebView;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.internal.util.C0535f;
import com.facebook.ads.internal.util.C0541h;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.i */
public class C0451i extends InterstitialAdapter {

    /* renamed from: a */
    private final String f930a = UUID.randomUUID().toString();

    /* renamed from: b */
    private Context f931b;

    /* renamed from: c */
    private C0440c f932c;

    /* renamed from: d */
    private InterstitialAdapterListener f933d;

    /* renamed from: e */
    private boolean f934e = false;

    /* renamed from: f */
    private C0456k f935f;

    /* renamed from: g */
    private C0452a f936g;

    /* renamed from: h */
    private WebView f937h;

    /* renamed from: com.facebook.ads.internal.adapters.i$a */
    public enum C0452a {
        VERTICAL,
        HORIZONTAL;

        /* renamed from: a */
        public static C0452a m869a(int i) {
            return i == 2 ? HORIZONTAL : VERTICAL;
        }
    }

    /* renamed from: a */
    private int m868a() {
        int rotation = ((WindowManager) this.f931b.getSystemService("window")).getDefaultDisplay().getRotation();
        if (this.f936g == C0452a.HORIZONTAL) {
            switch (rotation) {
                case 2:
                case 3:
                    return 8;
                default:
                    return 0;
            }
        } else {
            switch (rotation) {
                case 2:
                    return 9;
                default:
                    return 1;
            }
        }
    }

    public void loadInterstitialAd(Context context, InterstitialAdapterListener interstitialAdapterListener, Map<String, Object> map) {
        this.f931b = context;
        this.f933d = interstitialAdapterListener;
        this.f935f = C0456k.m910a((JSONObject) map.get("data"));
        if (C0535f.m1192a(context, (C0535f.C0536a) this.f935f)) {
            interstitialAdapterListener.onInterstitialError(this, AdError.NO_FILL);
            return;
        }
        this.f932c = new C0440c(context, this.f930a, this, this.f933d);
        this.f932c.mo5907a();
        Map<String, String> h = this.f935f.mo5958h();
        if (h.containsKey("orientation")) {
            this.f936g = C0452a.m869a(Integer.parseInt(h.get("orientation")));
        }
        this.f934e = true;
        if (this.f933d != null) {
            this.f933d.onInterstitialAdLoaded(this);
        }
    }

    public void onDestroy() {
        if (this.f932c != null) {
            this.f932c.mo5908b();
        }
        if (this.f937h != null) {
            C0541h.m1219a(this.f937h);
            this.f937h.destroy();
            this.f937h = null;
        }
    }

    public boolean show() {
        if (!this.f934e) {
            if (this.f933d != null) {
                this.f933d.onInterstitialError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        }
        Intent intent = new Intent(this.f931b, InterstitialAdActivity.class);
        this.f935f.mo5953a(intent);
        intent.putExtra(InterstitialAdActivity.PREDEFINED_ORIENTATION_KEY, m868a());
        intent.putExtra("adInterstitialUniqueId", this.f930a);
        intent.putExtra(InterstitialAdActivity.VIEW_TYPE, InterstitialAdActivity.Type.DISPLAY);
        intent.addFlags(268435456);
        this.f931b.startActivity(intent);
        return true;
    }
}
