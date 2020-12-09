package com.facebook.ads.internal.view;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.AdChoicesView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.view.component.C0569b;
import com.facebook.ads.internal.view.component.C0571d;
import java.util.Arrays;

/* renamed from: com.facebook.ads.internal.view.b */
public class C0561b extends RelativeLayout {

    /* renamed from: a */
    private final NativeAdViewAttributes f1304a;

    /* renamed from: b */
    private final NativeAd f1305b;

    /* renamed from: c */
    private final DisplayMetrics f1306c;

    public C0561b(Context context, NativeAd nativeAd, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        super(context);
        setBackgroundColor(nativeAdViewAttributes.getBackgroundColor());
        this.f1304a = nativeAdViewAttributes;
        this.f1305b = nativeAd;
        this.f1306c = context.getResources().getDisplayMetrics();
        setLayoutParams(new RelativeLayout.LayoutParams(-1, Math.round(((float) type.getHeight()) * this.f1306c.density)));
        C0585l lVar = new C0585l(context);
        lVar.setMinWidth(Math.round(280.0f * this.f1306c.density));
        lVar.setMaxWidth(Math.round(375.0f * this.f1306c.density));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        lVar.setLayoutParams(layoutParams);
        addView(lVar);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        lVar.addView(linearLayout);
        switch (type) {
            case HEIGHT_400:
                m1261b((ViewGroup) linearLayout);
                break;
            case HEIGHT_300:
                break;
        }
        m1257a((ViewGroup) linearLayout);
        m1258a(linearLayout, type);
        AdChoicesView adChoicesView = new AdChoicesView(getContext(), nativeAd);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) adChoicesView.getLayoutParams();
        layoutParams2.addRule(11);
        layoutParams2.setMargins(Math.round(this.f1306c.density * 4.0f), Math.round(this.f1306c.density * 4.0f), Math.round(this.f1306c.density * 4.0f), Math.round(this.f1306c.density * 4.0f));
        lVar.addView(adChoicesView);
    }

    /* renamed from: a */
    private void m1257a(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(this.f1306c.density * 180.0f)));
        relativeLayout.setBackgroundColor(this.f1304a.getBackgroundColor());
        MediaView mediaView = new MediaView(getContext());
        relativeLayout.addView(mediaView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (this.f1306c.density * 180.0f));
        layoutParams.addRule(13, -1);
        mediaView.setLayoutParams(layoutParams);
        mediaView.setAutoplay(this.f1304a.getAutoplay());
        mediaView.setNativeAd(this.f1305b);
        viewGroup.addView(relativeLayout);
    }

    /* renamed from: a */
    private void m1258a(ViewGroup viewGroup, NativeAdView.Type type) {
        C0569b bVar = new C0569b(getContext(), this.f1305b, this.f1304a, m1259a(type), m1260b(type));
        bVar.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(((float) m1260b(type)) * this.f1306c.density)));
        viewGroup.addView(bVar);
        this.f1305b.registerViewForInteraction(this, Arrays.asList(new View[]{bVar.getIconView(), bVar.getCallToActionView()}));
    }

    /* renamed from: a */
    private boolean m1259a(NativeAdView.Type type) {
        return type == NativeAdView.Type.HEIGHT_300 || type == NativeAdView.Type.HEIGHT_120;
    }

    /* renamed from: b */
    private int m1260b(NativeAdView.Type type) {
        switch (type) {
            case HEIGHT_400:
                return (type.getHeight() - 180) / 2;
            case HEIGHT_300:
                return type.getHeight() - 180;
            case HEIGHT_100:
            case HEIGHT_120:
                return type.getHeight();
            default:
                return 0;
        }
    }

    /* renamed from: b */
    private void m1261b(ViewGroup viewGroup) {
        C0571d dVar = new C0571d(getContext(), this.f1305b, this.f1304a);
        dVar.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(110.0f * this.f1306c.density)));
        viewGroup.addView(dVar);
    }
}
