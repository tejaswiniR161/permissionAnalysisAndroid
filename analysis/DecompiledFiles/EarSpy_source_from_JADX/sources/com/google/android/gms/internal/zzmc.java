package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;

@zziy
@TargetApi(14)
public final class zzmc extends zzma {
    public zzmc(zzlt zzlt) {
        super(zzlt);
    }

    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zza(view, i, customViewCallback);
    }
}
