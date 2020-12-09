package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.m */
public class C0459m extends C0438a {

    /* renamed from: b */
    private final C0460n f1001b;

    /* renamed from: c */
    private NativeAdView.Type f1002c;

    /* renamed from: d */
    private boolean f1003d;

    /* renamed from: e */
    private boolean f1004e;

    /* renamed from: f */
    private boolean f1005f;

    /* renamed from: g */
    private View f1006g;

    /* renamed from: h */
    private List<View> f1007h;

    public C0459m(Context context, C0439b bVar, C0460n nVar) {
        super(context, bVar);
        this.f1001b = nVar;
    }

    /* renamed from: b */
    private String m933b(View view) {
        try {
            return m934c(view).toString();
        } catch (JSONException e) {
            return "Json exception";
        }
    }

    /* renamed from: c */
    private JSONObject m934c(View view) {
        boolean z = true;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("id", Integer.valueOf(view.getId()));
        jSONObject.putOpt("class", view.getClass());
        jSONObject.putOpt(FirebaseAnalytics.Param.ORIGIN, String.format("{x:%d, y:%d}", new Object[]{Integer.valueOf(view.getTop()), Integer.valueOf(view.getLeft())}));
        jSONObject.putOpt("size", String.format("{h:%d, w:%d}", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getWidth())}));
        if (this.f1007h == null || !this.f1007h.contains(view)) {
            z = false;
        }
        jSONObject.putOpt("clickable", Boolean.valueOf(z));
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        if (view instanceof TextView) {
            str = "text";
        } else if (view instanceof Button) {
            str = "button";
        } else if (view instanceof ImageView) {
            str = "image";
        } else if (view instanceof MediaView) {
            str = "mediaview";
        } else if (view instanceof ViewGroup) {
            str = "viewgroup";
        }
        jSONObject.putOpt("type", str);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                jSONArray.put(m934c(viewGroup.getChildAt(i)));
            }
            jSONObject.putOpt("list", jSONArray);
        }
        return jSONObject;
    }

    /* renamed from: d */
    private String m935d(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return "";
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            createBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, this.f1001b.mo5932h(), byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: a */
    public void mo5967a(View view) {
        this.f1006g = view;
    }

    /* renamed from: a */
    public void mo5968a(NativeAdView.Type type) {
        this.f1002c = type;
    }

    /* renamed from: a */
    public void mo5969a(List<View> list) {
        this.f1007h = list;
    }

    /* renamed from: a */
    public void mo5970a(boolean z) {
        this.f1003d = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5906b() {
        if (this.f1001b != null) {
            HashMap hashMap = new HashMap();
            if (this.f887a != null) {
                hashMap.put("mil", Boolean.valueOf(this.f887a.mo5823a()));
                hashMap.put("eil", Boolean.valueOf(this.f887a.mo5824b()));
                hashMap.put("eil_source", this.f887a.mo5825c());
            }
            if (this.f1002c != null) {
                hashMap.put("nti", String.valueOf(this.f1002c.getValue()));
            }
            if (this.f1003d) {
                hashMap.put("nhs", String.valueOf(this.f1003d));
            }
            if (this.f1004e) {
                hashMap.put("nmv", String.valueOf(this.f1004e));
            }
            if (this.f1005f) {
                hashMap.put("nmvap", String.valueOf(this.f1005f));
            }
            if (this.f1006g != null && this.f1001b.mo5929e()) {
                hashMap.put("view", m933b(this.f1006g));
            }
            if (this.f1006g != null && this.f1001b.mo5931g()) {
                hashMap.put("snapshot", m935d(this.f1006g));
            }
            this.f1001b.mo5923a((Map<String, Object>) hashMap);
        }
    }

    /* renamed from: b */
    public void mo5971b(boolean z) {
        this.f1004e = z;
    }

    /* renamed from: c */
    public void mo5972c(boolean z) {
        this.f1005f = z;
    }
}
