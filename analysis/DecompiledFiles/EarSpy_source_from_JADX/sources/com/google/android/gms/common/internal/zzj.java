package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.zzrb;

public abstract class zzj implements DialogInterface.OnClickListener {
    public static zzj zza(final Activity activity, final Intent intent, final int i) {
        return new zzj() {
            public void zzauo() {
                if (intent != null) {
                    activity.startActivityForResult(intent, i);
                }
            }
        };
    }

    public static zzj zza(@NonNull final Fragment fragment, final Intent intent, final int i) {
        return new zzj() {
            public void zzauo() {
                if (intent != null) {
                    fragment.startActivityForResult(intent, i);
                }
            }
        };
    }

    public static zzj zza(@NonNull final zzrb zzrb, final Intent intent, final int i) {
        return new zzj() {
            @TargetApi(11)
            public void zzauo() {
                if (intent != null) {
                    zzrb.startActivityForResult(intent, i);
                }
            }
        };
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            zzauo();
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services", e);
        }
    }

    public abstract void zzauo();
}
