package com.facebook.ads.internal.util;

import android.graphics.Bitmap;
import android.support.p000v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.ads.internal.util.n */
class C0548n implements C0543j {

    /* renamed from: a */
    private static final short[] f1275a = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};

    /* renamed from: b */
    private static final byte[] f1276b = {9, 11, 12, 13, 13, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24};

    /* renamed from: com.facebook.ads.internal.util.n$a */
    private static class C0549a implements Callable<Void> {

        /* renamed from: a */
        private final int[] f1277a;

        /* renamed from: b */
        private final int f1278b;

        /* renamed from: c */
        private final int f1279c;

        /* renamed from: d */
        private final int f1280d;

        /* renamed from: e */
        private final int f1281e;

        /* renamed from: f */
        private final int f1282f;

        /* renamed from: g */
        private final int f1283g;

        public C0549a(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f1277a = iArr;
            this.f1278b = i;
            this.f1279c = i2;
            this.f1280d = i3;
            this.f1281e = i4;
            this.f1282f = i5;
            this.f1283g = i6;
        }

        /* renamed from: a */
        public Void call() {
            C0548n.m1235b(this.f1277a, this.f1278b, this.f1279c, this.f1280d, this.f1281e, this.f1282f, this.f1283g);
            return null;
        }
    }

    C0548n() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m1235b(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i - 1;
        int i8 = i2 - 1;
        int i9 = (i3 * 2) + 1;
        short s = f1275a[i3];
        byte b = f1276b[i3];
        int[] iArr2 = new int[i9];
        if (i6 == 1) {
            int i10 = (i5 * i2) / i4;
            int i11 = ((i5 + 1) * i2) / i4;
            while (true) {
                int i12 = i10;
                if (i12 < i11) {
                    long j = 0;
                    int i13 = i * i12;
                    long j2 = 0;
                    long j3 = 0;
                    long j4 = 0;
                    long j5 = 0;
                    long j6 = 0;
                    long j7 = 0;
                    for (int i14 = 0; i14 <= i3; i14++) {
                        iArr2[i14] = iArr[i13];
                        j6 += (long) (((iArr[i13] >>> 16) & 255) * (i14 + 1));
                        j5 += (long) (((iArr[i13] >>> 8) & 255) * (i14 + 1));
                        j4 += (long) ((iArr[i13] & 255) * (i14 + 1));
                        j3 += (long) ((iArr[i13] >>> 16) & 255);
                        j2 += (long) ((iArr[i13] >>> 8) & 255);
                        j7 += (long) (iArr[i13] & 255);
                    }
                    long j8 = 0;
                    long j9 = 0;
                    for (int i15 = 1; i15 <= i3; i15++) {
                        if (i15 <= i7) {
                            i13++;
                        }
                        iArr2[i15 + i3] = iArr[i13];
                        j6 += (long) (((iArr[i13] >>> 16) & 255) * ((i3 + 1) - i15));
                        j5 += (long) (((iArr[i13] >>> 8) & 255) * ((i3 + 1) - i15));
                        j4 += (long) ((iArr[i13] & 255) * ((i3 + 1) - i15));
                        j8 += (long) ((iArr[i13] >>> 16) & 255);
                        j9 += (long) ((iArr[i13] >>> 8) & 255);
                        j += (long) (iArr[i13] & 255);
                    }
                    int i16 = i3 > i7 ? i7 : i3;
                    int i17 = i3;
                    int i18 = 0;
                    long j10 = j3;
                    long j11 = j2;
                    long j12 = j7;
                    int i19 = i16 + (i12 * i);
                    int i20 = i16;
                    int i21 = i12 * i;
                    long j13 = j6;
                    long j14 = j5;
                    long j15 = j4;
                    long j16 = j8;
                    long j17 = j9;
                    long j18 = j;
                    long j19 = j10;
                    while (i18 < i) {
                        iArr[i21] = (int) (((long) (iArr[i21] & ViewCompat.MEASURED_STATE_MASK)) | ((((((long) s) * j13) >>> b) & 255) << 16) | ((((((long) s) * j14) >>> b) & 255) << 8) | (((((long) s) * j15) >>> b) & 255));
                        int i22 = i21 + 1;
                        long j20 = j13 - j19;
                        long j21 = j14 - j11;
                        long j22 = j15 - j12;
                        int i23 = (i17 + i9) - i3;
                        if (i23 >= i9) {
                            i23 -= i9;
                        }
                        long j23 = j19 - ((long) ((iArr2[i23] >>> 16) & 255));
                        long j24 = j11 - ((long) ((iArr2[i23] >>> 8) & 255));
                        long j25 = j12 - ((long) (iArr2[i23] & 255));
                        if (i20 < i7) {
                            i19++;
                            i20++;
                        }
                        iArr2[i23] = iArr[i19];
                        long j26 = j16 + ((long) ((iArr[i19] >>> 16) & 255));
                        long j27 = j17 + ((long) ((iArr[i19] >>> 8) & 255));
                        long j28 = j18 + ((long) (iArr[i19] & 255));
                        j13 = j20 + j26;
                        j14 = j21 + j27;
                        j15 = j22 + j28;
                        int i24 = i17 + 1;
                        if (i24 >= i9) {
                            i24 = 0;
                        }
                        j19 = j23 + ((long) ((iArr2[i24] >>> 16) & 255));
                        j11 = j24 + ((long) ((iArr2[i24] >>> 8) & 255));
                        j12 = j25 + ((long) (iArr2[i24] & 255));
                        j16 = j26 - ((long) ((iArr2[i24] >>> 16) & 255));
                        j17 = j27 - ((long) ((iArr2[i24] >>> 8) & 255));
                        j18 = j28 - ((long) (iArr2[i24] & 255));
                        i18++;
                        i17 = i24;
                        i21 = i22;
                    }
                    i10 = i12 + 1;
                } else {
                    return;
                }
            }
        } else if (i6 == 2) {
            int i25 = ((i5 + 1) * i) / i4;
            for (int i26 = (i5 * i) / i4; i26 < i25; i26++) {
                long j29 = 0;
                long j30 = 0;
                long j31 = 0;
                long j32 = 0;
                long j33 = 0;
                long j34 = 0;
                long j35 = 0;
                for (int i27 = 0; i27 <= i3; i27++) {
                    iArr2[i27] = iArr[i26];
                    j35 += (long) (((iArr[i26] >>> 16) & 255) * (i27 + 1));
                    j34 += (long) (((iArr[i26] >>> 8) & 255) * (i27 + 1));
                    j33 += (long) ((iArr[i26] & 255) * (i27 + 1));
                    j32 += (long) ((iArr[i26] >>> 16) & 255);
                    j31 += (long) ((iArr[i26] >>> 8) & 255);
                    j30 += (long) (iArr[i26] & 255);
                }
                long j36 = 0;
                long j37 = 0;
                int i28 = i26;
                for (int i29 = 1; i29 <= i3; i29++) {
                    if (i29 <= i8) {
                        i28 += i;
                    }
                    iArr2[i29 + i3] = iArr[i28];
                    j35 += (long) (((iArr[i28] >>> 16) & 255) * ((i3 + 1) - i29));
                    j34 += (long) (((iArr[i28] >>> 8) & 255) * ((i3 + 1) - i29));
                    j33 += (long) ((iArr[i28] & 255) * ((i3 + 1) - i29));
                    j37 += (long) ((iArr[i28] >>> 16) & 255);
                    j36 += (long) ((iArr[i28] >>> 8) & 255);
                    j29 += (long) (iArr[i28] & 255);
                }
                int i30 = i3 > i8 ? i8 : i3;
                int i31 = (i30 * i) + i26;
                int i32 = i3;
                int i33 = 0;
                int i34 = i30;
                int i35 = i26;
                while (i33 < i2) {
                    iArr[i35] = (int) (((long) (iArr[i35] & ViewCompat.MEASURED_STATE_MASK)) | ((((((long) s) * j35) >>> b) & 255) << 16) | ((((((long) s) * j34) >>> b) & 255) << 8) | (((((long) s) * j33) >>> b) & 255));
                    int i36 = i35 + i;
                    long j38 = j35 - j32;
                    long j39 = j34 - j31;
                    long j40 = j33 - j30;
                    int i37 = (i32 + i9) - i3;
                    if (i37 >= i9) {
                        i37 -= i9;
                    }
                    long j41 = j32 - ((long) ((iArr2[i37] >>> 16) & 255));
                    long j42 = j31 - ((long) ((iArr2[i37] >>> 8) & 255));
                    long j43 = j30 - ((long) (iArr2[i37] & 255));
                    if (i34 < i8) {
                        i31 += i;
                        i34++;
                    }
                    iArr2[i37] = iArr[i31];
                    long j44 = j37 + ((long) ((iArr[i31] >>> 16) & 255));
                    long j45 = j36 + ((long) ((iArr[i31] >>> 8) & 255));
                    long j46 = j29 + ((long) (iArr[i31] & 255));
                    j35 = j38 + j44;
                    j34 = j39 + j45;
                    j33 = j40 + j46;
                    int i38 = i32 + 1;
                    if (i38 >= i9) {
                        i38 = 0;
                    }
                    j32 = j41 + ((long) ((iArr2[i38] >>> 16) & 255));
                    j31 = j42 + ((long) ((iArr2[i38] >>> 8) & 255));
                    j30 = j43 + ((long) (iArr2[i38] & 255));
                    j37 = j44 - ((long) ((iArr2[i38] >>> 16) & 255));
                    j36 = j45 - ((long) ((iArr2[i38] >>> 8) & 255));
                    j29 = j46 - ((long) (iArr2[i38] & 255));
                    i33++;
                    i32 = i38;
                    i35 = i36;
                }
            }
        }
    }

    /* renamed from: a */
    public Bitmap mo6127a(Bitmap bitmap, float f) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i = C0552q.f1290a;
        ArrayList arrayList = new ArrayList(i);
        ArrayList arrayList2 = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new C0549a(iArr, width, height, (int) f, i, i2, 1));
            arrayList2.add(new C0549a(iArr, width, height, (int) f, i, i2, 2));
        }
        try {
            C0552q.f1291b.invokeAll(arrayList);
            try {
                C0552q.f1291b.invokeAll(arrayList2);
                return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
            } catch (InterruptedException e) {
                return null;
            }
        } catch (InterruptedException e2) {
            return null;
        }
    }
}
