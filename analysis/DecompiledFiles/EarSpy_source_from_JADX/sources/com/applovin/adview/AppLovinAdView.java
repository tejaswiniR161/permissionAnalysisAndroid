package com.applovin.adview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinAdView extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";

    /* renamed from: a */
    private AdViewController f15a;

    public AppLovinAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20a((AppLovinAdSize) null, (AppLovinSdk) null, context, attributeSet);
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, Activity activity) {
        super(activity);
        Log.d(AppLovinLogger.SDK_TAG, "Created new AdView");
        m20a(appLovinAdSize, (AppLovinSdk) null, activity, (AttributeSet) null);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Activity activity) {
        super(activity);
        m20a(appLovinAdSize, appLovinSdk, activity, (AttributeSet) null);
    }

    /* renamed from: a */
    private void m19a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin Ad");
        textView.setGravity(17);
        addView(textView, displayMetrics.widthPixels, (int) TypedValue.applyDimension(1, 50.0f, displayMetrics));
    }

    /* renamed from: a */
    private void m20a(AppLovinAdSize appLovinAdSize, AppLovinSdk appLovinSdk, Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            AdViewControllerImpl adViewControllerImpl = new AdViewControllerImpl();
            adViewControllerImpl.initializeAdView(this, context, appLovinAdSize, appLovinSdk, attributeSet);
            this.f15a = adViewControllerImpl;
            return;
        }
        m19a(attributeSet, context);
    }

    public void destroy() {
        if (this.f15a != null) {
            this.f15a.destroy();
        }
    }

    public AdViewController getAdViewController() {
        return this.f15a;
    }

    public AppLovinAdSize getSize() {
        if (this.f15a != null) {
            return this.f15a.getSize();
        }
        return null;
    }

    public void loadNextAd() {
        if (this.f15a != null) {
            this.f15a.loadNextAd();
        } else {
            Log.i(AppLovinLogger.SDK_TAG, "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.f15a != null) {
            this.f15a.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f15a != null) {
            this.f15a.onVisibilityChanged(i);
        }
    }

    public void pause() {
        if (this.f15a != null) {
            this.f15a.pause();
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        if (this.f15a != null) {
            this.f15a.renderAd(appLovinAd);
        }
    }

    public void resume() {
        if (this.f15a != null) {
            this.f15a.resume();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        if (this.f15a != null) {
            this.f15a.setAdClickListener(appLovinAdClickListener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        if (this.f15a != null) {
            this.f15a.setAdDisplayListener(appLovinAdDisplayListener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        if (this.f15a != null) {
            this.f15a.setAdLoadListener(appLovinAdLoadListener);
        }
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        if (this.f15a != null) {
            this.f15a.setAdVideoPlaybackListener(appLovinAdVideoPlaybackListener);
        }
    }

    public void setAutoDestroy(boolean z) {
        if (this.f15a != null) {
            this.f15a.setAutoDestroy(z);
        }
    }
}
