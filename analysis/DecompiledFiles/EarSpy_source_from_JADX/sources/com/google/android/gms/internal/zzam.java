package com.google.android.gms.internal;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.android.gms.internal.zzae;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzam {
    static boolean zzyf = false;
    /* access modifiers changed from: private */
    public static MessageDigest zzyg = null;
    private static final Object zzyh = new Object();
    private static final Object zzyi = new Object();
    static CountDownLatch zzyj = new CountDownLatch(1);

    private static final class zza implements Runnable {
        private zza() {
        }

        public void run() {
            try {
                MessageDigest unused = zzam.zzyg = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            } finally {
                zzam.zzyj.countDown();
            }
        }
    }

    private static int zza(boolean z) {
        return z ? 239 : 255;
    }

    static String zza(zzae.zza zza2, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return zza(zzark.zzf(zza2), str, z);
    }

    static String zza(String str, String str2, boolean z) {
        byte[] zzb = zzb(str, str2, z);
        return zzb != null ? zzak.zza(zzb, true) : Integer.toString(7);
    }

    static String zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return zzak.zza(z ? zzb(bArr, str) : zza(bArr, str), true);
    }

    static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + i) - 1) / i;
        Vector<byte[]> vector = new Vector<>();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * i;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > i ? i3 + i : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    static void zza(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new zzaqc(str.getBytes("UTF-8")).zzax(bArr);
    }

    static byte[] zza(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Vector<byte[]> zza2 = zza(bArr, 255);
        if (zza2 == null || zza2.size() == 0) {
            return zzb(zzark.zzf(zzb(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)), str);
        }
        zzae.zzf zzf = new zzae.zzf();
        zzf.zzfw = new byte[zza2.size()][];
        Iterator<byte[]> it = zza2.iterator();
        int i = 0;
        while (it.hasNext()) {
            zzf.zzfw[i] = zzb(it.next(), str, false);
            i++;
        }
        zzf.zzfr = zzg(bArr);
        return zzark.zzf(zzf);
    }

    static void zzas() {
        synchronized (zzyi) {
            if (!zzyf) {
                zzyf = true;
                new Thread(new zza()).start();
            }
        }
    }

    static MessageDigest zzat() {
        zzas();
        boolean z = false;
        try {
            z = zzyj.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        if (z && zzyg != null) {
            return zzyg;
        }
        return null;
    }

    static zzae.zza zzb(long j) {
        zzae.zza zza2 = new zzae.zza();
        zza2.zzdl = Long.valueOf(j);
        return zza2;
    }

    static byte[] zzb(String str, String str2, boolean z) {
        zzae.zzc zzc = new zzae.zzc();
        try {
            zzc.zzfp = str.length() < 3 ? str.getBytes("ISO-8859-1") : zzak.zza(str, true);
            zzc.zzfq = z ? str2.length() < 3 ? str2.getBytes("ISO-8859-1") : zzak.zza(str2, true) : (str2 == null || str2.length() == 0) ? Integer.toString(5).getBytes("ISO-8859-1") : zzak.zza(zza(str2.getBytes("ISO-8859-1"), (String) null, zzdi.zzbep.get().booleanValue()), true);
            return zzark.zzf(zzc);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            return null;
        }
    }

    static byte[] zzb(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return zzb(bArr, str, true);
    }

    private static byte[] zzb(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] array;
        int zza2 = zza(z);
        if (bArr.length > zza2) {
            bArr = zzark.zzf(zzb(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        }
        if (bArr.length < zza2) {
            byte[] bArr2 = new byte[(zza2 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(zza2 + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(zza2 + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(zzg(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        new zzan().zzb(array, bArr3);
        if (str != null && str.length() > 0) {
            zza(str, bArr3);
        }
        return bArr3;
    }

    public static byte[] zzg(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zzyh) {
            MessageDigest zzat = zzat();
            if (zzat == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            zzat.reset();
            zzat.update(bArr);
            digest = zzyg.digest();
        }
        return digest;
    }
}
