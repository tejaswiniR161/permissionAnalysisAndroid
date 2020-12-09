package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzae;
import com.google.android.gms.ads.internal.util.client.zzb;

public final class PublisherAdView extends ViewGroup {
    private final zzae zzajz;

    public PublisherAdView(Context context) {
        super(context);
        this.zzajz = new zzae(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzajz = new zzae(this, attributeSet, true);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzajz = new zzae(this, attributeSet, true);
    }

    public void destroy() {
        this.zzajz.destroy();
    }

    public AdListener getAdListener() {
        return this.zzajz.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzajz.getAdSize();
    }

    public AdSize[] getAdSizes() {
        return this.zzajz.getAdSizes();
    }

    public String getAdUnitId() {
        return this.zzajz.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zzajz.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzajz.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzajz.getOnCustomRenderedAdLoadedListener();
    }

    public boolean isLoading() {
        return this.zzajz.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzajz.zza(publisherAdRequest.zzdg());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        AdSize adSize;
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzb.zzb("Unable to retrieve ad size.", e);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                i3 = adSize.getWidthInPixels(context);
                i4 = adSize.getHeightInPixels(context);
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i3 = childAt.getMeasuredWidth();
            i4 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.zzajz.pause();
    }

    public void recordManualImpression() {
        this.zzajz.recordManualImpression();
    }

    public void resume() {
        this.zzajz.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzajz.setAdListener(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzajz.zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        this.zzajz.setAdUnitId(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zzajz.setAppEventListener(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.zzajz.setCorrelator(correlator);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.zzajz.setManualImpressionsEnabled(z);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzajz.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }
}
