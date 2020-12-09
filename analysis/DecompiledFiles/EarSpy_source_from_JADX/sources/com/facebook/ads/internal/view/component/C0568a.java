package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.view.C0582i;
import com.facebook.ads.internal.view.C0583j;

/* renamed from: com.facebook.ads.internal.view.component.a */
public class C0568a extends LinearLayout {

    /* renamed from: a */
    private C0583j f1321a = new C0583j(getContext(), 2);

    /* renamed from: b */
    private int f1322b;

    public C0568a(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
        super(context);
        setOrientation(1);
        setVerticalGravity(16);
        this.f1321a.setMinTextSize((float) (nativeAdViewAttributes.getTitleTextSize() - 2));
        this.f1321a.setText(nativeAd.getAdTitle());
        C0582i.m1311a(this.f1321a, nativeAdViewAttributes);
        this.f1321a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f1321a);
        this.f1322b = Math.min(nativeAd.getAdTitle().length(), 21);
        addView(C0582i.m1310a(context, nativeAd, nativeAdViewAttributes));
    }

    public int getMinVisibleTitleCharacters() {
        return this.f1322b;
    }

    public TextView getTitleTextView() {
        return this.f1321a;
    }
}
