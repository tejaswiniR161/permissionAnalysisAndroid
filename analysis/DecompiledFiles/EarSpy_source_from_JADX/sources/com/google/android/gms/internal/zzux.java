package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzuw;
import java.util.ArrayList;
import java.util.Collection;

public class zzux {
    private final Collection<zzuw> zzbah = new ArrayList();
    private final Collection<zzuw.zzd> zzbai = new ArrayList();
    private final Collection<zzuw.zzd> zzbaj = new ArrayList();

    public static void initialize(Context context) {
        zzva.zzbhn().initialize(context);
    }

    public void zza(zzuw zzuw) {
        this.zzbah.add(zzuw);
    }
}
