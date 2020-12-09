package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.zzd;
import java.util.Iterator;

public class zzqi extends zzqd {
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.zzqt, com.google.android.gms.common.util.zza] */
    public void onStop() {
        ? r2 = 0;
        super.onStop();
        Iterator it = r2.iterator();
        while (it.hasNext()) {
            ((zzd) it.next()).release();
        }
        r2.clear();
        r2.zza(this);
    }

    /* access modifiers changed from: protected */
    public void zza(ConnectionResult connectionResult, int i) {
        zzqt zzqt = null;
        zzqt.zza(connectionResult, i);
    }

    /* access modifiers changed from: protected */
    public void zzaqk() {
        zzqt zzqt = null;
        zzqt.zzaqk();
    }
}
