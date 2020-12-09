package com.google.android.gms.internal;

import android.os.Build;
import android.support.p003v7.internal.widget.ActivityChooserView;
import android.util.Log;
import com.google.android.gms.common.internal.zzq;

public class zzse {

    /* renamed from: CR */
    private final String f2237CR;

    /* renamed from: Dk */
    private final zzq f2238Dk;

    /* renamed from: bX */
    private final int f2239bX;
    private final String mTag;

    private zzse(String str, String str2) {
        this.f2237CR = str2;
        this.mTag = str;
        this.f2238Dk = new zzq(str);
        this.f2239bX = getLogLevel();
    }

    public zzse(String str, String... strArr) {
        this(str, zzd(strArr));
    }

    private int getLogLevel() {
        if (Build.VERSION.SDK_INT == 23) {
            String valueOf = String.valueOf(this.mTag);
            String property = System.getProperty(valueOf.length() != 0 ? "log.tag.".concat(valueOf) : new String("log.tag."));
            if (property != null) {
                char c = 65535;
                switch (property.hashCode()) {
                    case -880503115:
                        if (property.equals("SUPPRESS")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 2251950:
                        if (property.equals("INFO")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2656902:
                        if (property.equals("WARN")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 64921139:
                        if (property.equals("DEBUG")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 66247144:
                        if (property.equals("ERROR")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1069090146:
                        if (property.equals("VERBOSE")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1940088646:
                        if (property.equals("ASSERT")) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        return 2;
                    case 1:
                        return 3;
                    case 2:
                        return 4;
                    case 3:
                        return 5;
                    case 4:
                        return 6;
                    case 5:
                        return 7;
                    case 6:
                        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    default:
                        return 4;
                }
            }
        }
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        return i;
    }

    private static String zzd(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String str : strArr) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(str);
        }
        sb.append(']').append(' ');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.f2237CR.concat(str);
    }

    public void zza(String str, Object... objArr) {
        if (zzbf(2)) {
            Log.v(this.mTag, format(str, objArr));
        }
    }

    public boolean zzbf(int i) {
        return this.f2239bX <= i;
    }

    public void zze(String str, Object... objArr) {
        Log.i(this.mTag, format(str, objArr));
    }

    public void zzf(String str, Object... objArr) {
        Log.w(this.mTag, format(str, objArr));
    }
}
