package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.p000v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

@TargetApi(11)
public final class zzrc extends Fragment implements zzrb {

    /* renamed from: yZ */
    private static WeakHashMap<Activity, WeakReference<zzrc>> f2166yZ = new WeakHashMap<>();

    /* renamed from: za */
    private Map<String, zzra> f2167za = new ArrayMap();
    /* access modifiers changed from: private */

    /* renamed from: zb */
    public Bundle f2168zb;
    /* access modifiers changed from: private */
    public int zzbqm = 0;

    private void zzb(final String str, @NonNull final zzra zzra) {
        if (this.zzbqm > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (zzrc.this.zzbqm >= 1) {
                        zzra.onCreate(zzrc.this.f2168zb != null ? zzrc.this.f2168zb.getBundle(str) : null);
                    }
                    if (zzrc.this.zzbqm >= 2) {
                        zzra.onStart();
                    }
                    if (zzrc.this.zzbqm >= 3) {
                        zzra.onStop();
                    }
                    if (zzrc.this.zzbqm >= 4) {
                        zzra.onDestroy();
                    }
                }
            });
        }
    }

    public static zzrc zzt(Activity activity) {
        zzrc zzrc;
        WeakReference weakReference = f2166yZ.get(activity);
        if (weakReference == null || (zzrc = (zzrc) weakReference.get()) == null) {
            try {
                zzrc = (zzrc) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (zzrc == null || zzrc.isRemoving()) {
                    zzrc = new zzrc();
                    activity.getFragmentManager().beginTransaction().add(zzrc, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f2166yZ.put(activity, new WeakReference(zzrc));
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            }
        }
        return zzrc;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzra dump : this.f2167za.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzra onActivityResult : this.f2167za.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzbqm = 1;
        this.f2168zb = bundle;
        for (Map.Entry next : this.f2167za.entrySet()) {
            ((zzra) next.getValue()).onCreate(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public void onDestroy() {
        super.onStop();
        this.zzbqm = 4;
        for (zzra onDestroy : this.f2167za.values()) {
            onDestroy.onDestroy();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f2167za.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((zzra) next.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.zzbqm = 2;
        for (zzra onStart : this.f2167za.values()) {
            onStart.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        this.zzbqm = 3;
        for (zzra onStop : this.f2167za.values()) {
            onStop.onStop();
        }
    }

    public <T extends zzra> T zza(String str, Class<T> cls) {
        return (zzra) cls.cast(this.f2167za.get(str));
    }

    public void zza(String str, @NonNull zzra zzra) {
        if (!this.f2167za.containsKey(str)) {
            this.f2167za.put(str, zzra);
            zzb(str, zzra);
            return;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
    }

    public Activity zzasq() {
        return getActivity();
    }
}
