package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zzrf extends zzqd {

    /* renamed from: wh */
    private TaskCompletionSource<Void> f2176wh = new TaskCompletionSource<>();

    private zzrf(zzrb zzrb) {
        super(zzrb);
        this.f2165yY.zza("GmsAvailabilityHelper", (zzra) this);
    }

    public static zzrf zzu(Activity activity) {
        zzrb zzs = zzs(activity);
        zzrf zzrf = (zzrf) zzs.zza("GmsAvailabilityHelper", zzrf.class);
        if (zzrf == null) {
            return new zzrf(zzs);
        }
        if (!zzrf.f2176wh.getTask().isComplete()) {
            return zzrf;
        }
        zzrf.f2176wh = new TaskCompletionSource<>();
        return zzrf;
    }

    public Task<Void> getTask() {
        return this.f2176wh.getTask();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f2176wh.setException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    /* access modifiers changed from: protected */
    public void zza(ConnectionResult connectionResult, int i) {
        this.f2176wh.setException(zzb.zzl(connectionResult));
    }

    /* access modifiers changed from: protected */
    public void zzaqk() {
        int isGooglePlayServicesAvailable = this.f1981vP.isGooglePlayServicesAvailable(this.f2165yY.zzasq());
        if (isGooglePlayServicesAvailable == 0) {
            this.f2176wh.setResult(null);
        } else {
            zzk(new ConnectionResult(isGooglePlayServicesAvailable, (PendingIntent) null));
        }
    }

    public void zzk(ConnectionResult connectionResult) {
        zzb(connectionResult, 0);
    }
}
