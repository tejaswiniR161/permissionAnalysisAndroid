package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@zziy
public abstract class zzcv {
    @Nullable
    private static MessageDigest zzavf = null;
    protected Object zzakd = new Object();

    /* access modifiers changed from: package-private */
    public abstract byte[] zzac(String str);

    /* access modifiers changed from: protected */
    @Nullable
    public MessageDigest zzir() {
        MessageDigest messageDigest;
        synchronized (this.zzakd) {
            if (zzavf != null) {
                messageDigest = zzavf;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        zzavf = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = zzavf;
            }
        }
        return messageDigest;
    }
}
