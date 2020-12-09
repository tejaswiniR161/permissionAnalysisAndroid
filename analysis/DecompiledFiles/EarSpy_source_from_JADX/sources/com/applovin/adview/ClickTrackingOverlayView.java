package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.impl.sdk.C0348ca;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;

public class ClickTrackingOverlayView extends RelativeLayout {
    public ClickTrackingOverlayView(Context context, AppLovinSdk appLovinSdk) {
        super(context, (AttributeSet) null, new C0348ca(appLovinSdk).mo5567K());
        m94a(context, appLovinSdk);
    }

    /* renamed from: a */
    private void m94a(Context context, AppLovinSdk appLovinSdk) {
        RelativeLayout.LayoutParams layoutParams;
        C0348ca caVar = new C0348ca(appLovinSdk);
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        int J = caVar.mo5566J();
        if (J == -2 || J == -1) {
            layoutParams = new RelativeLayout.LayoutParams(J, J);
        } else {
            int dpToPx = AppLovinSdkUtils.dpToPx(context, J);
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        }
        layoutParams.addRule(13);
        progressBar.setLayoutParams(layoutParams);
        setBackgroundColor(Color.parseColor(caVar.mo5565I()));
        addView(progressBar);
    }
}
