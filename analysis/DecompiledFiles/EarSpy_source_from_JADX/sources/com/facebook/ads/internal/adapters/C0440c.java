package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p000v4.content.LocalBroadcastManager;
import com.facebook.ads.AdError;

/* renamed from: com.facebook.ads.internal.adapters.c */
public class C0440c extends BroadcastReceiver {

    /* renamed from: a */
    private String f890a;

    /* renamed from: b */
    private Context f891b;

    /* renamed from: c */
    private InterstitialAdapterListener f892c;

    /* renamed from: d */
    private InterstitialAdapter f893d;

    public C0440c(Context context, String str, InterstitialAdapter interstitialAdapter, InterstitialAdapterListener interstitialAdapterListener) {
        this.f891b = context;
        this.f890a = str;
        this.f892c = interstitialAdapterListener;
        this.f893d = interstitialAdapter;
    }

    /* renamed from: a */
    public void mo5907a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.impression.logged:" + this.f890a);
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f890a);
        intentFilter.addAction("com.facebook.ads.interstitial.dismissed:" + this.f890a);
        intentFilter.addAction("com.facebook.ads.interstitial.clicked:" + this.f890a);
        intentFilter.addAction("com.facebook.ads.interstitial.error:" + this.f890a);
        LocalBroadcastManager.getInstance(this.f891b).registerReceiver(this, intentFilter);
    }

    /* renamed from: b */
    public void mo5908b() {
        try {
            LocalBroadcastManager.getInstance(this.f891b).unregisterReceiver(this);
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        String str = intent.getAction().split(":")[0];
        if (this.f892c != null && str != null) {
            if ("com.facebook.ads.interstitial.clicked".equals(str)) {
                this.f892c.onInterstitialAdClicked(this.f893d, intent.getStringExtra("com.facebook.ads.interstitial.ad.click.url"), intent.getBooleanExtra("com.facebook.ads.interstitial.ad.player.handles.click", true));
            } else if ("com.facebook.ads.interstitial.dismissed".equals(str)) {
                this.f892c.onInterstitialAdDismissed(this.f893d);
            } else if ("com.facebook.ads.interstitial.displayed".equals(str)) {
                this.f892c.onInterstitialAdDisplayed(this.f893d);
            } else if ("com.facebook.ads.interstitial.impression.logged".equals(str)) {
                this.f892c.onInterstitialLoggingImpression(this.f893d);
            } else if ("com.facebook.ads.interstitial.error".equals(str)) {
                this.f892c.onInterstitialError(this.f893d, AdError.INTERNAL_ERROR);
            }
        }
    }
}
