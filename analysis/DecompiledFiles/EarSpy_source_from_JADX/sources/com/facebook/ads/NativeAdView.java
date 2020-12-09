package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.view.C0561b;

public class NativeAdView {

    public enum Type {
        HEIGHT_100(-1, 100),
        HEIGHT_120(-1, 120),
        HEIGHT_300(-1, 300),
        HEIGHT_400(-1, 400);
        

        /* renamed from: a */
        private final int f850a;

        /* renamed from: b */
        private final int f851b;

        private Type(int i, int i2) {
            this.f850a = i;
            this.f851b = i2;
        }

        public int getHeight() {
            return this.f851b;
        }

        public int getValue() {
            switch (this.f851b) {
                case 100:
                    return 1;
                case 120:
                    return 2;
                case 300:
                    return 3;
                case 400:
                    return 4;
                default:
                    return -1;
            }
        }

        public int getWidth() {
            return this.f850a;
        }
    }

    public static View render(Context context, NativeAd nativeAd, Type type) {
        return render(context, nativeAd, type, (NativeAdViewAttributes) null);
    }

    public static View render(Context context, NativeAd nativeAd, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAd.isNativeConfigEnabled()) {
            nativeAdViewAttributes = nativeAd.getAdViewAttributes();
        } else if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        nativeAd.mo5791a(type);
        return new C0561b(context, nativeAd, type, nativeAdViewAttributes);
    }
}
