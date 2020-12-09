package com.applovin.impl.adview;

import android.app.Activity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.adview.InterstitialAdDialogCreator;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class InterstitialAdDialogCreatorImpl implements InterstitialAdDialogCreator {

    /* renamed from: a */
    private static final Object f111a = new Object();

    /* renamed from: b */
    private static WeakReference f112b = new WeakReference((Object) null);

    /* renamed from: c */
    private static WeakReference f113c = new WeakReference((Object) null);

    public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk appLovinSdk, Activity activity) {
        C0260af afVar;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(activity);
        }
        synchronized (f111a) {
            afVar = (C0260af) f112b.get();
            if (afVar == null || !afVar.isShowing() || f113c.get() != activity) {
                afVar = new C0260af(appLovinSdk, activity);
                f112b = new WeakReference(afVar);
                f113c = new WeakReference(activity);
            } else {
                appLovinSdk.getLogger().mo5671w("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
            }
        }
        return afVar;
    }
}
