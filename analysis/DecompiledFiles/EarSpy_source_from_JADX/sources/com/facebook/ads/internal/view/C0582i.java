package com.facebook.ads.internal.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;

/* renamed from: com.facebook.ads.internal.view.i */
public abstract class C0582i {
    /* renamed from: a */
    public static LinearLayout m1310a(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
        LinearLayout linearLayout = new LinearLayout(context);
        NativeAd.Rating adStarRating = nativeAd.getAdStarRating();
        if (adStarRating == null || adStarRating.getValue() < 3.0d) {
            C0584k kVar = new C0584k(context);
            kVar.setText(nativeAd.getAdSocialContext());
            m1312b(kVar, nativeAdViewAttributes);
            linearLayout.addView(kVar);
        } else {
            RatingBar ratingBar = new RatingBar(context, (AttributeSet) null, 16842877);
            ratingBar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            ratingBar.setStepSize(0.1f);
            ratingBar.setIsIndicator(true);
            ratingBar.setNumStars((int) adStarRating.getScale());
            ratingBar.setRating((float) adStarRating.getValue());
            linearLayout.addView(ratingBar);
        }
        return linearLayout;
    }

    /* renamed from: a */
    public static void m1311a(TextView textView, NativeAdViewAttributes nativeAdViewAttributes) {
        textView.setTextColor(nativeAdViewAttributes.getTitleTextColor());
        textView.setTextSize((float) nativeAdViewAttributes.getTitleTextSize());
        textView.setTypeface(nativeAdViewAttributes.getTypeface(), 1);
    }

    /* renamed from: b */
    public static void m1312b(TextView textView, NativeAdViewAttributes nativeAdViewAttributes) {
        textView.setTextColor(nativeAdViewAttributes.getDescriptionTextColor());
        textView.setTextSize((float) nativeAdViewAttributes.getDescriptionTextSize());
        textView.setTypeface(nativeAdViewAttributes.getTypeface());
    }
}
