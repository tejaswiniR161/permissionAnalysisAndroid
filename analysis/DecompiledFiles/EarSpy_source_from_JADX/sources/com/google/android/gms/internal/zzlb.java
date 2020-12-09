package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzc;
import com.google.android.gms.ads.internal.zzu;

@zziy
public final class zzlb extends zzkm {
    private final String zzae;
    private final zzc zzcsz;

    public zzlb(Context context, String str, String str2) {
        this(str2, zzu.zzfz().zzg(context, str));
    }

    public zzlb(String str, String str2) {
        this.zzcsz = new zzc(str2);
        this.zzae = str;
    }

    public void onStop() {
    }

    public void zzfc() {
        this.zzcsz.zzcy(this.zzae);
    }
}
