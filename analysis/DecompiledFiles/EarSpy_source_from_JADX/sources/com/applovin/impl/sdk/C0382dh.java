package com.applovin.impl.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.applovin.impl.adview.C0288v;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.dh */
public class C0382dh extends AppLovinSdkUtils {

    /* renamed from: a */
    private static final char[] f653a = "0123456789abcdef".toCharArray();

    /* renamed from: b */
    private static final char[] f654b = "-'".toCharArray();

    /* renamed from: a */
    public static float m578a(float f) {
        return 1000.0f * f;
    }

    /* renamed from: a */
    public static Bitmap m579a(Context context, int i, int i2) {
        int i3 = 1;
        Bitmap bitmap = null;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), i);
            if (options.outHeight > i2 || options.outWidth > i2) {
                i3 = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(((double) i2) / ((double) Math.max(options.outHeight, options.outWidth))) / Math.log(0.5d))));
            }
            new BitmapFactory.Options().inSampleSize = i3;
            bitmap = BitmapFactory.decodeResource(context.getResources(), i);
            try {
                fileInputStream.close();
                fileInputStream2.close();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            try {
                fileInputStream.close();
                fileInputStream2.close();
            } catch (Exception e3) {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
                fileInputStream2.close();
            } catch (Exception e4) {
            }
            throw th;
        }
        return bitmap;
    }

    /* renamed from: a */
    public static Bitmap m580a(File file, int i) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        int i2 = 1;
        FileInputStream fileInputStream4 = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            fileInputStream = new FileInputStream(file);
            try {
                BitmapFactory.decodeStream(fileInputStream, (Rect) null, options);
                fileInputStream.close();
                if (options.outHeight > i || options.outWidth > i) {
                    i2 = (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(((double) i) / ((double) Math.max(options.outHeight, options.outWidth))) / Math.log(0.5d))));
                }
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = i2;
                FileInputStream fileInputStream5 = new FileInputStream(file);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream5, (Rect) null, options2);
                    fileInputStream5.close();
                    try {
                        fileInputStream.close();
                        fileInputStream5.close();
                        return decodeStream;
                    } catch (Exception e) {
                        return decodeStream;
                    }
                } catch (Exception e2) {
                    fileInputStream3 = fileInputStream5;
                    fileInputStream2 = fileInputStream;
                    try {
                        fileInputStream2.close();
                        fileInputStream3.close();
                    } catch (Exception e3) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream4 = fileInputStream5;
                    try {
                        fileInputStream.close();
                        fileInputStream4.close();
                    } catch (Exception e4) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream3 = null;
                fileInputStream2 = fileInputStream;
                fileInputStream2.close();
                fileInputStream3.close();
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream.close();
                fileInputStream4.close();
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream3 = null;
            fileInputStream2 = null;
            fileInputStream2.close();
            fileInputStream3.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            fileInputStream.close();
            fileInputStream4.close();
            throw th;
        }
    }

    /* renamed from: a */
    public static AppLovinAdImpl m581a() {
        return new AppLovinAdImpl.Builder().setHtml("").setSize(AppLovinAdSize.BANNER).setType(AppLovinAdType.REGULAR).setVideoFilename("").setTarget(AppLovinAdImpl.AdTarget.DEFAULT).setCloseStyle(C0288v.WhiteXOnOpaqueBlack).setVideoCloseDelay(0.0f).setPoststitialCloseDelay(0.0f).setCountdownLength(0).setCurrentAdIdNumber(-1).setClCode("").build();
    }

    /* renamed from: a */
    public static String m582a(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    /* renamed from: a */
    public static String m583a(String str, AppLovinSdkImpl appLovinSdkImpl) {
        return m584a(str, (Integer) appLovinSdkImpl.mo5363a(C0343bw.f561s), (String) appLovinSdkImpl.mo5363a(C0343bw.f560r));
    }

    /* renamed from: a */
    private static String m584a(String str, Integer num, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("No algorithm specified");
        } else if (str == null || str.length() < 1) {
            return "";
        } else {
            if (str2.length() < 1 || "none".equals(str2)) {
                return str;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(str.getBytes("UTF-8"));
                String a = m586a(instance.digest());
                return (a == null || num.intValue() <= 0) ? a : a.substring(0, Math.min(num.intValue(), a.length()));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Unknown algorithm \"" + str2 + "\"", e);
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("Programming error: UTF-8 is not know encoding", e2);
            }
        }
    }

    /* renamed from: a */
    static String m585a(Map map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append('=').append(entry.getValue());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m586a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("No data specified");
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i * 2] = f653a[(bArr[i] & 240) >>> 4];
            cArr[(i * 2) + 1] = f653a[bArr[i] & 15];
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static long m587b(float f) {
        return (long) Math.round(f);
    }

    /* renamed from: b */
    public static String m588b(String str) {
        return m584a(str, (Integer) -1, "SHA-1");
    }

    /* renamed from: c */
    public static long m589c(float f) {
        return m587b(m578a(f));
    }

    /* renamed from: c */
    static String m590c(String str) {
        if (!isValidString(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }
}
