package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.internal.zziy;

@zziy
public final class zzj extends zzw.zza {
    private final AppEventListener zzaxo;

    public zzj(AppEventListener appEventListener) {
        this.zzaxo = appEventListener;
    }

    public void onAppEvent(String str, String str2) {
        this.zzaxo.onAppEvent(str, str2);
    }
}
