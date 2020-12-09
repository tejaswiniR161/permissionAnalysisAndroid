package com.google.android.gms.internal;

import java.security.MessageDigest;

@zziy
public class zzcy extends zzcv {
    private MessageDigest zzavn;

    /* access modifiers changed from: package-private */
    public byte[] zza(String[] strArr) {
        if (strArr.length == 1) {
            return zzcx.zzn(zzcx.zzae(strArr[0]));
        }
        if (strArr.length < 5) {
            byte[] bArr = new byte[(strArr.length * 2)];
            for (int i = 0; i < strArr.length; i++) {
                byte[] zzq = zzq(zzcx.zzae(strArr[i]));
                bArr[i * 2] = zzq[0];
                bArr[(i * 2) + 1] = zzq[1];
            }
            return bArr;
        }
        byte[] bArr2 = new byte[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr2[i2] = zzp(zzcx.zzae(strArr[i2]));
        }
        return bArr2;
    }

    public byte[] zzac(String str) {
        byte[] bArr;
        int i = 4;
        byte[] zza = zza(str.split(" "));
        this.zzavn = zzir();
        synchronized (this.zzakd) {
            if (this.zzavn == null) {
                bArr = new byte[0];
            } else {
                this.zzavn.reset();
                this.zzavn.update(zza);
                byte[] digest = this.zzavn.digest();
                if (digest.length <= 4) {
                    i = digest.length;
                }
                bArr = new byte[i];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public byte zzp(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((-16777216 & i) >> 24));
    }

    /* access modifiers changed from: package-private */
    public byte[] zzq(int i) {
        int i2 = (65535 & i) ^ ((-65536 & i) >> 16);
        return new byte[]{(byte) i2, (byte) (i2 >> 8)};
    }
}
