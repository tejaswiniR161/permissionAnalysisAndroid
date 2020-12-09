package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.adapters.n */
public abstract class C0460n implements AdAdapter {
    /* renamed from: a */
    public abstract void mo5921a(int i);

    /* renamed from: a */
    public abstract void mo5922a(Context context, C0461o oVar, Map<String, Object> map);

    /* renamed from: a */
    public abstract void mo5923a(Map<String, Object> map);

    /* renamed from: b */
    public abstract void mo5926b(Map<String, Object> map);

    /* renamed from: d */
    public abstract boolean mo5928d();

    /* renamed from: e */
    public abstract boolean mo5929e();

    /* renamed from: f */
    public abstract boolean mo5930f();

    /* renamed from: g */
    public abstract boolean mo5931g();

    public final AdPlacementType getPlacementType() {
        return AdPlacementType.NATIVE;
    }

    /* renamed from: h */
    public abstract int mo5932h();

    /* renamed from: i */
    public abstract int mo5933i();

    /* renamed from: j */
    public abstract int mo5934j();

    /* renamed from: k */
    public abstract NativeAd.Image mo5935k();

    /* renamed from: l */
    public abstract NativeAd.Image mo5936l();

    /* renamed from: m */
    public abstract NativeAdViewAttributes mo5937m();

    /* renamed from: n */
    public abstract String mo5938n();

    /* renamed from: o */
    public abstract String mo5939o();

    /* renamed from: p */
    public abstract String mo5940p();

    /* renamed from: q */
    public abstract String mo5941q();

    /* renamed from: r */
    public abstract String mo5942r();

    /* renamed from: s */
    public abstract NativeAd.Rating mo5943s();

    /* renamed from: t */
    public abstract NativeAd.Image mo5944t();

    /* renamed from: u */
    public abstract String mo5945u();

    /* renamed from: v */
    public abstract String mo5946v();

    /* renamed from: w */
    public abstract String mo5947w();

    /* renamed from: x */
    public abstract String mo5948x();

    /* renamed from: y */
    public abstract AdExtras mo5949y();

    /* renamed from: z */
    public abstract boolean mo5950z();
}
