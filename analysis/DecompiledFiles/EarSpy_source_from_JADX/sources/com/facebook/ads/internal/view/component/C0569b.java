package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.view.C0582i;
import com.facebook.ads.internal.view.C0584k;

/* renamed from: com.facebook.ads.internal.view.component.b */
public class C0569b extends LinearLayout {

    /* renamed from: a */
    private ImageView f1323a;

    /* renamed from: b */
    private C0568a f1324b;

    /* renamed from: c */
    private TextView f1325c;

    /* renamed from: d */
    private LinearLayout f1326d = new LinearLayout(getContext());

    public C0569b(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes, boolean z, int i) {
        super(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        setVerticalGravity(16);
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(Math.round(15.0f * displayMetrics.density), Math.round(15.0f * displayMetrics.density), Math.round(15.0f * displayMetrics.density), Math.round(15.0f * displayMetrics.density));
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        this.f1326d.setOrientation(0);
        this.f1326d.setGravity(16);
        layoutParams2.weight = 3.0f;
        this.f1326d.setLayoutParams(layoutParams2);
        linearLayout.addView(this.f1326d);
        this.f1323a = new C0570c(getContext());
        int a = m1273a(z, i);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(Math.round(((float) a) * displayMetrics.density), Math.round(((float) a) * displayMetrics.density));
        layoutParams3.setMargins(0, 0, Math.round(15.0f * displayMetrics.density), 0);
        this.f1323a.setLayoutParams(layoutParams3);
        NativeAd.downloadAndDisplayImage(nativeAd.getAdIcon(), this.f1323a);
        this.f1326d.addView(this.f1323a);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        this.f1326d.addView(linearLayout2);
        this.f1324b = new C0568a(getContext(), nativeAd, nativeAdViewAttributes);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.setMargins(0, 0, Math.round(15.0f * displayMetrics.density), 0);
        layoutParams4.weight = 0.5f;
        this.f1324b.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.f1324b);
        this.f1325c = new TextView(getContext());
        this.f1325c.setPadding(Math.round(6.0f * displayMetrics.density), Math.round(6.0f * displayMetrics.density), Math.round(6.0f * displayMetrics.density), Math.round(6.0f * displayMetrics.density));
        this.f1325c.setText(nativeAd.getAdCallToAction());
        this.f1325c.setTextColor(nativeAdViewAttributes.getButtonTextColor());
        this.f1325c.setTextSize(14.0f);
        this.f1325c.setTypeface(nativeAdViewAttributes.getTypeface(), 1);
        this.f1325c.setMaxLines(2);
        this.f1325c.setEllipsize(TextUtils.TruncateAt.END);
        this.f1325c.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(nativeAdViewAttributes.getButtonColor());
        gradientDrawable.setCornerRadius(displayMetrics.density * 5.0f);
        gradientDrawable.setStroke(1, nativeAdViewAttributes.getButtonBorderColor());
        this.f1325c.setBackgroundDrawable(gradientDrawable);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.weight = 0.25f;
        this.f1325c.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.f1325c);
        if (z) {
            C0584k kVar = new C0584k(getContext());
            kVar.setText(nativeAd.getAdBody());
            C0582i.m1312b(kVar, nativeAdViewAttributes);
            kVar.setMinTextSize((float) (nativeAdViewAttributes.getDescriptionTextSize() - 1));
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 0);
            layoutParams6.weight = 1.0f;
            kVar.setLayoutParams(layoutParams6);
            kVar.setGravity(80);
            linearLayout.addView(kVar);
        }
    }

    /* renamed from: a */
    private int m1273a(boolean z, int i) {
        return (int) (((double) (i - 30)) * (3.0d / ((double) ((z ? 1 : 0) + 3))));
    }

    public TextView getCallToActionView() {
        return this.f1325c;
    }

    public ImageView getIconView() {
        return this.f1323a;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        TextView titleTextView = this.f1324b.getTitleTextView();
        if (titleTextView.getLayout().getLineEnd(titleTextView.getLineCount() - 1) < this.f1324b.getMinVisibleTitleCharacters()) {
            this.f1326d.removeView(this.f1323a);
            super.onMeasure(i, i2);
        }
    }
}
