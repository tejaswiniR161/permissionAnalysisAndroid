package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzard {
    private final ByteBuffer bqu;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super(new StringBuilder(108).append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ").append(i).append(" limit ").append(i2).append(").").toString());
        }
    }

    private zzard(ByteBuffer byteBuffer) {
        this.bqu = byteBuffer;
        this.bqu.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzard(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3).toString());
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int length = charSequence.length();
        int i4 = 0;
        int i5 = i + i2;
        while (i4 < length && i4 + i < i5) {
            char charAt = charSequence.charAt(i4);
            if (charAt >= 128) {
                break;
            }
            bArr[i + i4] = (byte) charAt;
            i4++;
        }
        if (i4 == length) {
            return i + length;
        }
        int i6 = i + i4;
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 < 128 && i6 < i5) {
                i3 = i6 + 1;
                bArr[i6] = (byte) charAt2;
            } else if (charAt2 < 2048 && i6 <= i5 - 2) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 6) | 960);
                i3 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i6 <= i5 - 3) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 >>> 12) | 480);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i3 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
            } else if (i6 <= i5 - 4) {
                if (i4 + 1 != charSequence.length()) {
                    i4++;
                    char charAt3 = charSequence.charAt(i4);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i10 = i6 + 1;
                        bArr[i6] = (byte) ((codePoint >>> 18) | 240);
                        int i11 = i10 + 1;
                        bArr[i10] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i12 = i11 + 1;
                        bArr[i11] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i3 = i12 + 1;
                        bArr[i12] = (byte) ((codePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i4 - 1).toString());
            } else {
                throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charAt2).append(" at index ").append(i6).toString());
            }
            i4++;
            i6 = i3;
        }
        return i6;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            zzb(charSequence, byteBuffer);
        }
    }

    public static int zzag(int i, int i2) {
        return zzahl(i) + zzahi(i2);
    }

    public static int zzah(int i, int i2) {
        return zzahl(i) + zzahj(i2);
    }

    public static int zzahi(int i) {
        if (i >= 0) {
            return zzahn(i);
        }
        return 10;
    }

    public static int zzahj(int i) {
        return zzahn(zzahp(i));
    }

    public static int zzahl(int i) {
        return zzahn(zzarn.zzaj(i, 0));
    }

    public static int zzahn(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zzahp(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int zzb(int i, double d) {
        return zzahl(i) + zzp(d);
    }

    public static int zzb(int i, zzark zzark) {
        return (zzahl(i) * 2) + zzd(zzark);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzahl(i) + zzbg(bArr);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 128) {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 2048) {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else if (charAt < 55296 || 57343 < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i - 1).toString());
            }
            i++;
        }
    }

    public static zzard zzbe(byte[] bArr) {
        return zzc(bArr, 0, bArr.length);
    }

    public static int zzbg(byte[] bArr) {
        return zzahn(bArr.length) + bArr.length;
    }

    public static int zzc(int i, zzark zzark) {
        return zzahl(i) + zze(zzark);
    }

    public static zzard zzc(byte[] bArr, int i, int i2) {
        return new zzard(bArr, i, i2);
    }

    public static int zzd(int i, float f) {
        return zzahl(i) + zzl(f);
    }

    public static int zzd(zzark zzark) {
        return zzark.mo9192db();
    }

    private static int zzd(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = i;
        int i3 = length;
        while (true) {
            if (i2 < length) {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 2048) {
                    i3 += zza(charSequence, i2);
                    break;
                }
                i2++;
                i3 = ((127 - charAt) >>> 31) + i3;
            } else {
                break;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(((long) i3) + 4294967296L).toString());
    }

    public static int zzda(long j) {
        return zzdf(j);
    }

    public static int zzdb(long j) {
        return zzdf(j);
    }

    public static int zzdc(long j) {
        return 8;
    }

    public static int zzdd(long j) {
        return zzdf(zzdh(j));
    }

    public static int zzdf(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long zzdh(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzdl(boolean z) {
        return 1;
    }

    public static int zze(int i, long j) {
        return zzahl(i) + zzda(j);
    }

    public static int zze(zzark zzark) {
        int db = zzark.mo9192db();
        return db + zzahn(db);
    }

    public static int zzf(int i, long j) {
        return zzahl(i) + zzdb(j);
    }

    public static int zzg(int i, long j) {
        return zzahl(i) + zzdc(j);
    }

    public static int zzh(int i, long j) {
        return zzahl(i) + zzdd(j);
    }

    public static int zzk(int i, boolean z) {
        return zzahl(i) + zzdl(z);
    }

    public static int zzl(float f) {
        return 4;
    }

    public static int zzp(double d) {
        return 8;
    }

    public static int zzs(int i, String str) {
        return zzahl(i) + zzuy(str);
    }

    public static int zzuy(String str) {
        int zzd = zzd((CharSequence) str);
        return zzd + zzahn(zzd);
    }

    /* renamed from: cN */
    public int mo9122cN() {
        return this.bqu.remaining();
    }

    /* renamed from: cO */
    public void mo9123cO() {
        if (mo9122cN() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zza(int i, double d) throws IOException {
        zzai(i, 1);
        zzo(d);
    }

    public void zza(int i, long j) throws IOException {
        zzai(i, 0);
        zzcw(j);
    }

    public void zza(int i, zzark zzark) throws IOException {
        zzai(i, 2);
        zzc(zzark);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzai(i, 2);
        zzbf(bArr);
    }

    public void zzae(int i, int i2) throws IOException {
        zzai(i, 0);
        zzahg(i2);
    }

    public void zzaf(int i, int i2) throws IOException {
        zzai(i, 0);
        zzahh(i2);
    }

    public void zzahg(int i) throws IOException {
        if (i >= 0) {
            zzahm(i);
        } else {
            zzde((long) i);
        }
    }

    public void zzahh(int i) throws IOException {
        zzahm(zzahp(i));
    }

    public void zzahk(int i) throws IOException {
        zzc((byte) i);
    }

    public void zzahm(int i) throws IOException {
        while ((i & -128) != 0) {
            zzahk((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        zzahk(i);
    }

    public void zzaho(int i) throws IOException {
        if (this.bqu.remaining() < 4) {
            throw new zza(this.bqu.position(), this.bqu.limit());
        }
        this.bqu.putInt(i);
    }

    public void zzai(int i, int i2) throws IOException {
        zzahm(zzarn.zzaj(i, i2));
    }

    public void zzb(int i, long j) throws IOException {
        zzai(i, 0);
        zzcx(j);
    }

    public void zzb(zzark zzark) throws IOException {
        zzark.zza(this);
    }

    public void zzbf(byte[] bArr) throws IOException {
        zzahm(bArr.length);
        zzbh(bArr);
    }

    public void zzbh(byte[] bArr) throws IOException {
        zzd(bArr, 0, bArr.length);
    }

    public void zzc(byte b) throws IOException {
        if (!this.bqu.hasRemaining()) {
            throw new zza(this.bqu.position(), this.bqu.limit());
        }
        this.bqu.put(b);
    }

    public void zzc(int i, float f) throws IOException {
        zzai(i, 5);
        zzk(f);
    }

    public void zzc(int i, long j) throws IOException {
        zzai(i, 1);
        zzcy(j);
    }

    public void zzc(zzark zzark) throws IOException {
        zzahm(zzark.mo9191da());
        zzark.zza(this);
    }

    public void zzcw(long j) throws IOException {
        zzde(j);
    }

    public void zzcx(long j) throws IOException {
        zzde(j);
    }

    public void zzcy(long j) throws IOException {
        zzdg(j);
    }

    public void zzcz(long j) throws IOException {
        zzde(zzdh(j));
    }

    public void zzd(int i, long j) throws IOException {
        zzai(i, 0);
        zzcz(j);
    }

    public void zzd(byte[] bArr, int i, int i2) throws IOException {
        if (this.bqu.remaining() >= i2) {
            this.bqu.put(bArr, i, i2);
            return;
        }
        throw new zza(this.bqu.position(), this.bqu.limit());
    }

    public void zzde(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzahk((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        zzahk((int) j);
    }

    public void zzdg(long j) throws IOException {
        if (this.bqu.remaining() < 8) {
            throw new zza(this.bqu.position(), this.bqu.limit());
        }
        this.bqu.putLong(j);
    }

    public void zzdk(boolean z) throws IOException {
        zzahk(z ? 1 : 0);
    }

    public void zzj(int i, boolean z) throws IOException {
        zzai(i, 0);
        zzdk(z);
    }

    public void zzk(float f) throws IOException {
        zzaho(Float.floatToIntBits(f));
    }

    public void zzo(double d) throws IOException {
        zzdg(Double.doubleToLongBits(d));
    }

    public void zzr(int i, String str) throws IOException {
        zzai(i, 2);
        zzux(str);
    }

    public void zzux(String str) throws IOException {
        try {
            int zzahn = zzahn(str.length());
            if (zzahn == zzahn(str.length() * 3)) {
                int position = this.bqu.position();
                if (this.bqu.remaining() < zzahn) {
                    throw new zza(zzahn + position, this.bqu.limit());
                }
                this.bqu.position(position + zzahn);
                zza((CharSequence) str, this.bqu);
                int position2 = this.bqu.position();
                this.bqu.position(position);
                zzahm((position2 - position) - zzahn);
                this.bqu.position(position2);
                return;
            }
            zzahm(zzd((CharSequence) str));
            zza((CharSequence) str, this.bqu);
        } catch (BufferOverflowException e) {
            zza zza2 = new zza(this.bqu.position(), this.bqu.limit());
            zza2.initCause(e);
            throw zza2;
        }
    }
}
