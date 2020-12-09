package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

public class zzarr extends CustomTabsServiceConnection {
    private WeakReference<zzars> brx;

    public zzarr(zzars zzars) {
        this.brx = new WeakReference<>(zzars);
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzars zzars = (zzars) this.brx.get();
        if (zzars != null) {
            zzars.zza(customTabsClient);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzars zzars = (zzars) this.brx.get();
        if (zzars != null) {
            zzars.zzlg();
        }
    }
}
