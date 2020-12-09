package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzz {
    private final String separator;

    private zzz(String str) {
        this.separator = str;
    }

    public static zzz zzhy(String str) {
        return new zzz(str);
    }

    public final String zza(Iterable<?> iterable) {
        return zza(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder zza(StringBuilder sb, Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(zzw(it.next()));
            while (it.hasNext()) {
                sb.append(this.separator);
                sb.append(zzw(it.next()));
            }
        }
        return sb;
    }

    /* access modifiers changed from: package-private */
    public CharSequence zzw(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
