package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzu;

@zziy
public class zzko extends Handler {
    public zzko(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzu.zzgd().zza((Throwable) e, "AdMobHandler.handleMessage");
        }
    }
}
