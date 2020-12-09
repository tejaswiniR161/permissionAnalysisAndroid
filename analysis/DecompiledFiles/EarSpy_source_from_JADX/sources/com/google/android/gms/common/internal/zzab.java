package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzab {

    public static final class zza {

        /* renamed from: CU */
        private final List<String> f1658CU;
        private final Object zzctc;

        private zza(Object obj) {
            this.zzctc = zzac.zzy(obj);
            this.f1658CU = new ArrayList();
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.zzctc.getClass().getSimpleName()).append('{');
            int size = this.f1658CU.size();
            for (int i = 0; i < size; i++) {
                append.append(this.f1658CU.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }

        public zza zzg(String str, Object obj) {
            List<String> list = this.f1658CU;
            String str2 = (String) zzac.zzy(str);
            String valueOf = String.valueOf(String.valueOf(obj));
            list.add(new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzx(Object obj) {
        return new zza(obj);
    }
}
