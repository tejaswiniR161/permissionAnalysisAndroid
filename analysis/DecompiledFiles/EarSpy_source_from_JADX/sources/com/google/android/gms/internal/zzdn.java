package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;

@zziy
public abstract class zzdn {
    @zziy
    public static final zzdn zzbii = new zzdn() {
        public String zzg(@Nullable String str, String str2) {
            return str2;
        }
    };
    @zziy
    public static final zzdn zzbij = new zzdn() {
        public String zzg(@Nullable String str, String str2) {
            return str != null ? str : str2;
        }
    };
    @zziy
    public static final zzdn zzbik = new zzdn() {
        @Nullable
        private String zzau(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String zzg(@Nullable String str, String str2) {
            String zzau = zzau(str);
            String zzau2 = zzau(str2);
            return TextUtils.isEmpty(zzau) ? zzau2 : TextUtils.isEmpty(zzau2) ? zzau : new StringBuilder(String.valueOf(zzau).length() + 1 + String.valueOf(zzau2).length()).append(zzau).append(",").append(zzau2).toString();
        }
    };

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzg(map.get(str), str2));
    }

    public abstract String zzg(@Nullable String str, String str2);
}
